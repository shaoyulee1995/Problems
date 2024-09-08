# Repeat String

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as times

```ts
interface String {
  replicate(times: number): string;
}

String.prototype.replicate = function (times): string {
  return this.repeat(times);
};
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as times

```ts
interface String {
  replicate(times: number): string;
}

String.prototype.replicate = function (times): string {
  if (times == 0) {
    return "";
  }
  return this + this.replicate(times - 1);
};
```
