package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorImplementation<T> implements Iterator<T> {
	Node<T> nextNode;
	
	public IteratorImplementation(Node<T> head) {
		nextNode = head;
	}
	
	public T next() throws NoSuchElementException {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		Node<T> tmpNode = nextNode;
		nextNode = nextNode.getNext();
		return tmpNode.getData();
	}
	
	public boolean hasNext() {
		if (nextNode != null) {
			return true;
		}
		return false;
	}
}