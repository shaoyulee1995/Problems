# Dot Product of Two Sparse Vectors

# Array

- Time Complexity:
  - dotProduct: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class SparseVector {
    int[] ans;
    SparseVector(int[] nums) {
        ans = nums;
    }
    public int[] getArray(){
        return ans;
    }
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(int i = 0; i < ans.length; i++){
            res += ans[i] * vec.getArray()[i];
        }
        return res;
    }
}
```

```
// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
```
