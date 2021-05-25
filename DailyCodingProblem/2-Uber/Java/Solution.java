class Solution{
	public static int[] convert(int[] a){
		int[] result = new int[a.length];
		result[0] = 1;
		for(int i = 1; i < a.length; i++){
			result[i] = result[i-1] * a[i-1];
		}
		int R = 1;
		for(int i = a.length - 1; i >= 0; i--){
			result[i] *= R;
			R *= a[i];
		}
		return result;
	}
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] coverted = convert(a);
       	for(int num: coverted){
       		System.out.print(num + " ");
       	}
    }
}