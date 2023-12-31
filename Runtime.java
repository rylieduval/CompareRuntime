import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Runtime
{
    static Random random = new Random();
    
    public static void main(String[] args)
    {
        //take in a user sized array
        
        System.out.println("Enter an array size: ");
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();

        //create the new arraay 
        int[] myArray = new int[arraySize];
        //fill the array with random integers from 0 to-100
        myArray = RandomizedArray(arraySize, 0, 101);
        //showcase the unsorted array
        System.out.println("Unsorted Array = " + Arrays.toString(myArray));

        //start the time before you call the selection sort function, and then see the time after the function runs to find the total run time
        long start = System.nanoTime();
        SelectionSort(myArray);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;  
        System.out.println("Sorting a random array size of " + arraySize + " took selection sort " + timeElapsed + " ns to complete");
        
        //start the time before you call the bubble sort function, and then see the time after the function runs to find the total run time
        long start2 = System.nanoTime();
        BubbleSort(myArray);
        long finish2 = System.nanoTime();
        long timeElapsed2 = finish2 - start2;  
        System.out.println("Sorting a random array size of " + arraySize + " took bubble sort " + timeElapsed2 + " ns to complete");
    }
    //function to fill the random array with a specific size, starting number, and ending number
    public static int[] RandomizedArray(int size, int start, int end)
    {
        int[] randomArray = new int[size];
    
        for (int i = 0; i < size; i++) 
        {
            randomArray[i] = random.nextInt((end) + start); 
        }
        
        return randomArray;
    }
    
    //selection sort method
    public static void SelectionSort(int[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int smallest = i;
            
            for (int j = i + 1; j < arr.length; j++) 
            {
                //comparing the current smallest index to the rest of the array indexes
                if (arr[j] < arr[smallest]) 
                {
                    smallest = j;
                }
            }
            //swap indexes if it finds a smaller index
            if (smallest > i) 
            {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        
        }
    }   
    //bubble sort function
    public static void BubbleSort(int[] arr) 
    {
        int temp = 0;  
        
        for(int i=0; i < arr.length; i++)
        {  
            for(int j=1; j < arr.length - i; j++)
            {  
                //check to see if number is smaller to the right, if so, swap them
                if(arr[j-1] > arr[j])
                {  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }         
            }  
        } 
    }  
}  
