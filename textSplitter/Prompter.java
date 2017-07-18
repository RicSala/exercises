import java.util.Scanner;



public class Prompter {

  public String text = "";
  Scanner scanner;

  public Prompter() {
    scanner = new Scanner(System.in);
  }

  public String askForString() {

    System.out.printf("Please, type your text: %n");
    return scanner.nextLine();
  }

  public Integer askForNumberOfLines() {

    System.out.printf("Please, type the number of lines: %n");
    return Integer.parseInt(scanner.nextLine());
  }

  public void showResult(String[] dividedText) {

    for (int i = 0; i < dividedText.length; i++){
      System.out.printf("'%s' %n", dividedText[i]);
    }
  }

}
