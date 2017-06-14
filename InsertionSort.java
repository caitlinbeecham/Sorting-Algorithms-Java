class InsertionSort {
    public static int[] InsertionSort(int[] seq, int lo) {
        if (lo == seq.length) {
            return seq;
        }
        if (lo == 0) {
            return InsertionSort(seq,1);
        }
        for (int i = lo - 1; i > -1; i--) {
            if (i == 0) {
                if (seq[lo] >= seq[0]) {
                }
                else {
                    seq = MoveOver(seq,i,lo);
                }
            }
            else {
                if (seq[lo] >= seq[i]) {
                    break;
                }
                else if ((seq[lo] < seq[i]) && (seq[lo] < seq[i-1])) {
                }
                else {
                    seq = MoveOver(seq,i,lo);
                }
            }
        }
        return InsertionSort(seq,lo+1);
    }
    
    public static int[] MoveOver(int[] seq,int index0,int index1) {
        int num = seq[index1];
        for (int i = index1 -1; i > index0 -1; i--) {
            seq[i+1] = seq[i];
        }
        seq[index0] = num;
        return seq;    
    }
    

    public static void printIntList(int[] seq) {
        System.out.print("{");
        for (int i = 0; i < seq.length - 1; i++) {
            System.out.print(seq[i] + ", ");
        }
        System.out.println(seq[seq.length - 1]+ "}");
    }
        
    
    public static void main(String[] args) {
        int[] sequence = {10,9,8,7,6,5,4,3};
        System.out.println("Sequence: ");
        printIntList(sequence);
        int[] sortedsequence = InsertionSort(sequence,0);
        System.out.println("Sorted Sequence: ");
        printIntList(sortedsequence);  
    }
    
}