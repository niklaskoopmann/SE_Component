import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader {

    private Class clazz;
    private Window window;
    private ApplicationLauncher appLauncher;

    public JarLoader(Window window) {
        this.window = window;
    }

    public Class loadClassFromJar(File jarToLoad) throws IOException, ClassNotFoundException {

        // remove brackets from jar path
        String jarToLoadCorrectedPath = "";
        char last = jarToLoad.getPath().charAt(jarToLoad.getPath().length() - 1);

        // strip path of unnecessary characters
        if (jarToLoad.getPath().charAt(0) == '[' && last == ']')
            jarToLoadCorrectedPath = jarToLoad.getPath().substring(1, jarToLoad.getPath().length() - 1);
        else if (last == ' ') {
            jarToLoadCorrectedPath = jarToLoad.getPath().substring(0, jarToLoad.getPath().length() - 1);
        } else {
            jarToLoadCorrectedPath = jarToLoad.getPath();
        }

        if (jarToLoadCorrectedPath.endsWith(".jar")) {

            // get jar file as corresponding object
            JarFile jarFile = new JarFile(jarToLoadCorrectedPath);
            // get entries of jar file as enumeration
            Enumeration<JarEntry> jarEntries = jarFile.entries();

            // init url class loader
            URL[] urls = new URL[]{new URL("file:" + jarToLoadCorrectedPath)};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, this.getClass().getClassLoader());
            Thread.currentThread().setContextClassLoader(urlClassLoader); // better safe than sorry

            // iterate through entries of jar file
            while (jarEntries.hasMoreElements()) {

                JarEntry jarEntry = jarEntries.nextElement();

                // check if found file is regular class
                if (!jarEntry.isDirectory() && jarEntry.getName().endsWith(".class")) {

                    // get class name for entry
                    String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);

                    // instantiate class
                    clazz = Class.forName(className, true, urlClassLoader);

                    if (!clazz.isInterface() && !clazz.getName().endsWith("$Port") && !clazz.getName().equals("Application") && !clazz.getName().equals("Configuration")) {
                        // display success message
                        window.getWindowOutputTextArea().appendText("\nComponent '" + clazz.getName() + "' sucessfully loaded.");
                        return clazz;
                    }
                }
            }
        }

        return null;
    }
}
