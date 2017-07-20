package karaoke.model;

public class Song {
  private String artist;
  private String title;
  private String url;

public Song(String artist, String title, String url) {
  this.artist = artist;
  this.title = title;
  this.url = url;
}

public String getTitle() {
  return title;
}

public String getArtist() {
  return artist;
}

public String getUrl() {
  return url;
}

@Override
public String toString() {
  return title + " by " + artist;

}


}
