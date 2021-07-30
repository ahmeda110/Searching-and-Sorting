import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException { //main method

    Scanner scanner = new Scanner(System.in); //scanner

    System.out.print("Please enter the desired file name: ");
    String fileName = scanner.nextLine(); //file to be opened

    File in = new File(fileName); // checking if file exists
    if (! in .exists()) { //if not found
      System.out.println();
      System.out.println("File not found, terminating. . .");
      System.exit(0); // terminating
    }

    System.out.println("--------------------------------------------------");
    System.out.print("Please enter the file name where you would like the anagram groups to be orinted to: ");
    String OutName = scanner.nextLine(); // file to be output to
    System.out.println();
    System.out.println("Processing. . .");

    String[] input = readingFileS1(fileName); //calling the "readingFile" function to read the desired file and then store its words into a String array
    Sorting.stringSortingS2(input.length - 1, 0, input); //sorting the array in alphabetical/numerical order
    AnagramsAndOutputing.anagramsAndOutputS3(input, input.length, OutName); //finds anagrams and prints them to a file
    System.out.println("Process Complete! " + OutName + " created and has anagrams grouped in it.");

  }

  /* Step 1: This function gets the file wanted by the user 
   * and returns the words contained with it to be later
   * saved in a String array which is later utilized.  
   */
  public static String[] readingFileS1(String fileName) throws IOException {

    byte[] fileC = Files.readAllBytes(Paths.get(fileName)); //reading all bytes from the file "fileName" and storing them into a byte array - Paths.get() (path of file) 
    String data = new String(fileC); //bytes -> String
    String[] input = data.split("\r\n"); //String Delimiter, if combination fails -> combine single char line separators
    return input; // returning words
  }
}
