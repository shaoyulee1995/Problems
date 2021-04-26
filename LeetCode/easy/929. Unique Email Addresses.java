class Solution {
    public int numUniqueEmails(String[] emails) {
        int count = 0;
        Set<String> set = new HashSet();
        for(String email: emails){
            String[] domain = email.split("@");
            while(domain[0].indexOf(".")!=-1){
                domain[0] = domain[0].replace(".","");
            }
            if(domain[0].indexOf("+")!=-1){
                domain[0] = domain[0].substring(0, domain[0].indexOf("+"));
            }
            if(set.add(domain[0] +"@"+ domain[1])){
                count++;    
            }
        }
        return count;
    }
}