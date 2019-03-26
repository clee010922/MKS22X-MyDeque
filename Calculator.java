public class Calculator {

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */

    public static double eval(String s) {
      String[] values = s.split(" ");
      MyDeque deque = new MyDeque(values.length);
      for (int i = 0; i < values.length; i++) {
        deque.addFirst(values[i]);
      }
      int val1 = Integer.parseInt(deque.getFirst());
      deque.removeFirst();
      int val2 = Integer.parseInt(deque.getFirst());
      deque.removeFirst();
      if (deque.getFirst)
    }

}
