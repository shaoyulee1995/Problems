* Time Complexity: O(1)
* Space Complexity: O(1)
```
int centuryFromYear(int year) {
    int val = year % 100;
    if(val != 0){
        return year / 100 + 1;
    }
    return year / 100;
}
```