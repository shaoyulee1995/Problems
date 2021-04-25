class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] nameOfDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        int givenDay = getNum(day, month, year);
        int today = getNum(25,4,2021);
        
        int diff = Math.abs(givenDay - today) % 7;
        
        if(diff == 0){
            return nameOfDay[0];
        }
        
        if(givenDay - today < 0){
            return nameOfDay[nameOfDay.length - diff];
        }
        return nameOfDay[diff];
    }
    
    
    private boolean isLeap(int year){
        if(year%4 == 0 && year%100 != 0){
            return true;
        }else if(year % 400 == 0){
            return true;
        }
        return false;
    }
    private int getNum(int day, int month, int year){
        HashMap<Integer, Integer> map = new HashMap();
        map.put(1,31);
        map.put(3,31);
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);
        map.put(2,28);

        if(isLeap(year)){
            map.put(2, 29);
        }
        int sum = 0;
        for(int i = 1977; i < year; i++){
            sum+=365;
            if(isLeap(i)){
                sum+=1;
            }
        }
        for(int i = 1; i < month; i++){
            sum+=map.get(i);
        }
        sum += day;
        return sum;
    }
}