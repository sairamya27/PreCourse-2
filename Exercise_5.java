class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
    //Try swapping without extra variable 
        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i] - arr[j];
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[l];
        int i=l;
        int j= h;
        while(i<j) {
            while(arr[i]<=pivot && i<arr.length-1) {
                i++;
            }
            while(arr[j]>pivot && j>0) {
                j--;
            }
   
            if(i<j) {
            swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        // Create an auxiliary stack
        int[] arrStack = new int[h - l + 1];
        int top = -1;
        arrStack[++top] = l;
        arrStack[++top] = h;
        
        while (top >= 0) {
            h = arrStack[top--];
            l = arrStack[top--];
            int p = partition(arr, l, h);
            if (p - 1 > l) {
                arrStack[++top] = l;
                arrStack[++top] = p - 1;
            }
            if (p + 1 < h) {
                arrStack[++top] = p + 1;
                arrStack[++top] = h;
            }
        }       
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 