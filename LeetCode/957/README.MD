# Prison Cells After N Days
# HashSet
* Time Complexity: O(NC)
* Space Complexity: O(NC)
	* N as n
	* C as length of cells
```
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> set = new HashSet();
        boolean cycle = false;
        int cycleCnt = 0, days = n;
        while(days > 0){
            int[] next = nextDay(cells);
            String val = Arrays.toString(next);
            if(!set.contains(val)){
                set.add(val);
                cycleCnt++;
            }else{
                cycle = true;
                break;
            }
            cells = next;
            days--;
        }
        if(cycle){
            n = n % cycleCnt;
            for(int i = 0; i < n; i++){
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    
    public int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];
        for(int i = 1; i + 1 < cells.length; i++){
            temp[i] = (cells[i-1] == cells[i+1])?1:0;
        }
        return temp;
    }
}}
}
```