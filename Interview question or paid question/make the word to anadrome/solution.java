class solution{
	public static int count(String word){
		int[] cnt = new int[26];
		for(char c: word.toCharArray()){
			cnt[c-'a']++;
		}
		int ans = 0;
		for(int i = 0; i < 26; i++){
			if(cnt[i]%2 != 0){
				ans++;
			}
		}
		if(ans == 1 || ans == 0){
			return 0;
		}
		return ans - 1;
	}
	public static void main(String[] args){
		String[] words = {"tattoo", "abcb", "abab", "abc"};
		for(int i = 0; i < words.length; i++){
			System.out.println(count(words[i]));
		}
	}
}