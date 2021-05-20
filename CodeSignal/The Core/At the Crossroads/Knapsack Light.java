int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    if(weight1 + weight2 <= maxW){
        return value1 + value2;
    }
    if(maxW>= weight1 && maxW >= weight2){
        return Math.max(value1, value2);
    }
    if(maxW>=weight1){
        return value1;
    }
    if(maxW >= weight2){
        return value2;
    }
    return 0;
}
