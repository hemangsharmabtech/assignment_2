package studyopedia;


public class NearestNeighboringNumbers {

    public static void main(String[] args) {
        int[] numbers = {45,333,1,8,2,0,12};

        int index = findNearestNeighboringNumbersIndex(numbers);
        
        System.out.println("Index of the first number in the pair with the smallest distance: " + index);
    }

    static int findNearestNeighboringNumbersIndex(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input array should have at least two elements.");
        }

        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            int currentDistance = Math.abs(arr[i + 1] - arr[i]);

            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                index = i;
            }
        }

        return index;
    }
}
