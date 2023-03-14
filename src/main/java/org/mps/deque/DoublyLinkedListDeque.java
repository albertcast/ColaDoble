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
    		throw new DoubleEndedQueueException("Se han intentado eliminar un elemento de una cola vac�a");
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
    		throw new DoubleEndedQueueException("Se han intentado eliminar un elemento de una cola vac�a");
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
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("El indice buscado no est� contenido en la lista (indice < 0 o indice > tama�o de la lista. Index = " + index);
		}

		int i = 0;
		DequeNode<T> aux = first;
		while(i < index){
			aux = first.getNext();
			i++;
		}



		return aux.getItem();
	}

	@Override
	public boolean contains(T value) {
		return false;
	}

	@Override
	public void remove(T value) {

	}

	@Override
	public void sort(Comparator<? super T> comparator) {
		DequeNode<T> auxFirst = first;
		for(int i = 0; i < size; i++){
			DequeNode<T> auxSecond = auxFirst.getNext();
			if(auxSecond != null) {
				for (int j = i; j < size; j++) {
					if (comparator.compare(auxFirst.getItem(), auxSecond.getItem()) > 0) {
						T placeholder = auxFirst.getItem();
						auxFirst.setItem(auxSecond.getItem());
						auxSecond.setItem(placeholder);
					}
				}
				auxFirst = first.getNext();
			}
		}
	}
}
