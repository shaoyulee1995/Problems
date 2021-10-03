class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int e) {
        List<Boolean> hasCandy = new ArrayList<>(candies.length);
        int max = Integer.MIN_VALUE;
        for(int n: candies){
            max = Math.max(n, max);
        }
        for(int n: candies){
            hasCandy.add((n+e>=max));
        }
        return hasCandy;
    }
}