class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        backTrack(0,ans, new ArrayList(), s);
        return ans;
    }
    
    private void backTrack(int low, List<List<String>> list, List<String> temp, String s){
        if(low == s.length()){
            list.add(new ArrayList(temp));
            return;
        }
        
        for(int high = low; high < s.length(); high++){
            if(!isPalindrome(s,low, high)){
                continue;
            }
            temp.add(s.substring(low, high+1));
            backTrack(high + 1, list, temp, s);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++; high--;
        }
        return true;
    }
}