package priv.starfish;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description: 通过反射技术暴力获取Unsafe对象
 * @author: starfish
 * @create: 2020-03-31 11:07
 **/
public class CompareAndSwapTest {

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //通过反射获得Unsafe实例，仅BootstrapClassLoader加载的类
        //（$JAVA_HOME/lib目录下jar包包含的类，如java.util.concurrent.atomic.AtomicInteger）
        //才能通过Unsafe.getUnsafe静态方法获取
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        //获得Target实例域value
//        Field valueField = Target.class.getDeclaredField("value");
//        //实例化Target
//        Target t = new Target();
//        System.out.println("原始value值:" + valueField.get(t));
//
//        //获得实例域在class文件里的偏移量
//        final long valueOffset = unsafe.objectFieldOffset(valueField);
//
//        //第一次swap
//        System.out.println("第一次swap(10,20)函数返回值:" + unsafe.compareAndSwapInt(t, valueOffset, 10, 20));
//        System.out.println("第一次swap(10,20)后value值:" + valueField.get(t));
//
//        //第二次swap
//        System.out.println("第一次swap(10,20)函数返回值:" + unsafe.compareAndSwapInt(t, valueOffset, 10, 20));
//        System.out.println("第一次swap(10,20)后value值:" + valueField.get(t));
//
    }

}
