class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: deck){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int num: map.values()){
            res = gcd(num, res);
        }
        return res > 1;
    }
    private int gcd(int a, int b){
        return b > 0? gcd(b, a%b): a;
    }
}