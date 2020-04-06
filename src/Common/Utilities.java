package common;

/**
 * This is the basic common utility class used to simplify redundant implementation.
 **/
public class Utilities {

    /**
     * Wrap up current output. e.g product.
     **/
    public static void addLines(String context) {
        System.out.println("---------------------------------------------");
        System.out.println(context);
        System.out.println("---------------------------------------------");
    }

    /**
     * Generate single dotted line.
     **/
    public static void singleLine() {
        System.out.println("---------------------------------------------");
    }

}
