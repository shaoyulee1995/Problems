# Relative Ranks

# Array

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of scores

```
class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] index = new Integer[score.length];
        for(int i = 0; i < score.length; i++){
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> score[b] - score[a]);
        String[] res = new String[score.length];
        for(int i = 0; i < score.length; i++){
            if(i == 0){
                res[index[i]] = "Gold Medal";
            }else if(i == 1){
                res[index[i]] = "Silver Medal";
            }else if(i == 2){
                res[index[i]] = "Bronze Medal";
            }else{
                res[index[i]] = (i+1) + "";
            }
        }
        return res;
    }
}
```

# Array

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of scores

```
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] temp = score.clone();
        HashMap<Integer, Integer> map = new HashMap();
        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            map.put(temp[i], temp.length-i);
        }
        String[] res = new String[score.length];
        for(int i = 0; i < res.length; i++){
            int rank = map.get(score[i]);
            String rankStr = rank + "";
            if(rank == 1){
                res[i] = "Gold Medal";
            }else if(rank == 2){
                res[i] = "Silver Medal";
            }else if (rank == 3){
                res[i] = "Bronze Medal";
            }else{
                res[i] = rankStr;
            }
        }
        return res;
    }
}
```
