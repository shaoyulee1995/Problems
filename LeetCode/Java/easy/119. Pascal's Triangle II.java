class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList();
        while(rowIndex >= 0){
            list.add(0,1);
            for(int i = 1; i < list.size() - 1; i++){
                list.set(i,  list.get(i) + list.get(i+1));
            }
            rowIndex--;
        }
        return list;
    }
}