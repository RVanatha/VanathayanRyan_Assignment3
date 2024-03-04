import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable{

	public int size;
	public Node<T> head;
	public Node<T> tail;
	
	public BasicDoubleLinkedList() {
		int size = 0;
		head = null;
		tail = null;
	}
	
	public void addToEnd​(T data) {
		
		Node temp = new Node(data);
		
		if(size == 0) {
			head = temp;
			tail = temp;
		}
		else {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		size ++;	
	}

	public void addToFront​(T data) {
		
		Node temp = new Node(data);
		
		if(size == 0) {
			head = temp;
			tail = temp;
		}
		else {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		size ++;	
	}

	public T getFirst() {
		
		if(size == 0)
			return null;
		
		else return head.data;
	}

	public T getLast() {
		
		if(size == 0)
			return null;
		else
			return tail.data;
	}

	public int getSize() {
		return size;
	}
	
	public BasicDoubleLinkedList<T>.Node<T> remove​(T targetData, Comparator<T> comparator) {
		
		Node <T> temp = head;
		int num;
		
		while(temp != null) {
				
			num = comparator.compare(targetData, temp.data);
				
			if(num == 0) {
				
				if(temp == head) {
					
					head = head.next;
					head.prev = null;
					size--;
					break;
					
				}
				else if(temp == tail) {
					
					tail = tail.prev;
					tail.next = null;
					size --;
					break;
				}
				else {
					
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					size--;
					break;
				}
				
			}	
				
			temp = temp.next;
			
		}
		
		return temp;
	}

	public T retrieveFirstElement() {
		
		if(size == 0)
			return null;
		
		else if(size == 1) {
			size --;
			return head.data;
		}
		
		T result = head.data;
		
		head = head.next;
		head.prev = null;
		
		size --;
		return result;
	}

	public T retrieveLastElement() {
		
		if(size == 0)
			return null;
		
		else if(size == 1) {
			size --;
			return tail.data;
		}
		
		T result = tail.data;
		
		tail = tail.prev;
		tail.next = null;
		
		size --;
		return result;
	}

	public ArrayList<T> toArrayList(){
		
		Node temp;
		temp = head;
		
		ArrayList<T> ar = new ArrayList<T>();
		
		while( temp != null) {
			
			ar.add((T) temp.data);
			temp = temp.next;
			
		}
		
		return ar;
	}
	
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	protected class Node<T>{
		
		protected T data;
		protected Node next;
		protected Node prev;
		
		public Node(T data) {
			this.data = data;
		}
		
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T>{

		protected Node itNode;		
		
		public DoubleLinkedListIterator() {
			itNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return itNode != null;
		}

		@Override
		public T next() {
			T result;
			
			if(hasNext()) {
				result = (T) itNode.data;
				itNode = itNode.next;
			}
			else
				throw new NoSuchElementException();
			
			return result;
		}

		@Override
		public boolean hasPrevious() {
			
			if(size == 0 || itNode == head)
				return false;
				
			return true;
		}
		
		@Override
		public T previous() {
			
			T result;
			
			if(hasPrevious()) {
				
				if(itNode == null)
					itNode = tail;
				else 
					itNode = itNode.prev;
				
			}
			else 
				throw new NoSuchElementException();
			
			result = (T) itNode.data;
			return result;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}



