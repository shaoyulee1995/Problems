class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList();
        HashSet<String> set = new HashSet();
        for(String word: words){
            set.add(word);
        }
        for(String word: words){
            set.remove(word);
            if(check(word, set)){
                list.add(word);
            }
            set.add(word);
        }
        return list;
    }
    public boolean check(String word, HashSet<String> set){
        if(set.size() == 0){
            return false;
        }
        if(set.contains(word)){
            return true;
        }
        int i = word.length() - 1;
        while(i >= 1){
            if(set.contains(word.substring(0,i)) && check(word.substring(i), set)){
                return true;
            }
            i--;
        }
        return false;
    }
}