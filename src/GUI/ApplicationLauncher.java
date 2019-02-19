import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ApplicationLauncher {

    private Window window;

    public ApplicationLauncher(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    // This is where the fun part happens...
    public Object runApp(Class clazz) throws IllegalAccessException, ClassCastException {

        final long startTime = System.nanoTime();

        BigInteger min = window.getRangeMin();
        BigInteger max = window.getRangeMax();
        ArrayList<BigInteger> result = null;
        Object instance = null;
        Object port = null;

        window.getWindowOutputTextArea().appendText("\nSearching in range from " + min.toString() + " to " + max.toString() + ".");

        // instantiate class
        try {
            instance = clazz.getMethod("getInstance", new Class[0]).invoke(null);
            port = clazz.getDeclaredField("port").get(instance);
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            window.getWindowOutputTextArea().appendText("\nMethod 'getInstance' or port not found in class " + clazz.getName() + "!");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause().toString());
            System.out.println(e.getTargetException().toString());
        }

        try {
            Method m = port.getClass().getMethod("execute", BigInteger.class, BigInteger.class);

            // debug
            window.getWindowOutputTextArea().appendText("\nInvoking method " + m.getName() + " in Port " + port.toString());

            result = (ArrayList<BigInteger>) m.invoke(port, min, max); // todo: Maybe avoid unchecked cast?

        } catch (NoSuchMethodException e) {
            window.getWindowOutputTextArea().appendText("\nMethod 'execute' not found in class " + clazz.getName() + "!");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Invocation Target Exception Cause: " + e.getCause().toString());
            System.out.println("Invocation Target Exception: " + e.getTargetException().toString());
        }

        final long endTime = System.nanoTime();

        window.getWindowOutputTextArea().appendText("\nRuntime: " + (endTime - startTime) / 1000000 + " ms.");

        writeResultToCSV(result);

        return result;
    }

    public void writeResultToCSV(ArrayList<BigInteger> result) {

        // replaces file automatically, thank God
        // todo: test on Windows
        Path destinationPath;

        // differentiate between different paths of jar file that can occur and trim accordingly
        if (window.getJarPath().startsWith("[") && window.getJarPath().endsWith("]"))
            destinationPath = FileSystems.getDefault().getPath(window.getJarPath().substring(1, window.getJarPath().length() - 4) + "csv");
        else if (window.getJarPath().endsWith(" "))
            destinationPath = FileSystems.getDefault().getPath(window.getJarPath().substring(0, window.getJarPath().length() - 4) + "csv");
        else
            destinationPath = FileSystems.getDefault().getPath(window.getJarPath().substring(0, window.getJarPath().length() - 3) + "csv");

        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationPath, Charset.forName("UTF-8"));

            for (int i = 0; i < result.size() - 2; i++) bufferedWriter.append(result.get(i).toString()).append(",");
            bufferedWriter.append(result.get(result.size() - 1).toString());

            window.getWindowOutputTextArea().appendText("\nResults written to file " + destinationPath.toString() + ".");

            bufferedWriter.close();

        } catch (IOException e) {

            window.getWindowOutputTextArea().appendText("\nCould not write results due to IOException (see console output)!");
            System.out.println("IOException while trying to write results to file:");
            e.printStackTrace();
        }
    }
}
