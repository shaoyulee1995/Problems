# Check If N and Its Double Exist
# TreeSet
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public boolean checkIfExist(int[] arr) {
        TreeSet<Integer> set = new TreeSet();
        for(int num: arr){
            if(set.contains(num*2) || set.contains(num / 2) && num %2 == 0){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
```