public class Hangman {

  public static void main(String[] args) {

    if (args.length == 0) {
      //POR QUÉ ES ARGS.LENGTH Y NO ARGS.LENGTH()??????
      System.out.println("Usage: Java Hangman <answer>");
      System.exit(1);
    }

    Game game = new Game(args[0]); //Creamos el juego
    Prompter prompter = new Prompter(game); //creamos el prompter

    while(game.getRemainigTries() > 0 && !game.winner()) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }

    prompter.mostrarResultado();

   }

}
