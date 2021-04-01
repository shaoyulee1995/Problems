class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        
        if(ruleKey.equals("color")){
            index = 1;
        }else if(ruleKey.equals("name")){
            index = 2;
        }
        int count = 0;
        for(List<String> list: items){
            if(list.get(index).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}