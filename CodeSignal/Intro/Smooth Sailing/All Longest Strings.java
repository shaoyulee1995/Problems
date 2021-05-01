String[] allLongestStrings(String[] inputArray) {
    List<String> set = new ArrayList();
    
    int longest = 0;
    
    for(String s: inputArray){
        if(s.length() < longest){
            continue;
        }
        if(s.length() > longest){
            set.clear();
        }
        set.add(s);
        longest = s.length();
    }
    
    return set.toArray(new String[0]);
}
