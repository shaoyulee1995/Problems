Queue
* Time Complexity: O(Nlog(N))
* Space Complexity: O(N)
```
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];
        LinkedList<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++){
            q.offer(i);
        }
        for(int i = 0; i < n; i++){
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return res;
    }
}
```