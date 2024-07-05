# Design Browser History

- Space Complexity: O(N)
  - N as length of urls
- visit
  - Time Complexity: O(1)
  - Space Complexity: O(1)
- back
  - Time Complexity: O(S)
  - Space Complexity: O(1)
    - S as steps
- forward
  - Time Complexity: O(S)
  - Space Complexity: O(1)
    - S as steps

```
class BrowserHistory {
    Stack<String> future,
                  history;
    public BrowserHistory(String homepage) {
        future = new Stack<>();
        history = new Stack<>();
        history.add(homepage);
        future.clear();
    }

    public void visit(String url) {
        history.add(url);
        future.clear();
    }

    public String back(int steps) {
        while(steps > 0 && history.size() > 1){
            future.add(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while(steps > 0 && future.size() > 0){
            history.add(future.pop());
            steps--;
        }
        return history.peek();
    }
}
```

- Space Complexity: O(N)
  - N as length of arr
- visit
  - Time Complexity: O(1)
  - Space Complexity: O(1)
- back
  - Time Complexity: O(1)
  - Space Complexity: O(1)
    - S as steps
- forward
  - Time Complexity: O(1)
  - Space Complexity: O(1)
    - S as steps

```
class BrowserHistory {

    ArrayList<String> arr;
    int curUrl, lastUrl;
    public BrowserHistory(String homepage) {
        arr = new ArrayList<String>();
        arr.add(homepage);
        curUrl = 0;
        lastUrl = 0;
    }

    public void visit(String url) {
        curUrl++;
        if(arr.size() > curUrl){
            arr.set(curUrl, url);
        }else{
            arr.add(url);
        }
        lastUrl = curUrl;
    }

    public String back(int steps) {
        curUrl = Math.max(0, curUrl - steps);
        return arr.get(curUrl);
    }

    public String forward(int steps) {
        curUrl = Math.min(lastUrl, curUrl+steps);
        return arr.get(curUrl);
    }
}
```

```
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
```
