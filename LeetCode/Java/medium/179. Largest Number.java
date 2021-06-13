class Solution {
    public String largestNumber(int[] nums) {
        //10 2
        //102 or 210
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return new String(b+a).compareTo(new String(a+b));
            }
        };
        String[] strs = new String[nums.length];
        int i = 0;
        for(int num: nums){
            strs[i++] = String.valueOf(num);
        }
        
        Arrays.sort(strs, comp);
        if(strs[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
        }
        return sb.toString();
    }
}