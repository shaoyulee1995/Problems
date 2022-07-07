```
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
```
# Sweep Line
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as size of airplanes-
```
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    class Point{
        int time, delta;
        public Point(int time, int delta){
            this.time = time;
            this.delta = delta;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here

        List<Point> list = new ArrayList<Point>(airplanes.size() * 2);

        for(Interval airplane: airplanes){
            int start = airplane.start,
                end = airplane.end;
            list.add(new Point(start, 1));
            list.add(new Point(end, -1));
        }
        Collections.sort(list, new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.time == b.time){
                    return a.delta - b.delta;
                }
                return a.time - b.time;
            }
        });
        int max = 0,
            sum = 0;
        for(Point p: list){
            sum += p.delta;
            max = Math.max(max, sum);
        }
        return max;
    }
}
```