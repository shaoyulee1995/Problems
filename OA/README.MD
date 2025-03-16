# OA

## Question <sub>last seen: 2/2018 @Google</sub>

```
Given two char arrays, where some characters are '\b' (representing backspace, which deletes the previous character), determine whether the two char arrays are equal as final results after processing backspaces.

Constraints:
Time complexity: 𝑂(𝑛)
Space complexity: 𝑂(1)

Examples:
['a', 'b', '\b', 'd', 'c'] and ['a', 'd', 'c'] → true
['a', 'b', '\b', '\b', 'b', '\b', 'd', 'c'] and ['d', 'c'] → true
['a', 'b', 'd', '\b'] and ['a', 'd'] → false
```

```java
public static boolean backspaceCompare(char[] s, char[] t) {
    int sPointer = s.length - 1, 
        tPointer = t.length - 1;
    
    while (sPointer >= 0 || tPointer >= 0) {
        sPointer = getNextValidChar(s, sPointer);
        tPointer = getNextValidChar(t, tPointer);
        
        if (sPointer >= 0 && tPointer >= 0) {
            if (s[sPointer] != t[tPointer]) {
                return false;
            }
        } else if (sPointer >= 0 || tPointer >= 0) {
            return false;
        }
        
        sPointer--;
        tPointer--;
    }
    
    return true;
}

private static int getNextValidChar(char[] array, int pointer) {
    int backspaceCount = 0;
    while (pointer >= 0 && (array[pointer] == '#' || backspaceCount > 0)) {
        if (array[pointer] == '#') {
            backspaceCount++;
        } else {
            backspaceCount--;
        }
        pointer--;
    }
    return pointer;
}

public static void main(String[] argv) {
    char[] s1 = {'a', 'b', '#', 'd', 'c'};
    char[] t1 = {'a', 'd', 'c'};
    System.out.println(backspaceCompare(s1, t1)); // true

    char[] s2 = {'a', 'b', '#', '#', '#', 'd', 'c'};
    char[] t2 = {'d', 'c'};
    System.out.println(backspaceCompare(s2, t2)); // true

    char[] s3 = {'a', 'b', 'd', '#'};
    char[] t3 = {'a', 'd'};
    System.out.println(backspaceCompare(s3, t3)); // false
}
```

## Question: Balanced or Not <sub>last seen: 2023 @JPMorgan</sub>

```
Consider a string consisting of the characters < and > only. 
The string is balanced if each < always appears before (i.e., to the left of) a corresponding > character (they do not need to be adjacent). 
Moreover, each < and > act as a unique pair of symbols and neither symbol can be considered as part of any other pair of symbols.

To balance a string, any > character can be replaced with <>. Given an expression and a maximum number of replacements, determine whether the string can be balanced.

Example:
expressions = ['<<>>', '<>', '<><>', '>>', '<<>', '><<<']
maxReplacements = [0, 1, 2, 2, 2, 2]

Process a series of expressions and their corresponding maxReplacements. 
Each of the first three expressions is balanced already. The string expressions[3] = '>>' can be balanced in two moves by replacing each > with a <> to make <> <>. 
Neither of the last two strings can ever be balanced.

Constraints:
1 ≤ n ≤ 10<sup>2</sup>
1 ≤ length of expressions[i] ≤ 10<sup>5</sup>
0 ≤ maxReplacements[i] ≤ 10<sup>5</sup>
```

```java
public static void main(String[] args) {
    String[] expressions = {"<<>>", "<>", "<><>", ">>", "<<>", "><<<"};
    int[] maxReplacements = {0, 1, 2, 2, 2, 2};

    for (int i = 0; i < expressions.length; i++) {
        System.out.println("Expression: " + expressions[i] + 
                            ", Max Replacements: " + maxReplacements[i] + 
                            " -> Balanced: " + isBalance(expressions[i], maxReplacements[i]));
    }
}

public static boolean isBalance(String str, int maxReplacement){
    int balance = 0;
    for(char c: str.toCharArray()){
        if(c == '<'){
            balance++;
        }else if(c == '>'){
            if(balance > 0){
                balance--;
            }else if(maxReplacement > 0){
                maxReplacement--;
            }else{
                return false;
            }
        }
    }
    if(balance==0 && maxReplacement >= 0){
        return true;
    }
    return false;
}
```

## Question <sub>last seen: 10/6/2024 @TikTok</sub>

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

## Question <sub>last seen: 10/6/2024 @TikTok</sub>

```
You are a data analyst at the popular social media company TikTok. 
Your task is to optimize user engagement on TikTok-like video reels by developing an "engagement boost" algorithm that increases user interaction on the platform.

You are provided with two datasets: views and likes, both of the same length, where each entry represents the views and likes on a particular video. 
The objective is to maximize the "engagement score," defined as the sum of all likes[i] where likes[i] exceeds views[i].

However, there's a catch! You are allowed to rearrange the likes dataset to maximize the engagement score, but the views dataset remains fixed. 
Your challenge is to design an efficient algorithm that rearranges the likes dataset to achieve the highest possible engagement score, while adhering to the constraint that the views dataset cannot be rearranged.

Given two arrays of integers, views and likes, your goal is to rearrange the elements of likes to maximize the engagement score.

Function Description

Complete the function maximizeEngagement in the editor.

maximizeEngagement has the following parameters:

1. int[] views: an array of integers representing the views
2. int[] likes: an array of integers representing the likes
Returns

int: the maximum engagement score
```

```java
public static int sum(int[] likes, int[] views) {
    int sum = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    // Populate TreeMap with view counts
    for (int view : views) {
        map.put(view, map.getOrDefault(view, 0) + 1);
    }

    Arrays.sort(likes);
    for (int i = likes.length - 1; i >= 0; i--) {
        int like = likes[i];

        Integer v = map.lowerKey(like);
        if (v != null) {
            sum += like;
            map.put(v, map.get(v) - 1);
            if (map.get(v) == 0) {
                map.remove(v);
            }
        }
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
