# Replace Words

## replaceWords(List<String> dictionary, String sentence)

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of dictionary

## replaceWords(String sentence)

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of sentence

## getShortestWord(String word)

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of word

## insert(String word)

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```
class Solution {
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        return replaceWords(sentence);
    }

    public String replaceWords(String sentence){
        StringBuilder sb = new StringBuilder();
        for(String word: sentence.split(" ")){
            sb.append(getShortestWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    public String getShortestWord(String word){
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            sb.append(c);
            if(node.children[c-'a'] == null){
                return word;
            }
            if(node.children[c-'a'].isWord){
                return sb.toString();
            }
            node = node.children[c-'a'];
        }
        return word;
    }


    public void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}
```
