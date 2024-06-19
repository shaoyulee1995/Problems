# Design Parking System

# Design

- Time Complexity:
  - addCar: O(N)
- Space Complexity: O(1)

```
class ParkingSystem {
    int B = 0, M = 0, S = 0;
    public ParkingSystem(int big, int medium, int small) {
        this.B = big;
        this.M = medium;
        this.S = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1){
            return --B >= 0;
        }
        if(carType == 2){
            return --M>= 0;
        }
        if(carType == 3){
            return --S >=0;
        }
        return false;
    }
}
```

# Design

- Time Complexity:
  - addCar: O(1)
- Space Complexity: O(1)

```
class ParkingSystem {
    int[] cars;
    public ParkingSystem(int big, int medium, int small) {
        cars = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return --cars[carType-1] >= 0;
    }
}
```

```
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
```
