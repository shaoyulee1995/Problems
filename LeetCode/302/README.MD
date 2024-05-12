# Smallest Rectangle Enclosing Black Pixels
# BFS
* Time Complexity: O(MN)
* Space Complexity: O(MN)
	* M as length of image
	* N as length of image[0]
```
class Solution {
    public int minArea(char[][] image, int x, int y) {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[]{x, y});
		int[] topLeft = {x, y},
			  bottomRight = {x, y};
		image[x][y] = '2';
		int[] dirs = new int[]{0, 1, 0, -1, 0};
		while(!queue.isEmpty()){
			int[] pos = queue.poll();
			int i = pos[0],
					j = pos[1];
			for(int k = 0; k < 4; k++){
				int r = i + dirs[k], 
					  c = j + dirs[k+1];
				if(r < 0 || r == image.length || c < 0 || c == image[0].length){
					continue;
				}
				if(image[r][c] != '1'){
					continue;
				}
				topLeft[0] = Math.min(topLeft[0], r);
				topLeft[1] = Math.min(topLeft[1], c);
				bottomRight[0] = Math.max(bottomRight[0], r);
				bottomRight[1] = Math.max(bottomRight[1], c);
				queue.offer(new int[]{r, c});
				image[r][c] = '2';
			}
		}
		int width = bottomRight[0] - topLeft[0] + 1, 
			height = bottomRight[1] - topLeft[1] + 1;
		return width * height;
    }
}
```
# FP
* Time Complexity: O(Max(MlogN, NlogM))
* Space Complexity: O(MN)
	* M as length of image
	* N as length of image[0]
```
class Solution {
	char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
		int x1 = findAnyOne(0, x, rowAllZero),
			x2 = findAllZero(x+1, image.length, rowAllZero),
			y1 = findAnyOne(0, y, ColAllZero),
			y2 = findAllZero(y+1, image[0].length, ColAllZero);
		return (x2-x1)*(y2-y1);
    }

	public int findAnyOne(int i, int j, Function<Integer, Boolean> allZero){
		while(i < j){
			int k = i + (j-i)/2;
			if(allZero.apply(k)){
				i = k + 1;
			}else{
				j = k;
			}   
		}
		return i;
	}

	public int findAllZero(int i, int j, Function<Integer, Boolean> allZero){
		while(i < j){
			int k = i + (j-i)/2;
			if(allZero.apply(k)){
				j = k;
			}else{
				i = k+1;
			}
		}
		return i;
	}

	Function<Integer, Boolean> rowAllZero = new Function<>(){
		public Boolean apply(Integer index){
			return new String(image[index]).chars().allMatch(p -> p == '0');
		}
	};

	Function<Integer, Boolean> ColAllZero = new Function<>(){
		public Boolean apply(Integer index){
			for(int i = 0; i < image.length; i++){
				if(image[i][index] == '1'){
					return false;
				}
			}
			return true;
		}
	};
}
```