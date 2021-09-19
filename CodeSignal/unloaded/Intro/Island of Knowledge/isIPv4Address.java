boolean isIPv4Address(String inputString) {
    String[] ipv4 = inputString.split("\\.");

    if(ipv4.length != 4){
        System.out.println("false here");
        return false;
    }
    for(String num: ipv4){
        try{
            Integer.parseInt(num);
        }catch(Exception e){
            return false;
        }
        if(!(Integer.parseInt(num) <= 255 && Integer.parseInt(num)>=0)){
            return false;
        }
        if(num.length() > 1 && num.charAt(0) == '0'){
            return false;
        }
    }
    return true;
}
