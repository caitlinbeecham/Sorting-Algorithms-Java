import java.util.*;

/*
 * TODO:
 * Fix SubArraysByIndexForH method
 * still don't know how to make a dynamically sized array of dynamically sized int arrays
 * need to do this still...
 */

class ShellSort {
    public static ArrayList<Integer> InsertionSortOnSubarrayOfIndices(ArrayList<Integer> seq, int lo, ArrayList<Integer> subarray) {
        if (lo == subarray.size()) {
            return seq;
        }
        if (lo == 0) {
            return InsertionSortOnSubarrayOfIndices(seq, 1, subarray);
        }
        for (int k = lo-1; k > -1; k--) {
            if (k == 0) {
                if (seq.get(subarray.get(lo)) >= seq.get(subarray.get(0))) {
                }
                else {
                    seq = MoveOver(seq,subarray,k,lo);
                }
            }
            else {
                if (seq.get(subarray.get(lo)) >= seq.get(subarray.get(k))) {
                    break;
                }
                else if ((seq.get(subarray.get(lo)) < seq.get(subarray.get(k))) && (seq.get(subarray.get(lo)) < seq.get(subarray.get(k-1)))) {
                    
                }
                else {
                    seq = MoveOver(seq,subarray,k,lo);
                }
            }
        }
        return InsertionSortOnSubarrayOfIndices(seq, lo+1, subarray);
    }
    
    public static ArrayList<Integer> MoveOver(ArrayList<Integer> seq, ArrayList<Integer> subarray, int index0, int index1) {
        int num = seq.get(subarray.get(index1));
        for (int k = index1-1; k > index0-1; k--) {
            int next = seq.get(subarray.get(k));
            seq.set(subarray.get(k+1), next);
        }
        seq.set(subarray.get(index0), num);
        return seq; 
    }
    
    public static ArrayList<Integer> HSort(ArrayList<Integer> seq, int H) {
        ArrayList<ArrayList<Integer>> subarraysbyindex = SubArraysByIndexForH(seq, H);
        for (ArrayList<Integer> subarray: subarraysbyindex) {
            seq = InsertionSortOnSubarrayOfIndices(seq,0,subarray);
        }
        return seq;
    }
    
    public static ArrayList<Integer> ShellSort(ArrayList<Integer> seq) {
        ArrayList<Integer> HSortSteps = new ArrayList<Integer>();
        for (int i = 0; i < seq.size()/2; i++) {
            if (i % 2 == 1) {
                HSortSteps.add(i);
            }
        }
        for (int h = HSortSteps.size() - 1; h > -1; h--) {
            seq = HSort(seq,HSortSteps.get(h));
        }
        return seq;
    }
    
    public static ArrayList<ArrayList<Integer>> SubArraysByIndexForH(ArrayList<Integer> seq, int H) {
        ArrayList<ArrayList<Integer>> SubArraysByIndex = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < H; i++) {
            ArrayList<Integer> SubArrayByIndex = new ArrayList<Integer>();
            if (i < seq.size()) {
                SubArrayByIndex.add(i);
            }
            while (i+H < seq.size()) {
                i = i+H;
                SubArrayByIndex.add(i);
            }
            SubArraysByIndex.add(SubArrayByIndex);
        }
        return SubArraysByIndex;
    }
    
    public static void PrintIntList(ArrayList<Integer> seq) {
        System.out.print("{");
        for (int i = 0; i < seq.size() -1; i++) {
            System.out.print(seq.get(i) + ", ");
        }
        System.out.println(seq.get(seq.size() - 1) + "}");
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> seq = new ArrayList<Integer>();
        int[] seqlist = {62,83,18,53,7,17,95,86,47,69,25,28};
        for (int item : seqlist) {
            seq.add(item);
        }
        System.out.println("Original Sequence: ");
        PrintIntList(seq);
        ArrayList<Integer> ans = ShellSort(seq);
        System.out.println("ShellSorted Sequence: ");
        PrintIntList(ans);
            
            
    }

}