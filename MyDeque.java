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

  public int size(){
    return size;
  }

  public String toString(){
    String result = "{";
    for (int i = 0; i < size; i++) {
      result += data[i] + " ";
    }
    result += "}";
    return result;
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    E temp = data[start];
    //remove
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    //remove
    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

}
