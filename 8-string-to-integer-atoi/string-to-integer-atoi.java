class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        char[] chr = s.toCharArray();
        int length = s.length();
        if (length == 0) return 0;

        boolean neg = false;
        int num = 0;
        int k = 0;

        if (chr[0] == '-') {
            neg = true;
            k++;
        } else if (chr[0] == '+') {
            k++;
        }

        for (int i = k; i < length; i++) {
            if (!Character.isDigit(chr[i])) {
                break;
            }

            int d = chr[i] - '0';
            if (num > (Integer.MAX_VALUE - d) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + d;
        }

        return neg ? -num : num;
    }
}
