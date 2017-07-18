public class TextSplitter {

  public static void main(String[] args) {

    //Creo objeto prompter para poder utilizar sus métodos. ¿Podria haberlo hecho sin prompter si fuesen static?

    Prompter prompter = new Prompter();

    String textToDivide = prompter.askForString(); //Solicito texto a dividir y lo asigno
    Integer numberOfStrings = prompter.askForNumberOfLines(); //Idem numero de lineas deseadas

    Logic logic = new Logic(numberOfStrings); //creo nuevo objeto logica. misma pregunta que arriba.
    String[] dividedText = logic.divideText(textToDivide); //ejecuto...me da la sensacion de que le estoy pasando el argumento dos veces...¿que difererncia hay entre dejar las funciones con parametros o que coja como parametros propiedades del objeto?

    prompter.showResult(dividedText);


    // System.out.printf("El peso tu texto es: %s%n",String.valueOf(weightOfText));









    //****************************************************************
    //POR QUE NO PILLA LA a???
    Double temp2 = logic.countLenght("bbc  a");
    System.out.println(String.valueOf(temp2));
    //****************************************************************



  }
}
