# OA

## Question

```
A subarray is any contiguous block of an array's elements.
Given an array of integers, find the sum of all elements of all subarrays of that array.

Example
For example, a three-element array [4, 5, 6] can be made into the following subarrays:

1 element subarrays: [4], [5], [6]
2 element subarrays: [4,5], [5,6]
3 element subarrays: [4, 5, 6]

The sum of all subarrays is 4 + 5 + 6 + (4+5) + (5+6) + (4 + 5 + 6) = 50.
```

```java
public int sumOfSubarrays(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i] * (i+1) * (arr.length-i);
    }
    return sum;
}
```

## Question <sub>last seen: 1/26/2024 @Galaxy Digital</sub>

```
Design a data structure that can, efficiently with respect to time used, store and check if the total of any three successively added elements is equal to a given total.
For example, new MovingTotal() creates an empty container with no existing totals.
append({1, 2, 3, 4})
appends elements {1, 2, 3, 4}, which means that there are two existing totals(1 + 2 + 3 = 6 and 2 + 3 + 4 = 9).
append({5})appends element 5 and creates an additional total from {3, 4, 5}.
There would now be three totals (1 + 2 + 3 = 6, 2 + 3 + 4 = 9, and 3 + 4 + 5 = 12).
At this point contains(6), contains(9), and contains(12) should return true, while contains(7) should return false.
```

```java
public class MovingTotal {
  Integer num1, num2, num3;
  HashSet<Integer> seen;

  public MovingTotal() {
    this.num1 = null;
    this.num2 = null;
    this.num3 = null;
    this.seen = new HashSet<>();
  }

  public void append(int[] nums){
    for(int num : nums){
      if(this.num1 != null && this.num2 != null && this.num3 != null){
        this.num1 = this.num2;
        this.num2 = this.num3;
        this.num3 = num;
        this.seen.add(this.num1 + this.num2 + this.num3);
      }else{
        if(this.num1 == null){
          this.num1 = num;
        }else if(this.num2 == null){
          this.num2 = num;
        }else{
          this.num3 = num;
          this.seen.add(this.num1 + this.num2 + this.num3);
        }
      }
    }
  }

  public boolean contains(int total){
    return this.seen.contains(total);
  }
}
```

## Question <sub>last seen: 1/26/2024 @Galaxy Digital</sub>

```
A character in a platformer game is standing on a single row of floor tiles numbered 0 to N, at position X.
When the character moves, the tile at the previous position disappears.
The character can only move left and right, and always jumps over one tile, and any holes.
The character will not move if there are no tiles left to move to (you do not need to implement this in the code).
Implement a class that models this behavior and can report the character's position efficiently with respect to time used.
For example, new Platformer(6, 3) creates a row of 6 tiles (numbered 0 to 5) and a character position on tile 3 {0 1 2 |3| 4 5}.
A call to jumpleft() moves the character two tiles to the left and the tile at position 3 disappears {0 |1| 2 4 5}.
A subsequent call tojumpRight() moves the character two tiles to the right and the tile at position disappears, skipping tiles that have disappeared {0 2 |4| 5}.
Calling Position() method at this point should return 4.
```

```java
public class Platformer {
  Stack<Integer> left;
  Stack<Integer> right;
  Integer currentPosition;

  public Platformer(int n, int x) {
    this.left = new Stack<>();
    this.right = new Stack<>();
    this.currentPosition = x;
    for(int i = 0; i < x; i++){
      this.left.push(i);
    }
    for(int i = n-1; i > x; i--){
      this.right.push(i);
    }
  }

  public void jumpLeft() {
    if(this.left.size() >= 2){
      this.right.push(this.left.pop());
      this.currentPosition = this.left.pop();
    }
  }

  public void jumpRight(){
    if(this.right.size() >= 2){
      this.left.push(this.right.pop());
      this.currentPosition = this.right.pop();
    }
  }

  public int position(){
    return this.currentPosition;
  }
}
```

## Question <sub>last seen: 1/26/2024 @Galaxy Digital</sub>

```
In a survival game, to climb over a wall the player constructs a flimsy ladder where each step has varying integrities. 
When they place their foot on a step, it immediately loses one point of integrity. 
If the integrity drops to 0, the step breaks, and the ladder becomes unusable. 
The player needs to step over the top of the ladder to get over the wall. 
The usageCount method is used to determine how many times the player can use that ladder to get over the wall.

For example:
int[] ladder = {4, 5, 5, 4, 3, 5, 4};
System.out.println(usageCount(ladder)); // Should print 2

In the example above, the step at index 4 would break after climbing over the ladder twice. 
After the step breaks the player cannot use the ladder anymore.
```

```java
public int usageCount(int[] ladder) {
    return Arrays.stream(ladder).min().getAsInt()-1;
}
```
