class MyCalendar {
    // treeset using the first index to sort
    TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        int[] book = new int[] {start, end};
        //return the largest element in the set that is less than or equal to the given element
        int[] floor = books.floor(book);
        int[] ceiling = books.ceiling(book);
        // ------
        //   -------
        if(floor != null && start < floor[1]) return false; 
        //    -------
        // ------
        if(ceiling != null && end > ceiling[0]) return false;
        books.add(book);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */