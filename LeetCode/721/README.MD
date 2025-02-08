# Accounts Merge

- Time Complexity: O(NMlogM)
- Space Complexity: O(NM)
  - N as the number of accounts
  - M as the maximum length of an account

```java
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size() == 0){
            return new ArrayList();
        }
        HashMap<String, Integer> emailIndex = new HashMap();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(emailIndex.containsKey(email)){
                    int parentIndex = emailIndex.get(email);
                    uf.union(parentIndex, i);
                }else{
                    emailIndex.put(email, i);
                }
            }
        }

        HashMap<Integer, Set<String>> disjointSet = new HashMap();

        for(int i = 0; i < n; i++){
            int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet());
            Set<String> setEmails = disjointSet.get(parentIndex);
            for(int j = 1; j < accounts.get(i).size(); j++){
                setEmails.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, setEmails);
        }

        List<List<String>> res = new ArrayList();
        for(int idx: disjointSet.keySet()){
            List<String> emails = new ArrayList();
            emails.addAll(disjointSet.get(idx));
            Collections.sort(emails);
            emails.add(0, accounts.get(idx).get(0));
            res.add(emails);
        }
        return res;
    }

    class UnionFind{
        int[] parent;
        int size;
        public UnionFind(int n){
            this.size = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int a, int b){
            parent[find(a)] = parent[find(b)];
        }

        public int find(int a){
            if(a != parent[a]){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
    }
}
```

- Time Complexity: O(NMlogM)
- Space Complexity: O(NM)
  - N as the number of accounts
  - M as the maximum length of an account

```java
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
}
```
