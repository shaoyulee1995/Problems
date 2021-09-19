int adjacentElementsProduct(int[] inputArray) {
    int max = Integer.MIN_VALUE;
    for(int i = 1; i < inputArray.length; i++){
        int localmax = inputArray[i] * inputArray[i-1];
        max = Math.max(max, localmax);
    }
    return max;
}
