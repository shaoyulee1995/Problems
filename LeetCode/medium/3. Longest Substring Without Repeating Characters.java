class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int ptr_left = 0,
            ptr_right = 0,
            max =0;
        
        while(ptr_right < s.length()){
            
            if(!set.contains(s.charAt(ptr_right))){
                set.add(s.charAt(ptr_right));
                ptr_right++;
                max = Math.max(set.size(), max);
            }else{
                set.remove(s.charAt(ptr_left));
                ptr_left++;
            }
            
        }
        return max;
    }
}