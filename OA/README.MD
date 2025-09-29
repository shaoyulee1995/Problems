# OA

## Question <sub>last seen: 8/2025 @Google</sub>

```
Given a list of addresses as a set of tuples/lists : street_number ,stree_name, city_name, state_name ; and a list of queries where each query is of length 4 but a possibility of NULL in the query example : ("A", NULL, "B", "C") NULL matches any address here. We want to design an address matcher and return a list of matched addresses like True/ False for each query.
```

```java
class Pair<K, V> {
    private final K key;
    private final V value;
    public Pair(K key, V value) { this.key = key; this.value = value; }
    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class Main {

    public static void main(String[] args) {
        List<String[]> addresses = List.of(
            new String[]{"123", "Main St", "Springfield", "IL"},
            new String[]{"456", "Elm St", "Springfield", "IL"},
            new String[]{"789", "Main St", "Chicago", "IL"},
            new String[]{"101", "Oak St", "Chicago", "NY"}
        );

        List<String[]> queries = List.of(
            new String[]{"123", null, "Springfield", null},    // Matches address 0
            new String[]{null, "Main St", null, "IL"},         // Matches addresses 0, 2
            new String[]{"456", "Oak St", null, null},         // No match
            new String[]{null, null, null, "NY"},              // Matches address 3
            new String[]{null, "Main St", null, null},         // Matches addresses 0, 2
            new String[]{"123", null, null, null},             // Matches address 0
            new String[]{null, null, null, null},              // Matches all addresses
            new String[]{"456", "Elm St", "Springfield", "NY"} // No match
        );

        Main matcher = new Main(addresses);
        matcher.print();
        Pair<boolean[], BitSet[]> result = matcher.matchAddresses(queries);
        System.out.println("-------------------");
        for(int i = 0; i < result.getKey().length; i++){
            System.out.println("query is: " + Arrays.toString(queries.get(i)));
            System.out.println("result is: " + result.getValue()[i]);
            System.out.println("---");
        }
    }

    private final List<String[]> addresses;
    private final Map<String, BitSet>[] fieldIndexes;

    @SuppressWarnings("unchecked")
    public Main(List<String[]> addresses) {
        this.addresses = addresses;
        this.fieldIndexes = new Map[4];
        for (int i = 0; i < 4; i++) {
            fieldIndexes[i] = new HashMap<>();
        }

        // Build inverted indexes
        for (int addrIdx = 0; addrIdx < addresses.size(); addrIdx++) {
            String[] address = addresses.get(addrIdx);
            for (int field = 0; field < 4; field++) {
                String value = address[field];
                BitSet bitSet = fieldIndexes[field].computeIfAbsent(value, k -> new BitSet(addresses.size()));
                bitSet.set(addrIdx);
            }
        }
    }

    private void print(){
        for (int i = 0; i < fieldIndexes.length; i++) {
            System.out.println("Field " + i + ":");
            for (Map.Entry<String, BitSet> entry : fieldIndexes[i].entrySet()) {
                System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    public Pair<boolean[], BitSet[]> matchAddresses(List<String[]> queries) {
        boolean[] result = new boolean[queries.size()];
        BitSet[] result2 = new BitSet[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String[] query = queries.get(i);
            BitSet candidates = null;
            boolean allNull = true;

            for (int field = 0; field < 4; field++) {
                if (query[field] != null) {
                    allNull = false;
                    BitSet bitSet = fieldIndexes[field].get(query[field]);
                    if (bitSet == null) {
                        candidates = new BitSet();
                        break;
                    }
                    if (candidates == null) {
                        candidates = (BitSet) bitSet.clone();
                    } else {
                        candidates.and(bitSet);
                    }
                }
            }

            if (allNull) {
                result[i] = !addresses.isEmpty();
                result2[i] = new BitSet(addresses.size());
                if (result[i]) result2[i].set(0);
            } else {
                result[i] = candidates != null && !candidates.isEmpty();
                result2[i] = (candidates == null) ? new BitSet(addresses.size()) : (BitSet) candidates.clone();
            }
        }

        return new Pair<>(result, result2);
    }
}
```

## Question <sub>last seen: 8/2025 @Microsoft</sub>

```
For an array of n positive integers arr[n] and an integer k, a subarray is considered good if it consists of at least k distinct integers. Find the minimum length subarray that is good. If there is no such subarray, return -1.

Example
arr = [2, 2, 1, 1, 3]
k = 3

The subarrays with at least k = 3 distinct integers are [2, 2, 1, 1, 3] and [2, 1, 1, 3]. Return 4, the minimum length of a good subarray.

Returns
int: the minimum length possible for a good subarray, or -1 if there is none

Constraints
• 1 ≤ n ≤ 10^5
• 1 ≤ arr[i] ≤ 10^6
• 1 ≤ k ≤ n
```

```java
public static int findMinimumLengthSubarray(int[] arr, int k){
    if(arr == null || arr.length < k){
        return -1;
    }
    HashMap<Integer, Integer> map = new HashMap();
    int i = 0,
        j = 0,
        res = Integer.MAX_VALUE;
    while(j < arr.length){
        map.merge(arr[j], 1, Integer::sum);
        while(map.size() == k){
            res = Math.min(res, j-i+1);
            map.merge(arr[i], -1, Integer::sum);
            if(map.get(arr[i]) == 0){
                map.remove(arr[i]);
            }
            i++;
        }
        j++;
    }
    return res == Integer.MAX_VALUE? -1: res;
}
```

## Question <sub>last seen: 8/2025 @Google</sub>

```markdown
Given a directed social network where each Person has a name and a list of Person objects they like (represented as List<Person> likes), find a common liked friend between two given persons, p1 and p2, such that the sum of the shortest distances from p1 and p2 to this common friend is minimized. The graph is directed, meaning the "likes" relationship is one-way (if A likes B, B does not necessarily like A).

A common liked friend is a Person that is reachable from both p1 and p2 through their respective "likes" paths.
The distance from a person to a friend is the number of edges in the shortest path in the directed graph.
If no common liked friend exists, return null.
The total distance to a common friend is the sum of the shortest path lengths from p1 and p2 to that friend.
The solution should return the common friend with the minimum total distance. If multiple friends have the same minimum total distance, any one of them can be returned.

Input
p1: A Person object representing the first person.
p2: A Person object representing the second person.
Each Person has:
name: A String representing the person's name.
likes: A List<Person> representing the people they like (outgoing edges in the directed graph).

Output
A Person object representing the common liked friend with the minimum total distance from p1 and p2.
If no common liked friend exists, return null.

Constraints
The graph may contain cycles.
The number of persons in the graph is at most 10^5.
Each person’s likes list contains at most 10^3 persons.
All name strings are unique.
p1 and p2 are guaranteed to be distinct.
The input graph is well-formed (no null persons in likes lists).

Example 1
Input:
p1 -> a -> b
p2 -> b

Graph:

- p1.likes = [a]
- a.likes = [b]
- p2.likes = [b]
- b.likes = []

Output: b
Explanation:

- b is a common liked friend.
- Distance from p1 to b: 2 (p1 -> a -> b)
- Distance from p2 to b: 1 (p2 -> b)
- Total distance: 2 + 1 = 3
- No other common friend exists, so b is the answer.

Example 2
Input:
p1 -> a -> b -> g -> e -> c
p2 -> c -> d -> h -> e

Graph:

- p1.likes = [a]
- a.likes = [b]
- b.likes = [g]
- g.likes = [e]
- e.likes = [c]
- p2.likes = [c]
- c.likes = [d]
- d.likes = [h]
- h.likes = [e]
- All other likes lists are empty.

Output: c
Explanation:

- Common liked friends: c, e
- For c:
  - Distance from p1 to c: 5 (p1 -> a -> b -> g -> e -> c)
  - Distance from p2 to c: 1 (p2 -> c)
  - Total distance: 5 + 1 = 6
- For e:
  - Distance from p1 to e: 4 (p1 -> a -> b -> g -> e)
  - Distance from p2 to e: 3 (p2 -> c -> d -> h -> e)
  - Total distance: 4 + 3 = 7
- c has the minimum total distance (6), so c is the answer.

Follow-Up Questions

How would you optimize the solution if the graph is very large?
What if we want to return all common friends with the minimum total distance?
How would you handle the case where distances are weighted?

Expected Solution Approach

Use Breadth-First Search (BFS) to compute the shortest distances from p1 and p2 to all reachable persons.
Store distances in hash maps for each starting person (p1 and p2).
Iterate through the intersection of reachable persons to find the common friend with the minimum sum of distances.
Time Complexity: O(V + E), where V is the number of persons and E is the total number of edges (likes).
Space Complexity: O(V) for the distance maps and BFS queue.
```

```java
class Person {
    String name;
    List<Person> likes;

    public Person(String name) {
        this.name = name;
        this.likes = new ArrayList<>();
    }
}

public Pair<Person, Integer> findCommonFriend(Person p1, Person p2) {
    // If either person is null or has no likes, return null
    if (p1 == null || p2 == null || p1.likes == null || p2.likes == null) {
        return null;
    }

    // Map to store distances from p1 and p2 to each person
    Map<Person, Integer> distFromP1 = new HashMap<>();
    Map<Person, Integer> distFromP2 = new HashMap<>();

    // Perform BFS from p1
    bfs(p1, distFromP1);
    // Perform BFS from p2
    bfs(p2, distFromP2);

    // Find common friends and their total distances
    Person commonFriend = null;
    int minTotalDistance = Integer.MAX_VALUE;

    // Check all persons reachable from both p1 and p2
    for (Person person : distFromP1.keySet()) {
        if (distFromP2.containsKey(person)) {
            int totalDistance = distFromP1.get(person) + distFromP2.get(person);
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
                commonFriend = person;
            }
        }
    }
    if(commonFriend == null){
        return null;
    }
    return new Pair<>(commonFriend, minTotalDistance);
}

private void bfs(Person start, Map<Person, Integer> distances) {
    Queue<Person> queue = new LinkedList<>();
    queue.add(start);
    distances.put(start, 0);

    while (!queue.isEmpty()) {
        Person current = queue.poll();
        int currentDistance = distances.get(current);

        // Explore all liked persons
        for (Person neighbor : current.likes) {
            if (!distances.containsKey(neighbor)) {
                distances.put(neighbor, currentDistance + 1);
                queue.add(neighbor);
            }
        }
    }
}
```

## Question <sub>last seen: 6/2025 @Google</sub>

```
You are given a file system represented as a hierarchical structure of folders and files. A folder can contain zero or more folders, zero or more files, or a combination of both. Each file has an associated size attribute (a non-negative integer). Your task is to compute the total size of all files within the file system, including those in nested folders. The solution should traverse the file system recursively and sum the sizes of all files.
```

```java
class File {
    private int size;

    public File(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Folder {
    private List<File> files;
    private List<Folder> subfolders;

    public Folder(List<File> files, List<Folder> subfolders) {
        this.files = files;
        this.subfolders = subfolders;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getSubfolders() {
        return subfolders;
    }
}

public class Solution {
    public long calculateTotalSize(Folder root) {
        if (root == null) {
            return 0;
        }

        long totalSize = 0;

        for (File file : root.getFiles()) {
            totalSize += file.getSize();
        }

        for (Folder subfolder : root.getSubfolders()) {
            totalSize += calculateTotalSize(subfolder);
        }

        return totalSize;
    }
}
```

## Question <sub>last seen: 6/2025 @Google</sub>

```
Similar to the phone interview question, you are given a file system represented as a hierarchical structure of folders and files. Each file has a size attribute (a non-negative integer), and a folder can contain files and other folders. Your task is to find the top k largest file sizes in the file system, including files in nested folders. The solution should traverse the file system, collect all file sizes, and return the k largest sizes in descending order. If there are fewer than k files, return all file sizes in descending order.
```

```java
class File {
    private int size;

    public File(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Folder {
    private List<File> files;
    private List<Folder> subfolders;

    public Folder(List<File> files, List<Folder> subfolders) {
        this.files = files;
        this.subfolders = subfolders;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getSubfolders() {
        return subfolders;
    }
}

public class TopKFileSizes {
    public List<Integer> findTopKFileSizes(Folder root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        collectFileSizes(root, minHeap, k);

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    private void collectFileSizes(Folder folder, PriorityQueue<Integer> minHeap, int k) {
        if (folder == null) {
            return;
        }

        for (File file : folder.getFiles()) {
            minHeap.offer(file.getSize());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (Folder subfolder : folder.getSubfolders()) {
            collectFileSizes(subfolder, minHeap, k);
        }
    }
}
```

## Question <sub>last seen: 6/2025 @Google</sub>

```
You are given an undirected graph that may contain cycles. The graph is represented as an adjacency list, where each node is connected to a list of neighboring nodes. The first task is to visit all nodes in the graph, ensuring each node is visited exactly once. You can use either Depth-First Search (DFS) or Breadth-First Search (BFS) to achieve this. The follow-up task is to check the validity of a cycle in the graph. A cycle is considered valid if it forms a simple cycle (i.e., a closed path where no node is repeated except for the start and end nodes). The solution should detect whether such a valid cycle exists.
```

```java
public class GraphCycleDetection {
    public boolean hasCycle(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
```

## Question <sub>last seen: 6/2025 @Google</sub>

```
Given an array arr of length n representing n waiters, where each element in the array indicates the time each waiter takes to serve one person, and given m people waiting in line, if you are the last person to arrive, how long do you need to wait?
```

```java
public static long waitingTime(int[] arr, int m) {
    int n = arr.length;
    long maxA = 0,
         minA = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        if (arr[i] > maxA) {
            maxA = arr[i];
        }
        if(arr[i] < minA){
            minA = arr[i];
        }
    }
    long target = m + 1;
    long low = minA;
    long high = maxA * target;
    while (low < high) {
        long mid = low + (high - low) / 2;
        long count = 0;
        for (int a : arr) {
            count += Math.ceil((double)mid / a);
        }
        if (count >= target) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
```

## Question <sub>last seen: 6/2025 @Google</sub>

```
Given an array of ints and a target value, return the length of the shortest contiguous array with the sum equal to target value

Test Case 1: Basic Case
Input: nums = [1, 2, 3, 4, 5], target = 12
Expected Output: 3 (subarray [2, 3, 4] sums to 12)

Test Case 2: Single Element
Input: nums = [5, 2, 3], target = 5
Expected Output: 1 (subarray [5] sums to 5)

Test Case 3: No Solution
Input: nums = [1, 2, 3], target = 10
Expected Output: 0 (no subarray sums to 10)

Test Case 4: Multiple Subarrays
Input: nums = [2, 3, 1, 2, 4, 3], target = 7
Expected Output: 2 (subarray [4, 3] sums to 7)

Test Case 5: Empty Array
Input: nums = [], target = 5
Expected Output: 0 (empty array returns 0)

Test Case 6: Negative Numbers
Input: nums = [-1, 2, -3, 4, 5], target = 1
Expected Output: 2 (subarray [2, -3, 4] sums to 1)
```

```java
public int shortestSubarray(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int minLength = Integer.MAX_VALUE;
    Map<Long, Integer> prefixMap = new HashMap<>();
    prefixMap.put(0L, -1);
    long prefixSum = 0;
    for (int i = 0; i < nums.length; i++) {
        prefixSum += nums[i];
        long needed = prefixSum - (long) target;
        if (prefixMap.containsKey(needed)) {
            int j = prefixMap.get(needed);
            minLength = Math.min(minLength, i - j);
        }
        prefixMap.put(prefixSum, i);
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

```java
public int shortestSubarray(int[] nums, int target) {
    int n = nums.length,
        left = 0,
        currentSum = 0,
        minLength = Integer.MAX_VALUE;

    for(int right = 0; right < nums.length; right++){
        currentSum += nums[right];
        while(left < right && currentSum > target){
            currentSum -= nums[left];
            left++;
        }
        if(currentSum == target){
            minLength = Math.min(minLength, right-left+1);
        }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

## Question <sub>last seen: 5/2025 @Google</sub>

```
You are given a stream of inputs.
For each incoming string, check whether the same string has appeared within the past 60 seconds.
If it has appeared, drop the current string. Otherwise, output the string.

Follow-up:
If duplicates are detected, instead of just dropping the current one, drop all duplicates that occur within the 60-second window.
```

```java

static HashMap<String, List<Long>> wordMap = new HashMap();
private static final long WINDOWS_TIMEFRAME = 60000;

public static String processString(String word, long timestamp){
    if(wordMap.containsKey(word)){
        List<Long> existingTimestamp = wordMap.get(word);
        for(int i = 0; i < existingTimestamp.size(); i++){
            if(timestamp - existingTimestamp.get(i) <= WINDOWS_TIMEFRAME){
                return null;
            }
        }
        wordMap.get(word).add(timestamp);
    }else{
        wordMap.putIfAbsent(word, new ArrayList());
        wordMap.get(word).add(timestamp);
    }
    return word;
}

public Set<String> getCurrentUniqueStrings() {
    return new HashSet<>(wordMap.keySet());
}
```

## Question <sub>last seen: 4/2025 @Google</sub>

[Source](https://leetcode.com/discuss/post/6696099/google-l3-onsite-r3-by-anonymous_user-8nma/)

```
You have a class Queue with only two operations allowed in it.

class Queue {
    Integer pop();
    boolean isEmpty();
}

Input : List queues
Constraints : All values inside the queue are positive integers.

Warm-Up Question:
You have a list of queue of size len. Return the index of the shortest queue from the list of queues with only two queue operations allowed as mentioned above.

Main Question:
Now, you have to find out the minimum sum of a queue from the list of the queues in the most efficient manner.
```

```java
int findShortestQueueIndex(List<Queue> queues) {
    int minSize = Integer.MAX_VALUE;
    int minIndex = -1;

    for (int i = 0; i < queues.size(); i++) {
        Queue q = queues.get(i);
        int size = 0;
        while (!q.isEmpty()) {
            q.pop();
            size++;
        }
        if (size < minSize) {
            minSize = size;
            minIndex = i;
        }
    }
    return minIndex;
}
```

```java
int findMinimumSumValue(List<Queue> queues) {
    int minSum = Integer.MAX_VALUE;

    for (int i = 0; i < queues.size(); i++) {
        Queue q = queues.get(i);
        int running = 0;
        boolean pruned = false;

        while (!q.isEmpty()) {
            running += q.pop();
            if (running > minSum) {
                pruned = true;
                break;
            }
        }

        if (!pruned && running < minSum) {
            minSum = running;
        }
    }

    return minSum;
}
```

## Question <sub>last seen: 4/2025 @Google</sub>

[Source](https://leetcode.com/discuss/post/6696473/google-l3-onsite-r1-by-anonymous_user-n8rl/)

```
You are two files of Changelogs with version and it's messages. You have to merge both of the files into the one. All the version values inside the changelog files are sorted in descending order.

If there is a conflict of any version between two files, merge them up and the message ordering should be consistent in accordance with ChangeLog from first files to be taken first then from the second file.

Print the changes after merging the changes.

Example :
ChangeLog File1:
    24.0.1
    Added Export functionality
    Fixed the template issue.

    23.0.2
    Added Foreign key to template table.

ChangeLog File2:
    24.0.2
    Created index on template.

    23.0.2
    Resolved merge conflicts.

    Output:
    24.0.2
    Created index on template.

    24.0.1
    Added Export functionality
    Fixed the template issue.

    23.0.2
    Added Foreign key to template table.
    Resolved merge conflicts.
```

```java
class Log {
    String version;
    LinkedList changes;

    Log(String version, LinkedList<String> changes) {
    this.version = version;
    this.changes = changes;
    }
}


public static List<Log> merge(List<Log> file1, List<Log> file2) {
    // Create a map to store version to changes mapping
    Map<String, LinkedList<String>> versionToChanges = new TreeMap<>(Collections.reverseOrder());

    // Process file1
    for (Log log : file1) {
        versionToChanges.putIfAbsent(log.version, new LinkedList<>());
        versionToChanges.get(log.version).addAll(log.changes);
    }

    // Process file2
    for (Log log : file2) {
        versionToChanges.putIfAbsent(log.version, new LinkedList<>());
        versionToChanges.get(log.version).addAll(log.changes);
    }

    // Convert map to list of Log objects
    List<Log> result = new ArrayList<>();
    for (Map.Entry<String, LinkedList<String>> entry : versionToChanges.entrySet()) {
        result.add(new Log(entry.getKey(), entry.getValue()));
    }

    return result;
}
```

## Question <sub>last seen: 3/2025 @Google</sub>

[Source](https://leetcode.com/discuss/post/6490748/google-interview-question-help-onsite-1-drwvu/)

```
given a binary tree, with each edge having a cost associated. we want to cut the edges in such a way that all the leaf nodes get disconnected from root. find the min cost.
```

```java
public class Main {
    static class TreeNode {
        int leftWeight;
        int rightWeight;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.leftWeight = 0;
            this.rightWeight = 0;
            this.left = null;
            this.right = null;
        }
    }

    public static int minCost(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // If node is a leaf, return large value (can't cut leaf itself)
        if (node.left == null && node.right == null) {
            return Integer.MAX_VALUE;
        }
        // Calculate min cost for left subtree: min of cutting edge or disconnecting leaves
        int leftCost = node.left != null ? Math.min(node.leftWeight, minCost(node.left)) : 0;
        // Calculate min cost for right subtree: min of cutting edge or disconnecting leaves
        int rightCost = node.right != null ? Math.min(node.rightWeight, minCost(node.right)) : 0;
        // Total cost is sum of left and right costs
        return leftCost + rightCost;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node1 = new TreeNode();

        root1.left = node4;
        root1.right = node2;
        root1.leftWeight = 5;
        root1.rightWeight = 2;
        node4.left = node1;
        node4.leftWeight = 1;

        int result1 = minCost(root1);
        System.out.println("Test Case 1: Expected 3, Got " + result1);
        assert result1 == 3 : "Test Case 1 Failed";

        TreeNode root2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node7 = new TreeNode();
        TreeNode node8 = new TreeNode();
        TreeNode node4_2 = new TreeNode();

        root2.left = node3;
        root2.right = node5;
        root2.leftWeight = 4;
        root2.rightWeight = 2;
        node3.left = node7;
        node3.right = node8;
        node3.leftWeight = 3;
        node3.rightWeight = 5;
        node5.left = node4_2;
        node5.leftWeight = 1;

        int result2 = minCost(root2);
        System.out.println("Test Case 2: Expected 5, Got " + result2);
        assert result2 == 5 : "Test Case 2 Failed";

        System.out.println("All test cases passed!");
    }
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

## Question <sub>last seen: 3/2024 @Google</sub>

```
The Google SDE interview question involves a style requirement where the display width of a line should not exceed 70 characters, and the task is to write a method to automatically format code into this specified format. The process includes reading data from an array to generate a table list, with each column left-aligned for easy reading—even if each cell contains only one character—while maintaining the original order of the strings.
For example,
given W = 70 (characters) and
S = [isAudioBuffer, GetTimestamp, SetTimestamp, GetSampleRate, GetNumberOfChannels, GetSampleSize, GetNumberOfSamples, GetDataBuffer, GetChannel],

the formatted output can be
isAudioBuffer GetTimestamp SetTimestamp GetSampleRate |
GetNumberOfChannels GetSampleSize GetNumberOfSamples GetDataBuffer |
GetChannel |

The goal is to format the given list of strings using the maximum character count per line, ensuring the original order of the strings is preserved as much as possible.
```

```java
public static List<String> formatCode(String[] words, int maxWidth) {
    List<String> formattedLines = new ArrayList<>();
    StringBuilder currentLine = new StringBuilder();
    int currentWidth = 0;
    int index = 0;

    while (index < words.length) {
        String word = words[index];
        int nextSegmentWidth = SPACE_WIDTH + word.length() + SPACE_WIDTH + VERTICAL_BAR_WIDTH;

        if (currentWidth + nextSegmentWidth > maxWidth) {
            currentLine.append(" |");
            formattedLines.add(currentLine.toString());
            currentLine.setLength(0);
            currentWidth = 0;
        } else {
            if (currentWidth > 0) {
                currentLine.append(" ");
                currentWidth += SPACE_WIDTH;
            }
            currentLine.append(word);
            currentWidth += word.length();
            index++;
        }
    }

    if (currentLine.length() > 0) {
        currentLine.append(" |");
        formattedLines.add(currentLine.toString());
    }

    return formattedLines;
}
```

## Question <sub>last seen: 2/2024 @JPMorgan Chase</sub>

```
Consider pair of integers (a, b). The following operations can be performed on (a, b) in any order, zero or more times.
• (a, b) -> (a + b, b)
• (a, b) -> (a, a + b)
Return a string that denotes whether or not (a, b) can be converted to (c, d) by performing the operation zero or more times.

Example
(a, b) = (1, 1)
(c, d) = (5, 2)
Perform the operation (1, 1) + to get (1, 2), perform the operation (+ 2) to get (3, 2), and perform the operation (+ 2) to get (5, 2). Alternatively, the first operation could be (1+1, 1) to get (2, 1) and so on. Return "Yes" if (a, b) can be converted to (c, d) by performing zero or more of the operations specified above, or "No" if not.

Constraints
1 ≤ a, b, c, d ≤ 1000
```

```java
public String isPossible(int a, int b, int c, int d) {
    Set<String> visited = new HashSet<>();
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{a, b});
    visited.add(a + "," + b);

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];

        if (x == c && y == d) {
            return "Yes";
        }
        if (x > c && y > d) {
            continue;
        }

        int nextX1 = x + y;
        int nextY1 = y;
        if (nextX1 <= 1000 && !visited.contains(nextX1 + "," + nextY1)) {
            queue.offer(new int[]{nextX1, nextY1});
            visited.add(nextX1 + "," + nextY1);
        }

        int nextX2 = x;
        int nextY2 = x + y;
        if (nextY2 <= 1000 && !visited.contains(nextX2 + "," + nextY2)) {
            queue.offer(new int[]{nextX2, nextY2});
            visited.add(nextX2 + "," + nextY2);
        }
    }

    return "No";
}
```

```java
public String isPossible(int a, int b, int c, int d) {
    Set<String> visited = new HashSet<>();
    return canReach(a, b, c, d, visited) ? "Yes" : "No";
}

private boolean canReach(int x, int y, int c, int d, Set<String> visited) {
    if (x == c && y == d) {
        return true;
    }

    String state = x + "," + y;
    if (visited.contains(state) || x > 1000 || y > 1000 || (x > c && y > d)) {
        return false;
    }

    visited.add(state);

    if (canReach(x + y, y, c, d, visited)) {
        return true;
    }

    if (canReach(x, x + y, c, d, visited)) {
        return true;
    }

    return false;
}
```

```java
public String isPossible(int a, int b, int c, int d) {
    return canReach(a, b, c, d)? "Yes": "No";
}

private boolean canReach(int x, int y, int c, int d) {
    if(a > c || b > d){
        return false;
    }
    if(a == c && b == d){
        return true;
    }
    return canReach(x+y, y, c, d) || canReach(x, x+y, c, d);
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

## Question <sub>last seen: 1/19/2024 @Pinterest</sub>

```
You are given a 2D grid represented as a list of lists of strings, where each cell contains either an empty string "" (representing no object) or a non-empty string (representing an object of that type).
Two cells are considered connected if they share the same non-empty value and are adjacent horizontally or vertically (but not diagonally).
Your task is to identify all unique non-empty object types (i.e., distinct string values) that form at least one connected group of size 2 or more. Return these object types as a sorted list of strings.

Constraints:
The grid has dimensions m rows and n columns, where 1 <= m, n <= 100.
Each cell is either "" or a non-empty string consisting of lowercase letters.
```

```java

public List<String> findConnectedObjects(String[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return new ArrayList<>();
    }

    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Map<String, Integer> maxComponentSize = new HashMap<>();

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!grid[i][j].isEmpty() && !visited[i][j]) {
                String val = grid[i][j];
                int size = dfs(grid, visited, i, j, val);
                maxComponentSize.put(val, Math.max(maxComponentSize.getOrDefault(val, 0), size));
            }
        }
    }

    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : maxComponentSize.entrySet()) {
        if (entry.getValue() >= 2) {
            result.add(entry.getKey());
        }
    }
    Collections.sort(result);
    return result;
}

private int dfs(String[][] grid, boolean[][] visited, int i, int j, String val) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !grid[i][j].equals(val)) {
        return 0;
    }
    visited[i][j] = true;
    int size = 1;

    size += dfs(grid, visited, i - 1, j, val);
    size += dfs(grid, visited, i + 1, j, val);
    size += dfs(grid, visited, i, j - 1, val);
    size += dfs(grid, visited, i, j + 1, val);
    return size;
}
```

## Question <sub>last seen: 12/2023 @JPMorgan Chase</sub>

```
Two strings are anagrams if they are permutations of each other. 
In other words, both strings have the same size and the same characters. 
For example, "aaagnnrs" is an anagram of "anagrams". Given an array of strings, remove each string that is an anagram of an earlier string, then return the remaining array in sorted order.
Example
str = ["code", "doce", "ecod", "framer", "frame"]

"code" and "doce" are anagrams. Remove "doce" from the array and keep the first occurrence "code" in the array.
"code" and "ecod" are anagrams. Remove "ecod" from the array and keep the first occurrence "code" in the array.

"framer" and "frame" are not anagrams. Keep both strings in the array.
Order the remaining strings in ascending order: ["code", "frame", "framer"]

Returns: string[m]: an array of the remaining strings in ascending alphabetical order.

Constraints
0 ≤ n ≤ 1000
0 ≤ m ≤ n
1 ≤ length of text[i] ≤ 1000
Each string text[i] is made up of characters in the range ascii[a-z]
```

```java
public static List<String> funWithAnagrams(String[] text) {
    Set<String> seen = new HashSet<>(); 
    TreeSet<String> result = new TreeSet<>();
    
    for (String s : text) {
        char[] chars = s.toLowerCase().toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        
        if (!seen.contains(sorted)) {
            seen.add(sorted);
            result.add(s);
        }
    }
    
    return new ArrayList<>(result);
}
```

## Question <sub>last seen: 12/2023 @JPMorgan Chase</sub>

```
Consider a string, sentence, of words separated by spaces where each word is a substring consisting of English alphabetic letters only.
Find the first word in the sentence that has a length which is both an even number and greater than or equal to the length of any other word of even length in the sentence.
If there are multiple words meeting the criteria, return the one which occurs first in the sentence.
```

```java
public static String longestEvenWord(String sentence) {
    String[] words = sentence.split(" ");
    String result = "";

    for (String word : words) {
        int length = word.length();
        if (length % 2 == 0 && length > result.length()) {
            result = word;
        }
    }

    return result;
}
```

## Question: <sub>last seen: 12/2023 @Meta</sub>

```
Given two arrays where the first array represents the prices of outbound flights from the departure location to the arrival location on consecutive days, and the second array represents the prices of return flights on the same set of consecutive days (with each index corresponding to a specific day), determine the minimum total cost for a round-trip ticket. The return flight may occur on the same day as the outbound flight or on any subsequent day. Return an array containing the indices of the outbound day and return day that yield this minimum cost. If multiple combinations achieve the same minimum cost, any valid pair of indices may be returned.
```

```java
public class CheapestRoundTrip {
    public static int[] findCheapestRoundTrip(int[] outbound, int[] inbound) {
        if (outbound == null || inbound == null || outbound.length == 0 || inbound.length == 0) {
            throw new IllegalArgumentException("Input arrays cannot be null or empty");
        }
        if (outbound.length != inbound.length) {
            throw new IllegalArgumentException("Input arrays must be of the same length");
        }

        int n = outbound.length;
        int minCost = Integer.MAX_VALUE;
        int[] result = new int[3]; // [outboundIndex, returnIndex, minCost]

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentCost = outbound[i] + inbound[j];
                if (currentCost < minCost) {
                    minCost = currentCost;
                    result[0] = i; // outbound index
                    result[1] = j; // return index
                    result[2] = minCost; // total cost
                }
            }
        }

        return result;
    }
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
