public class Hangman {

  public static void main(String[] args) {

    Game game = new Game("CodeThen"); //Creamos el juego
    Prompter prompter = new Prompter(game); //creamos el prompter

    while(game.getRemainigTries() > 0) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }
   }

}
