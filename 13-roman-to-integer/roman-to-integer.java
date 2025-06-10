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
        int length = s.length();
        for (int i = length-1 ; i >= 0; i--) {
            if(i != length-1 && (map.get(s.charAt(i+1)) > map.get(s.charAt(i))) ){
                sum -= map.get(s.charAt(i));
            } else{
                sum += map.get(s.charAt(i));
            }
        }
        return sum;                                                     
    }
}