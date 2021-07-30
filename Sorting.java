public class Sorting {

  /* 
   * This function assists in step 3, where it takes the ordered array
   * from step 2 and sorts each individual String from each line for 
   * easier comparisons when finding anagrams (car -> acr) and so on.
   */
  public static String charASorting(int e, int s, char[] array) {

    int lowerH = s, higherH = e; //scan from both sides
    char placeH, pvt = array[(higherH + lowerH) / 2]; //middle spot

    if (array != null) { //making sure array contains elements 
      while (higherH >= lowerH) { //scan till lowerH and HigherH meet
        while (pvt < array[higherH]) {
          higherH--;
        } // end side -> if current element > pvt go on
        while (pvt > array[lowerH]) {
          lowerH++;
        } // start side -> if current element < pvt go on

        if (higherH >= lowerH) { // checking elements at center right as both side scans cross -- swapping
          placeH = array[lowerH];
          array[lowerH] = array[higherH];
          array[higherH] = placeH;
          higherH--;
          lowerH++;
        }
      }
      if (e > lowerH) {
        charASorting(e, lowerH, array);
      }

      if (higherH > s) {
        charASorting(higherH, s, array);
      } //Recursive calling to sort from start and end 
    }
    return String.valueOf(array); //return fully sorted word
  }

  /*
   * Step 2: Now that the file is read and stored in an array this function 
   * uses the "quick-sort" method to sort the String array in order (low to high or 
   * Alphabetically).
   */
  public static void stringSortingS2(int e, int s, String[] array) {

    int lowerH = s, higherH = e; //scan from both sides
    String placeH, pvt = array[(higherH + lowerH) / 2]; //middle spot

    if (array != null) { //making sure array contains elements 
      while (higherH >= lowerH) { //scan till lowerH and HigherH meet
        while (0 < array[higherH].compareTo(pvt)) {
          higherH--;
        } // end side -> if current > origin element go on and stop when an element is < pvt
        while (0 > array[lowerH].compareTo(pvt)) {
          lowerH++;
        } // start side -> if current < origin element go on and stop when an element is > pvt

        if (higherH >= lowerH) { // checking elements at center right as both side-scans cross -- swapping
          placeH = array[lowerH];
          array[lowerH] = array[higherH];
          array[higherH] = placeH;
          higherH--;
          lowerH++;
        }
      }
      if (e > lowerH) {
        stringSortingS2(e, lowerH, array);
      }

      if (higherH > s) {
        stringSortingS2(higherH, s, array);
      } //Recursive calling to sort from start and end 
    }
  }
}
