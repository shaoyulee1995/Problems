# Word Ladder

- Time Complexity: O(NW<sup>2</sup>)
- Space Complexity: O(NW)
  - N as length of wordList
  - W as length of word

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet(wordList);
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        for(int res = 1, size = queue.size(); !queue.isEmpty(); res++, size = queue.size()){
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.equals(endWord)){
                    return res;
                }
                for(int j = 0; j < word.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(j, c);
                        if(set.contains(sb.toString())){
                            queue.offer(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
}
```

- Time Complexity: O(NW<sup>2</sup>)
- Space Complexity: O(NW)
  - N as length of wordList
  - W as length of word in wordList

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> total = new HashSet(wordList),
                        start = new HashSet(),
                        end = new HashSet();
        start.add(beginWord);
        end.add(endWord);
        return bfs(start, end, total, 1);
    }

    public int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> total, int step){
        if(start.size() > end.size()){
            return bfs(end, start, total, step);
        }
        HashSet<String> attempt = new HashSet();
        total.removeAll(start);
        for(String s: start){
            for(int i = 0; i < s.length(); i++){
			    char[] chars = s.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(total.contains(newWord)){
                        attempt.add(newWord);
                    }
                    if(total.contains(newWord) && end.contains(newWord)){
                        return step + 1;
                    }

                }
            }
        }
        if(attempt.isEmpty()){
            return 0;
        }
        step++;
        return bfs(attempt, end, total, step);
    }
}
```

- Time Complexity: O(NW<sup>2</sup>)
- Space Complexity: O(NW)
  - N as length of wordList
  - W as length of word in wordList

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet(wordList),
                        begin = new HashSet(),
                        end = new HashSet(),
                        seen = new HashSet();
        if(!words.contains(endWord)){
            return 0;
        }
        begin.add(beginWord);
        end.add(endWord);
        int step = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            HashSet<String> nextSet = new HashSet();
            for(String word: begin){
                for(int i = 0; i < word.length(); i++){
                    char[] chars = word.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if(end.contains(nextWord)){
                            return step+1;
                        }
                        if(seen.add(nextWord) && words.contains(nextWord)){
                            nextSet.add(nextWord);
                        }
                    }
                }
            }
            step++;
            if(nextSet.size() > end.size()){
                begin = end;
                end = nextSet;
            }else{
                begin = nextSet;
            }
        }
        return 0;
    }
}
```
