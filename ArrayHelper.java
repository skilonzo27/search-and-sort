import java.util.Arrays;

public class ArrayHelper {

	/* Create an integer array with numElements, randomized
	 * between [min, max]
	 */
	public static int[] create(int numElements, int min, int max) {
		int[] arr = new int[numElements];
		for(int i=0; i< arr.length; i++) {
			arr[i] = (int)(min+Math.random() * (max-min+1));
		}
		return arr;
	}
	
	public static ArrayStats bubbleSort(int[] arr) {
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr.length-1; j++) {
				stats.incrementLoops();
				stats.incrementIfs();
				if(arr[j] > arr[j+1]) {
					stats.incrementSwaps();
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		stats.endTimer();
		return stats;
	}

	public static ArrayStats bubbleSortImproved(int[] arr) {
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr.length-1-i; j++) {
				stats.incrementLoops();
				stats.incrementIfs();
				if(arr[j] > arr[j+1]) {
					stats.incrementSwaps();
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		stats.endTimer();
		return stats;
	}

	public static ArrayStats selectionSort(int[] arr) {
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		for(int i=0; i<arr.length-1; i++) {
			int smallestIndex = i;
			for(int j=i+1; j < arr.length; j++){
				stats.incrementLoops();
				stats.incrementIfs();
				if(arr[j] < arr[smallestIndex]) smallestIndex = j;
			}
			stats.incrementSwaps();
			int temp = arr[i];
			arr[i] = arr[smallestIndex];
			arr[smallestIndex] = temp;
		}
		stats.endTimer();
		return stats;
	}

	public static ArrayStats insertionSort(int[] arr){
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			for(int j=i-1; j>=0; j--){
				stats.incrementLoops();
				stats.incrementIfs();
				if(arr[j] > temp) {
					stats.incrementSwaps();
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
				else{
					continue;
				}
			}
		}
		stats.endTimer();


		return stats;
	}

	public static int factorial(int n){
		if(n == 1) return 1;
		else{
			return n * factorial(n-1);
		}
	}

	/*you split the array until it is into arrays of length one.
	 * then you go recurse and create a new dummy array to order the numbers thats the size of the
	 * 2 most recent partitioned arrays.
	 * you make the dummy array and then you look at the 2 arrays and going through both of the 2
	 * arrays, say the index of the dummy array is k, and the index of the first is i, and the 
	 * other is j. you then go through k and k asks the beginning of each array which is smaller
	 * then adds that to the k index of the new array. then you increment k and whatever array you
	 * pulled from. then you repeat this until either i or j is bigger than the size of it's
	 * respective array, in that case you would just copy the rest of the other array to the
	 * dummy array. or k is bigger which in that case it is just finished. then you replace the
	 * recursed array you split to get the 2 partitioned arrays with the dummy array because it is
	 * in order. then you go up in order and you continue to do the same process until you return 
	 * the full array
	 */

	private static int[] merge(int[] arr, int low, int middle, int high) {
		if(arr.length > 1){
			int highTwo = high;
			high = middle;
			int lowTwo = middle+1;
			middle = (low+high)/2;
			int middleTwo = (lowTwo+high)/2;
			int[] newArr = Arrays.copyOf(arr, high+1);
			int[] newArrTwo = Arrays.copyOfRange(arr, lowTwo, highTwo+1);
			
			
			System.out.println(Arrays.toString(newArr));
			System.out.println(Arrays.toString(newArrTwo));
			newArr = merge(newArr, low, middle, high);
			newArrTwo = merge(newArrTwo, lowTwo, middleTwo, high);

			System.out.println(1);
			System.out.println(Arrays.toString(newArr));
			System.out.println(Arrays.toString(newArrTwo));
			int[] a = newArr;
			int[] b = newArrTwo;

			int[] dummy = new int[(high-low)+1];
			int k=0; //temp index
			int i=0; //a index
			int j=0; //b index

			while(k < dummy.length){
				if(i == a.length){
					System.arraycopy(b, j, dummy, k, b.length);
					k = dummy.length;
				}
				else if(j == a.length){
					System.arraycopy(a, i, dummy, k, a.length);
					k = dummy.length;
				}
				else{
					if(a[i] > b[j]){
						dummy[k] = b[j];
						j++;
						k++;
					}
					else if(a[i] < b[j]){
						dummy[k] = a[i];
						i++;
						k++;
					}
					else{
						int[] c = {a[i], b[j]};
						System.arraycopy(c, 0, dummy, k, c.length);
						k += 2;
						i++;
						j++;
					}
					
				}
			}
			return dummy;
		}
		else {
			return arr;
		}
	}

	public static ArrayStats mergeSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int middle = (low+high)/2;

		System.out.println(Arrays.toString(arr));
		merge(arr, low, middle, high);
		return null;
	}

	public static boolean isSorted(int[] arr){
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1] < arr[i]) return false;
		}
		return true;
	}
	public static void print(int[] arr) {
		System.out.print("[");
		for(int i=0; i< arr.length; i++) {
			int temp = arr[i];
			System.out.print(temp);
			if(i != arr.length-1){
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}
