/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Employee> q = new LinkedList();
        int res = 0;
        q.offer(map.get(id));
        while(!q.isEmpty()){
            Employee node = q.poll();
            res += node.importance;
            for(Integer sub: node.subordinates){
                q.offer(map.get(sub));
            }
        }
        return res;
    }
}