class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        
        for(String domain: cpdomains){
            int i = domain.indexOf(" ");
            int hits = Integer.valueOf(domain.substring(0, i));
            String link = domain.substring(i + 1);
            map.put(link, map.getOrDefault(link, 0) + hits);
            for(int j = 0; j < link.length(); j++){
                if(link.charAt(j)=='.'){
                    String subLink = link.substring(j+1);
                    map.put(subLink, map.getOrDefault(subLink, 0) + hits);
                }
            }
        }
        List<String> ans = new ArrayList();
        for(String s: map.keySet()){
            ans.add(map.get(s) + " " + s);
        }
        return ans;
    }
}