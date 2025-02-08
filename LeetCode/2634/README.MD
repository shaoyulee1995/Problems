# Filter Elements from Array

```javascript
@param {number[]} arr
@param {Function} fn
@return {number[]}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the array

```javascript
var filter = function(arr, fn) {
    var res = []
    for(let i = 0; i < arr.length; i++){
        if(fn(arr[i], i)){
            res.push(arr[i]);
        }
    }
    return res;
};
```
