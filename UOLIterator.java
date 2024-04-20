import java.util.NoSuchElementException;
// Class representing an iterator for a uniquely ordered list.
public class UOLIterator<T> implements CopyableIterator<T> {

    // This instance variable points to the next item that is returned by the iterator.
    private LinearNode<T> curr;

    // A constructor class that initiates the node to the current node.
    public UOLIterator(LinearNode<T> node) { this.curr = node; }

    // A hasNext method that returns a boolean to determine if there are unvisited
    // elements in the list.
    public boolean hasNext() { return curr != null; }

    // A next method that returns an element of type T, which is the next
    // unvisited element in the list.
    public T next() {
        // If there isn't a next element then we throw a NoSuchElementException.
        if (!hasNext()) { throw new NoSuchElementException("iterator empty"); }
        // Retrieving the current data and moving to the next node.
        T result = curr.getData();
        curr = curr.getNext();
        return result;
    }

    // Returns a new UOIListIterator object that points to the same current node as this iterator.
    public CopyableIterator<T> copy() { return new UOLIterator<>(curr); }

}
