# 4Sum

- Time Complexity: O(N<sup>3</sup>)
- Space Complexity: O(N<sup>4</sup>)
  - N as length of nums

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int idx, int k){
        List<List<Integer>> res = new ArrayList();
        if(idx == nums.length || k * nums[idx] > target || k * nums[nums.length - 1] < target){
            return res;
        }
        if(k == 2){
            return twoSum(nums, idx, target);
        }
        for(int i = idx; i < nums.length; i++){
            if(i == idx || nums[i-1] != nums[i]){
                for(var set : kSum(nums, target-nums[i], i+1, k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int idx, int target){
        List<List<Integer>> res = new ArrayList();
        int i = idx, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < target || (i > idx && nums[i] == nums[i-1])){
                i++;
            }else if(sum > target || j < nums.length - 1 && nums[j] == nums[j+1]){
                j--;
            }else{
                res.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>3</sup>)
- Space Complexity: O(N<sup>4</sup>)
  - N as length of nums

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i + 3 < nums.length; i++){
            if(nums[i] > 0 && nums[i] > target){
                return new ArrayList(res);
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j + 2 < nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j+1,
                    l = nums.length-1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[k] == nums[k+1]){
                            k++;
                        }
                        while(k < l && nums[l] == nums[l-1]){
                            l--;
                        }
                        k++;
                        l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return new ArrayList(res);
    }
}
```
