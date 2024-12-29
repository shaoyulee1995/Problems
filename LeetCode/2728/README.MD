# Count Houses in a Circular Street

```java
Definition for a street.
class Street {
    public Street(int[] doors);
    public void openDoor();
    public void closeDoor();
    public boolean isDoorOpen();
    public void moveRight();
    public void moveLeft();
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as k

```java
class Solution {
    public int houseCount(Street street, int k) {
        for(int i = 0; i < k; i++){
            street.closeDoor();
            street.moveRight();
        }
        for(int i = 0; i < k; i++){
            if(street.isDoorOpen()){
                return i;
            }
            street.openDoor();
            street.moveRight();
        }
        return k;
    }
}
```