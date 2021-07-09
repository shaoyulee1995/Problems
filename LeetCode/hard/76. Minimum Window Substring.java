class Solution {
    public String minWindow(String s, String t) {
        // if(s.length() < t.length() || t.length() == 0){
        //     return "";
        // }
        HashMap<Character, Integer> freqT = new HashMap();
        for(char c: t.toCharArray()){
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, tCount = freqT.size();
        int ansStart = 0, ansEnd = Integer.MAX_VALUE;
        
        while(right < s.length()){
            while(right < s.length() && tCount > 0){ //moving right on windows
                char cur = s.charAt(right);
                if(freqT.containsKey(cur)){
                    freqT.put(cur, freqT.get(cur) - 1);
                    if(freqT.get(cur) == 0){
                        tCount--;
                    }
                }
                right++;
            }
            //will at least find one
            while(left<s.length() && tCount == 0){
                //record the data
                if(ansEnd - ansStart > right - left){
                    ansEnd = right;
                    ansStart = left;
                }        
                char cur = s.charAt(left);
                if(freqT.containsKey(cur)){
                    freqT.put(cur, freqT.getOrDefault(cur,0) + 1);
                    if(freqT.get(cur) == 1){
                        tCount++;
                    }
                }
                left++;
            }
        }
            return ansEnd == Integer.MAX_VALUE?"":s.substring(ansStart, ansEnd); //no need to ansEnd + 1 bc i already ++ before i update
    }
}
