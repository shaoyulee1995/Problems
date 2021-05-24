#include <iostream>
#include <vector>
#include <set>

using namespace std;

bool check(vector<int> &a, int k);

//n = 4, k = 17
//array: 10,15,3,7
int main(){
	int n, k;
	cin>> n >> k;
	cout<<"k: "<<k<<endl;
	vector<int> a(n);
	for(int i = 0; i < n; i++){
		cin >> a[i];
	}
	bool ans = check(a, k);
	if(ans){
		cout<<"Found"<<endl;
	}else{
		cout<<"Not Found"<<endl;
	}
	return 0;
}

bool check(vector<int> &a, int k){
	set<int> set ;
	
	for(int i = 0; i < a.size(); i++){
		if(set.find(a[i])!=set.end()){
			return true;
		}
		set.insert(k-a[i]);
	}
	return false;
}
