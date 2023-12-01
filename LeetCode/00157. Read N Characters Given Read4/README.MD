# Lambda
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of buf
```
The read4 API is defined in the parent class Reader4.
    int read4(char[] buf4);
    
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char[] temp = new char[4];
        int total = 0;
        while(!eof && total < n){
            int count = read4(temp);
            eof = count < 4;
            count = Math.min(count, n - total);
            for(int i = 0; i < count; i++){
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}
```