# Open the Lock

# Regular BFS

## Java

- Time Complexity: O(N<sup>2</sup>A<sup>N</sup>+D)
- Space Complexity: O(A<sup>N</sup>+D)
  - N as length of the lock
  - A as possible digit
  - D as deadlock

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

# Two-End BFS

```
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet();
        for(String d: deadends){
            dead.add(d);
        }
        HashSet<String> q1 = new HashSet(),
                        q2 = new HashSet();
        HashSet<String> visit = new HashSet();
        int step = 0;
        q1.add("0000");
        q2.add(target);
        while(!q1.isEmpty() && !q2.isEmpty()){
            HashSet<String> temp = new HashSet();
            for(String cur: q1){
                if(dead.contains(cur)){
                    continue;
                }
                if(q2.contains(cur)){
                    return step;
                }
                visit.add(cur);
                for(int j = 0; j < 4; j++){
                    String up = plus(cur, j);
                    if(!visit.contains(up)){
                        temp.add(up);
                    }
                    String down = minus(cur, j);
                    if(!visit.contains(down)){
                        temp.add(down);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
    public String plus(String s, int i){
        char[] c = s.toCharArray();
        if(c[i] == '9'){
            c[i] = '0';
        }else{
            c[i] += 1;
        }
        return new String(c);
    }
    public String minus(String s, int i){
        char[] c = s.toCharArray();
        if(c[i] == '0'){
            c[i] = '9';
        }else{
            c[i] -= 1;
        }
        return new String(c);
    }
}
```
