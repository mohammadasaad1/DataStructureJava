package CloneArrayList;
public abstract class AbstractArrayList <T>
{      // now we must to implement all these methods .
    public abstract boolean isFull() ;

    public abstract boolean isEmpty() ;

    public abstract boolean isValidIdx(int idx) ;

    public abstract void printArrayList() ;

    public abstract void add (T element) ;

    public abstract void addByIndex (int idx , T element) throws IllegalAccessException;

    public abstract void set (int idx , T element) throws IllegalAccessException;


    public abstract void clearIt () ;

    public abstract T Get (int idx) ;

    public abstract int indexOf (T element) ;

    public abstract int lastIndexOf (T element) ;

    public abstract T remove (int idx) ;

    public abstract T [] removeRange (int statIdx , int endIdx) ;

    public abstract T[] subArray (int statIdx , int endIdx) ;

    public abstract T[] toArray() ;

    public abstract boolean contains(T element) ;

}
