import java.util.AbstractList;


/** A class that implements a doubly linked list 
 * 
 * @author DeepIdris
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) 
			throw new NullPointerException();
		
		LLNode<E> newNode = new LLNode<E>(element);
		//If list is empty
		if (this.size == 0) {
			head.next = newNode;
			tail.prev = newNode;
			newNode.prev = head;
			newNode.next = tail;
			size = size +1;
		}
		else {
			LLNode<E> prevNode = tail.prev;
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = tail;
			tail.prev = newNode;
			size = size +1;
		}
		return true;		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= this.size || index < 0) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element.equals(null)) 
			throw new NullPointerException();
		
		if (index > size || index < 0) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		
		LLNode<E> prevNode = currentNode.prev;
		newNode.prev = prevNode;
		newNode.next = currentNode;
		prevNode.next = newNode;
		currentNode.prev = newNode;
		size = size +1;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		E data = currentNode.data;
		LLNode<E> nextNode = currentNode.next;
		LLNode<E> prevNode = currentNode.prev;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size =  size -1;
		
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if (element.equals(null)) 
			throw new NullPointerException();
		
		if (index > size || index < 0) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> currentNode = head.next;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		E oldValue = currentNode.data;
		currentNode.data = element;
		
		return oldValue;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}


}
