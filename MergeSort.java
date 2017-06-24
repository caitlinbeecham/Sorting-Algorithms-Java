import java.lang.*;
import java.util.Arrays;

class MergeSort {
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int left_idx = 0;
        int right_idx = 0;
        while ((left_idx < left.length) && (right_idx < right.length)) {
            if (left[left_idx] <= right[right_idx]) {
                result[left_idx + right_idx] = left[left_idx];
                left_idx++;
            }
            else {
                result[left_idx + right_idx] = right[right_idx];
                right_idx++;
            }
        }
        if (left_idx < left.length) {
            for (int i = left_idx; i < left.length; i++) {
                result[left_idx + right_idx] = left[i];
                left_idx++;
            }
        }
        if (right_idx < right.length) {
            for (int i = right_idx; i < right.length; i++) {
                result[left_idx + right_idx] = right[i];
                right_idx++;
            }
        }
        return result;
    }
    
    public static int[] mergeSort(int[] array) {
        int[] ret = new int[array.length];
        if (array.length == 1) {
            ret = array;
            return ret;
        }
        else {
            int mid_idx = array.length/2;
            int[] left = Arrays.copyOfRange(array,0,mid_idx);
            int[] right = Arrays.copyOfRange(array,mid_idx,array.length);
            ret = merge(mergeSort(left), mergeSort(right));
        }
        return ret;
    }
    
    public static void PrintIntList(int[] seq) {
        System.out.print("{");
        for (int i = 0; i < seq.length -1; i++) {
            System.out.print(seq[i] + ", ");
        }
        System.out.println(seq[seq.length - 1] + "}");
    }
    
    public static void main(String[] args) {
        int[] seq = {10,9,8,7,6,5,4,3,3,3,2,-25};
        PrintIntList(seq);
        int[] answer = mergeSort(seq);
        PrintIntList(answer);
    }
}
