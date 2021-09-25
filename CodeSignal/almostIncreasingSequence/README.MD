* Time Complexity: O(N)
* Space Complexity: O(1)
```
boolean almostIncreasingSequence(int[] sequence) {
    int cnt = 0;
    for(int i = 1; i < sequence.length; i++){
        if(sequence[i-1] >= sequence[i]){
            cnt++;
            if(cnt > 1){
                return false;
            }
            if(i-2>= 0 && i+1 < sequence.length &&
               sequence[i] <= sequence[i-2]  && sequence[i-1] >= sequence[i+1]){
                return false;
            }
        }
    }
    return true;
}
```