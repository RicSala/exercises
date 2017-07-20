package karaoke;

import karaoke.model.SongBook;
import karaoke.model.Song;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KaraokeMachine {
  private SongBook songBook;
  private BufferedReader reader;
  private Map<String, String> menu;


  public KaraokeMachine(SongBook songBook) {
    //CONSTRUC KARAOKE

    reader = new BufferedReader(new InputStreamReader(System.in));
    menu = new HashMap<String, String>();
    menu.put("add", "Add a song to the song book");
    menu.put("quit", "Give up! Exit the Karaoke");
  }



  private String askForAction() throws IOException {
    //DRAW THE MENU AND RETURN THE STRING WRITTEN BY THE USER
    System.out.printf("There %d songs available. Your options are: ", songBook.getSongCount());

    //REVISAR!!!!!

    for (Map.Entry<String, String> option: menu.entrySet()) {
      System.out.println(option.getKey() + " - " + option.getValue());
    }

    System.out.print("What do you want to do?  ");
    String choice = reader.readLine(); //MAY THROW AN EXCEPTION!
    return choice.trim().toLowerCase();
    }


  public void run() {
    String choice = ""; //WHY THAT ""??

    do {
      try {
        choice = askForAction();
        switch(choice) {

          case"add":
            Song song = addSong();
            System.out.printf(song + " added to the song book!%n%n%n");
          break;

          case"quit":
            System.out.println("Thanks for playing!!");
          break;

          default:
            System.out.println("Unknown choice!");
        }
      }
      catch(IOException ioe) {
            System.out. println("There was a problem");
            ioe.printStackTrace();
      }
    }

    while (!choice.equals("quit")); //OJO! LAS CADENAS DE STRING COPARARLAS CON EQUALS, SON OBJETOS REFERENCIADOS!

  }

  private Song addSong() throws IOException {
    // String artist = System.out.println("Enter the artists name: "); ----> OJO!!!!!
    // String title = System.out.println("Enter the song title: ");
    // String url = System.out.println("Enter the song's URL: ");

      System.out.println("Enter the artists name: ");
      String artist = reader.readLine();
      System.out.println("Enter the song title: ");
      String title = reader.readLine();
      System.out.println("Enter the song's URL: ");
      String url = reader.readLine();

    return new Song(artist, title, url);

  }



























}
