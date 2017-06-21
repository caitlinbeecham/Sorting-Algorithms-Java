import java.lang.*;

class CombSort {
    public static int[] BubbleSortWithStepSize(int[] array, int step) {
        int count = 0;
        while (count < array.length - step) {
            for (int i = 0; i < array.length - step; i++) {
                if (array[i+step] < array[i]) {
                    int rightmost = array[i+step];
                    array[i+step] = array[i];
                    array[i] = rightmost;
                }
                else if (i == 0) {
                    count = 1;       
                }
                else {
                    count++;
                }
            }
        }
        return array;   
    }
    
    public static int[] CombSort(int[] array, double shrinkfactor) {
        int step = (int)(Math.floor(array.length/shrinkfactor));
        while (step >= 1) {
            array = BubbleSortWithStepSize(array,step);
            step = (int)(Math.floor(step/shrinkfactor));
        }
        return array;
    }
    
    public static void PrintIntList(int[] seq) {
        System.out.print("{");
        for (int i = 0; i < seq.length -1; i++) {
            System.out.print(seq[i] + ", ");
        }
        System.out.println(seq[seq.length - 1] + "}");
    }
    
    public static void main(String[] args) {
        int[] array0 = {10,9,8,7,6,5,4,3,2,1};
        int[] array1 = {0,0,0,0,0,0,0,0};
        int[] array2 = {3,4,5,6,7,8,9,0,22,6,3,8,11,-5,2,0,138};
        
        System.out.println("Original Array #0:");
        PrintIntList(array0);
        int[] sortedarray0 = CombSort(array0, 1.3);        
        System.out.println("CombSorted Array #0:");
        PrintIntList(sortedarray0);
        
        System.out.println("Original Array #1:");
        PrintIntList(array1);
        int[] sortedarray1 = CombSort(array1, 1.3);        
        System.out.println("CombSorted Array #1:");
        PrintIntList(sortedarray1);
        
        System.out.println("Original Array #2:");
        PrintIntList(array2);
        int[] sortedarray2 = CombSort(array2, 1.3);        
        System.out.println("CombSorted Array #2:");
        PrintIntList(sortedarray2);
        
        
    }
}