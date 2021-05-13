import java.util.ArrayList;
import java.util.*;
 
class shortestWayToFormString{
	//Time: O(n*m)
	//Speac: O(n)
	public int findNumberFreq(String source, String target){
		int num = 0;
		String remain = target;
		while(remain.length() > 0){
			StringBuilder sb = new StringBuilder();
			int i = 0, j = 0;
			while(i < source.length() && j < remain.length()){
				if(source.charAt(i++) == remain.charAt(j)){
					sb.append(remain.charAt(j++));
				}
			}
			if(sb.length() == 0){
				return -1;
			}
			num++;
			remain = remain.substring(sb.length());
		}	
		return num;
	}
	
	public static void main(String[] args){
		String a = "xyz",
			   b = "xyzxz";
		shortestWayToFormString temp = new shortestWayToFormString();
		int num = temp.findNumberFreq(a,b);

		System.out.println(num);
	}
}