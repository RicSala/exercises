import karaoke.model.Song;
import karaoke.model.SongBook;
import karaoke.KaraokeMachine;

public class Karaoke {
  public static void main(String[] args) {

    SongBook songBook = new SongBook();
    KaraokeMachine karaokeMachine = new KaraokeMachine(songBook);
    karaokeMachine.run();


  }
}
