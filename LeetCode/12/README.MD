# Integer to Roman

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            while(num >= values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public String intToRoman(int num) {
        if(num >= 1000){
            return "M" + intToRoman(num - 1000);
        }
        if(num >= 900){
            return "CM" + intToRoman(num - 900);
        }
        if(num >= 500){
            return "D" + intToRoman(num - 500);
        }
        if(num >= 400){
            return "CD" + intToRoman(num - 400);
        }
        if(num >= 100){
            return "C" + intToRoman(num - 100);
        }
        if(num >= 90){
            return "XC" + intToRoman(num - 90);
        }
        if(num >= 50){
            return "L" + intToRoman(num - 50);
        }
        if(num >= 40){
            return "XL" + intToRoman(num - 40);
        }
        if(num >= 10){
            return "X" + intToRoman(num - 10);
        }
        if(num >= 9){
            return "IX" + intToRoman(num - 9);
        }
        if(num >= 5){
            return "V" + intToRoman(num - 5);
        }
        if(num >= 4){
            return "IV" + intToRoman(num - 4);
        }
        if(num >= 1){
            return "I" + intToRoman(num - 1);
        }
        return "";
    }
}
```
