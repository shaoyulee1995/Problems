class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(n <= 0 || cells.length == 0 || cells == null){
            return cells;
        }
        HashSet<String> record = new HashSet();
        int cycle = 0;
        boolean hasCycle = false;
        for(int i = 0; i < n; i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!record.contains(key)){
                record.add(key);
                cycle++;
            }else{
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            n = n % cycle;
            for(int i = 0; i < n; i++){
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    private int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];
        for(int i = 1; i + 1 < temp.length; i++){
            temp[i] = (cells[i-1] == cells[i+1])?1:0;
        }
        return temp;
    }
}