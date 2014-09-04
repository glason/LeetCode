/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  */
  public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0){
            return -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int left=0,right=0;
        for(String s:tokens){
            if("+-*/".contains(s)){
                right = stack.pop();
                left = stack.pop();
            }
            if(s.equals("+")){
                stack.add(left+right);
            }else if(s.equals("-")){
                stack.add(left-right);
            }else if(s.equals("*")){
                stack.add(left*right);
            }else if(s.equals("/")){
                stack.add(left/right);
            }else{
                stack.add(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}