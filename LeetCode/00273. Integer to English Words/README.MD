# StringBuilder
* Time Complexity: O(log<sub>1000</sub>(N))
* Space Complexity: O(1)
	* N as num
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