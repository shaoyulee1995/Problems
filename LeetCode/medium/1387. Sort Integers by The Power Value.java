class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int getKth(int lo, int hi, int k) {
        map.put(1,0);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i1, i2) -> (getSteps(i1) != getSteps(i2))
                        ? (getSteps(i2) - getSteps(i1))
                        : i2 - i1
        );
        
        for(int i = lo; i <= hi; i++){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.gc();
        return pq.peek();
    }
    
    private int getSteps(int num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        int steps = 1 + ((num % 2 == 0)?getSteps(num/2):getSteps(num*3 + 1));
        
        map.put(num, steps);
        return steps;
    }
}