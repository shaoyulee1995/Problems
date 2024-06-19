# Text Justification

# String

- Time Complexity: O(WMc)
- Space Complexity: O(W)
  - W as length of words
  - M as maxWidth
  - c as number of lines

```
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> list = new ArrayList();
        while(i < words.length){
            int j = goRight(i, words, maxWidth);
            list.add(justify(i, j, words, maxWidth));
            i = j + 1;
        }
        return list;
    }

    public int goRight(int start, String[] words, int maxWidth){
        int end = start;
        int sum = words[end++].length();

        while(end < words.length && sum + 1 + words[end].length() <= maxWidth){
            sum += 1 + words[end++].length();
        }
        return end - 1;
    }

    public String justify(int start, int end, String[] words, int maxWidth){
        if(start == end){
            return padResult(words[start], maxWidth);
        }
        boolean lastLine = (end == words.length - 1);
        int numSpace = end - start;
        int totalSpace = maxWidth  - wordsSpace(start, end, words);
        String space = lastLine? " ": blank(totalSpace / numSpace);
        int remainder = lastLine? 0: totalSpace % numSpace;

        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            sb.append(words[i])
                .append(space)
                .append(remainder-- > 0?" ": "");
        }
        return padResult(sb.toString().trim(), maxWidth);
    }

    public int wordsSpace(int i, int j, String[] words){
        int wordLength = 0;
        for(int w = i; w <= j; w++){
            wordLength += words[w].length();
        }
        return wordLength;
    }

    public String padResult(String word, int maxWidth){
        return word + blank(maxWidth - word.length());
    }

    public String blank(int spaces){
        return new String(new char[spaces]).replace('\0', ' ');
    }
}
```
