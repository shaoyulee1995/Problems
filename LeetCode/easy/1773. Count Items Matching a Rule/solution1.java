class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = Map.of("type", 0, "color", 1, "name", 2);
        int count = 0, index = map.get(ruleKey);
        
        for(List<String> row: items){
            if(row.get(index).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}