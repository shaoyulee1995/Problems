# Defanging an IP Address

# StringBuilder

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(char c: address.toCharArray()){
            sb.append(c=='.'?"[.]":c);
        }
        return sb.toString();
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}
```
