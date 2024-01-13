# String
* Time Complexity: O(WN)
* Space Complexity: O(N)
	* K as length of title
    * W as length of word
```
class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(word.length() <= 2){
                sb.append(word.toLowerCase());
            }else{
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    sb.append((j==0)? Character.toUpperCase(c): Character.toLowerCase(c));
                }
            }
            if(i != words.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
```