class Game {
  private String answer;
  private String hits;
  private String misses;

  public Game(String answer) {
    this.answer = answer; //así evitamos que colisionen las variables
    hits = ""; //inicializa la variable hits a "" --> Acabamos de empezar aún no hay hits
    misses = "";  //inicializa la variable misses a "" --> idem

  }

  public boolean applyGuess(char letter) {
    boolean isHit = ( answer.indexOf(letter) != -1 );
    if (isHit) {
      hits += letter;
    }
    else {
      misses += letter;
    }
    return isHit;
  }


}
