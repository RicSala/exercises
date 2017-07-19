import java.nio.charset.*;
import java.io.IOException;
import java.util.Scanner;


public class Prompter {



  public static String  readFile() {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Please, type file path (relative): %n");
    String path = scanner.nextLine();

    try {
      String html = Logic.readFile(path, Charset.defaultCharset());
      // System.out.println(html);
      System.out.printf("Reading file...%n");
      return html;
    } catch (IOException ioe ) {
      ioe.printStackTrace();
      throw new RuntimeException(ioe);
    }
  }

  public static String[] selectSeparators() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please, type the opener separator: ");
    String opener = scanner.nextLine();
    System.out.println("Please, type the closer separator: ");
    String closer = scanner.nextLine();
    String[] separators = {opener, closer};
    return separators;

  }

  public static String getValue(String placeholderName) {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Please provide your value for the varible " + placeholderName + ":  %n");
    return scanner.nextLine();

  }

  // public static Map<String, String> getValues() {
  //   Map<String, String> placeholdersAndValues = new Hashmap<String, String>;
  //
  // }


}
