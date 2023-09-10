# List
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of ops
```
class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList();
        for(String op: ops){
            if(op.equals("+")){
                list.add(list.get(list.size()-2)+list.get(list.size()-1));
            }else if(op.equals("C")){
                list.removeLast();
            }else if(op.equals("D")){
                list.add(2*list.get(list.size()-1));
            }else{ 
                list.add(Integer.valueOf(op));
            }
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
```