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
      for (int i = start; i <= end; i++) {
        temp[i] = data[i+start];
      }
    }
    if (start > end) {
      int counter = 0;
      for (int i = start; i < data.length; i++) {
        temp[i] = data[i];
        counter++;
      }
      for (int i = 0; i <= end; i++) {
        temp[counter] = data[i];
        counter++;
      }
    }
    start = 0;
    end = size-1;
    data = temp;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String result = "{";
    if (start < end) {
      for (int i = start; i <= end; i++) {
        result += data[i] + " ";
      }
    }
    if (start > end) {
      for (int i = start; i < data.length; i++) {
        result += data[i] + " ";
      }
      for (int i = 0; i <= end; i++) {
        result += data[i] + " ";
      }
    }
    result += "}";
    return result;
  }

  public void addFirst(E element) {
    if (element == null)
      throw new NullPointerException();
    if (size == data.length)
      resize();
    if (size == 0) {
      data[0] = element;
      end++;
    }
    else if (start == 0) {
      data[data.length-1] = element;
      start = data.length-1;
    }
    else if (start != 0) {
      data[start-1] = element;
      start--;
    }
    size++;
  }

  public void addLast(E element) {
    if (element == null)
      throw new NullPointerException();
    if (size == data.length)
      resize();
    if (end = data.length-1) {
      data[0] = element;
      end = 0;
    }
    else {
      data[end+1] = element;
      end++;
    }
    size++;
  }

  public E removeFirst() {
    if (data[start] == null)
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
    if (data[end] == null)
      throw new NoSuchElementException();
    E temp = data[end];
    data[end] = null;
    if (end == 0)
      end = data.length-1;
    else end--;
    size--;
    return temp;
  }

  public E getFirst() {
    if (data[start] == null)
      throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (data[end] == null)
      throw new NoSuchElementException();
    return data[end];
  }

}
