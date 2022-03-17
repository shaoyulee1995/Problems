# HashMap
* Time Complexity: O(NS)
* Space Complexity: O(N)
	* N as length of cpdomains
	* S as length of each domain
```
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        for(String cp: cpdomains){
            int i  = cp.indexOf(' ');
            Integer rep = Integer.valueOf(cp.substring(0, i));
            String s = cp.substring(i+1);
            for(i = 0; i < s.length(); i++){
                if(s.charAt(i) == '.'){
                    String d = s.substring(i+1);
                    map.put(d, map.getOrDefault(d, 0) + rep);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + rep);
        }
        List<String> res = new ArrayList();
        for(String key: map.keySet()){
            res.add(map.get(key) + " " + key);
        }
        return res;
    }
}
```