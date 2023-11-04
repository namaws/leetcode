public class Codec {

    // Encodes a list of strings to a single string.
    /*
    1. count the words
    2. add # after number
    3. attached the word following
    */
    
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str: strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < s.length()){
            ptr2 = ptr1;
            while(s.charAt(ptr2) != '#')
                ptr2++;
            int len = Integer.valueOf(s.substring(ptr1, ptr2));
            //ptr2 is # now
            String str = s.substring(ptr2+1, ptr2+1+len);
            ptr1 = ptr2+1+len;
            list.add(str);
            
        }   
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));