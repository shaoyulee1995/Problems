class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<Item> items = new ArrayList();
        
        for(int i = 0; i < values.length; i++){
            items.add(new Item(values[i], labels[i]));
        }
        
        PriorityQueue<Item> pq  = new PriorityQueue<>((a, b) -> b.val - a.val);
        pq.addAll(items);
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        
        while(!pq.isEmpty() && num_wanted > 0){
            Item item = pq.poll();
            map.put(item.label, map.getOrDefault(item.label, 0) + 1);
            if(map.get(item.label) <= use_limit){
                num_wanted--;
                sum += item.val;
            }
        }
        return sum;
    }
    
    class Item{
        int val, label;
        
        public Item(int value, int label){
            this.val = value;
            this.label = label;
        }
    }
}