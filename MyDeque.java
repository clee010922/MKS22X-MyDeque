import java.util.*;

public class MyDeque<E> {

  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] temp = (E[])new Object[data.length * 2 + 1];
    if (start < end) {
      for (int i = 0; i+start < end; i++) {
        temp[i] = data[i+start];
      }
    }
    if (start > end) {
      int counter = 0;
      for (int i = start; i < data.length; i++) {
        temp[counter] = data[i];
        counter++;
      }
      for (int i = 0; i < end; i++) {
        temp[counter] = data[i];
        counter++;
      }
    }
    start = 0;
    end = size;
    data = temp;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String result = "{";
    if (start < end) {
      for (int i = start; i < end; i++) {
        result += data[i] + " ";
      }
    }
    if (start > end) {
      for (int i = start; i < data.length; i++) {
        result += data[i] + " ";
      }
      for (int i = 0; i < end; i++) {
        result += data[i] + " ";
      }
    }
    result += "}";
    return result;
  }

  public void addFirst(E element) {
    if (element == null)
      throw new NullPointerException();
    if (size == data.length-1)
      resize();
    if (size == 0) {
      data[0] = element;
      end++;
    }
    else if (start == 0) {
      data[data.length-1] = element;
      start = data.length-1;
    }
    else {
      data[start-1] = element;
      start--;
    }
    size++;
  }

  public void addLast(E element) {
    if (element == null)
      throw new NullPointerException();
    if (size == data.length-1)
      resize();
    if (end == data.length-1) {
      data[data.length-1] = element;
      end = 0;
    }
    else {
      data[end] = element;
      end++;
    }
    size++;
  }

  public E removeFirst() {
    if (size == 0)
      throw new NoSuchElementException();
    E temp = data[start];
    data[start] = null;
    if (start == data.length-1)
      start = 0;
    else start++;
    size--;
    return temp;
  }

  public E removeLast() {
    if (size == 0)
      throw new NoSuchElementException();
    E temp = data[end-1];
    if (end == 0) {
      temp = data[data.length];
      end = data.length;
    }
    else {
      data[end-1] = null;
      end--;
    }
    size--;
    return temp;
  }

  public E getFirst() {
    if (size == 0)
      throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (size == 0)
      throw new NoSuchElementException();
    if (end == 0)
      return data[data.length-1];
    else return data[end-1];

  }

  //from on here are methods that I've used for debugging
  /*
  public int start() {
    return start;
  }

  public int end() {
    return end;
  }

  public static void main(String[] args) {
    MyDeque deque = new MyDeque(10);
    System.out.println(deque);
    deque.addFirst(4);
    System.out.println(deque);
    System.out.println(deque.start());
    System.out.println(deque.end());
    deque.addFirst(3);
    System.out.println(deque);
    deque.addFirst(2);
    System.out.println(deque);
    deque.addFirst(1);
    System.out.println(deque);
    deque.addFirst(0);
    System.out.println(deque);
    deque.addLast(5);
    System.out.println(deque);
  }
  */

}
