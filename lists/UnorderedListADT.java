/**
 * 
 */
package lists;

/**
 * @author perla
 *
 */
public interface UnorderedListADT<T> extends ListADT<T> {
	
	public void addToFront(T element);
	public void addToRear(T element);
	public void addAfter(T existingElement, T element);

}
