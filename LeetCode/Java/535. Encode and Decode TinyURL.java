public class Codec {

    HashMap<String, String> codeDatabase = new HashMap(), 
                            urlDatabase = new HashMap();
    String alphabet = "QAZXSWEDCVFRTGBNHYUJMKIOLPqazxswedcvfrtgbnhyujmkiolp";
    
    
    public String getCode(){
        char[] code = new char[6];
        
        for(int i = 0; i < 6; i++){
            code[i] = alphabet.charAt((int)Math.random()*62);
        }
        
        return "http://tinyurl.com/" + String.valueOf(code);
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(urlDatabase.containsKey(longUrl)){
            return urlDatabase.get(longUrl);
        }
        
        String code = getCode();
        
        while(urlDatabase.containsKey(longUrl)){
            code = getCode();
        }
        
        codeDatabase.put(code, longUrl);
        urlDatabase.put(longUrl, code);
        return code;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeDatabase.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));