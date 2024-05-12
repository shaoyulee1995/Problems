# Perfect Rectangle
# Set
* Time Complexity: O(R)
* Space Complexity: O(R)
	* R as length of rectangles
```
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0){
            return false;
        }
        int x1 = Integer.MAX_VALUE,
            y1 = Integer.MAX_VALUE,
            x2 = Integer.MIN_VALUE,
            y2 = Integer.MIN_VALUE,
            area = 0;
        Set<String> set = new HashSet();
        for(int[] rect: rectangles){
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String pt1 = rect[0] + " " + rect[1],
                   pt2 = rect[0] + " " + rect[3],
                   pt3 = rect[2] + " " + rect[1],
                   pt4 = rect[2] + " " + rect[3];
            if(!set.add(pt1)){
                set.remove(pt1);
            }
            if(!set.add(pt2)){
                set.remove(pt2);
            }
            if(!set.add(pt3)){
                set.remove(pt3);aa
            }
            if(!set.add(pt4)){
                set.remove(pt4);
            }
        }
        if(set.size() != 4 ||
           !set.contains(x1 + " " + y1) ||
           !set.contains(x1 + " " + y2) ||
           !set.contains(x2 + " " + y1) ||
           !set.contains(x2 + " " + y2)){
            return false;
        }
        return area == (x2-x1)*(y2-y1);
    }
}
```