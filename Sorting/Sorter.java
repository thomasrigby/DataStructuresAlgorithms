package Sorting;
//import CITS2200.Sort;
/**
 * Comparison on different sorting algorithms.
 */
public class Sorter{

  /**
   * Executes the insertion sort algorithm sorting the argument array. There is
   * no return as the parameter is to be mutated.
   *
   * @param      a     The array of long integers to be sorted.
   */
  public static void insertionSort(long[] arr) {
     for (int i = 1; i < arr.length; i++) {
      long key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];

        j--;

      }
      arr[j + 1] = key;
    }
  }

  /**
   * Executes the merge sort algorithm sorting the argument array. There is no
   * return as the parameter is to be mutated.
   *
   * @param      a     the array of long integers to be sorted
   * @return 
   */
  public static void mergeSort(long[] arr){
    int arrayLength = arr.length;

    if (arrayLength < 2) {
      return;
    }
    int middle = arrayLength / 2;
    long[] left = new long[middle];
    long[] right = new long[arrayLength - middle];

    for (int i = 0; i < middle; i++) {
      left[i] = arr[i];
    }
    for (int i = middle; i < arr.length; i++) {
      right[i - middle] = arr[i];
    }
    mergeSort(left);
    mergeSort(right);
    sort(arr, left, right);
  }
  private static void sort(long[] arr, long[] left, long[] right) {
    int leftLength = left.length;
    int rightLength = right.length;

    int i = 0;
    int z = 0;
    int y = 0;

    while (i < leftLength && z < rightLength) {
      if (left[i] <= right[z]) {
        arr[y] = left[i];

        i++;

      } else {
        arr[y] = right[z];

        z++;

      }
      y++;

    }
    while (i < leftLength) {
      arr[y] = left[i];
      i++;
      y++;
    }
    while (z < rightLength) {
      arr[y] = right[z];
      z++;
      y++;
    }
  }

  
  /**
   * Executes the quick sort algorithm sorting the argument array. There is no
   * return as the parameter is to be mutated.
   *
   * @param      a     The array of long integers to be sorted.
   */
  public static void quickSort(long[] arr){
     quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(long[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    long pivot = arr[high];
    int lp = low;
    int rp = high;

    while (lp < rp) {
      while (arr[lp] <= pivot && lp < rp) {
        lp++;

      }
      while (arr[rp] >= pivot && lp < rp) {
        rp--;

      }
      swap(arr, lp, rp);
    }
    swap(arr, lp, high);
    quickSort(arr, low, lp - 1);
    quickSort(arr, lp + 1, high);
  }

  private static void swap(long[] arr, int i1, int i2) {
    long temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
  }
 
  public static void main(String[] args){
  long arr[] = {1,2,3,57,8,2,3,1,23,43};
  long dupe[] = arr.clone();
  for(int i = 0; i < arr.length;i++){
    System.out.println(arr[i]);
   }
   //Insertion Sort
   insertionSort(dupe);
   System.out.println("Insertion Sort:");
   for(int i = 0; i < arr.length;i++){
    System.out.println(dupe[i]);
   }
   //Merge Sort
   long repl[] = arr.clone();
   System.out.println("Merge Sort:");
   mergeSort(repl);
   for(int i = 0; i < arr.length;i++){
    System.out.println(repl[i]);
   }
   //Quick Sort
   long copy[] = arr.clone();
   System.out.println("Quick Sort:");
   quickSort(copy);
   for(int i = 0; i < arr.length;i++){
    System.out.println(copy[i]);
   }
  }
}