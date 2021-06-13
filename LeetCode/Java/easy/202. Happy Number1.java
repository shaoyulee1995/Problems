class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n != 1){
            n = square(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
        
    }
    public int square(int n){
        int res = 0;
        while(n != 0){
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }
}