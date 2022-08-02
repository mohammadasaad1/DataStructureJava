package CloneArrayList;

public class ClonedArrayList <T> extends AbstractArrayList <T>{
  private T arr[] ; // there is array.length
  private int size ;
  public ClonedArrayList(){
      // constructor1
      arr = (T[]) new Object[10];
  }
    public ClonedArrayList(int InitialCapacity){
        // constructor2
        arr = (T[]) new Object[InitialCapacity];
    }

    public int getSize () {
        return size;
    }

    @Override
    public boolean isFull () {
      // check if the arr full or not .
        return ( size == arr.length ) ;
    }

    @Override
    public boolean isEmpty () {
        return ( size == 0 ) ;
    }

    @Override
    public boolean isValidIdx ( int idx ) {
        return !(idx < 0 || idx > size) ;
    }

    private void ensureCapacity () {
    if( isFull() )
    {
        T[] newArray = (T[]) new Object [ arr.length * 2 + 1 ] ;
        for(int i = 0 ; i < size ; i++)
        {
            newArray [i] = arr[i] ;
        }
        arr = newArray ;
    }
    }

    @Override
    public void printArrayList () {
       for(int i = 0 ; i < size ; i++)
        System.out.print(arr[i] + " ");
    }

    @Override
    public void add ( T element ) {
        ensureCapacity();
        arr[size++] = element ;
    }

    @Override
    public void addByIndex ( int idx, T element ) throws IllegalAccessException {
        ensureCapacity();
        if(! isValidIdx(idx))
            throw new IllegalAccessException() ;
      else {
          // it doesn't matter if u don't put else statement
            for (int i = size; i >= idx; i--) {
                arr[i] = arr[i - 1];
            }
            arr[idx] = element;
            size++;
        }
    }


    @Override
    public void set ( int idx, T element ) throws IllegalAccessException {
        if(!isValidIdx(idx))
            throw new IllegalAccessException() ;
        arr[idx] = element ;
    }

    @Override
    public void clearIt () {
        size = 0 ;
    }

    @Override
    public T Get ( int idx ) {
        if(!isValidIdx(idx))
            throw new ArrayIndexOutOfBoundsException() ;
        return arr[idx] ;
    }

    @Override
    public int indexOf ( T element ) {
        int idx = -1 ;
        for(int i = 0 ; i < size ; i++)
            if(arr[i].equals(element)) {
                idx = i;
                break;
            }
        return idx ;
    }

    @Override
    public int lastIndexOf ( T element ) {
        int idx = -1 ;
        for(int i = size - 1 ; i >= 0 ; --i)
            if(arr[i].equals(element)) {
                idx = i;
                break;
            }
        return idx ;
    }

    @Override
    public T remove ( int idx ) {
        if(!isValidIdx(idx) & isEmpty()) // & >> to check both conditions
            throw new ArrayIndexOutOfBoundsException("out of bound or it's empty");
        T value = arr[idx] ;
        for(int i = idx ; i < size ; i++)
            arr[i] = arr[i + 1] ;
        size-- ;
        return value ;
   }

    @Override
    public T[] removeRange ( int statIdx, int endIdx ) {
      if (!isValidIdx(statIdx) & !isValidIdx(endIdx) & statIdx < endIdx)
          throw new IllegalStateException("Error!!!") ;
        T [] returnedArray =(T[]) new Object[endIdx - statIdx] ;
        for(int i = statIdx , j = 0 ; i <= endIdx; i++ , j++) {
            returnedArray[j] = arr[i];
            size--;
        }
        return returnedArray ;
    }

    @Override
    public T[] subArray ( int statIdx, int endIdx ) {
        if (!isValidIdx(statIdx) & !isValidIdx(endIdx) & statIdx < endIdx)
            throw new IllegalStateException("Error!!!") ;
        T [] returnedArray =(T[]) new Object[endIdx - statIdx] ;
        for(int i = statIdx , j = 0 ; i <= endIdx; i++ , j++) {
            returnedArray[j] = arr[i];
        }
        return returnedArray ;
    }

    @Override
    public T[] toArray () {
        T [] returnedArray =(T[]) new Object[size] ;
        for(int i = 0 ; i < size; i++) {
            returnedArray[i] = arr[i];
        }
        return returnedArray ;
    }

    @Override
    public boolean contains ( T element ) {
        for(int i = 0 ; i < size ; i++)
        {
            if(arr[i].equals(element))
                return true ;
        }
        return false ;
    }
}
