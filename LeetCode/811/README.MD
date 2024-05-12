# Subdomain Visit Count
# HashMap
* Time Complexity: O(NC)
* Space Complexity: O(N)
	* N as length of cpdomains
	* C as length of each domain
```
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = wnew ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for(String cpdomain: cpdomains){
            int space = cpdomain.indexOf(' ');
            Integer rep = Integer.valueOf(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space+1);
            for(int i = 0; i < domain.length(); i++){
                if(domain.charAt(i) == '.'){
                    String subd = domain.substring(i+1);
                    map.put(subd, map.getOrDefault(subd, 0) + rep);
                }
            }
            map.put(domain, map.getOrDefault(domain, 0) + rep);
        }
        for(String k: map.keySet()){
            res.add(map.get(k) +" " + k);
        }
        return res;
    }
}
```