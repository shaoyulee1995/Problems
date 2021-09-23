* Time Complexity: O(N)
* Space Complexity: O(1)
```
int shapeArea(int n) {
    int squareLength = n + (n-1);
    int ans = squareLength * squareLength;
    int whites = 0;
    while(n-1 != 0){
        whites += n-1;
        n--;
    }
    return ans - 4*whites;
}
```