package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class DoublyLinkedListDequeTest {

	/*
	 * Autor: Alberto Castillo Sanchez
	 *
	 * Trabajando con lista vacia:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()
	 * 
	 * Trabajando con lista de un solo elemento:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()
	 * 
	 * Trabajando con lista de dos elementos:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()		
	 * 
	 * Trabajando con lista de 3 elementos:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()
	 * 
	 */
	
	@Nested
	@DisplayName("Pruebas para listas con 0 elementos")
	class pruebasListasVacias{
	
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
		void listaVaciaAnadirAlFinal() {
			dlld.append(2);
			assertEquals(2, dlld.last());
			assertEquals(2, dlld.first());
			assertEquals(1, dlld.size());
		}
		
		@Test
		void listaVaciaAnadirAlPrincipio() {
			dlld.prepend(2);
			assertEquals(2, dlld.last());
			assertEquals(2, dlld.first());
			assertEquals(1, dlld.size());
		}
	}
	
	@Nested
	@DisplayName("Pruebas para listas con 1 elemento")
	class pruebasListasUnElemento{
	
		private DoublyLinkedListDeque<Integer> dlld;
		
		@BeforeEach
		void Comienzo() {
			dlld = new DoublyLinkedListDeque<Integer>();
			dlld.append(2);
		}
		
		@AfterEach
		void Fin() {
			dlld = null;
		}
	
		@Test
		void listaUnElementoFirst() {
			assertEquals(2, dlld.first());
		}
	
		@Test
		void listaUnElementoLast() {
			assertEquals(2, dlld.last());
		}
	
		@Test
		void listaUnElementoSize() {
			assertEquals(1, dlld.size());
		}
	
		@Test
		void listaUnElementoBorrarPrimero() {
			dlld.deleteFirst();
			assertNull(dlld.first());
			assertNull(dlld.last());
			assertEquals(0, dlld.size());
		}
	
		@Test
		void listaUnElementoBorrarUltimo() {
			dlld.deleteLast();
			assertNull(dlld.first());
			assertNull(dlld.last());
			assertEquals(0, dlld.size());
		}
	
		@Test
		void listaUnElementoAnadirAlFinal() {
			dlld.append(3);
			assertEquals(2, dlld.first());
			assertEquals(3, dlld.last());
			assertEquals(2, dlld.size());
		}
		
		@Test
		void listaUnElementoAnadirAlPrincipio() {
			dlld.prepend(3);
			assertEquals(3, dlld.first());
			assertEquals(2, dlld.last());
			assertEquals(2, dlld.size());
		}
	}
	
	
	@Nested
	@DisplayName("Pruebas para listas con 2 elementos")
	class pruebasListasDosElementos{
	
		private DoublyLinkedListDeque<Integer> dlld;
		
		@BeforeEach
		void Comienzo() {
			dlld = new DoublyLinkedListDeque<Integer>();
			dlld.append(2);
			dlld.append(3);
		}
		
		@AfterEach
		void Fin() {
			dlld = null;
		}
		@Test	
		void listaDosElementosFirst() {
			assertEquals(2, dlld.first());
		}
	
		@Test	
		void listaDosElementosLast() {	
			assertEquals(3, dlld.last());
		}
	
		@Test	
		void listaDosElementosSize() {
			assertEquals(2, dlld.size());
		}
	
		@Test	
		void listaDosElementosDeleteFirst() {
			dlld.deleteFirst();
			assertEquals(3, dlld.first());
			assertEquals(3, dlld.last());
			assertEquals(1, dlld.size());
		
		}
	
		@Test
		void listaDosElementosDeleteLast() {
			dlld.deleteLast();
			assertEquals(2, dlld.first());
			assertEquals(2, dlld.last());
			assertEquals(1, dlld.size());
		}
	
		@Test
		void listaDosElementosAnadirAlFinal() {	
			dlld.append(4);
			assertEquals(2, dlld.first());
			assertEquals(4, dlld.last());
			assertEquals(3, dlld.size());
		}
	
		@Test
		void listaDosElementosAnadirAlPrincipio() {
			dlld.prepend(1);
			assertEquals(1, dlld.first());
			assertEquals(3, dlld.last());
			assertEquals(3, dlld.size());
		}
	}
	
	@Nested
	@DisplayName("Pruebas para listas con 3 elementos")
	class pruebasListasTresElementos{
	
		private DoublyLinkedListDeque<Integer> dlld;
		
		@BeforeEach
		void Comienzo() {
			dlld = new DoublyLinkedListDeque<Integer>();
			dlld.append(2);
			dlld.append(3);
			dlld.prepend(1);
		}
		
		@AfterEach
		void Fin() {
			dlld = null;
		}
	
		@Test	
		void listaTresElementosFirst() {	
			assertEquals(1, dlld.first());
		}
	
		@Test	
		void listaTresElementosLast() {
			assertEquals(3, dlld.last());
		}
	
		@Test	
		void listaTresElementosSize() {	
			assertEquals(3, dlld.size());
		}
	
		@Test	
		void listaTresElementosDeleteFirst() {
			dlld.deleteFirst();
			assertEquals(2, dlld.first());
			assertEquals(3, dlld.last());
			assertEquals(2, dlld.size());
		
		}
	
		@Test
		void listaTresElementosDeleteLast() {
			dlld.deleteLast();
			assertEquals(1, dlld.first());
			assertEquals(2, dlld.last());
			assertEquals(2, dlld.size());
		}
	
		@Test
		void listaTresElementosAnadirAlFinal() {	
			dlld.append(4);
			assertEquals(1, dlld.first());
			assertEquals(4, dlld.last());
			assertEquals(4, dlld.size());
		}
	
		@Test
		void listaTresElementosAnadirAlPrincipio() {
			dlld.prepend(0);
			assertEquals(0, dlld.first());
			assertEquals(3, dlld.last());
			assertEquals(4, dlld.size());
		}	
	}


}
