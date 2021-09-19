String messageFromBinaryCode(String code) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < code.length(); i += 8){
        String sub = code.substring(i, i+8);
        int num = Integer.parseInt(sub, 2);
        sb.append((char)num);
    }
    return sb.toString();
}
