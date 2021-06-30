class NumArray {

    class TreeNode{
        private int sum, start, end;
        TreeNode right, left;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    TreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length -1);
    }
    
    public void update(int index, int val) {
        updateTree(root, index, val);
    }
    public int sumRange(int left, int right) {
        return query(root, left, right);
    }
    
    public int query(TreeNode root, int left, int right){
        if(root.start == left && root.end == right){
            return root.sum;
        }else{
            int mid = root.start + (root.end - root.start)/2;
            if(right <= mid){
                return query(root.left, left, right);
            }else if(left > mid){
                return query(root.right, left, right);
            }else{
                return query(root.left, left, mid) + query(root.right,  mid + 1, right);
            }
        }
    }
    
    private void updateTree(TreeNode root, int index, int val){
        if(root.start == root.end){
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(index <= mid){
            updateTree(root.left, index, val);
        }else{
            updateTree(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            TreeNode node = new TreeNode(start, end);
            node.sum = nums[start];
            return node;
        }else{
            TreeNode node = new TreeNode(start, end);
            int mid = start + (end - start)/2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */