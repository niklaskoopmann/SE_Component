import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;

public class Window extends Application {

    private JarLoader jarLoader;
    private TextArea windowOutputTextArea;
    private TextField windowCLIInputTextField;
    private Spinner<Integer> spinnerMin;
    private Spinner<Integer> spinnerMax;
    private TextField dragDropField;
    private ApplicationLauncher appLauncher;
    private String jarPath;
    private Button executeButton;
    private Button loadButton;
    private Class loadedClass = null;
    private FileChooser fileChooser;
    private String lastCommand = "";
    private BigInteger rangeMin;
    private BigInteger rangeMax;

    public static void main(String[] args) {
        launch(args);
    }

    public JarLoader getJarLoader() {
        return jarLoader;
    }

    public ApplicationLauncher getAppLauncher() {
        return appLauncher;
    }

    public String getJarPath() {
        return jarPath;
    }

    public TextArea getWindowOutputTextArea() {
        return windowOutputTextArea;
    }

    public TextField getWindowCLIInputTextField() {
        return windowCLIInputTextField;
    }

    public Spinner<Integer> getSpinnerMin() {
        return spinnerMin;
    }

    public Spinner<Integer> getSpinnerMax() {
        return spinnerMax;
    }

    public TextField getDragDropField() {
        return dragDropField;
    }

    public BigInteger getRangeMin() {
        return rangeMin;
    }

    public BigInteger getRangeMax() {
        return rangeMax;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // instantiate jar loader
        jarLoader = new JarLoader(this);

        // instantiate app launcher
        appLauncher = new ApplicationLauncher(this);

        // load FXML VBox
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Component_Window.fxml"));
        VBox vBox = loader.load();

        // add VBox elements to scene
        StackPane root = new StackPane();
        root.getChildren().setAll(vBox);
        Scene scene = new Scene(root);

        // centre text field
        windowOutputTextArea = (TextArea) vBox.lookup("#windowOutputTextField");
        windowOutputTextArea.appendText("Entering BigInteger values as min and max borders is unfortunately only possible via the command line.\nType 'help' for a list of commands.");

        // command line text area
        windowCLIInputTextField = (TextField) vBox.lookup("#windowCLIInputTextField");
        windowCLIInputTextField.setText("> ");

        // init spinners
        // todo: maybe get rid of unchecked casts!
        // spinners are only available for integer values
        spinnerMin = (Spinner<Integer>) vBox.lookup("#windowSpinnerMin");
        spinnerMax = (Spinner<Integer>) vBox.lookup("#windowSpinnerMax");
        spinnerMin.getValueFactory().setValue(1);
        spinnerMax.getValueFactory().setValue(200);

        // init values for min and max
        rangeMin = new BigInteger("1");
        rangeMax = new BigInteger("200");

        // execute button
        executeButton = (Button) vBox.lookup("#executeButton");

        // load button
        loadButton = (Button) vBox.lookup("#loadButton");

        // text field to drag and drop files
        dragDropField = (TextField) vBox.lookup("#windowSuccessStatus");
        dragDropField.setStyle("-fx-background-color: darkblue; -fx-text-fill: white;");
        dragDropField.setText("Drag & Drop files here!");
        AtomicBoolean dropSuccess = new AtomicBoolean(false);

        // drag and drop handlers
        dragDropField.setOnDragOver(event -> {
            dropSuccess.set(false);
            dragDropField.setText("Drop your file here!");
            dragDropField.setStyle("-fx-background-color: blue; -fx-text-fill: black;");

            if (event.getGestureSource() != dragDropField
                    && event.getDragboard().hasFiles()) {
                /* allow for both copying and moving, whatever user chooses*/
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        dragDropField.setOnDragExited(event -> {
            if (!dropSuccess.get()) {
                dragDropField.setText("Drag & Drop files here!");
                dragDropField.setStyle("-fx-background-color: darkblue; -fx-text-fill: white;");
            }
        });

        dragDropField.setOnDragDropped(event -> {

            Dragboard db = event.getDragboard();
            dropSuccess.set(false);

            if (db.hasFiles()) {
                try {

                    // import file
                    File file = new File(db.getFiles().toString());
                    jarPath = file.getPath();
                    String fileNameLocal = file.getName().substring(0, file.getName().length() - 1);

                    // update field
                    dragDropField.setText("JAR drop successful!");
                    dragDropField.setStyle("-fx-background-color: green; -fx-text-fill: white;");

                    windowOutputTextArea.appendText("\nFile '" + fileNameLocal + "' dragged to field component in GUI.");
                    dropSuccess.set(true);

                    // load jar file
                    loadedClass = jarLoader.loadClassFromJar(file);

                } catch (Exception e) {

                    // update field and log error to console
                    dragDropField.setText("JAR drop failed!");
                    dragDropField.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    System.out.println("Drag & Drop operation has failed for dragDropField: \n\n");
                    e.printStackTrace();
                    dropSuccess.set(false);
                }
            }
            // let the source know whether the string was successfully transferred and used
            event.setDropCompleted(dropSuccess.get());
            event.consume();
        });

        spinnerMin.getEditor().textProperty().addListener((obs, oldval, newval) -> {
            this.rangeMin = new BigInteger(newval);
        });
        spinnerMax.getEditor().textProperty().addListener((obs, oldval, newval) -> {
            this.rangeMax = new BigInteger(newval);
        });

        // execute button handler
        executeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> executeSearch());

        // load button handler
        loadButton.setOnMouseClicked(mouseEvent -> {

            // instantiate file chooser
            fileChooser = new FileChooser();
            fileChooser.setTitle("Select JAR File...");
            fileChooser.getExtensionFilters().removeAll();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JAR Files", "*.jar"));
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {

                // set jar path
                jarPath = selectedFile.getPath();

                // update field
                dragDropField.setText("JAR loaded!");
                dragDropField.setStyle("-fx-background-color: green; -fx-text-fill: white;");

                // load jar file
                try {
                    loadedClass = jarLoader.loadClassFromJar(selectedFile);
                } catch (IOException | ClassNotFoundException e) {

                    // update field and log error to console
                    dragDropField.setText("Loading failed!");
                    dragDropField.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                    e.printStackTrace();
                }
            }
        });

        // cli field keystroke handler
        windowCLIInputTextField.setOnKeyPressed(keyEvent -> {
            // avoid deletion of "> "
            if (windowCLIInputTextField.getCaretPosition() < 2) {
                String formerCLIFieldText = windowCLIInputTextField.getText();
                clearInputField();
                if (!(keyEvent.getCode() == KeyCode.BACK_SPACE)) {
                    windowCLIInputTextField.appendText(formerCLIFieldText.substring(2));
                } else {
                    windowCLIInputTextField.appendText(formerCLIFieldText.substring(1));
                }
                windowCLIInputTextField.positionCaret(2);
            }
            // send command using return key
            if (keyEvent.getCode() == KeyCode.ENTER) {
                String command = windowCLIInputTextField.getText().substring(2);
                if (!command.startsWith("load")) command = command.toLowerCase();
                windowOutputTextArea.appendText("\nCommand '" + command + "' sent.");
                executeCommand(command);
                clearInputField();
            }
            // load last command if up key pressed
            if (keyEvent.getCode() == KeyCode.UP) {
                clearInputField();
                windowCLIInputTextField.appendText(lastCommand);
            }
        });

        // set window details and display
        primaryStage.setResizable(false);
        primaryStage.setTitle("Komponenten");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void executeSearch() {

        // reset field
        dragDropField.setText("Drag & Drop files here!");
        dragDropField.setStyle("-fx-background-color: darkblue; -fx-text-fill: white;");

        // class must be loaded
        if (loadedClass != null) {

            windowOutputTextArea.appendText("\nExecuting search using class " + loadedClass.getName() + "...");

            try {
                // run app launcher
                appLauncher.runApp(loadedClass);
            } catch (IllegalAccessException e) {
                System.out.println("Error executing method in class " + loadedClass.getName() + ":");
                e.printStackTrace();
            }
        } else {
            windowOutputTextArea.appendText("\nNo class loaded!");
        }
    }

    private void executeCommand(String cmd) {

        lastCommand = cmd;

        String[] mulCmd = cmd.split(" ");

        if (mulCmd.length == 1) {

            switch (cmd) {
                case "help":
                case "?":
                case "hilfe":
                    windowOutputTextArea.appendText("\n\nHelp screen:\n" +
                            "execute: execute search in loaded class and given range\n" +
                            "clear: clear output screen\n" +
                            "setmin + <number>: set min value\n" +
                            "setmax + <number>: set max value\n" +
                            "load + <path>: load jar at path (use absolute path to be safe)\n" +
                            "exit/quit/close: close application");
                    break;

                case "exit":
                case "quit":
                case "close":
                    System.exit(0);
                    break;

                case "execute":
                    executeSearch();
                    break;

                case "clear":
                    windowOutputTextArea.clear();
                    break;

            }
        } else if (mulCmd[0].equals("setmin") && mulCmd.length == 2) {
            this.rangeMin = new BigInteger(mulCmd[1]);
            try {
                spinnerMin.getValueFactory().setValue(Integer.parseInt(mulCmd[1]));
            } catch (Exception e) {
                windowOutputTextArea.appendText("\nSpinner value could not be updated!");
                spinnerMin.getValueFactory().setValue(1);
                e.printStackTrace();
            }
        } else if (mulCmd[0].equals("setmax") && mulCmd.length == 2) {
            this.rangeMax = new BigInteger(mulCmd[1]);
            try {
                spinnerMax.getValueFactory().setValue(Integer.parseInt(mulCmd[1]));
            } catch (Exception e) {
                windowOutputTextArea.appendText("\nSpinner value could not be updated!");
                spinnerMax.getValueFactory().setValue(200);
                e.printStackTrace(); // tolerated exception
            }
        } else if (mulCmd[0].equals("load")) {

            // get path from command
            StringBuilder pathBuilder = new StringBuilder();
            for (int i = 1; i < mulCmd.length; i++) {
                pathBuilder.append(mulCmd[i]).append(" ");
            }
            jarPath = pathBuilder.toString();

            // load file from path
            try {

                File file = new File(jarPath);

                // update field
                dragDropField.setText("JAR loaded!");
                dragDropField.setStyle("-fx-background-color: green; -fx-text-fill: white;");

                // load jar file
                loadedClass = jarLoader.loadClassFromJar(file);
            } catch (Exception e) {

                // update field and log error to console
                dragDropField.setText("Loading failed!");
                dragDropField.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                e.printStackTrace();
            }
        }
    }

    private void clearInputField() {
        windowCLIInputTextField.clear();
        windowCLIInputTextField.appendText("> ");
        windowCLIInputTextField.positionCaret(3);
    }

    private void readFileContent(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName.substring(1, fileName.length() - 1)));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }
}
