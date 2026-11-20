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

	private static int[] merge(ArrayStats stats, int[] arr, int low, int middle, int high) {
		middle -= low;
		high -= low;
		low -= low;
		if(arr.length > 1){
			int[] newArr = Arrays.copyOf(arr, middle+1);
			int[] newArrTwo = Arrays.copyOfRange(arr, middle+1, arr.length);
			
			int highTwo = high;
			int lowTwo = middle+1;
			int middleTwo = (lowTwo+highTwo)/2;
			high = middle;
			middle = (low+high)/2;
			
			newArr = merge(stats, newArr, low, middle, high);
			if(newArrTwo.length > 1){
				newArrTwo = merge(stats, newArrTwo, lowTwo, middleTwo, highTwo);
			}

			int[] a = newArr;
			int[] b = newArrTwo;

			int[] dummy = new int[(highTwo-low)+1];
			int k=0; //temp index
			int i=0; //a(newArr) index
			int j=0; //b(newArrTwo) index

			while(k < dummy.length){
				stats.incrementLoops();
				stats.incrementIfs();
				if(i >= a.length){
					System.arraycopy(b, j, dummy, k, b.length-j);
					k = dummy.length;
				}
				else if( j >= b.length){
					System.arraycopy(a, i, dummy, k, a.length-i);
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
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		int[] a = merge(stats, arr, low, middle, high);
		stats.endTimer();

		return stats;
	}

	public static ArrayStats linearSearch(int[] arr, int target) {
		ArrayStats stats = new ArrayStats();
		stats.startTimer();
		for(int i=0; i<arr.length; i++){
			stats.incrementLoops();
			stats.incrementIfs();
			if(arr[i] == target) {
				stats.endTimer();
				return stats;
			}
		}
		stats.endTimer();
		return stats;
	}

	public static ArrayStats binarySearch(int[] arr, int target){
		ArrayStats stats = new ArrayStats();

		stats.startTimer();
		int low = 0;
		int high = arr.length-1;
		int mid = (low+high)/2;

		while(mid != target) {
			stats.incrementLoops();
			stats.incrementIfs();
			if(mid > target){
				high = mid;
				mid = (low+high)/2;
			}
			else{
				low = mid;
				mid = (low+high)/2;
			}
		}

		stats.endTimer();
		return stats;
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
