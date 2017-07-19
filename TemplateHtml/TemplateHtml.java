

public class TemplateHtml {

  public static void main(String[] args) {

    /*
    TODOs:
      1) LOS PLACEHOLDERS LOS PIDE DESORDENADOS --> REVISAR SI EL ORDEN DE HASHMAP ES CONSISTENTE
      2) DEBUG PLACEHOLDERS TIPO {{}} --> ESCAPAR GENEX O MODIFICAR TEXTO (MISMO PROBLEMA)
      3) REVISAR ESTRUCTURA ARCHIVOS Y VER SI CONVIENE HACER INSTANCIAS DE PROMPTER Y Logic
      4) COMENTARIOS PROMPTER
      5) COMENTARIOS TEMPLATEHTML
      6) SCANNER, ABRO Y CIERRO VARIAS VECES, REVISAR
      7) EXPULSAR EN ARCHIVO
    */

    String template = Prompter.readFile();
    String[] separators = Prompter.selectSeparators();


    String customHtml = Logic.createCustomhtml(template, separators);

    System.out.println(customHtml);



  }
}























//OLD CODE TO BE COMMENTED


// System.out.println("si, esto pasando por aqui" + Logic.positionsOfSubstring("u", prueba2));


// String[] temp = separators[0].split("");
// String temp2 ="";
//
// for (String s: temp) {
//   temp2 += "\\" + s;
// }
// System.out.println(temp2);

// template.replaceAll(separators[0], "[[");
// template.replaceAll(separators[1], "]]");




// String template = "<h1>{{title}}</t1><p>{{description}}</p>";
// String title = "Generando un html";
// String description = "Este java genera un html";
//
// template.replace("{{title}}", title);
// template.replace("{{description}}", description);
//
// System.out.println(template);
