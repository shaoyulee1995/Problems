# 1 HashSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of paths
```
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
```
# 2 HashSets
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of paths
```
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> cityA = new HashSet(),  
                        cityB = new HashSet();
        for(int i = 0; i < paths.size(); i++){
            String A = paths.get(i).get(0),
                   B = paths.get(i).get(1);
            cityA.add(A);
            cityB.add(B);
        }
        for(String A: cityA){
            if(cityB.contains(A)){
                cityB.remove(A);
            }
        }
        return cityB.iterator().next();
    }
}
```