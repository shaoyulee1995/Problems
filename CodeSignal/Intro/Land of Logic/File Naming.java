String[] fileNaming(String[] names) {
    List<String> list = new ArrayList();
    for(String name: names){
        if(list.contains(name)){
            int i = 1;
            for(; list.contains(name+"("+i+")"); i++){
                
            }
            name+="("+i+")";
        }
        list.add(name);
    }
    String[] words = new String[list.size()];
    for(int i=0; i < list.size(); i++){
        words[i] = list.get(i);
    }
    return words;
}
