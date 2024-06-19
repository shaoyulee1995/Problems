# Integer to English Words

# StringBuilder

- Time Complexity: O(Wlog<sub>1000</sub>(N))
- Space Complexity: O(1)
  - W aS length of word
  - N as num

```
class Solution {
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                             "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                             "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int i = 0;
        String word = "";
        while(num > 0){
            if(num % 1000 != 0){
                word = calculation(num%1000) + THOUSANDS[i] + " " + word;
            }
            i++;
            num /= 1000;
        }
        return word.trim();
    }

    public String calculation(int num){
        if(num == 0){
            return "";
        }
        if(num < 20){
            return LESS_THAN_20[num] + " ";
        }
        if(num < 100){
            return TENS[num/10] + " " + calculation(num%10);
        }
        return LESS_THAN_20[num/100] + " Hundred " + calculation(num%100);
    }
}
```

# String

- Time Complexity: O(Wlog<sub>1000</sub>(N))
- Space Complexity: O(1)
  - W aS length of word
  - N as num

```
class Solution {

    private final String[] Thousand = {"", "Thousand", "Million", "Billion"};
    private final String[] lessTwenty = {"","One", "Two", "Three","Four","Five","Six",
                                        "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
                                        "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] Ten = {"", "","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num %1000 != 0){
                StringBuilder tmp = new StringBuilder();
                helper(tmp, num%1000);
                sb.insert(0,tmp.append(Thousand[index]).append(" "));
            }
            index++;
            num/= 1000;
        }
        return sb.toString().trim();
    }
    private void helper(StringBuilder sb, int num){
        if(num == 0){}
        else if(num < 20){
            sb.append(lessTwenty[num]).append(" ");
        }else if(num < 100){
            sb.append(Ten[num / 10]).append(" ");
            helper(sb, num%10);
        }else{
            sb.append(lessTwenty[num / 100]).append(" Hundred ");
            helper(sb, num%100);
        }
        return;
    }
}
```
