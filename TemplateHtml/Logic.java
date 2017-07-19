import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.*;
import java.util.*;


public class Logic {

  // Map<String, String> placeholdersAndValues = new Hasmap<String, String>;

  public static String cleanText(String text, String subString){
    //Deletes subString from String and returns the new String.

    return text.replace(subString, "");
  }

  public static String createCustomhtml (String template, String[] separators) {
    //Main function: Given the string template and a String[] of separators {opener, closer}
    //it returns the customiced text

    //FERRAN --> DEBERIA ESTAR ESTO EN TEMPLATEHTML?


    Map<String, Integer[]> coordinates = new HashMap<String, Integer[]>();
    coordinates = findPlaceHolders(template, separators[0], separators[1]);

    Map<String, String> placeholdersAndValues = new HashMap<String, String>();
    placeholdersAndValues = getValuesFromMap(coordinates, separators[0], separators[1]);

    String customHtml = substituteKeysPerValues(template, placeholdersAndValues);
    return customHtml;

  }


  public static Map<String, String> getValuesFromMap(Map<String, Integer[]> coordinates, String opener, String closer) {
    //Given a map of coordinates, an opener mark and a closer mark, it returns a Map<String, String> with key
    //the placeholder (included the marks) and value the value selected by user

    Map<String, String> placeholdersAndValues = new HashMap<String, String>();

    for (String key: coordinates.keySet()) {
      //clean the placeholder name to show it to the user (a.k.a: eliminates marks)
      String placeholderName = cleanText(key, opener);
      placeholderName = cleanText(placeholderName, closer);

      //get the user value for that placeholder and put the pair (key, value) in the Map
      String value = Prompter.getValue(placeholderName);
      placeholdersAndValues.put(key, value);

    }

    return placeholdersAndValues;
  }


  public static String substituteKeysPerValues(String template, Map<String, String> listKeysAndValues) {
    //Given a template String and a Map<String, String> of placeholders and values, it substitutes the
    //placeholders for their value in every instance of the given String

    String customizedString = template;

    for (String placeHolder: listKeysAndValues.keySet() ) {
      customizedString = customizedString.replace(placeHolder, listKeysAndValues.get(placeHolder));
    }
    return customizedString;
  }



  public static String readFile(String path, Charset encoding)
  //COMENTAR CON FERRAN
    throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }



  public static Map<String, Integer[]> findPlaceHolders(String template, String opener, String closer) {
  //FUNCTION: given a String template, an opener String (open placeholder) and a closer String (close placholder)
  //it returns a map of placholders (key) and their coordinates (position of first open and position of last close)

    Map<String, Integer[]> coordinates = new HashMap<String, Integer[]>();
    List<Integer> openerCoordinates = new ArrayList<Integer>();
    List<Integer> closerCoordinates = new ArrayList<Integer>();

    //List of integer with the position of every instance of the placeholders marks
    openerCoordinates = positionsOfSubstring(opener, template);
    closerCoordinates = positionsOfSubstring(closer, template);

    //Creates the output map, combining both coordintes and the name in each item.

    for (int i = 0; i < openerCoordinates.size(); i++) {
      Integer[] coordinate = {openerCoordinates.get(i), closerCoordinates.get(i)}; //create coordinate pairs
      String coordinateName = template.substring(openerCoordinates.get(i), closerCoordinates.get(i)+closer.length()); //get coordinate name
      coordinates.put(coordinateName, coordinate);
    }

    return coordinates;
  }



  static public List<Integer> positionsOfSubstring (String substring, String text ) {
    //Given a text and a substring, it returns a List<Integer> of the position of each instance of the substring

      List<Integer> coordinates = new ArrayList<Integer>();

      for (int i = 0; i < text.length();) { //increasing by 1 wuold be inneficiente and return repeated values
        coordinates.add(text.indexOf(substring, i));

        //if this instance is the last one, do break the loop
        if (text.indexOf(substring, i) == text.lastIndexOf(substring)) {
          break;
        }

        i = text.indexOf(substring, i) + 1; //each time it finds an instance, it jumps right to the next char
        }
      return coordinates;
  }



}
