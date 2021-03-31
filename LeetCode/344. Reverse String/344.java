class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++){
            char front = s[i],
                 end = s[s.length-1 -i];
            s[s.length-1 -i] = front;
            s[i] = end;
        }
    }
}