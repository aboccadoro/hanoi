package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T> {
	private Node<T> head = null;
	private Node<T> tail = new Node<T>(null, null);
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int n) throws NoSuchElementException {
		if (n < 0 || n >= size()) {
			throw new NoSuchElementException();
		}
		int count = 0;
		T type = null;
		Iterator<T> iter = this.iterator();
		while (iter.hasNext()) {
			if (count == n) {
				type = iter.next();
				break;
			}
			iter.next();
			count++;
		}
		return type;
	}
	
	public ListInterface<T> append(T elem) {
		if (elem == null) {
			throw new NullPointerException();
		}
		else if (head == null) {
			head = new Node<T>(elem, null);
			tail = head;
			size++;
		}
		else if (tail != null) {
			Node<T> node = new Node<T>(elem, null);
			tail.setNext(node);
			tail = node;
			size++;
		}
		return this;
	}

	public Iterator<T> iterator() {
		return new IteratorImplementation<T>(head);
	}
}