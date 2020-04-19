import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MyVector<E> extends MyAbstractList<E> {

    private E[] mylist;
    private int capIncrement=5;

    public MyVector(){
        mylist = (E[]) new Object[10];
    }

    public MyVector(int initialSize) {
        mylist = (E[]) new Object[initialSize];
    }

    public MyVector(int initialSize, int capValue) {
        mylist = (E[]) new Object[initialSize];
        capIncrement=capValue;
    }

    public int getCapacity() {
        return mylist.length;
    }

    public int getIncrement() {
        return capIncrement;
    }

    private void resize() {
        E[] secondlist = (E[]) new Object[getCapacity()+capIncrement];
        for (int i=0; i<mylist.length; i++) {
            secondlist[i]=mylist[i];
        }
        mylist=secondlist;
    }

    @Override
    public String toString() {
        Object[] temp=Arrays.stream(mylist).filter(Objects::nonNull).toArray();
        return Arrays.toString(temp);
    }

    @Override
    public boolean add(E data) {
        if(size>=getCapacity())
            resize();
        mylist[size++]=data;
        return true;
    }

    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if(size>=getCapacity())
            resize();
       for(int i=size; i>index; i--) {
        mylist[i]=mylist[i+1];
       }
           mylist[index] = data;
        size++;
        return true;
    }

    @Override
    public void clear() {
        mylist = (E[]) new Object[getCapacity()];
        size=0;
    }

    @Override
    public E get(int index) {
        return mylist[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        E item = mylist[index];
        for(int i=index; i<=size; i++) {
            mylist[i]=mylist[i+1];
        }
        size--;
        return item;
    }

    @Override
    public void trimToSize() {
        E[] secondlist = (E[]) new Object[size];
        for (int i=0; i<size; i++) {
            secondlist[i]=mylist[i];
        }
        mylist=secondlist;
    }
}
