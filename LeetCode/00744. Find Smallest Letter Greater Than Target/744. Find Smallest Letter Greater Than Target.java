class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length - 1]){
            return letters[0];
        }
        int left = 0, right = letters.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return letters[right];
    }
}