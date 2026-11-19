public class ArrayStats {
	private long startTime;
	private long endTime;
	private int loopCount;
	private int ifCount;
	private long swapCount;

	public ArrayStats() {
		startTime = 0;
		endTime = 0;
		loopCount = 0;
		ifCount = 0;
		swapCount = 0;
	}

	public void startTimer() {
		startTime = System.currentTimeMillis();
	}	

	public void endTimer() {
		endTime = System.currentTimeMillis();
	}

	public long duration() {
		return endTime - startTime;
	}

	public void incrementLoops() {
		loopCount++;
	}

	public void incrementIfs() {
		ifCount++;
	}

	public void incrementSwaps() {
		swapCount++;
	}

	public int getIfCount() {
		return ifCount;
	}

	public int getLoopCount() {
		return loopCount;
	}

	public long getSwapCount() {
		return swapCount;
	}

	public String toString() {
		return "Duration: " + duration() +
			"\nLoops: " + loopCount +
			"\nIfs: " + ifCount +
			"\nSwaps: " + swapCount + "\n"; 
	}

}
