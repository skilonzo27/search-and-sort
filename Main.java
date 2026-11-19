import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
	public static void main(String args[]) throws Exception{

		PrintWriter writer = new PrintWriter("results.csv");

		//processBubbleSort(writer);
		//System.out.println("Bubble Sort Done...");

		//processBubbleSortImproved(writer);
		//System.out.println("Bubble Sort Improved Done...");

		//processSelectionSort(writer);
		//System.out.println("Selection Sort Done...");

		//processInsertionSort(writer);
		//System.out.println("Insertion Sort Done...");

		int[] a = {5,4,3,2,1};
		ArrayStats stats = ArrayHelper.mergeSort(a);
		writer.close();

		System.out.println();
		int b = ArrayHelper.factorial(290);
		System.out.println(b);

		System.out.println("PROGRAM DONE...");
	}

	public static void processInsertionSort(PrintWriter writer){
		writer.println();
		writer.println("Selection Sort");
		writer.println("n,time,ifs,loops,swaps");

		int[] a = ArrayHelper.create(10,1,1000);
		ArrayStats stats = ArrayHelper.insertionSort(a);
		writer.println("10,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		
		a = ArrayHelper.create(100,1,1000);
		stats = ArrayHelper.insertionSort(a);
		writer.println("100,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(1000,1,1000);
		stats = ArrayHelper.insertionSort(a);
		writer.println("1000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(10000,1,1000);
		stats = ArrayHelper.insertionSort(a);
		writer.println("10000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		//close the writer

		a = ArrayHelper.create(100000,1,1000);
		stats = ArrayHelper.insertionSort(a);
		writer.println("100000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		writer.println("1000000,na,na,na,na");
	}

	public static void processSelectionSort(PrintWriter writer){
		writer.println();
		writer.println("Selection Sort");
		writer.println("n,time,ifs,loops,swaps");

		int[] a = ArrayHelper.create(10,1,1000);
		ArrayStats stats = ArrayHelper.selectionSort(a);
		writer.println("10,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		
		a = ArrayHelper.create(100,1,1000);
		stats = ArrayHelper.selectionSort(a);
		writer.println("100,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(1000,1,1000);
		stats = ArrayHelper.selectionSort(a);
		writer.println("1000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(10000,1,1000);
		stats = ArrayHelper.selectionSort(a);
		writer.println("10000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		//close the writer

		a = ArrayHelper.create(100000,1,1000);
		stats = ArrayHelper.selectionSort(a);
		writer.println("100000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		writer.println("1000000,na,na,na,na");
	}
	public static void processBubbleSortImproved(PrintWriter writer){
		writer.println();
		writer.println("Bubble Sort Improved");
		writer.println("n,time,ifs,loops,swaps");

		int[] a = ArrayHelper.create(10,1,1000);
		ArrayStats stats = ArrayHelper.bubbleSortImproved(a);
		writer.println("10,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		
		a = ArrayHelper.create(100,1,1000);
		stats = ArrayHelper.bubbleSortImproved(a);
		writer.println("100,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(1000,1,1000);
		stats = ArrayHelper.bubbleSortImproved(a);
		writer.println("1000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(10000,1,1000);
		stats = ArrayHelper.bubbleSortImproved(a);
		writer.println("10000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		//close the writer

		a = ArrayHelper.create(100000,1,1000);
		stats = ArrayHelper.bubbleSortImproved(a);
		writer.println("100000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		writer.println("1000000,na,na,na,na");
	}

	public static void processBubbleSort(PrintWriter writer) {
		writer.println("Bubble Sort");
		writer.println("n,time,ifs,loops,swaps");

		int[] a = ArrayHelper.create(10,1,1000);
		ArrayStats stats = ArrayHelper.bubbleSort(a);
		writer.println("10,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		
		a = ArrayHelper.create(100,1,1000);
		stats = ArrayHelper.bubbleSort(a);
		writer.println("100,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(1000,1,1000);
		stats = ArrayHelper.bubbleSort(a);
		writer.println("1000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		a = ArrayHelper.create(10000,1,1000);
		stats = ArrayHelper.bubbleSort(a);
		writer.println("10000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());
		//close the writer

		a = ArrayHelper.create(100000,1,1000);
		stats = ArrayHelper.bubbleSort(a);
		writer.println("100000,"+stats.duration()+","+stats.getIfCount()+","+stats.getLoopCount()+","+stats.getSwapCount());

		writer.println("1000000,na,na,na,na");
	}
}
