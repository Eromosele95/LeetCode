class Solution231 {
    // Learning to work with bits and bitwise operations. Checking if a number is a 
    // power of 2
    public boolean isPowerOfTwo(int n) {
        int max_on_bit = 0;
        
        while (n>0){
            max_on_bit += n & 1; 
            n >>= 1;

        }
        return max_on_bit == 1;
        
    }
}