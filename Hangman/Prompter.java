import java.util.Scanner;

class Prompter {
// EL PROMPTER COGERa Y DARA INFORMACIoN AL USUARIO.


//Lo primero que tenemos que decirle a nuestro Prompter es que existe un objeto de clase Game.
  private Game game; //aquí game es la variable de la clase.

//Pero para qué sirve la instancia de prompter y la variable game si no le decimos cual es?

  public Prompter (Game game){ //aquí podríamos llamarle de otra manera, es "lo que le entregamos"
    this.game = game; //que lo asignamos a la variable de esta instancia de clase
  }


  public boolean promptForGuess() { //RECUERDA: EN EL PROMPT NO VA LÓGICA.
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAceptable = false;

    do {
      System.out.print("Enter a letter: ");
      String guessInput = scanner.nextLine();
      char guess = guessInput.charAt(0); //Básicamente le estamos diciendo que solo considere el primero.

      try {
        isHit = game.applyGuess(guess);
        isAceptable = true;
      } catch(IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    } while (!isAceptable);

    return isHit;
  }


  public void displayProgress() {
    System.out.printf("You have %d to try to solve: %s.%n",game.getRemainigTries(),  game.currentProgress());
  }
}
