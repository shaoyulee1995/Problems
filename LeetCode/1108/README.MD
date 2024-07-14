# Defanging an IP Address

# StringBuilder

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
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

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}
```
