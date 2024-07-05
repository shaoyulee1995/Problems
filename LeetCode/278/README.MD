# First Bad Version

```
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 0,
            j = n;
        while(i <= j){
            int k = i + (j-i)/2;
            if(!isBadVersion(k)){
                i = k+1;
            }else{
                j = k-1;
            }
        }
        return i;
    }
}
```
