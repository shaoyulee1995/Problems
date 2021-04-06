    class Solution {
        public boolean isPalindrome(String s) {
            int start = 0, 
                end = s.length() - 1;

            while(start < end){
                char c1 = s.charAt(start),
                     c2 = s.charAt(end);

                while(start < end && !checkValid(c1)){
                    c1 = s.charAt(++start);
                }
                while(start < end && !checkValid(c2)){
                    c2 = s.charAt(--end);
                }

                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        public boolean checkValid(char c){
            if(c>=97 && c<=122){
                return true;
            }
            if(c>=65 && c<=90){
                return true;
            }
            if(c>=48 && c<=57){
                return true;
            }
            return false;
        }
    }