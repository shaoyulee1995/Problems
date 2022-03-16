# TreeMap, OOP
* FileSystem
	* Space Complexity: O(1)
* findNode
	* Time Complexity: O(N)
	* Space Complexity: O(1)
		* N as depth of path
```
class FileSystem {
    fileNode root;
    public FileSystem() {
        root = new fileNode("");
    }
    
    public List<String> ls(String path) {
        return findNode(path).getList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }
    public fileNode findNode(String path){
        String[] paths = path.split("/");
        fileNode cur = root;
        for(String p: paths){
            if(p.length() == 0){
                continue;
            }
            cur.children.putIfAbsent(p, new fileNode(p));
            cur = cur.children.get(p);
            if(cur.isFile()){
                break;
            }
        }
        return cur;
    }
}
```
* fileNode
	* Space Complexity: O(N)
		* N as depth of path
* getContent
	* Time Complexity: O(N)
	* Space Complexity: O(1)
		* N as depth of path
* addContent
	* Time Complexity: O(N)
	* Space Complexity: O(N)
		* N as depth of path
* getList
	* Time Complexity: O(N)
	* Space Complexity: O(N)
		* N as depth of path
```
class fileNode{
    TreeMap<String, fileNode> children;
    StringBuilder file;
    String name;
    public fileNode(String name){
        this.name = name;
        children = new TreeMap();
        file = new StringBuilder();
    }
    public String getContent(){
        return file.toString();
    }
    public String getName(){
        return name;
    }
    public void addContent(String content){
        file.append(content);
    }
    public boolean isFile(){
        return file.length() > 0;
    }
    public List<String> getList(){
        List<String> list = new ArrayList();
        if(isFile()){
            list.add(getName());
        }else{
            list.addAll(children.keySet());
        }
        return list;
    }
}
```
```
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
```