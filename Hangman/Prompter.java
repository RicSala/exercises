import java.util.Scanner;

public class Prompter {
// EL PROMPTER COGERa Y DARA INFORMACIoN AL USUARIO.
//Lo primero que tenemos que decirle a nuestro Prompter es que existe un objeto de clase Game.
  private Game game; //aquí game es la variable de la clase.
//PARA QUÉ HACE ESTO DE AQUÍ ARRIBA???




//Pero para qué sirve la instancia de prompter y la variable game si no le decimos cual es? PREG RET
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

      try {
        isHit = game.applyGuess(guessInput);
        isAceptable = true;
      } catch(IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    } while (!isAceptable);

    return isHit;
  }



  public void mostrarResultado() {
    if (game.winner()) {

      System.out.printf("%nEnhorabuena, has ganado! %n%n%nLa palabra era: %s%n%n", game.currentProgress());
    }
    else {
      System.out.printf("%nQue maaaaalo que eres!%n%n");
    }
  }




  public void displayProgress() {
    System.out.printf("You have %d guesses to try to solve: %s.%n",game.getRemainigTries(),  game.currentProgress());
  }
}
