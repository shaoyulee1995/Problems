int digitsProduct(int product) {
    List<Integer> digits = new ArrayList();
    int ans = 0;
    if(product == 0){
        return 10;
    }
    if(product == 1){
        return 1;
    }
    for(int d = 9; d > 1; d--){
        while(product % d == 0){
            product /= d;
            digits.add(d);
        }
    }
    System.out.println(product);
    if(product > 1){
        return -1;
    }
    Collections.sort(digits);
    for(Integer num: digits){
        ans=ans*10 + num;
    }
    return ans;
}