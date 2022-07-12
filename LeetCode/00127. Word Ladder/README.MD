# One direction BFS
* Time Complexity: O(NW<sup>2</sup>)
* Space Complexity: O(NW)
	* N as length of wordList
	* W as length of word
```
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet(wordList);
        if(!set.contains(endWord)){
            return 0;       
        }
        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        
        HashSet<String> seen = new HashSet();
        seen.add(beginWord);
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                   return res; 
                }
                for(int w = 0; w < word.length(); w++){
                    for(int c = 'a'; c <= 'z'; c++){
                        char[] cnt = word.toCharArray();
                        cnt[w] = (char)c;
                        
                        String str = new String(cnt);
                        if(!seen.contains(str) && set.contains(str)){
                            q.offer(str);
                            seen.add(str);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
```
# Two directions DFS
* Time Complexity: O()
* Space Complexity: O()
```
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> start = new HashSet();
        start.add(beginWord);
        HashSet<String> end = new HashSet();
        end.add(endWord);
        HashSet<String> total = new HashSet(wordList);
        int res = bfs(start, end, total, 1);
        return res;
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
        step += 1;
        if(attempt.isEmpty()){
            return 0;
        }
        return bfs(attempt, end, total, step);
    }
}
```