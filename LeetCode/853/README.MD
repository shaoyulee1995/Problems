# Car Fleet

# Array

- Time Complexity: O(Nlog(N))
- Space Complexity: O(N)
  - N as length of cars

```
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], (double)(target-position[i])/speed[i]);
        }
        Arrays.sort(cars, (a, b) -> b.position - a.position);
        int res = 0;
        double time = 0;
        for(int i = 0; i < cars.length; i++){
            if(cars[i].time > time){
                res++;
                time = cars[i].time;
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
