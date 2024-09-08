# Dot Product of Two Sparse Vectors

- Time Complexity:
  - dotProduct: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class SparseVector {
    
    int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(int i = 0; i < this.nums.length; i++){
            res += this.nums[i] * vec.getVector()[i];
        }
        return res;
    }

    public int[] getVector(){
        return this.nums;
    }
}
```

```
Your SparseVector object will be instantiated and called as such:
SparseVector v1 = new SparseVector(nums1);
SparseVector v2 = new SparseVector(nums2);
int ans = v1.dotProduct(v2);
```
