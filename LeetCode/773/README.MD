# Sliding Puzzle

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as the total number of elements in the board
  - M as the total number of possible states

```java
class Solution {
    int[] dirs = {-1, 1, -3, 3};
    public int slidingPuzzle(int[][] board) {
        if(board == null || board.length == 0){
            return -1;
        }
        Queue<String> queue = new LinkedList();
        HashSet<String> seen = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(int[] row: board){
            for(int num: row){
                sb.append(num);
            }
        }
        String start = sb.toString(),
               target = "123450";
        
        queue.add(start);
        seen.add(start);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String node = queue.poll();
                if(node.equals(target)){
                    return res;
                }
                int startIndex = node.indexOf("0");
                for(int j = 0; j < dirs.length; j++){
                    int nextIndex = startIndex + dirs[j];
                    if(isValid(startIndex, nextIndex)){
                        char[] letters = node.toCharArray();
                        swap(letters, startIndex, nextIndex);
                        String nextState = new String(letters);
                        if(nextState.equals(target)){
                            return res+1;
                        }
                        if(!seen.contains(nextState)){
                            queue.add(nextState);
                            seen.add(nextState);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public void swap(char[] strs, int i, int j){
        char tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public boolean isValid(int startIndex, int nextIndex){
        if(nextIndex < 0 || nextIndex > 5 || (startIndex == 2 && nextIndex == 3) || (startIndex == 3 && nextIndex == 2)){
            return false;
        }
        return true;
    }
}
```