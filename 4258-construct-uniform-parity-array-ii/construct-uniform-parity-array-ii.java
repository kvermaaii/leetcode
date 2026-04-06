class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        // try to construct odd parity array 
        //find the smallest odd number in nums1
        //check if it s lest then the smallest even number in nums1
        //if yes then return true
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int num : nums1){
            if(num % 2 == 1){
                minOdd = Math.min(num,minOdd);
            }else{
                minEven = Math.min(num,minEven);
            }
        }
        if(minOdd < minEven) return true;
        //try to construct even parity array
        //the problem here is to construct the array into even parity i have to subtract all th odd integer with another odd integer
        //in this case i have to subtract the min odd integer with another odd integer too but as it is the min odd integer and i cant subtract with itself so its not possible to get it >=1 so return false;
        if(minOdd == Integer.MAX_VALUE){
            return true;
        } // all even numbers 
        return false;
    }
}