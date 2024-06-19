# Hexspeak

# HashMap

- Time Complexity: O(log<sub>16</sub>N)
- Space Complexity: O(N)
  - N as length of num

```
class Solution {
    public String toHexspeak(String num) {
        HashMap<Integer, Character> map = new HashMap();
        map.put(0, 'O');
        map.put(1, 'I');
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        Long n = Long.parseLong(num);
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int bit = (int)(n%16);
            if(bit > 1 && bit < 10){
                return "ERROR";
            }
            sb.append(map.get(bit));
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
```

# Math

- Time Complexity: O(log<sub>16</sub>N)
- Space Complexity: O(N)
  - N as length of num

```
class Solution {
    public String toHexspeak(String num) {
        Long n = Long.valueOf(num);
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            long d = n%16;
            switch((int)d){
                case 0:
                    sb.append("O");
                    break;
                case 1:
                    sb.append("I");
                    break;
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    return "ERROR";
            }
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
```
