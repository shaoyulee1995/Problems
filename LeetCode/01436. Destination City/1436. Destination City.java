class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet();
        //add start points
        for(List<String> l: paths){
            set.add(l.get(0));
        }
        for(List<String> l: paths){
            if(!set.contains(l.get(1))){
                return l.get(1);
            }
        }
        return "";
    }
}