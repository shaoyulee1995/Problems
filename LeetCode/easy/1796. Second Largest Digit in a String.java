class Solution {
    public int secondHighest(String s) {
        // PriorityQueue<Integer> pq = new PriorityQueue(
        //     (a,b) -> Integer.compare(y,x));
        var set = new TreeSet<Integer>();
        for(char c: s.toCharArray()){
            if(c >='0' && c <='9'){
                set.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        if(set.size() <= 1){
            return -1;
        }
        set = (TreeSet)set.descendingSet();
        set.pollFirst();
        return set.pollFirst();
    }
}