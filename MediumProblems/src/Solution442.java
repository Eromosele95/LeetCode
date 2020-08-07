class Solution442 {

    // Finding All duplicates in an array in Java,
    // 1 < nums[i] < n ( n = length of the array)
    // NOTE: a more efficient solution exists leveraging the restriction above!
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> holder = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        
        for(int num: nums){
            if(!holder.add(num)){
                res.add(num);
            }
        }
       return res; 
    }
}