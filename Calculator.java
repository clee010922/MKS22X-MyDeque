public class Calculator {

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */

    public static double eval(String s) {
      String[] values = s.split(" ");
      MyDeque<Double> deque = new MyDeque<Double>();
      for (int i = 0; i < values.length; i++) {
        if (values[i].equals("+")) {
          Double second = deque.getLast();
          deque.removeLast();
          Double first = deque.getLast();
          deque.removeLast();
          deque.addLast(first + second);
        }
        else if (values[i].equals("-")) {
          Double second = deque.getLast();
          deque.removeLast();
          Double first = deque.getLast();
          deque.removeLast();
          deque.addLast(first - second);        
        }

}
