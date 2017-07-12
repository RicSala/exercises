class Game {
  public final int MAX_MISSES = 7;

  private String answer;
  private String hits;
  private String misses;

  public Game(String answer) {
    this.answer = answer.toLowerCase(); //así evitamos que colisionen las variables
    hits = ""; //inicializa la variable hits a "" --> Acabamos de empezar aún no hay hits
    misses = "";  //inicializa la variable misses a "" --> idem

  }

  private char normalizeGuess(char letter) {
    if (!Character.isLetter(letter)) {
      throw new IllegalArgumentException("Debes introducir una letra!");
    }
    if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
      throw new IllegalArgumentException(letter + " has already been guessed.");
    }
    letter = Character.toLowerCase(letter);
    return letter;
  }

  public boolean applyGuess(char letter) {
    letter= normalizeGuess(letter); //No necesito ponerle nada delante? --> no porque es un método de esta misma clase, para qué decirle Game.normlize.... CHEQUEAR FERRAN

    boolean isHit = ( answer.indexOf(letter) != -1 );
    if (isHit) {
      hits += letter;
    }
    else {
      misses += letter;
    }
    return isHit;
  }

  public  int getRemainigTries() {
    return MAX_MISSES - misses.length() ;

  }

  public String currentProgress() {
    String progress = "";
    for (char letter : answer.toCharArray()) {
      if (hits.indexOf(letter) != -1) {
          progress += letter;
      } else {
          progress += '-';
      }
    }
    return progress;

  }

}
