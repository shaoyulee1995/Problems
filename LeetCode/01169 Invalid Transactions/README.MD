# HashMap
* Time Complexity: O(N^2)
* Space Complexity: O(N)
```
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList();
        HashMap<String, List<Transaction> > map = new HashMap();
        
        for(String s: transactions){
            Transaction t = new Transaction(s);
            map.putIfAbsent(t.name, new ArrayList());
            map.get(t.name).add(t);
        }
        
        for(String s: transactions){
            Transaction t = new Transaction(s);
            if(!isValid(t, map.get(t.name))){
                ans.add(s);
            }
        }
        return ans;
    }
    
    public boolean isValid(Transaction t, List<Transaction> list){
        if(t.amount > 1000){
            return false;
        }
        for(Transaction l: list){
            if(Math.abs(l.time - t.time) <= 60 && !l.city.equals(t.city)){
                return false;
            }
        }
        return true;
    }
    
    class Transaction{
        String name, city;
        int amount, time;
        
        Transaction(String input){
            String[] split = input.split(",");
            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3];
        }
    }
}
```