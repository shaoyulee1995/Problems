# Evaluate Division

- Time Complexity: O(E+QE)
- Space Complexity: O(E+N)
  - N as total numbers of node
    - Q as size of queries
    - E as edges

```
class Solution {
    HashMap<String, HashMap<String, Double>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap();
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0),
                   b = equations.get(i).get(1);
            double val = values[i];
            map.computeIfAbsent(a, x -> new HashMap()).put(b, val);
            map.computeIfAbsent(b, x -> new HashMap()).put(a, 1/val);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String c = queries.get(i).get(0),
                   d = queries.get(i).get(1);
            res[i] = dfs(c, d, new HashSet<>());
        }
        return res;
    }

    public double dfs(String start, String end, HashSet<String> seen){
        if(!map.containsKey(start) || !map.containsKey(end)){
            return -1.0;
        }
        if(start.equals(end)){
            return 1.0;
        }
        seen.add(start);
        HashMap<String, Double> neighbors = map.get(start);
        for(String neighbor: neighbors.keySet()){
            if(!seen.contains(neighbor)){
                double v = dfs(neighbor, end, seen);
                if(v != -1.0){
                    return neighbors.get(neighbor) * v;
                }
            }
        }
        seen.remove(start);
        return -1.0;
    }
}
```
