class Solution {
    public int fib(int n) {
        return fib(n, new HashMap<>());
    }
    public int fib(int n, HashMap<Integer,Integer> map){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int val = fib(n-1, map) + fib(n-2, map);
        map.put(n, val);
        return val;
    }
}