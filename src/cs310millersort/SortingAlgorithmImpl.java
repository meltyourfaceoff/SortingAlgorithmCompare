/*
 * Implementation class for CS310 
 */
package cs310millersort;

/**
 *
 * @author Kyle W. Miller
 * 
 */
class SortingAlgorithmImpl {

   
   private long[][] resultsArray;
   
   //intializes result Array
   public SortingAlgorithmImpl() {
       int sort = 0;
       int run = 0;
       resultsArray = new long[3][3];   
   }

   
   
   
    /**
    *
    * @param list
    * @param list
    * @return
    */
   public void selectionSort(Integer[] list){
      
      int lastItemIdx = list.length - 1;
     
      
      for(int i = 0; i < lastItemIdx; i++){
         
         int remainingListTop = i;
         for(int j = i + 1; j < list.length; j++){
            if(list[j] < list[remainingListTop]){
               remainingListTop = j;
            }
         }   
         int smallerNum = list[remainingListTop];
         list[remainingListTop] = list[i];
         list[i] = smallerNum;
            
         } 
      
      
      
   //return list;
   }
   
   
      /**
    *
    * @param list
    * @return
    */
   public void insertionSort(Integer[] list){
      
      int lastIndex = list.length;
      
      for(int remainingTopIdx = 1; remainingTopIdx < lastIndex; remainingTopIdx++){
         
         int insertValue = list[remainingTopIdx];
         int currentIdx = remainingTopIdx - 1;
         
           while(currentIdx >= 0 && list[currentIdx] > insertValue){
              list[currentIdx + 1] = list[currentIdx];
              currentIdx = currentIdx - 1;
           }
           list[currentIdx + 1] = insertValue;
      }
      
   
      //return list;
   }
   
    /** This method performs quick sort
    * @param list
    * @param low
    * @param high
    */
   public void quickSort(Integer[] list, int low, int high){
      
      if(low < high){
         
         int partIdx = partionList(list, low, high);
         
         quickSort(list, low, partIdx - 1);
         quickSort(list, partIdx +1, high);
      
      }
      //return list;
   
   }
    /** This method partions the list for quick sort
    * @param list
    * @param low
    * @param high
    * @return 
    */
   public int partionList(Integer[] list, int low, int high){
      
      //set the highest value to pivot!!
      int pivot = list[high];
      int i = (low - 1);
      
       for (int j=low; j<high; j++){ 
            // If current element is smaller than or equal to pivot 
            if (list[j] <= pivot){ 
                i++; 
                // swap list[i] and list[j] 
                int temp = list[i]; 
                list[i] = list[j]; 
                list[j] = temp; 
            } 
        } 
  
        // swap values pointed to by pivot and right
        int temp = list[i+1]; 
        list[i+1] = list[high]; 
        list[high] = temp; 
  
        return i+1; 
  
   }
   /** This method adds all timing values to an array 
    * @param run
    * @param sort
    * @param timeResults
    */
   public void addToResultsArray(int run, int sort, long timeResult){
   
      resultsArray[sort][run] = timeResult;
   
   }
   /** This method gets results from array
    * @return
    */
   public long[][] getResultsArray() {
      return resultsArray;
   }

}
