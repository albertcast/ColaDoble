package org.mps.deque;

import java.util.Comparator;

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

	@Override
	public T get(int index) {
		return null;
	}


	@Override
	public boolean contains(T value) {
		if(first!=null) {
			return contains(first, value);
		}else{
			return false;
		}
	}
	private boolean contains(DequeNode node, T value){
		if(node.getItem().equals(value)){
			return true;
		}else if(node.getNext()!=null){
			return contains(node.getNext(),value);
		}else{
			return false;
		}


	}
	@Override
	public void remove(T value) {
		remove(value, first);
	}
	private void remove(T value, DequeNode node){
		if(node!=null) {
			if (node.getItem().equals(value)) {
				if (node.getPrevious() != null) {
					node.getPrevious().setNext(node.getNext());
				}
				if (node.getNext() != null) {
					node.getNext().setPrevious(node.getPrevious());
				}
				node.setPrevious(null);
				node.setNext(null);
				node.setItem(null);

			} else if (node.getNext() != null) {
				remove(value, node.getNext());
			} else {
				throw new DoubleEndedQueueException("Error, There is no such element in the queue");
			}
		}else{
			throw new DoubleEndedQueueException("Error, cannot remove an element from an empty queue");
		}
	}
	@Override
	public void sort(Comparator<? super T> comparator) {

	}
}
