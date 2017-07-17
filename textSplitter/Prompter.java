import java.util.Scanner;



public class Prompter {

  public String text = "";

  public String askForString() {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Please, type your text: %n");
    return scanner.nextLine();

  }

  public Integer askForNumberOfLines() {

    Scanner scanner = new Scanner(System.in);
    System.out.printf("Please, type the number of lines: %n");
    return Integer.parseInt(scanner.nextLine());

  }

  public void showResult(String[] dividedText) {

    for (int i = 0; i < dividedText.length; i++){
      System.out.printf("'%s' %n", dividedText[i]);
    }
  }

}
