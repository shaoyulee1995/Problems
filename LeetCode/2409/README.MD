# Count Days Spent Together
# String
* Time Complexity: O(M)
* Space Complexity: O(1)
	* M as length of months
```
class Solution {
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a = new int[]{getDays(arriveAlice), getDays(leaveAlice)},
              b = new int[]{getDays(arriveBob), getDays(leaveBob)};
        if(b[0] > a[1] || a[0] > b[1]){
            return 0;
        }
        int start = Math.max(a[0], b[0]),
            end = Math.min(a[1], b[1]);
        return end - start + 1;
    }
    public int getDays(String s){
        int month = (s.charAt(0) -'0')*10 + (s.charAt(1) - '0'),
            day = (s.charAt(3) -'0')*10 + (s.charAt(4) - '0'),
            total = day;
        for(int i = 0; i < month-1; i++){
            total += months[i];
        }
        return total;
    }
}
```