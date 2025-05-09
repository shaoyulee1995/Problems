# Array Prototype ForEach

```javascript
const arr = [1,2,3];
const callback = (val, i, arr) => arr[i] = val * 2;
const context = {"context":true};
arr.forEach(callback, context)  
console.log(arr) // [2,4,6]
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the array
  
```javascript
type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Callback = (currentValue: JSONValue, index: number, array: JSONValue[]) => any
type Context = Record<string, JSONValue>

Array.prototype.forEach = function(callback: Callback, context: Context): void {
    for(let i = 0; i < this.length; i++){
        callback.call(context, this[i], i, this);
    }
}
```