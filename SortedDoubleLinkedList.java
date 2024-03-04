import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		
		comparator = compareableObject;
	}
	
	public void add​(T data) {
		
		Node newNode = new Node<T>(data);
		Node<T> temp;
		temp = head;
		int num = 0;
		
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;	
		}
		
		else {
	
			while (temp != null) {
				
				num = comparator.compare(data, temp.data);
				
				if (num < 0) {
					
					newNode.prev = temp.prev;
				
					newNode.next = temp;
					
					if (newNode.prev == null)
						head = newNode;
					
					else
						newNode.prev.next = newNode;
					
					temp.prev = newNode;
					size++;
					
					return;
				}
				
				temp = temp.next;
			}
	
			Node<T> endNode = new Node<T>(data);
			endNode.next = null;
			endNode.prev = tail;
			tail.next = endNode;
			tail = endNode;
			size++;
		}
	}
	
	public void addToEnd​(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	public void addToFront​(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	public ListIterator<T> iterator(){
		return super.iterator();
	}

	public BasicDoubleLinkedList.Node remove​(T data, Comparator<T> comparator){
		return super.remove​(data, comparator);
	}

	
	
	
}