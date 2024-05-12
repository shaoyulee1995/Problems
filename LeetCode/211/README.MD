# Design Add and Search Words Data Structure
# Trie
## addWord
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of word 
## search
* Time Complexity: O(26<sup>N</sup>)
* Space Complexity: O(1)
	* N as length of word
```
class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }       
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child: node.children){
                if(child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }else{
            return node.children[c-'a'] != null && dfs(word, index+1, node.children[c-'a']);
        }
    } 
}

class TrieNode{
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
```
```
Your WordDictionary object will be instantiated and called as such:
WordDictionary obj = new WordDictionary();
obj.addWord(word);
boolean param_2 = obj.search(word);
```