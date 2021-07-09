class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //# with its frequency
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0; i < arr1.length; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        
        int[] sorted = new int[arr1.length];
        int i = 0;
        for(int a: arr2){
            while(map.get(a) != 0){
                sorted[i++] = a;
                map.put(a, map.get(a)-1);
            }
        }
        while(map.size() > 0){
            int key = map.firstKey();
            int freq = map.remove(key);
            for(int j = 0; j < freq; j++){
                sorted[i++] = key;
            }
        }
        return sorted;
    }
}