# Unique Email Addresses

- Time Complexity: O(E \* N)
  - E represents length of emails
  - N represents length of email
- Space Complexity: O(E)

```java
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> seen = new HashSet();
        for(String email: emails){
            int i = email.indexOf("@");
            String local = email.substring(0, i),
                   domain = email.substring(i);
            if(local.contains("+")){
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", "");
            seen.add(local + domain);
        }
        return seen.size();
    }
}
```
