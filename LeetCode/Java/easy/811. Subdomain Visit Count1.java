class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        
        for(String domain: cpdomains){
            int hits = Integer.parseInt(domain.substring(0, domain.indexOf(" ")));
            String link = domain.substring(domain.indexOf(" ") + 1);
            
            while(!link.isEmpty()){
                map.put(link, map.getOrDefault(link, 0) + hits);
                int dot = link.indexOf(".");
                if(dot != -1){
                    link = link.substring(dot + 1);
                }else{
                    link = "";
                }
            }
        }
        
        
        List<String> ans = new ArrayList();
        for(String s: map.keySet()){
            String l = String.valueOf(map.get(s)) + " " + s;
            ans.add(l);
        }
        return ans;
    }
}