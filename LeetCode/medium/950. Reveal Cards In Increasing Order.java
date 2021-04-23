class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList();
        
        for(int i = 0; i < deck.length; i++){
            q.add(i);
        }
        int[] res = new int[deck.length];
        for(int i = 0; i < deck.length; i++){
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }
}