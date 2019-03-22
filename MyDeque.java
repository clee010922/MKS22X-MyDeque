import java.util.*;
public class MyDeque<E> {

  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public void resize(){
    E[] temp = (E[])new Object[data.length * 2];
    if (start < end) {
      for (int i = start; i <= end; i++) {
        temp[i] = data[i];
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
    data = temp;
  }

  public int size(){
    return size;
  }

  public String toString(){
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

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length)
      resize();
    //add
    size++;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length)
      resize();
    //add
    size++;
  }

  public E removeFirst(){
    if (data[start] == null)
      throw new NoSuchElementException();
    E temp = data[start];
    data[start] = null;
    //set start to new index
    size--;
    return temp;
  }

  public E removeLast(){
    if (data[end] == null)
      throw new NoSuchElementException();
    E temp = data[end];
    data[end] = null;
    //set end to new index
    size--;
    return temp;
  }

  public E getFirst(){
    if (data[start] == null)
      throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if (data[end] == null)
      throw new NoSuchElementException();
    return data[end];
  }

}
