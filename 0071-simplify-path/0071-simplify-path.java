class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack();
        String[] strs = path.split("/");
        
        for(int i=0; i<strs.length; i++) {
            //go to parent directory -> remove current one
            if(!s.empty() && strs[i].equals(".."))
                s.pop();

            else if(!strs[i].equals(".") && !strs[i].equals("") && !strs[i].equals(".."))
                s.add(strs[i]);
        }
        //root
        if(s.empty()) return "/";

        StringBuilder sb = new StringBuilder();
        while(!s.empty()) {
            sb.insert(0, ("/"+s.pop()));
        }
        return sb.toString();

    }
}