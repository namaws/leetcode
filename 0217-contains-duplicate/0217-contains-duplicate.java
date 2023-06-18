class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            //set.add(num) will return boolean value
            //true -> num can add in the set, meaning num is not in the set yet
            //false -> num cannot be added in the set, meaning num is already existed
            if(!set.add(num))
                return true;
            set.add(num);
        }
        return false;
    }
}