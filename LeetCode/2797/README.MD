# Partial Function With Placeholder

```js
@param {Function} fn
@param {Array} args
@return {Function}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the args array

```js
var partial = function (fn, args) {
  let j = 0;
  return function (...restArgs) {
    for (let i = 0; i < args.length; i++) {
      if (args[i] === "_") {
        args[i] = restArgs[j];
        j++;
      }
    }
    return fn(...args, ...restArgs.slice(j));
  };
};
```
