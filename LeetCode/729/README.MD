# My Calendar I
# TreeMap
* Time Complexity: O(logN)
* Space Complexity: O(N)
	* N as values in the books
```
class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);
        if(low == null || map.get(low) <= start){
            map.put(start, end);
            return true;
        }
        return false;
    }
}
```
# List
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as values in the books
```
class MyCalendar {
    List<int[]> books;
    public MyCalendar() {
        books = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for(int[] book: books){
            if(Math.max(start, book[0]) < Math.min(end, book[1])){
                return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}
```
```
Your MyCalendar object will be instantiated and called as such:
MyCalendar obj = new MyCalendar();
boolean param_1 = obj.book(start,end);
```