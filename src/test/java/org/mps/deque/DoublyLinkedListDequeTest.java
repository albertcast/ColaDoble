package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DoublyLinkedListDequeTest {

	/*
	 * Trabajando con lista vacía:
	 * 		método First()
	 * 		método Last()
	 * 		método size()
	 * 		método DeleteFirst()
	 * 		método DeleteLast()
	 * 		método append()
	 * 		método prepend()
	 * 
	 * Trabajando con lista de un solo elemento:
	 * 		método First()
	 * 		método Last()
	 * 		método size()
	 * 		método DeleteFirst()
	 * 		método DeleteLast()
	 * 		método append()
	 * 		método prepend()
	 * 
	 * Trabajando con lista de dos elementos:
	 * 		método First()
	 * 		método Last()
	 * 		método size()
	 * 		método DeleteFirst()
	 * 		método DeleteLast()
	 * 		método append()
	 * 		método prepend()		
	 * 
	 * Trabajando con lista de 3 elementos:
	 * 		método First()
	 * 		método Last()
	 * 		método size()
	 * 		método DeleteFirst()
	 * 		método DeleteLast()
	 * 		método append()
	 * 		método prepend()
	 * 
	 */
	
	private DoublyLinkedListDeque<Integer> dlld;
	
	@BeforeEach
	void Comienzo() {
		dlld = new DoublyLinkedListDeque<Integer>();
	}
	
	@AfterEach
	void Fin() {
		dlld = null;
	}
	
	@Test
	void listaVaciaFirst() {
		assertNull(dlld.first());
	}
	
	@Test
	void listaVaciaLast() {
		assertNull(dlld.last());
	}
	
	@Test
	void listaVaciaSize() {
		int expectedResult = 0;
		assertEquals(expectedResult, dlld.size());
	}
	
	@Test
	void listaVaciaBorrarPrimero() {
		assertThrows(DoubleEndedQueueException.class, () -> dlld.deleteFirst());
	}
	
	@Test
	void listaVaciaBorrarUltimo() {
		assertThrows(DoubleEndedQueueException.class, () -> dlld.deleteLast());
	}
	
	@Test
	void listaVaciaAñadirAlFinal() {
		dlld.append(2);
		assertEquals(2, dlld.last());
		assertEquals(2, dlld.first());
		assertEquals(1, dlld.size());
	}
	
	@Test
	void listaVaciaAñadirAlPrincipio() {
		dlld.prepend(2);
		assertEquals(2, dlld.last());
		assertEquals(2, dlld.first());
		assertEquals(1, dlld.size());
	}
	
	@Test
	void listaUnElementoFirst() {
		dlld.append(2);
		assertEquals(2, dlld.first());
	}

	@Test
	void listaUnElementoLast() {
		dlld.append(2);	
		assertEquals(2, dlld.last());
	}

	@Test
	void listaUnElementoSize() {
		dlld.append(2);		
		assertEquals(1, dlld.size());
	}

	@Test
	void listaUnElementoBorrarPrimero() {
		dlld.append(2);		
		dlld.deleteFirst();
		assertNull(dlld.first());
		assertNull(dlld.last());
		assertEquals(0, dlld.size());
	}

	@Test
	void listaUnElementoBorrarUltimo() {
		dlld.append(2);		
		dlld.deleteLast();
		assertNull(dlld.first());
		assertNull(dlld.last());
		assertEquals(0, dlld.size());
	}

	@Test
	void listaUnElementoAñadirAlFinal() {
		dlld.append(2);	
		dlld.append(3);
		assertEquals(2, dlld.first());
		assertEquals(3, dlld.last());
		assertEquals(2, dlld.size());
	}
	
	@Test
	void listaUnElementoAñadirAlPrincipio() {
		dlld.append(2);		
		dlld.prepend(3);
		assertEquals(3, dlld.first());
		assertEquals(2, dlld.last());
		assertEquals(2, dlld.size());
	}

	@Test	
	void listaDosElementosFirst() {
		dlld.append(2);
		dlld.append(3);
		assertEquals(2, dlld.first());
	}

	@Test	
	void listaDosElementosLast() {
		dlld.append(2);
		dlld.append(3);		
		assertEquals(3, dlld.last());
	}

	@Test	
	void listaDosElementosSize() {
		dlld.append(2);
		dlld.append(3);	
		assertEquals(2, dlld.size());
	}

	@Test	
	void listaDosElementosDeleteFirst() {
		dlld.append(2);
		dlld.append(3);	
		dlld.deleteFirst();
		assertEquals(3, dlld.first());
		assertEquals(3, dlld.last());
		assertEquals(1, dlld.size());
	
	}

	@Test
	void listaDosElementosDeleteLast() {
		dlld.append(2);
		dlld.append(3);		
		dlld.deleteLast();
		assertEquals(2, dlld.first());
		assertEquals(2, dlld.last());
		assertEquals(1, dlld.size());
	}

	@Test
	void listaDosElementosAñadirAlFinal() {
		dlld.append(2);
		dlld.append(3);		
		dlld.append(4);
		assertEquals(2, dlld.first());
		assertEquals(4, dlld.last());
		assertEquals(3, dlld.size());
	}

	@Test
	void listaDosElementosAñadirAlPrincipio() {
		dlld.append(2);
		dlld.append(3);
		dlld.prepend(1);
		assertEquals(1, dlld.first());
		assertEquals(3, dlld.last());
		assertEquals(3, dlld.size());
	}
	
	@Test	
	void listaTresElementosFirst() {
		dlld.append(2);
		dlld.append(3);
		dlld.prepend(1);
		assertEquals(1, dlld.first());
	}

	@Test	
	void listaTresElementosLast() {
		dlld.append(2);
		dlld.append(3);		
		dlld.prepend(1);
		assertEquals(3, dlld.last());
	}

	@Test	
	void listaTresElementosSize() {
		dlld.append(2);
		dlld.append(3);		
		dlld.prepend(1);		
		assertEquals(3, dlld.size());
	}

	@Test	
	void listaTresElementosDeleteFirst() {
		dlld.append(2);
		dlld.append(3);	
		dlld.prepend(1);
		dlld.deleteFirst();
		assertEquals(2, dlld.first());
		assertEquals(3, dlld.last());
		assertEquals(2, dlld.size());
	
	}

	@Test
	void listaTresElementosDeleteLast() {
		dlld.append(2);
		dlld.append(3);		
		dlld.prepend(1);	
		dlld.deleteLast();
		assertEquals(1, dlld.first());
		assertEquals(2, dlld.last());
		assertEquals(2, dlld.size());
	}

	@Test
	void listaTresElementosAñadirAlFinal() {
		dlld.append(2);
		dlld.append(3);		
		dlld.prepend(1);	
		dlld.append(4);
		assertEquals(1, dlld.first());
		assertEquals(4, dlld.last());
		assertEquals(4, dlld.size());
	}

	@Test
	void listaTresElementosAñadirAlPrincipio() {
		dlld.append(2);
		dlld.append(3);
		dlld.prepend(1);
		dlld.prepend(0);
		assertEquals(0, dlld.first());
		assertEquals(3, dlld.last());
		assertEquals(4, dlld.size());
	}	
	


}
