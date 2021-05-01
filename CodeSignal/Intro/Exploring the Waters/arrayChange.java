int arrayChange(int[] inputArray) {
    int steps = 0;
    
    for(int i = 1; i < inputArray.length; i++){
        if(inputArray[i] <= inputArray[i-1]){
            int incr = inputArray[i-1] - inputArray[i] + 1;
            inputArray[i] += incr;
            steps += incr;
        }
    }
    return steps;
}
