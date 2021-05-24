import java.util.HashSet;

class Solution{
	public static void main(String[] args){
		int[] a = {10,15,3,7};
		if(check(a, 17)){
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}
	}
	public static boolean check(int[] A, int k){
		HashSet<Integer> set = new HashSet();
		for(int a: A){
			if(set.contains(a)){
				return true;
			}
			set.add(k-a);
		}
		return false;
	}
}