# Maximum Value of a String in an Array

- Time Complexity: O(NW)
- Space Complexity: O(1)
  - N is the length of the array
  - W is the length of the longest string in the array

```java
class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(String str: strs){ O(N)
            boolean isNumeric = isNumeric(str);
            if(isNumeric){
                int num = getTrimValue(str);
                res = Math.max(res, num);
            }else{
                res = Math.max(res, str.length());
            }
        }
        return res;
    }

    public int getTrimValue(String str){ O(W)
        int res = 0;
        for(char c: str.toCharArray()){
            res = res*10 + (c-'0');
        }
        return res;
    }

    public boolean isNumeric(String str){
        for(char c: str.toCharArray()){ O(W)
            if(Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
```