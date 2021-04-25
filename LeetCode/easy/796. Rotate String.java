class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder(A + A);
        return sb.indexOf(B) != -1;
    }
}