int firstDuplicate(int[] a) {
    if(a.length == 0){
        return 0;
    }
    HashSet<Integer> set = new HashSet<>();
    
    for(int num: a){
        if(!set.contains(num)){
            set.add(num);
        }else{
            return num;
        }
    }
    return -1;
    
}
