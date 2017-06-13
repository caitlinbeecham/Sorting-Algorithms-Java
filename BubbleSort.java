class BubbleSort {
    public static int[] BubbleSort(int[] seq) {
        int count = 0;
        while (count < seq.length - 1) {
            for (int i = 0; i < seq.length - 1; i++) {
                if (seq[i] > seq[i+1]) {
                    int leftmost = seq[i];
                    seq[i] = seq[i+1];
                    seq[i+1] = leftmost;
                    count = 0;
     
                }
                else if (i == seq.length - 1) {
                    count = 0;
                }
                else {
                    count++;
                }
            }
        }
        return seq;
    }   
    
    public static void main(String[] args) {
        int[] sequence0 = {5,1,4,2,8};
        int[] sequence00 = {5,1,4,2,8};
        int[] sortedsequence0 = BubbleSort(sequence0);
        System.out.print("Sequence: {");
        for (int i = 0; i < sequence00.length - 1; i++) {
            System.out.print(sequence00[i] + ", ");
        }
        System.out.println(sequence00[sequence00.length - 1] + "}");
        System.out.print("Sorted Sequence: {");
        for (int i = 0; i < sortedsequence0.length - 1; i++) {
            System.out.print(sortedsequence0[i] + ", ");
        }
        System.out.println(sortedsequence0[sortedsequence0.length - 1] + "}");
        System.out.println();
        
        int[] sequence1 = {10,9,8,7,6,5,4,3,2,1,0};
        int[] sequence01 = {10,9,8,7,6,5,4,3,2,1,0};
        int[] sortedsequence1 = BubbleSort(sequence1);
        System.out.print("Sequence: {");
        for (int i = 0; i < sequence01.length - 1; i++) {
            System.out.print(sequence01[i] + ", ");
        }
        System.out.println(sequence01[sequence01.length - 1] + "}");

        System.out.print("Sorted Sequence: {");
        for (int i = 0; i < sortedsequence1.length - 1; i++) {
            System.out.print(sortedsequence1[i] + ", ");
        }
        System.out.println(sortedsequence1[sortedsequence1.length - 1] + "}");
        System.out.println();
    }
}

