public class Logic {

/*
TO DO --> EL ALGORITMO DE SEPARACION ES EFICIENTE PERO NO ES EFICAZ, PORQUE NO TIENE EN CUENTA EL TAMAÑO COMPLETO DE LA PALABRA
ANTES DE ASIGNARLA A UNA FRASE, SE PODRIA MEJORAR MUCHO.
*/


  public String  textToDivide;
  Integer numberOfLines;

  public Logic (String textToDivide, Integer numberOfLines) {
    this.textToDivide = textToDivide;
    this.numberOfLines = numberOfLines;

  }




  public String[] divideText(String text) {

    //ME GUSTARIA DIVIDIRLA EN MAS FUNCIONES, PERO COMO "ITERO" DENTRO DE UNA ITERACION Y LE PASO EL INDICE A LA DE FUERA?

    Double scrappedWeight = 0.0; //LO HAGO ASi PORQUE NO VEO LA FORMA DE INTEREARR DENTRO DE UN LOOP CONTANDO CADA VUELTA EN EL LOOP EXTERNO, ES UN APAÑO

    Double positionOfSplittedText;
    Integer positionOfSplittedTextInt;
    String[] dividedInWordsText = separateWords(textToDivide);

    Double realWeight = countLenght(textToDivide); // - (numberOfLines - 1) * countLenght(" ");
    // System.out.println(String.valueOf(realWeight));
    Double weigthPerLine = realWeight / numberOfLines;
    String[] equalLines = new String[numberOfLines];

    for (int i = 0; i < dividedInWordsText.length; i++) {

      positionOfSplittedText = (scrappedWeight / weigthPerLine); // OJO ÚLTIMO NÚMERO!  por que tengo que hacer estos dos pasos tontos?? No me deja añadirlo en cola!!!
      positionOfSplittedTextInt = positionOfSplittedText.intValue();

      if ( equalLines[positionOfSplittedTextInt] == null ) { //Hay alguna otra forma de evitar tener que hacer esta linea? se entiende mal el codigo y es añadir por añadir...
      equalLines[positionOfSplittedTextInt]= dividedInWordsText[i];
      }
      else {
      equalLines[positionOfSplittedTextInt]+= dividedInWordsText[i];
      }

      scrappedWeight += countLenght(dividedInWordsText[i]);

      if (i < dividedInWordsText.length - 1) { //antes me salía un out of bounds porque estaba añadiendo un espacio al final de la frase, lo cual hacía que se fuese al siguiente, que no existe...
        equalLines[positionOfSplittedTextInt]+= " ";
        scrappedWeight += countLenght(" ");
      }
    }

    // cleanLines(equalLines);

    return equalLines;


  }


  // public void cleanLines(String[] lines) {
  //   for (int i = 0; i < lines.length; i++) {
  //     if (lines[i].charAt(lines[i].length() == ' ')){
  //
  //
  //     }
  //   }
  //
  // }

  public String[] separateWords(String textToDivide) {
  // FUNCTION:  Given a text, it returns an String array with separate words
  //           Punctuation is considered part of the word
    String[] wordsArray = textToDivide.split(" "); //LO HAGO ASI PORQUE NO TENGO CLARO QUE ME DEVOLVERIA...
    return wordsArray;
  }


  public Double countLenght(String textToWeight){
  // FUNCTION:  Given a text, it returns the weight of the text
  //           based on the weight of each character
  //           according to a set of constant Strings

    String LARGAS = "abcdefghijklmnopqrstuvwxyz ";
    String MEDIANAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String CORTAS = "";
    String MUY_CORTAS = "";
    Double weight = 0.0;

    for (int i = 0; i < textToWeight.length(); i++) {
    // Iterates the String to measure

      if (LARGAS.indexOf(textToWeight.charAt(i)) > 0) {
        weight += 1.5;
      }
      else if (MEDIANAS.indexOf(textToWeight.charAt(i)) > 0) {
        weight += 1;
      }

      else if (CORTAS.indexOf(textToWeight.charAt(i)) > 0) {
        weight += 0.5;
      }

      else if (MUY_CORTAS.indexOf(textToWeight.charAt(i)) > 0) {
        weight += 0.25;
      }
    }
    return weight;
  }


}
