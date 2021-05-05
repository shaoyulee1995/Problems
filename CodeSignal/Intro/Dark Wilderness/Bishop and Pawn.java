boolean bishopAndPawn(String bishop, String pawn) {
    char bishopX = bishop.charAt(0),
         bishopY = bishop.charAt(1),
         pawnX = pawn.charAt(0),
         pawnY = pawn.charAt(1);
    if(bishopX == pawnX || bishopY == pawnY){
        System.out.println("dsafd");
        return false;
    }
    int[][] directions = new int[][]{{-1,1}, {-1,-1},{1,-1},{1,1}};
    int d = 0;
    if(pawnX > bishopX && pawnY > bishopY){ //top right
        d = 3;
    }else if(pawnX < bishopX && pawnY > bishopY){ // top left
        d = 0;
    }else if(pawnX < bishopX && pawnY < bishopY){ // bottom left
        d = 1;
    }else{
        d = 2;
    }
    while(bishopX<='h' && bishopX>='a' && bishopY <='8' && bishopY>='1'){
        if(bishopX == pawnX && bishopY == pawnY){
            return true;
        }
        bishopX += directions[d][0];
        bishopY += directions[d][1];
    }
    
    return false;
}
