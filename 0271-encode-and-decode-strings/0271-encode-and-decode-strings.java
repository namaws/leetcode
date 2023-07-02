public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int len = str.length();
            sb.append(len+"#"+str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        int ptr1 = 0;
        while(ptr1 < s.length()) {
            int ptr2 = ptr1;
            while(s.charAt(ptr2) != '#')
                ptr2++;
            int len = Integer.valueOf(s.substring(ptr1, ptr2));
            String str = s.substring(ptr2+1, ptr2+len+1);
            result.add(str);
            ptr1 = ptr2+len+1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));