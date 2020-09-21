import java.util.*;
public class DirReduction {
  public static String[] dirReduc(String[] arr) {
    
    //Array mit Länge der String[] Eingabe 
    int[] intArray = new int[arr.length];
    //Werte auf 1 setzen. Bei unnötiger Angabe -> 0
    for (int n = 0; n < arr.length; n++) {
      intArray[n] = 1;
    }
    
    //list zum Speichern der notwendigen Angaben
    List<String> arrayList = new ArrayList();    
    
    
    // j prüft nachfolgende Eingabe != 0
    int j = 0;
    // k prüft vorangehende Eingabe != 0
    int k = 0;
    int x = 0;

    for (int i = 0; i < arr.length; i++) {
      if (
          arr[i] == "NORTH" && arr[i+1] == "SOUTH" 
      ||  arr[i] == "SOUTH" && arr[i+1] == "NORTH"
      ||  arr[i] == "EAST"  && arr[i+1] == "WEST"
      ||  arr[i] == "WEST"  && arr[i+1] == "EAST"
      ){
        intArray[i]   = 0;
        intArray[i+1] = 0;
        i++;
        x=0;
        k = i-1;
        j = i;
        while(x<arr.length){
          x++;
           while(intArray[k]==0 && k != 0) {
            k--;
          }
          while(intArray[j]==0 && j+1 < arr.length) {
            j++;
          }
            if(
            (   arr[k] == "NORTH" && arr[j] == "SOUTH" 
            ||  arr[k] == "SOUTH" && arr[j] == "NORTH"
            ||  arr[k] == "EAST"  && arr[j] == "WEST"
            ||  arr[k] == "WEST"  && arr[j] == "EAST"
            ) && intArray[k] == 1 && intArray[j] == 1
            ){
              intArray[k] = 0;
              intArray[j] = 0;
            }
          }
        }
      /* Ausgabe zur Kontrolle des int[] 
      for (int o = 0; o < arr.length; o++) {
       //System.out.println(intArray[o]);
      }
      */
      // Verhindert IndexOutOfBounds
      if(i == arr.length - 2) {
        i++;
      }
      /* Ausgabe zur Kontrolle des Schleifendurchlaufs
      System.out.println("Ende Durchlauf");
      */
    }
    
    // 1 in intArray[i] = notwendige Angabe -> list.add[i]
    for (int l = 0; l < arr.length; l++) {
      if (intArray[l] == 1) {
        arrayList.add(arr[l]);
      }
    }
    
    String[] str = arrayList.toArray(new String[0]);

    return str;
  }
}
