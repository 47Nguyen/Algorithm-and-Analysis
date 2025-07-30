import java.util.HashSet;
import java.util.Set;

public class problem3 {
    /**
     * You have two ADTs: Set and Sequence. The Set ADT supports the following operations: add, remove, and size (which returns the number of elements in a set).
     * The Sequence ADT supports the following operations: next (which returns the first, second, etc. elements in a sequence until the last one on each subsequent call;
     * then, if it is called again, it will return false).
     * You have two sequences, each containing only unique elements. Describe an algorithm to check whether the two sequences are permutations of the same set.

     * Examples:

     * 1/ Seq1 = [1, 2, 3, 4], Seq2 = [4, 3, 2, 1] => YES
     * 2/ Seq1 = [1, 2, 3, 4], Seq2 = [1, 2, 3, 4] => YES
     * 3/ Seq1 = [1, 2, 3], Seq2 = [1, 2, 4] => NO
     */
    public static boolean isPermutation(int[] seq1, int[] seq2){
        boolean isPermuted = false;

        if (seq1.length != seq2.length){
            return isPermuted;
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : seq1){
            set1.add(num);
        }
        for (int num : seq2){
            set2.add(num);
        }

        if (set1.equals(set2)){
            isPermuted = true;
        }
        else {
            return isPermuted;
        }
        return isPermuted;
    }
    public static void main(String[] args) {

    }
}