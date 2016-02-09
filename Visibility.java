
import java.util.Arrays;
import java.util.Hashtable;

public class Visibility {
	
	public static void main(String[] args) {
		

		Hashtable <Integer, Integer> ht= new Hashtable<Integer, Integer>();
		InputData inp = new InputData(args[0]);
		
		Building[] BuildingArray;
		int[] XArray;
		int[] AllX;
		float[] heights;
		
		
		int n=inp.getN();
		
		XArray = new int[2*n];
		AllX = new int[2*n+1];
		
		AllX=inp.getAllXArray();

		quickSort(AllX,0,2*n-1);
		
		
		int k=0;
		XArray[k]=AllX[0];
		for (int i = 1; i < 2*n; i++) {
			if (AllX[i]> AllX[i-1]) {
				XArray[++k]=AllX[i];
			}
		}
		

		int Xlength=k+1;

		
		for (int i = 0; i < Xlength; i++){
			ht.put(XArray[i],i);
		}
				
		heights=new float[Xlength];
		for (int i = 0; i < Xlength; i++){
			heights[i]=0;
		}
		
		
		BuildingArray = new Building[n];
		BuildingArray = inp.getArrayOfBuildings();		
		Arrays.sort(BuildingArray, new YswComparator());	//sort Buildings by Ysw
		
		int counter=0;
		for (int i = 0; i < n; i++){
			int left=ht.get(BuildingArray[i].getXsw());
			int right=ht.get(BuildingArray[i].getXne());
			int flag=0;
			for (int j = left; j < right; j++){
				if (heights[j]< BuildingArray[i].getH()) {
					heights[j]= BuildingArray[i].getH();
					flag=1;
				}
			}
			if (flag==1){
				counter++;
			}

		}
		System.out.println(counter);
		
		
	}
	
	
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
	
	
}
