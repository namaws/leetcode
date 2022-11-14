class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(days(date1) - days(date2));
    }
    
    
    //count start from 1900-1-0
    public int days(String date) {
        String[] day = date.split("-");
        int y = Integer.valueOf(day[0]);
        int m = Integer.valueOf(day[1]);
        int d = Integer.valueOf(day[2]);
        
        //count from January
        int[] monthDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        
        //how many years have been, but not including this year
        //this year is not fully done yet
        int fullYear = y - 1 - 1900;
        //how many leap year -> add how many days
        //start from 1900, every 4 year is leap year
        int currDays = fullYear*365 + fullYear/4; 
        int fullMonth = monthDays[m-1];
        if(isLeapYear(y) && m-1 >= 2) {
            currDays ++;
        }
        return currDays + fullMonth + d;
    }
    
    private boolean isLeapYear(int year) {
        return (year%100 != 0 && year%4 == 0) || year % 400 == 0;
    }
}