/* Printing class.
 *
 */
package cs310millersort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author kyle
 */
public class PrintImpl {
   
   private final String outputFileName = "output/sortResults.txt";
   
   /** This method performs quick sort
    * @param sortingAlgorithmImpl
    */ 
   public void printReport(SortingAlgorithmImpl sortingAlgorithmImpl){
     long [][] resultsArray = sortingAlgorithmImpl.getResultsArray();
     long averageTime1;
     long averageTime2;
     long averageTime3;
     System.out.println();
     
    try{

      File outFile = new File(outputFileName); //creates file object
      PrintWriter fileOutput; //instaniates printwriter variable
 
      fileOutput = new PrintWriter(outFile);//defines printwriter variable
      
      fileOutput.println("SORTING RESULTS");
      fileOutput.println("-----------------");
      //Run No. Headers
      fileOutput.printf("%25s","Run 1");
      fileOutput.printf("%15s","Run 2");
      fileOutput.printf("%15s","Run 3");
      fileOutput.printf("%15s\n","Average");
      
      //SELECTION SORT PRINTING
      fileOutput.print("Selection Sort:");
      fileOutput.printf("%10d", resultsArray[0][0]);
      fileOutput.printf("%15d", resultsArray[1][0]);
      fileOutput.printf("%15d", resultsArray[2][0]);
      //defines average
      averageTime1 = (resultsArray[0][0] + resultsArray[1][0] + 
              resultsArray[2][0]) / 3;
      fileOutput.printf("%15d\n", averageTime1 );
      
      //INSERTION SORT PRINTING
      fileOutput.print("Insertion Sort:");
      fileOutput.printf("%10d", resultsArray[0][1]);
      fileOutput.printf("%15d", resultsArray[1][1]);
      fileOutput.printf("%15d", resultsArray[2][1]);
      //defines average
      averageTime2 = (resultsArray[0][1] + resultsArray[1][1] + 
              resultsArray[2][1]) / 3;
      fileOutput.printf("%15d\n", averageTime2 );
      
      //QUICK SORT PRINTING
      fileOutput.print("Quick Sort:");
      fileOutput.printf("%14d", resultsArray[0][2]);
      fileOutput.printf("%15d", resultsArray[1][2]);
      fileOutput.printf("%15d", resultsArray[2][2]);
      //defines average
      averageTime3 = (resultsArray[0][2] + resultsArray[1][2] + 
              resultsArray[2][2]) / 3;
      fileOutput.printf("%15d", averageTime3 );
     
     
     
      fileOutput.close();
      System.out.print("Report has been sucessfully exported to  " 
              + outputFileName);
    }
    catch(IOException e){
      System.out.println("**Error: cannot create report in " + outputFileName);
    }   
   }  
}
