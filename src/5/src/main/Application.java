import java.io.File;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Application
{
    private Class clazz;
    private Object instance;
    private Object port;

    public void loadClazzFromJavaArchive()
    {
        try
        {
            URL[] urls = {new File(Configuration.instance.subFolderPathOfJavaArchive).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Application.class.getClassLoader());
            clazz = Class.forName(Configuration.instance.nameOfClass, true, urlClassLoader);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void provideInstanceOfClass()
    {
        try
        {
            instance = clazz.getMethod("getInstance").invoke(null);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void provideComponentPort()
    {
        try
        {
            port = clazz.getDeclaredField("port").get(instance);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void executeMethodUsingPort()
    {
        try
        {
            Method method = port.getClass().getMethod("execute", BigInteger.class, BigInteger.class);
            BigInteger rangeFrom = BigInteger.valueOf(10);
            BigInteger rangeTo = BigInteger.valueOf(200000);
            ArrayList<BigInteger> result = (ArrayList<BigInteger>) method.invoke(port, rangeFrom, rangeTo);

            if (result.size() == 0)
            {
                System.out.println("No primes found.");
            }
            else
            {
                System.out.println("Primes found:");

                for (BigInteger number : result)
                    System.out.println(number.toString());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void execute()
    {
        Configuration.instance.print();
        loadClazzFromJavaArchive();
        provideInstanceOfClass();
        provideComponentPort();
        executeMethodUsingPort();
    }

    public static void main(String... args)
    {
        Application application = new Application();
        application.execute();
    }
}