class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        for(int i = 0; i < ranges.length; i++){
            if(ranges[i] == 0){
                continue;
            }
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i+ranges[i]);
        }
        System.out.println(Arrays.toString(arr));
        int i = 0, CurEnd = 0, cnt = 0, farToReach = 0;
        while(i < arr.length && CurEnd < n){
            cnt++;
            while(i < arr.length && i <= CurEnd){
                farToReach = Math.max(farToReach, arr[i++]);
            }
            if(farToReach == CurEnd){
                return -1;
            }
            CurEnd = farToReach;
        }
        return cnt;
    }
}