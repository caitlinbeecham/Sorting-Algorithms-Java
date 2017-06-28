class CountingSort {
    public static int[] counting_sort(int[] seq) {
        int min_val = seq[0];
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] < min_val) {
                min_val = seq[i];
            }
        }
        int max_val = seq[0];
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > max_val) {
                max_val = seq[i];
            }
        }
        int counts_of_each_num_size = max_val - min_val + 1;
        int[] counts_of_each_num = new int[counts_of_each_num_size];
        for (int i = 0; i < counts_of_each_num_size; i++) {
            counts_of_each_num[i] = 0;
        }
        for (int i = 0; i < seq.length; i++) {
            (counts_of_each_num[seq[i] - min_val])++;
        }
        int result_size = seq.length;
        int[] result = new int[result_size];
        int num = -1;
        int res_index = 0;
        for (int i = 0; i < counts_of_each_num_size; i++) {
            num = i + min_val;
            for (int j = 0; j < counts_of_each_num[i]; j++) {
                result[res_index] = num;
                res_index++;
            }
        }
        return result;
    }
    
    public static void PrintIntList(int[] seq) {
        System.out.println("{");
        for (int i = 0; i < seq.length-1; i++) {
            System.out.print(seq[i] + ", ");
        }
        System.out.println(seq[seq.length-1] + "}");
    }
    
    public static void main(String[] args) {
        int[] seq = {0,3,9,8,8,3,5,2,7,3,0,17,3};
        System.out.println("Original Sequence: ");
        PrintIntList(seq);
        int[] answer = counting_sort(seq);
        System.out.println("Counting-Sorted Sequence: ");
        PrintIntList(answer);
    }
}