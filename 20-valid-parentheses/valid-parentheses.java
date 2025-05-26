import java.util.Map;
import java.util.Stack;

public class Solution {

    private static final Map<Character, Character> map = Map.of('(', ')',
                                                                '{', '}', 
                                                                '[', ']');

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int l = s.length();
        if(l == 0 || l%2 != 0){
            return false;
        }
        if(map.containsValue(s.charAt(0))){
            return false;
        }
        stk.push(s.charAt(0));
        for(int i =1; i<l; i++){
            if(stk.isEmpty() && map.containsValue(s.charAt(i))){
                return false;
            }
            if(map.containsKey(s.charAt(i))){
                stk.push(s.charAt(i));
            } else{
                if(s.charAt(i) == map.get(stk.peek())){
                    stk.pop();
                } else {
                    if(map.containsValue(s.charAt(i))){
                        return false;
                    }
                }
            }
        }

        return stk.isEmpty();
    }
}