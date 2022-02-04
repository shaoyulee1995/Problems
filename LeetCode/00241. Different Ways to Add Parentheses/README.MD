# Recursion Map
* Time Complexity: O(N^2)
* Space Complexity: O(N^2)
```
class Solution {
    HashMap<String, List<Integer>> map = new HashMap();
    public List<Integer> diffWaysToCompute(String expression) {
        if(map.containsKey(expression)){
            return map.get(expression);
        }        
        List<Integer> res = new ArrayList();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i)),
                              right = diffWaysToCompute(expression.substring(i + 1));
                for(int l: left){
                    for(int r: right){
                        if(c == '+'){
                            res.add(l+r);
                        }else if(c == '-'){
                            res.add(l-r);
                        }else if(c == '*'){
                            res.add(l*r);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        map.put(expression, res);
        return res;
    }
}
```