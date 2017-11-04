/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
/**
 *
 * @author jcd4912
 * @param <AnyType>
 */
public class BinaryHeap<AnyType extends Comparable> extends PriorityQueue{
    private AnyType[] heap;
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize; // Number of elements in heap
 
public BinaryHeap()
{
   currentSize = 0;
   heap = (AnyType[]) new Comparable[DEFAULT_CAPACITY];
}
public BinaryHeap(int capacity)
{
    currentSize = 0;
    heap = (AnyType[])new Object[capacity + 1];
    Arrays.fill(heap, -1);
}

public BinaryHeap( AnyType [ ] items ){
    currentSize = items.length;
    heap = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

    int i = 1;
    for( AnyType item : items )
        heap[ i++ ] = item;
    buildHeap();
}

private void buildHeap( ){
    for( int i = currentSize / 2; i > 0; i-- )
        percolateDown( i );
}
public void insert( AnyType x )
{
    if( currentSize == heap.length - 1 )
        enlargeArray( heap.length * 2 + 1 );
    // Percolate up
    int hole = ++currentSize;
    for( heap[ 0 ] = x; x.compareTo( heap[ hole / 2 ] ) < 0; hole /= 2 )
        heap[ hole ] = heap[ hole / 2 ];
    heap[ hole ] = x;
}

public AnyType findMin( )
{
    if (isEmpty() )
        throw new NoSuchElementException("Underflow Exception");           
    return heap[0];
}

public AnyType deleteMin( )
{
    if (currentSize == 0) throw new RuntimeException();

    AnyType minItem = findMin( );
    heap[ 1 ] = heap[ currentSize-- ];
    percolateDown( 1 );

    return minItem;
}

private void percolateDown( int hole )
{
    int child;
    AnyType tmp = heap[hole];

    for( ; hole * 2 <= currentSize; hole = child )
    {
        child = hole * 2;
        if( child != currentSize && heap[ child + 1 ].compareTo( heap[ child ])<0)
            child++;
        if( heap[ child ].compareTo( tmp ) < 0 )
            heap[ hole ] = heap[ child ];
        else
            break;
    }
    heap[ hole ] = tmp;
}
public boolean isEmpty() {
    return currentSize == 0;
}
public void makeEmpty() {
    currentSize = 0;
}

public AnyType[] enlargeArray(int newSize) {
    return Arrays.copyOf(heap, newSize);
}

@Override
public String toString()
   {
      String out = "";
      for(int k = 1; k <= currentSize; k++) out += heap[k]+" ";
      return out;
   }
}
