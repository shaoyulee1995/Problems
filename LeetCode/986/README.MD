# Interval List Intersections

- Time Complexity: O(Min(M, N))
- Space Complexity: O(Min(M, N))
  - M as length of firstList
  - N as length of secondList

```java
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        LinkedList<int[]> res = new LinkedList();
        int i = 0,
            j = 0;
        while(i < firstList.length && j < secondList.length){
            int[] a = firstList[i],
                  b = secondList[j];
            if(a[0] <= b[1] && b[0] <= a[1]){
                res.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
            }
            if(a[1]< b[1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(int[][]:: new);
    }
}
```

```python
class Solution(object):
    def intervalIntersection(self, A, B):
        """
        :type firstList: List[List[int]]
        :type secondList: List[List[int]]
        :rtype: List[List[int]]
        """
        i, j = 0, 0
        res = []
        while i < len(A) and j < len(B):
            a0, a1 = A[i][0], A[i][1]
            b0, b1 = B[j][0], B[j][1]
            if b1 >= a0 and a1 >= b0:
                res.append([max(b0,a0), min(b1,a1)])

            if b1 < a1:
                j += 1
            else:
                i += 1
        return res
```
