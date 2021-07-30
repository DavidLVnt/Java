/**
 * 
 */
package support;

/**
 * @author congd
 *
 */
public class SLNode<T> {
	
	private T data;
	private SLNode<T> nextNode;
	
	/**
	 * @param data
	 */
	public SLNode(T data) {		
		this.data = data;
		this.nextNode = null;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the nextNode
	 */
	public SLNode<T> getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(SLNode<T> nextNode) {
		this.nextNode = nextNode;
	}	

}
