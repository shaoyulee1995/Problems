int chessKnight(String cell) {
    if(!isValid(cell)){
        return 0;
    }
    int[][] directions = {{-2,1},{-2,-1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}};
    int cnt = 0;
    for(int[] direction: directions){
        StringBuilder sb = new StringBuilder();
        sb.append((char)(cell.charAt(0)+direction[0]));
        sb.append((char)(cell.charAt(1)+direction[1]));
        if(isValid(sb.toString())){
            cnt++;
        }
    }
    return cnt;
}

boolean isValid(String cell){
    char col = Character.toUpperCase(cell.charAt(0)),
         row = Character.toUpperCase(cell.charAt(1));
    return (col<='H' && col >='A') && (row <='8' && row >='1');
}
