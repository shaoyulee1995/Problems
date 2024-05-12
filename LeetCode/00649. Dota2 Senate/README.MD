# String
* Time Complexity: O(S)
* Space Complexity: O(S)
    * S as lenght of senate
```
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList(),
                       dire = new LinkedList();
        int idx = 0;
        for(char c: senate.toCharArray()){
            if(c == 'R'){
                radiant.offer(idx++);
            }else{
                dire.offer(idx++);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            if(radiant.peek() > dire.peek()){
                dire.offer(idx++);
            }else{
                radiant.offer(idx++);
            }
            dire.poll();
            radiant.poll();
        }
        return (radiant.isEmpty())? "Dire": "Radiant";
    }
}
```