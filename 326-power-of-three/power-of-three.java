class Solution {
    public boolean isPowerOfThree(int n) {
        // as 3 is a prime no and the maximum poer of 3 for int can be 3^19 so the only divisor of 3^19 will be from 3^0, 3^1, .... ,3^18, 3^19. so is n divides 3^19 it is power of 3.
          return n > 0 && 1162261467 % n == 0;
    }
}