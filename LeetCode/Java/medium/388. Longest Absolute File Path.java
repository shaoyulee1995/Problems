class Solution {
    
    /**
    dir
        suddir1
            file1.ext
            subsubdir1
        subdir2
            subsubdir2
                file2.ext
    
    */
    public int lengthLongestPath(String input) {
        ArrayDeque<Integer> stack = new ArrayDeque();
        stack.push(0);
        int maxL = 0;
        for(String s: input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            int length = s.length() - level;
            while(stack.size() > level + 1){
                stack.pop();
            }
            if(s.contains(".")){
                maxL = Math.max(maxL, stack.peek() + length);
            }else{
                stack.push(stack.peek() + length + 1); //adding the "prev length" and "itself" and "/"
            }
            
        }
        
        return maxL;
    }
}