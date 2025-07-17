public class Problem4 {
    public static int[] findSumToZero(int[] array){
        int minDistance = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];
        for (int i = 0; i < array.length-1;i++){
            for (int j = i+1; j < array.length;j++){
                int currentSum = array[i] + array[j];
                int distance = Math.abs(currentSum);
                if (distance < minDistance) {
                    minDistance = distance;
                    smallestPair[0] = array[i];
                    smallestPair[1] = array[j];
                }
            }
        }

        return smallestPair;
    }

    public static void main(String[] args) {
        int[] array = {-100, 50, -52, 99};
//        int[] array = {2, 3, 9, 6};
        int[] smallestSum = findSumToZero(array);
        System.out.println("The smallest sum of a pair is: " + smallestSum[0] + " " +smallestSum[1]); // Output: 3 (from 1 + 2)
    }
}
