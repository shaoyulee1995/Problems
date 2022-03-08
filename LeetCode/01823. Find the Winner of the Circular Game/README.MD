# Queue
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nums from 1 to n
```
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }
        while(q.size() > 1){
            int cnt = k;
            while(cnt > 1){
                q.offer(q.remove());
                cnt--;
            }
            q.remove();
        }
        return q.peek();
    }
}
```