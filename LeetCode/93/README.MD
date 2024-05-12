# Restore IP Addresses
# Backtrack
* Time Complexity: O(IDK)
* Space Complexity: O(IDK)
	* IDK as I don't know
```
class Solution {
    List<String> list = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12){
            return list;
        }
        int[] segments = new int[4];
        restoreIpAddresses(s, 0, segments, 0);
        return list;
    }
    public void restoreIpAddresses(String s, int index, int[] segments, int segmentIndex){
        if(index == s.length() && segmentIndex == 4){
            list.add(new String(segments[0] + "." + segments[1] + "." + segments[2] + "." + segments[3]));
            return;
        }
		if(index == s.length() || segmentIndex == 4){
            return;
        }
        for(int len = 1; len <= 3 && index + len <= s.length(); len++){
            int val = Integer.parseInt(s.substring(index, index + len));
            if(val > 255 || len > 1 && s.charAt(index) == '0'){
                break;
            }
            segments[segmentIndex] = val;
            restoreIpAddresses(s, len+index, segments, segmentIndex + 1);
            segments[segmentIndex] = -1;
        }
    }
}
```