# Accounts Merge

- Time Complexity: O(NMlogM)
- Space Complexity: O(NM)
  - N as the number of accounts
  - M as the maximum length of an account

```java
class UnionFind{
    int[] parent;
    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public void union(int x, int y){
        parent[find(x)] = parent[find(y)];
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailToIndex = new HashMap();
        UnionFind uf = new UnionFind(accounts.size());
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                emailToIndex.putIfAbsent(email, i);
                uf.union(emailToIndex.get(email), i);
            }
        }

        HashMap<Integer, TreeSet<String>> mergedAccounts = new HashMap();
        for(Map.Entry<String, Integer> entry: emailToIndex.entrySet()){
            String email = entry.getKey();
            int parentIndex = uf.find(entry.getValue());
            mergedAccounts.computeIfAbsent(parentIndex, x -> new TreeSet()).add(email);
        }

        List<List<String>> res = new ArrayList();
        
        for(Map.Entry<Integer, TreeSet<String>> entry: mergedAccounts.entrySet()){
            List<String> records = new ArrayList<>(entry.getValue());
            String name = accounts.get(entry.getKey()).get(0);
            records.add(0, name);
            res.add(records);
        }

        return res;
    }
}
```

- Time Complexity: O(NMlogM)
- Space Complexity: O(NM)
  - N as the number of accounts
  - M as the maximum length of an account

```java
class DSU{
    HashMap<String, String> map;
    public DSU(){
        map = new HashMap();
    }
    public void union(String x, String y){
        map.put(find(x), find(y));
    }

    public String find(String x){
        String xParent = map.getOrDefault(x, x);
        if(!xParent.equals(x)){
            xParent = find(xParent);
        }
        map.put(x, xParent);
        return xParent;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> emailToName = new HashMap();
        DSU dsu = new DSU();
        for(List<String> account: accounts){
            String name = account.get(0),
                   primaryEmail = account.get(1);
            for(int i = 1; i < account.size(); i++){
                String currentEmail = account.get(i);
                emailToName.put(currentEmail, name);
                dsu.union(primaryEmail, currentEmail);
            }
        }

        HashMap<String, List<String>> mergeAccountByPrimaryEmail = new HashMap();
        for(String email: emailToName.keySet()){
            String primaryEmail = dsu.find(email);
            mergeAccountByPrimaryEmail.computeIfAbsent(primaryEmail, x -> new ArrayList()).add(email);
        }

        List<List<String>> res = new ArrayList();
        for(List<String> emails: mergeAccountByPrimaryEmail.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }
}
```
