boolean areFollowingPatterns(String[] strings, String[] patterns) {
    HashSet<String> set_strings = new HashSet(),
                    set_patterns = new HashSet();
                    
    for(int i = 0; i < strings.length; i++){
        boolean x = set_strings.add(strings[i]);
        boolean y = set_patterns.add(patterns[i]);
        
        if(y != x){
            return false;
        }
    }
    return true;
}
