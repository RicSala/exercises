package karaoke.model;

import java.util.List;
import java.util.ArrayList;

public class SongBook {

  private List<Song> Songs; //aquí le estoy diciendo el interfaz, pero no la implementación;

  public SongBook() {
    Songs = new ArrayList<Song>();
  }

  public  void addSong(Song song) {
    Songs.add(song);
  }

  public int getSongCount() {
    return Songs.size();
  }

}

//Hemos encapsulado la forma en la que almacenamos la información de forma que siempre podremos cambiarla
//y los usuarios de nuestra clase nunca se enterarían.
