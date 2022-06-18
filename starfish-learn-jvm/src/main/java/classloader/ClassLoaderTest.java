package classloader;

import java.net.URL;

public class ClassLoaderTest {


    public static void main(String[] args) {


        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  //sun.misc.Launcher$AppClassLoader@135fbaa4

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);  //sun.misc.Launcher$ExtClassLoader@2503dbd3

        //再获取其上层：获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);     //null

        //对于用户自定义类来说，默认使用系统类加载器进行加载，输出和systemClassLoader一样
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@135fbaa4

        //String 类使用引导类加载器进行加载。Java的核心类库都使用引导类加载器进行加载，所以也获取不到
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);  //null

        //获取BootstrapClassLoader可以加载的api的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

    }


}
