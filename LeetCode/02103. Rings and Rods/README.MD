# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(10)
	* N as length of rings
```
class Solution {
    public int countPoints(String rings) {
        int[] red = new int[10],
              blue = new int[10],
              green = new int[10];
        for(int i = 0; i < rings.length(); i+=2){
            char color = rings.charAt(i);
            int pos = rings.charAt(i+1) -'0';
            if(color == 'B'){
                blue[pos]++;
            }else if(color == 'R'){
                red[pos]++;
            }else if(color == 'G'){
                green[pos]++;
            }
        }
        int res = 0;
        for(int i = 0; i < 10; i++){
            if(red[i] > 0 && blue[i] > 0 && green[i] > 0){
                res++;
            }
        }
        return res;
    }
}
```