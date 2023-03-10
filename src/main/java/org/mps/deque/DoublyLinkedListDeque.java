package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

	private DequeNode<T> first;
	private DequeNode<T> last;
	private int size;

	public DoublyLinkedListDeque() {
		first = null;
		last = null;
		size = 0;
	}

	public void prepend(T value) {
		if(size == 0) {
			DequeNode<T> aux = new DequeNode<T>(value, null, null);
			first = aux;
			last = aux;
			size++;
		} else {
			DequeNode<T> aux = new DequeNode<T>(value, null, first);
			first.setPrevious(first);
			first = aux;
			size++;
		}
	}

	public void append(T value) {
		if(size == 0) {
			DequeNode<T> aux = new DequeNode<T>(value, null, null);
			first = aux;
			last = aux;
			size++;
		} else {
			DequeNode<T> aux = new DequeNode<T>(value, last, null);
			last.setNext(aux);
			last = aux;
			size++;
		}
	}

	public void deleteFirst() {
		if(size > 1) {
			first = first.getNext();
			size--;
		} else if (size == 1) {
			first = null;
			last = null;
			size--;
		} else {
			throw new DoubleEndedQueueException("Se han intentado eliminar un elemento de una cola vacía");
		}
	}

	public void deleteLast() {
		if(size > 1) {
			last = last.getPrevious();
			size--;
		} else if (size == 1) {
			first = null;
			last = null;
			size--;
		} else {
			throw new DoubleEndedQueueException("Se han intentado eliminar un elemento de una cola vacía");
		}
	}

	public T first() {
		if(first != null) {
			return first.getItem();
		} else {
			return null;
		}
	}

	public T last() {
		if(last != null) {
			return last.getItem();
		} else {
			return null;
		}
	}

	public int size() {
		return size;
	}
}