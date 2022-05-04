# HashMap
* Time Complexity: O(U)
* Space Complexity: O(N)
	* U as length of url
	* N as number of urls
```
public class Codec {

    HashMap<String, String> map = new HashMap();
    String chars = "QAZXSWEDCVFRTGBNHYUJMKIOLPqazxswedcvfrtgbnhyujmkiolp0123456789";
    Random r = new Random();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = "";
        while(map.containsKey(longUrl)){
            key = getCode();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String getCode(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++){
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(shortUrl);
    }
}
```
```
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
```