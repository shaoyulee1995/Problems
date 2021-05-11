class Solution {
    public boolean canReorderDoubled(int[] A) {
        Integer[] B = new Integer[A.length];
        int j = 0;
        for(int a: A){
            B[j++] = a;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < B.length; i++){
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        Arrays.sort(B, (a,b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        
        for(int i = 0; i < B.length; i++){
            if(map.get(B[i]) == 0){
                continue;
            }
            if(!map.containsKey(2*B[i]) || map.get(2*B[i]) == 0){
                return false;
            }
            map.put(B[i], map.get(B[i]) - 1);
            map.put(2*B[i], map.get(2*B[i]) - 1);
        }
        return true;
    }
}