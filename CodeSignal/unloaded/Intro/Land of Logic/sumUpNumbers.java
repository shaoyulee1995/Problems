int sumUpNumbers(String inputString) {
    String[] words = inputString.split(" ");
    int sum = 0;
    for(String word: words){
        int subSum = 0;
        for(char c: word.toCharArray()){
            if(c <'0' || c >'9'){
                sum += subSum;
                subSum = 0;
                continue;
            }
            subSum = subSum * 10 + (char)c - '0';
        }
        sum += subSum;
        subSum = 0;
    }
    return sum;
}
