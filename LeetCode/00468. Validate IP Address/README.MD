# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of queryIP
```
class Solution {
    public String validIPAddress(String queryIP) {
        if(isIPv4(queryIP)){
            return "IPv4";
        }
        if(isIPv6(queryIP)){
            return "IPv6";
        }
        return "Neither";
    }
    public boolean isIPv4(String ip){
        String[] strs = ip.split("\\.", -1);
        if(strs.length != 4){
            return false;
        }
        for(String str: strs){
            if(str.length() > 1 && str.charAt(0) == '0'){
                return false;
            }
            try{   
                Integer num = Integer.parseInt(str);
                if(num == null || num < 0 || num > 255){
                    return false;
                }
            }catch(NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String ip){
        String[] strs = ip.split("\\:", -1);
        if(strs.length != 8){
            return false;
        }
        for(String str: strs){
            if(str == null || str.length() == 0 || str.length() > 4){
                return false;
            }
            for(char c: str.toCharArray()){
                if(Character.isDigit(c)){
                    continue;
                }
                c = Character.toLowerCase(c);
                if(c < 'a' || c > 'f'){
                    return false;
                }
            }
        }
        return true;
    }
}
```