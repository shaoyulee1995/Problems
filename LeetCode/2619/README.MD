# Array Prototype Last

- Time Complexity: O(1)
- Space Complexity: O(1)

```ts
interface Array<T> {
    last(): T | -1;
}
```

```ts
Array.prototype.last = function() {
    return this.length === 0? -1: this[this.length-1];
};
```