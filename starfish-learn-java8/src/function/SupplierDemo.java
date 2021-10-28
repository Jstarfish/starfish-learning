package function;

import java.util.function.Supplier;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/12 15:05
 */
public class SupplierDemo {

    static String product = "JavaKeeper";

    public static void main(String[] args) {

        Supplier<Integer> intSupplier = () -> product.length() - 1;
        Supplier<Boolean> boolSupplier = () -> "javaKeeper".equals(product);
        Supplier<String> strSupplier = ()-> product.toUpperCase();

        System.out.println(intSupplier.get());
        System.out.println(boolSupplier.get());
        System.out.println(strSupplier.get());
    }
}
