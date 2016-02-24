import javafx.util.Pair;

public class Program {

    /*
     * if d2 in arr, then abs(d1 - d2) < eps, return true
     * 
     * Worst case: O(n); Best case: O(1); Average case: O(n)/2;
     */
    public static boolean 
    contains(double[] arr, double eps, double d1) {
	for (int i = 0; i < arr.length; i++) {
	    if (Math.abs(d1 - arr[i]) < eps) {
		return true;
	    }
	}
	return false;
    } // boolean contains(double[] arr, double eps, double d1)

    /*
     * returns x^y
     * 
     * Worst case: fastExp(x) =; Best case: fastExp(x) =; Average case: fastExp(x);
     * =
     */
    public static int 
    fastExp(int x, int y) {

	// break down exp until exp = 1
	if (y != 1) {
	    if (y % 2 == 0) {
		return fastExp(x * x, y / 2);
	    } else {
		return x * fastExp(x * x, (y - 1) / 2);
	    }
	}
	return x;
    } // int fastExp(int x, int y)

    // prints all pairs within input set, repeats included
    public static Pair[]
    allPairs(int[] arr) throws IllegalArgumentException {

	// ensure arr is not empty
	if (arr == null) {
	    throw new IllegalArgumentException("Error: arr is empty.");
	}

	// create pairs array
	Pair[] pairs = new Pair[arr.length * arr.length];
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr.length; j++) {
		pairs[i + j] = new Pair(arr[i], arr[j]);
	    }
	}
	return pairs;
    } // Pair[] allPairs(int[] arr)

    // replicates each string n times, and concatenates
    public static String 
    concatAndReplicateAll(String[] strings, int n) throws IllegalArgumentException {

	// ensure Strings is not empty
	if (strings == null) {
	    throw new IllegalArgumentException("Error, empty str array");
	}

	String retStr = new String();
	for (int i = 0; i < strings.length; i++) {
	    for (int j = 0; j < n; j++) {
		retStr = retStr.concat(strings[i]);
	    }
	}
	return retStr;
    } // String concatAndReplicateAll(String[] strings, int n)

    // returns the mode within the array of ints
    public static int 
    boundedMode(int[] arr) throws IllegalArgumentException {

	// ensure arr is not null
	if (arr == null) {
	    throw new IllegalArgumentException("Error, empty int array");
	}

	// create auxillary array
	int[] auxArr = new int[100];
	for (int i = 0; i < arr.length; i++) {
	    // ensure ints reside within appropriate range
	    if (arr[i] < 0 || arr[i] > 100) {
		throw new IllegalArgumentException("Error, array value out of bounds");
	    }
	    
	    auxArr[arr[i]]++;
	}

	// find index in auxArr with max value
	int mode = 0;
	for (int i = 1; i < auxArr.length; i++) {
	    if (auxArr[i] > auxArr[mode]) {
		mode = i;
	    }
	}

	return mode;
    } // int boundedMode(int[] arr)
    
    public static int 
    unboundedMode(int[] arr) throws IllegalArgumentException {
	
	// ensure arr is not null
	if (arr == null) {
	    throw new IllegalArgumentException("Error, empty int array");
	}

	// determine lower and upperBounds of arr values
	int lowerBound = arr[0], upperBound = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] < lowerBound) {
		lowerBound = arr[i];
	    } else if (arr[i] > upperBound) {
		upperBound = arr[i];
	    }
	}
	
	// create auxArr with determined bounds
	int[] auxArr = new int[upperBound - lowerBound + 1];
	for (int i = 0; i < arr.length; i++) {
	    auxArr[arr[i] - lowerBound]++;
	}
	
	// find index in auxArr with max value
	int mode = 0;
	for (int i = 1; i < auxArr.length; i++) {
	    if (auxArr[i] > auxArr[mode]) {
		mode = i;
	    }
	}
	
	return mode + lowerBound;
    }

    public static void main(String[] args) {

	if (fastExp(3, 3) == 27) {
	    System.out.print("congrats");
	}
	String[] strArr = { "Hello", "World", "!" };
	String str = concatAndReplicateAll(strArr, 3);
	System.out.println(str);
	
	int[] intArr = {-1, -1, -1, -1, 1, 2, 2, 4, 6, 7, 8, 7, 2, 9, 101};
	int mode = unboundedMode(intArr);
	System.out.format("%d\n", mode);

    } // void main(String[] args)
}
