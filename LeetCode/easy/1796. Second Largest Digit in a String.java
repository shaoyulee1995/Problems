class Solution {
    public int secondHighest(String s) {
        var set = new TreeSet<Character>();
        for(char c: s.toCharArray()){
            if(c >='0' && c <='9'){
                set.add(c);
            }
        }
        if(set.size() <= 1){
            return -1;
        }
        set = (TreeSet)set.descendingSet();
        set.pollFirst();
        return (int)set.pollFirst()-'0';
    }
}