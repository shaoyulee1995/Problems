int adjacentElementsProduct(int[] inputArray) {
    if(inputArray.length == 2){
        return inputArray[0] *inputArray[1];
    }
    int max = Integer.MIN_VALUE;
    
    for(int i = 1; i < inputArray.length -1; i++){
        int left = inputArray[i-1] * inputArray[i],
            right = inputArray[i] * inputArray[i+1];
        int curMax = Math.max(left, right);
        max = Math.max(max, curMax);
    }
    return max;
}
