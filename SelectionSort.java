class SelectionSort {
    public static int[] sortBySelection(int[] seq, int lo) {
        if (lo == seq.length) {
            return seq;
        }
        
        int smallest_index = lo;
        
        for (int i = lo; i < seq.length; i++) {
            if (seq[i] < seq[smallest_index]) {
                smallest_index = i;
            }
        }  
        
        //swap seq[lo] and seq[smallest_elt]
        int leftmost = seq[lo];
        seq[lo] = seq[smallest_index];
        seq[smallest_index] = leftmost;
        
        System.out.print("{");
        for (int j = 0; j < seq.length-1; j++) {
            System.out.print(seq[j] + ", ");
        }
        System.out.print(seq[seq.length - 1] + "}");
        System.out.println();
        
        return sortBySelection(seq, lo + 1);
    }
    
    public static void main (String[] args) {
        int[] sequence = {1,10,3,8,2,4,11,5,6,7,9};
        sortBySelection(sequence, 0);
    }
    
}