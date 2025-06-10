class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        char[] chr = s.toCharArray();
        for (int i = chr.length-1 ; i >= 0; i--) {
            if(i != chr.length-1 && (map.get(chr[i+1]) > map.get(chr[i])) ){
                sum -= map.get(chr[i]);
            } else{
                sum += map.get(chr[i]);
            }
        }
        return sum;                                                     
    }
}