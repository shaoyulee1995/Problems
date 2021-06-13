
class Solution {
    public String defangIPaddr(String address) {
        String output = "";
        
        for(char c : address.toCharArray()){
            if(c == '.'){
                output+= "[.]";
            }else{
                output+=c;
            }
        }
        return output;
    }
}
