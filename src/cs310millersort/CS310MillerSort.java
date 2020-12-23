/*
 * This program uses various sorting methods and times each. It then produces
 * a report to export the results
 */
package cs310millersort;
import java.io.*;
import java.util.*;
/**
 *
 * @author Kyle W. Miller
 * @version 1.0
 */
public class CS310MillerSort {
   
   static SortingAlgorithmImpl sortingAlgorithmImpl = new SortingAlgorithmImpl();
   static PrintImpl printImpl = new PrintImpl();
   //static long[][] resultsArray = new long[3][3];
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
   
      
      System.out.println("Welcome to Kyle's sorting comparison tool!");
      sortingFunction();
      createReport();
      

   }
   
   /** 
    * This method is what performs the sorting, stores the time it takes,
    * as well stores the time in a result array 
    */
   public static void sortingFunction(){
         
      final int NUM_ELEMENTS = 50000;

      //create lists! 
      Integer[] list1 = new Integer[NUM_ELEMENTS];
      Integer[] list2 = new Integer[NUM_ELEMENTS];
      Integer[] list3 = new Integer[NUM_ELEMENTS];
  
      
      for(int sort = 0; sort < 3; sort++){
         int run = 0;
         
         System.out.println();
         System.out.println("Starting Sort# " + (sort +1) );
         //creates random generation function
         java.util.Random random = new java.util.Random();
      
         //intialize lists
         for(int i = 0; i < NUM_ELEMENTS; i++){
         list1[i]=list2[i]=list3[i] = random.nextInt(100000);
         }
         
         //SELECTION SORT BLOCK
         long start1 = System.currentTimeMillis();
         sortingAlgorithmImpl.selectionSort(list1);
         long end1 = System.currentTimeMillis();
         long diff1 = end1 - start1;
         //double secondsDiff1 = diff1 * 0.001;
         //resultsArray[sort][run] = diff1;
         sortingAlgorithmImpl.addToResultsArray(run, sort, diff1);
         System.out.print("    Selection Sort Time: ");
         System.out.println(diff1 + " milliseconds");
         run++;
         
         //verifies list is ordered
         if(verifyOrder(list1) == true){
            System.out.println("Sort validated!");
         }
         else{
            System.out.println("ERROR: Sort could not be validated.");
            System.exit(99);
         }
         
        
         
         //INSERTION SORT BLOCK
         long start2 = System.currentTimeMillis();
         sortingAlgorithmImpl.insertionSort(list2);
         long end2 = System.currentTimeMillis();
         long diff2 = end2 - start2;
         //double secondsDiff2 = diff2 * 0.001;
         //resultsArray[sort][run] = diff2;
         sortingAlgorithmImpl.addToResultsArray(run, sort, diff2);
         System.out.print("    Insertion Sort Time: ");
         System.out.println(diff2 + " milliseconds");
         run++;
         //verifies list is ordered
         if(verifyOrder(list2) == true){
            System.out.println("Sort validated!");
         }
         else{
            System.out.println("ERROR: Sort could not be validated.");
            System.exit(99);
         }
  
         //QUICK SORT BLOCK
         long start3 = System.currentTimeMillis();
         sortingAlgorithmImpl.quickSort(list3, 0 , NUM_ELEMENTS - 1);
         long end3 = System.currentTimeMillis();
         long diff3 = end3 - start3;
         //double secondsDiff3 = diff3 * 0.001;
         //resultsArray[sort][run] = diff3;
         sortingAlgorithmImpl.addToResultsArray(run, sort, diff3);
         System.out.print("     Quick Sort Time: ");
         System.out.println(diff3 + " milliseconds");
         //verifies list is ordered
         if(verifyOrder(list3) == true){
            System.out.println("Sort validated!");
         }
         else{
            System.out.println("ERROR: Sort could not be validated.");
            System.exit(99);
         }
 
      }
   }
   
    /**This method verifies sorting actually works
    * @param list
    */
   public static boolean verifyOrder(Integer[] list){
   
      boolean verification = false;

      //iterates through entire loop and compares if value is less than previous
      for(int i = 0; i < list.length - 1; i++){
         int higherIdx = i + 1;
         if(list[i] < list[higherIdx]){
            verification = true;
         }
      }

      return verification;
         
   }
   
    /** 
    * This method prints the report
    */
   public static void createReport(){
      printImpl.printReport(sortingAlgorithmImpl);
   
   }
   
   
}
