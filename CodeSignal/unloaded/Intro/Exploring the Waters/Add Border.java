String[] addBorder(String[] picture) {
    String[] boarder = new String[picture.length + 2];

    for(int i = 0; i < picture.length; i++){
        boarder[i+1] = "*" + picture[i] + "*";
    }
    
    boarder[0] = boarder[1].replaceAll(".", "*");
    boarder[boarder.length - 1] = boarder[0];
    return boarder;
}
