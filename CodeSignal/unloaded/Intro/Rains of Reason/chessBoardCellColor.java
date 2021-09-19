boolean chessBoardCellColor(String cell1, String cell2) {
    boolean row = (cell1.charAt(0)-'a') % 2 == (cell2.charAt(0)-'a') % 2;
    boolean col = (cell1.charAt(1)-'1') % 2 == (cell2.charAt(1)-'1') % 2;
    return row == col;
}
