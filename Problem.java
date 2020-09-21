import java.util.*;
public class DirReduction {
    public static void main(String[] args){
     String[] arr = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
      List<String> arrayList = Arrays.asList(arr);  
      
      for (int i = 0; i < arr.length; i++) {
      if (
          arr[i] == "NORTH" && arr[i+1] == "SOUTH" 
      ||  arr[i] == "SOUTH" && arr[i+1] == "NORTH"
      ||  arr[i] == "EAST"  && arr[i+1] == "WEST"
      ||  arr[i] == "WEST"  && arr[i+1] == "EAST"
      ){
        //Testausgabe um zu sehen, wann Programm abbricht
        System.out.println("Test vor remove");
        arrayList.remove(i);
        System.out.println("Test nach remove");
        /*
            [...]
        */
        }
      }
     
      return;
    }
}
