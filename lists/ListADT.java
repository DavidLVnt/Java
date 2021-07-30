/**
 * 
 */
package lists;

/**
 * @author perla
 *
 */
public interface ListADT<T> extends Iterable<T> {
	
	/**
	 * @return generic T element 
	 */
	public T removeFirst();
	
	/**
	 * @return T, the last element in the list
	 */
	public T removeLast();
	
	/**
	 * @param element, element to remove from list
	 * @return T, the element removed
	 * Throw ElementNotFoundException
	 */
	public T remove(T element);
	
	public T first();
	public T last();
	public boolean contains(T element);
	public boolean isEmpty();
	public int size();
	public String toString();
	
	

}
