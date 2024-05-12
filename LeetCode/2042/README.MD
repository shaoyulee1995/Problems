# Check if Numbers Are Ascending in a Sentence
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public boolean areNumbersAscending(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        ArrayList<Integer> list = new ArrayList();
        for(String a: arr){
            if(isDigit(a)){
                list.add(Integer.valueOf(a));
            }
        }
        if(list.size() == 1){
            return true;
        }
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1) >= list.get(i)){
                return false;
            }
        }
        return true;
    }

    public boolean isDigit(String num){
        for(int i = 0; i < num.length(); i++){
            if(!Character.isDigit(num.charAt(0))){
                return false;
            }
        }
        return true;
    }
}
```