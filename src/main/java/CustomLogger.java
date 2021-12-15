import java.util.StringJoiner;

public class CustomLogger {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void format(Response response, String color){
        System.out.println(color +formatString(response)+ANSI_RESET);
    }
    public static void formatText(String text, String color){
        System.out.println(color +text+ANSI_RESET);
    }


    public static String formatString(Response response){
        StringJoiner joiner = new StringJoiner("  ");
        joiner.add(response.getTime().toString());
        joiner.add(response.getPan());
        joiner.add(response.getAccount());
        joiner.add(response.getBin());
        joiner.add(response.getAmount());
        joiner.add(response.getSourceNode());
        joiner.add(response.getSinNode());
        joiner.add(String.valueOf(response.getResponseCode()));

        return joiner.toString();

    }
}
