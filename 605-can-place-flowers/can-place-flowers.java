class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if(length == 1 && flowerbed[0] == 0 && n < 2){
            return true;
        }
        int totalCount = 0;
        int space = 0;
        int i = 0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            totalCount++;
            flowerbed[0] = 1;
        }
        if(flowerbed[length-1] == 0 && flowerbed[length-2] == 0){
            totalCount++;
            flowerbed[length-1] = 1;
        }
        int start;
        while(i < length){
            start = i;
            while(i < length && flowerbed[i] != 1){
                i++;
            }
            space = i - start;
            if(space < 3){
                i++;
                continue;
            }
            if(space % 2 == 0){
                totalCount += space/2 - 1;
            } else{
                totalCount += space/2;
            }
            i++;
        }
        return totalCount >= n ? true : false;
    }
}