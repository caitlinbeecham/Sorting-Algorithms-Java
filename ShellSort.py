import math
def InsertionSortOnSubarrayOfIndices(seq,lo,subarray):
    if lo == len(subarray):
        return seq
    if lo == 0:
        return InsertionSortOnSubarrayOfIndices(seq, 1, subarray)
    for k in range(lo-1, -1, -1):
        if k == 0:
            if seq[subarray[lo]] >= seq[subarray[0]]:
                pass
            else:
                seq = MoveOver(seq, subarray, k, lo)                
        else:
            if seq[subarray[lo]] >= seq[subarray[k]]:   
                break
            elif ((seq[subarray[lo]] < seq[subarray[k]]) and (seq[subarray[lo]] < seq[subarray[k-1]])):
                pass
            else:
                # ie if seq[lo] < seq[i] and seq[lo] >= seq[i-1]
                #find place in sorted list
                #shift all entries in range(place,lo-1 over 1) and put seq[lo] in place
                seq = MoveOver(seq,subarray,k,lo)

    return InsertionSortOnSubarrayOfIndices(seq,lo + 1, subarray)

def MoveOver(seq, subarray, index0, index1):
    """
    these are indices on our subarray which is a list of indices that index elts of our subarray
    """
    new = seq[subarray[index1]]
    for k in range(index1-1, index0 -1,-1):
        seq[subarray[k+1]] = seq[subarray[k]]
        
    seq[subarray[index0]] = new
    return seq


def HSort(seq, H):
    subarraysbyindex = SubArraysByIndexForH(seq, H)
    for subarray in subarraysbyindex:
        seq = InsertionSortOnSubarrayOfIndices(seq,0,subarray)
    return seq
        
def ShellSort(seq):
    HSortSteps = []
    
    for i in range(math.floor(len(seq)/2)):
        if i %2 == 1:
            HSortSteps.append(i)
    for h in range(len(HSortSteps)-1, -1, -1):
        print(seq)
        seq = HSort(seq,HSortSteps[h])
    return seq
        

def SubArraysByIndexForH(seq, H):
    SubArraysByIndex = []
    for i in range(H):
        SubArrayByIndex = []
        if i < len(seq):
            SubArrayByIndex.append(i)
        while i+H < len(seq):
            i = i+H
            SubArrayByIndex.append(i)
        SubArraysByIndex.append(SubArrayByIndex)
    return SubArraysByIndex

  
seq = [62,83,18,53,7,17,95,86,47,69,25,28]

ans = ShellSort(seq)
print(ans)

