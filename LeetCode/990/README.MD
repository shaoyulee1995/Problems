# Satisfiability of Equality Equations
# UnionFind
* Time Complexity: O(NClog(C))
* Space Complexity: O(C)
	* N as length of equations
	* C as length of lowercase alphabet
```
class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String equation: equations){
            int a = equation.charAt(0)-'a',
                b = equation.charAt(3)-'a';
            if(equation.charAt(1) =='='){
                uf.union(a,b);
            }
        }
        for(String equation: equations){
            int a = equation.charAt(0)-'a',
                b = equation.charAt(3)-'a';
            if(equation.charAt(1) =='!'){
                if(uf.isConnected(a,b)){
                    return false;
                }
            }
        }
        return true;
    }
}
```
```
class UnionFind{
    int[] parents;
    public UnionFind(int nodes){
        parents = new int[nodes];
        for(int i = 0; i < nodes; i++){
            parents[i] = i;
        }
    }

    public void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 != root2){
            parents[root2] = root1;
        }
    }
    public int find(int node){
        while(parents[node] != node){
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }
    public boolean isConnected(int node1, int node2){
        return find(node1) == find(node2);
    }
}
```