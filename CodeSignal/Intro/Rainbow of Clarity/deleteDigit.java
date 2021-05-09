int deleteDigit(int n) {
    String val = String.valueOf(n);
    int max = Integer.MIN_VALUE;
    
    for(int i = 0; i < val.length(); i++){
        StringBuilder sb = new StringBuilder(val);
        sb.deleteCharAt(i);
        max = Math.max(max, Integer.parseInt(sb.toString()));
    }
    return max;
}

