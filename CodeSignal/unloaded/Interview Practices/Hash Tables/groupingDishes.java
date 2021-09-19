String[][] groupingDishes(String[][] dishes) {
    TreeMap<String, TreeSet<String> > map = new TreeMap();
    
    for(String[] dish: dishes){
        for(int i = 1; i < dish.length; i++){
            TreeSet<String> temp = new TreeSet();
            
            if(!map.containsKey(dish[i])){
                temp.add(dish[0]);
                map.put(dish[i], temp);
                continue;
            }
            
            temp = map.get(dish[i]);
            temp.add(dish[0]);
            map.put(dish[i], temp);
        }
    }
    ArrayList<String[]> ans = new ArrayList();
    
    for(String food: map.keySet()){
        if(map.get(food).size() > 1){
            String[] cur_foods = new String[map.get(food).size() + 1];
            cur_foods[0] = food;
            int index = 1;
            for(String name: map.get(food)){
                cur_foods[index++] = name;
            }
            ans.add(cur_foods);
        }
    }
    
    return ans.toArray(new String[0][]);
}
