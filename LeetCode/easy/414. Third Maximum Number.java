class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((a,b)->
                                            (b>a)?1:(b<a)?-1:0);
        for(int num: nums){
            set.add(num);
        }
        if(set.size() < 3){
            return set.pollFirst();
        }
        set.pollFirst();set.pollFirst();
        return set.pollFirst();
    }
}