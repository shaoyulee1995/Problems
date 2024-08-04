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

```java
class BrowserHistory {
    Stack<String> future, history;
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

```java
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

- Space Complexity: O(N)
  - N as length of nodes
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

```java
class BrowserHistory {

    class DLLNode{
        public DLLNode prev, next;
        public String data;
        public DLLNode(String url){
            this.data = url;
            prev = null;
            next = null;
        }
    }
    DLLNode cur, linkedlistHead;
    public BrowserHistory(String homepage) {
        linkedlistHead = new DLLNode(homepage);
        cur = linkedlistHead;
    }

    public void visit(String url) {
        DLLNode node = new DLLNode(url);
        cur.next = node;
        node.prev = cur;
        cur = node;
    }

    public String back(int steps) {
        while(steps > 0 && cur.prev != null){
            steps--;
            cur = cur.prev;
        }
        return cur.data;
    }

    public String forward(int steps) {
        while(steps > 0 && cur.next != null){
            steps--;
            cur = cur.next;
        }
        return cur.data;
    }
}
```

```
Your BrowserHistory object will be instantiated and called as such:
BrowserHistory obj = new BrowserHistory(homepage);
obj.visit(url);
String param_2 = obj.back(steps);
String param_3 = obj.forward(steps);
```
