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

class Solution {
    public boolean isHappy(int n) {
        int s = n, f = n;
        
        do{
            s = compute(s);
            if(s == 1){
                return true;
            }
            f = compute(compute(f));
            
            
            
        }while(s!=f);
        return false;
    }
    public int compute(int n){
        int val = 0;
        
        while(n!=0){
            int digit = n % 10;
            val += digit * digit;
            n /= 10;
        }
        
        return val;
    }
}