class Solution {
    public String simplifyPath(String path) {
        /*
        1. "." the current directory
        2. ".." means moving up one directory level
        3. "//" interpreted as single slash
        */
        
        //use stack to record directory name
        Stack <String> s = new Stack();
        String[] strs = path.split("/");
        
        for(int i=0; i<strs.length; i++) {
            
            if(!s.isEmpty() && strs[i].equals(".."))
                s.pop();
            else if(!strs[i].equals(".") && !strs[i].equals("") && !strs[i].equals(".."))
                s.add(strs[i]);
        }
        
        //root directory
        if(s.isEmpty()) return "/";
        
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.insert(0, ("/" + s.pop()));
        }
        return res.toString();
    }
}