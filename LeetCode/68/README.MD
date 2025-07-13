# Text Justification

- Time Complexity: O(WMc)
- Space Complexity: O(W)
  - W as length of words
  - M as maxWidth
  - c as number of lines

```java
class Solution {
    int SPACE_LENGTH = 1;
    char SPACE = ' ';

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        for (int i = 0, j; i < words.length;) {
            j = goRight(i, words, maxWidth);
            String eachLine = justify(i, j, words, maxWidth);
            res.add(eachLine);
            i = j + 1;
        }
        return res;
    }

    public int goRight(int i, String[] words, int maxWidth) {
        int sumWidth = words[i].length(),
            j = i + 1;
        while (j < words.length && (sumWidth + SPACE_LENGTH + words[j].length()) <= maxWidth) {
            sumWidth += SPACE_LENGTH + words[j].length();
            j++;
        }
        return j - 1;
    }

    public String justify(int i, int j, String[] words, int maxWidth) {
        if (i == j) {
            return padResult(words[i], maxWidth);
        }
        boolean lastLine = (j == words.length - 1);

        int minSpace = j - i,
            totalSpace = maxWidth - wordsInLine(i, j, words),
            remainSpace = lastLine ? 0 : totalSpace % minSpace;
        String eachSpace = lastLine ? " " : blank(totalSpace / minSpace);

        StringBuilder sb = new StringBuilder();
        for (int w = i; w <= j; w++) {
            sb.append(words[w])
              .append(eachSpace);
            if (remainSpace > 0) {
                sb.append(SPACE);
                remainSpace--;
            }
        }
        return padResult(sb.toString().trim(), maxWidth);
    }

    public int wordsInLine(int i, int j, String[] words) {
        int res = 0;
        for (int w = i; w <= j; w++) {
            res += words[w].length();
        }
        return res;
    }

    public String padResult(String word, int maxWidth) {
        return word + blank(maxWidth - word.length());
    }

    public String blank(int space) {
        return new String(new char[space]).replace('\0', SPACE);
    }
}
```
