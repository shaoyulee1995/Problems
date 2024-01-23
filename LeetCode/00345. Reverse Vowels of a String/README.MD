# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseVowels(String s) {
        return reverse(s.toCharArray());
    }

    public String reverse(char[] s){
        int i = 0,
            j = s.length - 1;
        while(i < j){
            while(i < j && !isVowel(s[i])){
                i++;
            }
            while(j > i && !isVowel(s[j])){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(s, i++, j--);
        }
        return new String(s);
    }
    
    public void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public boolean isVowel(char c){
        return c =='a' || c =='e' || c =='i' || c =='o' || c =='u' || 
            c =='A' || c =='E' || c =='I' || c =='O' || c =='U';
    }
}
```
# 2 Pointers HashSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','I','O','U','E'));
        int i = 0,
            j = s.length()-1,
            n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while(i < j && i < n && j >= 0){
            char a = s.charAt(i),
                 b = s.charAt(j);
            while(!set.contains(a)){
                i++;
                if(i == n){
                    break;
                }
                a = s.charAt(i);
            }
            while(!set.contains(b)){
                j--;
                if(j < 0){
                    break;
                }
                b = s.charAt(j);
            }
            if(set.contains(a) && set.contains(b)){
                sb.setCharAt(i, b);
                sb.setCharAt(j, a);
                i++;
                j--; 
            }
            
        }
        return sb.toString();
    }
}
```