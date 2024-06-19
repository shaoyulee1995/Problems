# Cinema Seat Allocation

# HashMap

- Time Complexity: O(SN)
- Space Complexity: O(S)
  - N as n
  - S as length of seats

```
class Solution {
    public int maxNumberOfFamilies(int n, int[][] seats) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int[] seat: seats){
            map.putIfAbsent(seat[0], new ArrayList());
            map.get(seat[0]).add(seat[1]);
        }
        int res = (n - map.size()) * 2;
        for(Integer row: map.keySet()){
            boolean left = true,
                    right = true,
                    middle = true;
            for(int num: map.get(row)){
                if(num >= 2 && num <= 5){
                    left = false;
                }
                if(num >= 6 && num <= 9){
                    right = false;
                }
                if(num >= 4 && num <= 7){
                    middle = false;
                }
            }
            if(left && right){
                res += 2;
            }else if(left || right || middle){
                res += 1;
            }
        }
        return res;
    }
}
```
