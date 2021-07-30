import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AnagramsAndOutputing {

  /*
   * Step3: This function finds anagrams then outputs them into a file
   * named as requested by the user
   */
  @SuppressWarnings("resource")
  public static void anagramsAndOutputS3(String[] array, int s, String OutName) throws FileNotFoundException {

    String[] copy = new String[s];
    System.arraycopy(array, 0, copy, 0, s); //creating a copy of "array" to later use to sort each word individually for later uses
    boolean first = true;
    int analyze = 0, x = 1;

    PrintStream out = new PrintStream(OutName); //OutStream

    for (int a = 0; a < copy.length; a++) {
      char[] toChar = copy[a].toCharArray();
      copy[a] = Sorting.charASorting(toChar.length - 1, 0, toChar); // sorting each word (line)
    }

    while (true) {

      if (array[analyze] != null && first == true) {
        out.print(array[analyze]);
        first = false;
      } //outputting first element 

      if (copy.length >= 2 && copy[x] != null && copy[analyze] != null) { // searching for anagrams
        if (copy[x].equals(copy[analyze]) && x != analyze) { //if matches
          out.print(" ");
          out.print(array[x]); // add it to line
          copy[x] = null;
          array[x] = null; //setting to null to "remove" and avoid repetition
          x--;
        }
      }

      if (x == array.length - 1) {
        x = 0;
        copy[analyze] = null;
        array[analyze] = null;
        first = true;
        analyze++;
      }

      if (first && array[analyze] != null) { //new line
        out.println();
      }

      if (analyze == array.length - 1) {
        if (array[analyze] != null) {
          out.print(array[analyze]);
          array[analyze] = null;
        }
        break;
      }
      x++;

    }
    out.println();
  } //all anagrams should be found here
}
