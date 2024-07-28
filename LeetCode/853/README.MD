# Car Fleet

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of cars

```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], (double) (target - position[i])/speed[i]);
        }
        Arrays.sort(cars, (a, b) -> b.position - a.position);
        int res = 0;
        double lastCarTime = 0;
        for(int i = 0; i < cars.length; i++){
            if(cars[i].time > lastCarTime){
                res++;
                lastCarTime = cars[i].time;
            }
        }
        return res;
    }

    class Car{
        int position;
        double time;
        public Car(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
}
```
