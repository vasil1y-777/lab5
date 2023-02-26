package helper;

public class ColorTextBuilder {

    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_GREEN = "\u001B[32m";

    public static void printConsoleLine(String txt){
        System.out.print(COLOR_GREEN + txt + COLOR_RESET);
    }
    public static String getConsoleLine(String txt){
        return COLOR_GREEN + txt + COLOR_RESET;
    }
}
