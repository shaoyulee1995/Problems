# BFS

## Java

* Time Complexity: O(b^d*d^2 + md) 
* Space Complexity: O(b^d*d+m)
	* b for number incremented, d for turntable, m for combinations for deadends
```
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for(String d: deadends){
            dead.add(d);
        }
        Set<String> visit = new HashSet();
        Queue<String> q = new LinkedList();
        q.offer("0000");
        visit.add("0000");
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(dead.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return step;
                }
                for(int j = 0; j < 4; j++){
                    String p = plus(cur, j);
                    if(!visit.contains(p)){
                        q.offer(p);
                        visit.add(p);
                    }
                    String m = minus(cur, j);
                    if(!visit.contains(m)){
                        q.offer(m);
                        visit.add(m);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public String plus(String s, int i){
        char[] ch = s.toCharArray();
        if(ch[i] == '9'){
            ch[i] = '0'; 
        }else{
            ch[i] += 1;        
        }
        return new String(ch);
    }
    public String minus(String s, int i){
        char[] ch = s.toCharArray();
        if(ch[i] == '0'){
            ch[i] = '9';    
        }else{        
            ch[i] -= 1;
        }
        return new String(ch);
    }
}
```