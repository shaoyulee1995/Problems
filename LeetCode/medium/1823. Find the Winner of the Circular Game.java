class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList();
        
        for(int i = 1; i <= n; i++){
            q.add(i);
        }
        
        while(q.size() != 1){
            int remove = k;
            while(remove > 1){
                int temp = q.peek();
                q.remove();
                q.add(temp);
                remove--;
            }
            q.remove();
        }
        return q.peek();
    }
}