#include <iostream>
#include <vector>
using namespace std;
vector<int> productExceptSelf(vector<int> &nums){
	int n = nums.size();
	vector<int> result(n);
	result[0]=1;
	for(int i = 1; i < n; i++){
		result[i] = result[i-1] * nums[i-1];
	}
	int R = 1;
	for(int i = n-1; i >= 0; i--){
		result[i]*=R;
		R*=nums[i];
	}
	return result;
}

int main(){
	int n;
	cin >> n;
	vector<int> vec(n);
	for(int i = 0; i < n; i++){
		cin >> vec[i];
	}
	vector<int> ans = productExceptSelf(vec);
	for(int i = 0; i < ans.size(); i++){
		cout<<ans[i]<< " ";	
	}
	return 0;
}
