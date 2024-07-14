# Employee Importance

```
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
```

# HashMap, LinkedList

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList();
        queue.offer(map.get(id));
        int res = 0;
        while(!queue.isEmpty()){
            Employee node = queue.poll();
            res += node.importance;
            for(Integer sub: node.subordinates){
                queue.offer(map.get(sub));
            }
        }
        return res;
    }
}
```
