# Reformat Phone Number

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of number

```java
class Solution {
    public String reformatNumber(String number) {
        String digits = getNumbers(number);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < digits.length()){
            if(i+4 == digits.length()){
                sb.append(digits.substring(i, i+2))
                  .append("-")
                  .append(digits.substring(i+2, i+4));
                i+=4;
            }else if(i+2 == digits.length()){
                sb.append(digits.substring(i, i+2));
                i+=2;
            }else if(i+3 <= digits.length()){
                sb.append(digits.substring(i, i+3));
                i+=3;
            }
            if(i < digits.length()){
                sb.append("-");
            }
        }
        return sb.toString();
    }

    private String getNumbers(String number){
        StringBuilder sb = new StringBuilder();
        for(char c: number.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of number

```java
class Solution {
    public String reformatNumber(String number) {
        String digits = number.replaceAll("[^0-9]", "");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < digits.length()){
            int remain = digits.length() - i;
            if(remain > 4){
                sb.append(digits.substring(i, i+3))
                  .append("-");
                i += 3;
            }else if(remain == 4){
                sb.append(digits.substring(i, i+2))
                  .append("-")
                  .append(digits.substring(i+2, i+4));
                i += 4;
            }else if(remain == 3){
                sb.append(digits.substring(i, i+3));
                i += 3;
            }else if(remain == 2){
                sb.append(digits.substring(i, i+2));
                i += 2;
            }else if(remain == 1){
                sb.append(digits.substring(i, i+1));
                i += 1;
            }
        }
        return sb.toString();
    }
}
```