# Array
* Time Complexity: O(Nlog(N))
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowels = new ArrayList();
        for(char c: s.toCharArray()){
            if(isVowel(c)){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                sb.append(vowels.get(j++));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i' || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I'; 
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String sortVowels(String s) {
        int[] ascii = new int[128];
        for(char c: s.toCharArray()){
            ascii[c]++;
        }
        String sortedVowels = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                while(ascii[sortedVowels.charAt(j)] == 0){
                    j++;
                }
                sb.append(sortedVowels.charAt(j));
                ascii[sortedVowels.charAt(j)]--;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i' || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I'; 
    }
}
```