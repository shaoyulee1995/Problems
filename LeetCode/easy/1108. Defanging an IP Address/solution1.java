class Solution {
    public String defangIPaddr(String address) {
        String output = "";
        
        for(int i = 0; i < address.length(); i++){
            char c = address.charAt(i);
            if(c == '.'){
                output+= "[.]";
            }else{
                output+=c;
            }
        }
        return output;
    }

}