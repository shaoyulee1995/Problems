* Time Complexity: O(NlogN)
* Space Complexity: O(1)
```
int makeArrayConsecutive2(int[] statues) {
    Arrays.sort(statues);
    int ans = 0;
    for(int i = 0; i + 1< statues.length; i++){
        int diff = statues[i+1] - statues[i];
        if(diff == 1){
            continue;
        }
        ans += statues[i+1] - statues[i] - 1;
    }
    return ans;
}
```