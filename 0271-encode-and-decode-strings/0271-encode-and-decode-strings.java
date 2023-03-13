public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()+"#"+str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList();
        int p1 = 0;
        while(p1 < s.length()) {
            int p2 = p1;
            //find the number of length
            while(s.charAt(p2) != '#') {
                p2++;
            }
            // change the string of number into integer
            int length = Integer.valueOf(s.substring(p1, p2));
            //make p1 go all the way to the end of that word
            p1 = p2 + length + 1;
            list.add(s.substring(p2+1, p1));
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));