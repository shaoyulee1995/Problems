#include <iostream>
#include <bits/stdc++.h>
#include <string>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left, *right;
	TreeNode(int x): val(x), left(NULL), right(NULL){};
};

class Node{
	public:
	string seralize(TreeNode *root){
		if(!root){
			return "NULL";
		}
		return to_string(root->val) + " " + seralize(root->left) + " " + seralize(root->right);
	}
	TreeNode* deserialize(string data){
		cout<<"data in deserialize: "<<data<<endl;
		istringstream ss(data);
		return deserial(ss);
	}
	TreeNode *deserial(istringstream &ss){
		string str;
		ss >> str;
		if(str == "NULL"){
			return NULL;
		}
		TreeNode* root = new TreeNode(stoi(str));
		root->left = deserial(ss);
		root->right = deserial(ss);
		return root;
	}
};

int main(){
	string input = "1 2 NULL NULL 3 4 NULL NULL 5 NULL NULL";
	Node node;
	string output = node.seralize(node.deserialize(input));
	if(input == output){
		cout<<"same strings"<<endl;
	}else{
		cout<<"error on seralize or deserialize"<<endl;
	}
	return 0;
}
