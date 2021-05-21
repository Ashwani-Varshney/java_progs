package Myassignment;
import java.util.Random; //for creating an object of class Random
class HeapSort
{

public static void heapSort(int[] data){ // parent function for heap sort that further calls initialise_MaxHeap() , reconstruct_MaxHeap()
    int size = data.length; //calculating the length of the data array
    int temp; //temporary variable to swap two values
	
	initialise_MaxHeap(data, size); //to construct the maxheap from the data array
	int i = size - 1;
	while(i > 0){
		
		temp = data[i];
		data[i] = data[0];
		data[0] = temp;
		
		reconstruct_MaxHeap(data, 0, i - 1);
		
		i--;
	} //swapped the largest element from the last element and reduced the size of the array by 1
}

public static void initialise_MaxHeap(int[] data, int size){ // function that creates a heap for the original user entered data
	
	int i = (size - 2) / 2; 
	while(i >= 0){
		
		reconstruct_MaxHeap(data, i, size - 1);
		i--;
	}//recreating the heap after removing the last element from the original data array
	
}

public static void reconstruct_MaxHeap(int[] data, int start, int end){ //function that recreates the heap for the remaning elements after removing th largest element
	
    int i = start;
    int temp;
	while((i * 2 + 1) <= end){      
		int child = i * 2 + 1;      //left child , child+1 = right child
		if(child + 1 <= end && data[child] < data[child + 1])
            child = child + 1;       
                
		if(data[i] < data[child]){     //making the larger value node as the parent node in each subtree
			temp = data[i];
			data[i] = data[child];
			data[child] = temp;
            i = child;      
                      
		}else
			return;
	}
}
	public static void main(String args[])
	{
        int data[] = new int[10]; //an array of 10 elements

        int rn=0;   //to store the random number generated in each iteration
        Random r=new Random(); //generating the numbers to be sorted randomly

        for(int i=0;i<10;i++)
            {
                    rn=r.nextInt(101);
                    data[i]=rn;
            }

        System.out.println("Unsorted array ( generated randomly ):");
     
		 for (int x: data) {
            System.out.print(" "+x);
        }
		
        heapSort(data);
        System.out.println("");
		System.out.println("Sorted array ( after performing Heap Sort ):");
		 for (int x: data) {
            System.out.print(" "+x);
        }
    } 
}