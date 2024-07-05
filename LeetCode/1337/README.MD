# The K Weakest Rows in a Matrix

- Time Complexity: O(M\*Max(N, logM))
- Space Complexity: O(M)
  - M as mat.length
  - N as mat[0].length

```
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];

        TreeMap<Integer, List<Integer> > map = new TreeMap();
        for(int i = 0; i < mat.length; i++){
            int ones = Arrays.stream(m).filter(x -> x==1).sum();
            map.computeIfAbsent(ones, x -> new ArrayList<>()).add(i);
        }

        int index = 0;
        for(int num: map.keySet()){
            for(int val: map.get(num)){
                if(index == k){
                    return res;
                }
                res[index++] = val;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(MlogN)
- Space Complexity: O(K)
  - M as mat.length
  - N as mat[0].length
  - K as k

```
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1] == b[1]? b[0] - a[0]: b[1] - a[1]);
        for(int i = 0; i < mat.length; i++){
            int val = findOne(mat, i);
            pq.add(new int[]{i, val});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        while(k>0){
            result[--k] = pq.poll()[0];
        }
        return result;
    }
    public int findOne(int[][] mat, int i){
        int l = 0, r = mat[i].length - 1;
        while(l < r){
            int m = l + (r-l)/2;
            if(mat[i][m] == 1){
                l = m+1;
            }else{
                r = m;
            }
        }
        return mat[i][l] == 1? l+1:l;
    }
}
```
