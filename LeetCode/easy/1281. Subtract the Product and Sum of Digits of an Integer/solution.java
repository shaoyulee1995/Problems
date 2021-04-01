class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while(n>0){
            int cur = n % 10; //4
            sum += cur; //4
            product *= cur; //4
            n = n / 10; //23
        }
        return product - sum;
    }
}