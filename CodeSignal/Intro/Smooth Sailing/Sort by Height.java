int[] sortByHeight(int[] a) {
    List<Integer> list = new ArrayList();
    
    for(int num: a){
        if(num != -1){
            list.add(num);
        }
    }
    Collections.sort(list);
    int index = 0;
    for(int i = 0; i < a.length; i++){
        if(a[i] != -1){
            a[i]=list.get(index++);
        }
    }
    return a;
}
