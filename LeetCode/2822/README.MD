# Inversion of Object

```javascript
@param {Object} obj
@return {Object}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of keys in the object

```javascript
var invertObject = function(obj) {
    const invertedObj = {}

    for(var key in obj){
      var v = obj[key];
      if(invertedObj[v] === undefined){
        invertedObj[v] = key;
      }else{
        if(Array.isArray(invertedObj[v])){
          invertedObj[v].push(key);
        }else{
          invertedObj[v] = [invertedObj[v], key];
        }
      }
    }
    return invertedObj;
};
```