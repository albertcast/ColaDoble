package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class DoublyLinkedListDequeTest {

	/*
	 * @author Alberto Castillo Sanchez
	 *
	 * Trabajando con lista vacia:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()
	 * 		metodo contains() -> false;
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
	 * 	Trabajando con lista (3, 6, 8, 2, 1, 3, 10 , 24):
	 *
	 * 		metodo contains(3) -> True (Primer elemento)
	 * 		metodo contains(2) -> True (Elemento intermedio)
	 * 		metodo contains(24) -> True (Ultimo elemento)
	 * 		metodo contains(142) -> False (Elemento no en la cola)
	 *
	 * 		metodo remove(3) -> (6, 8, 2, 1, 3, 10, 24)
	 * 		metodo remove(8) -> contains(8) = false
	 * 		metodo remove(24) -> contains(24) = false
	 * 		metodo remove(124)-> Exception.
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
		@Test
		@DisplayName("Buscar elemento da negativo")
		void listaVaciaContieneElemento(){
			assertFalse(dlld.contains(3));
		}

		@Test
		@DisplayName("Eliminar elemento en lista vacia da error apropiado")
		void listaVaciaEliminarElemento(){
			assertThrows(DoubleEndedQueueException.class, () -> dlld.remove(1),"Error, cannot remove an element from an empty queue" );
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
		@Test
		void listaUnElementoEliminarElementoDaListaVacia(){
			dlld.remove(2);
			assertNull(dlld.first());
			assertNull(dlld.last());

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

	@Nested
	@DisplayName("Lista con elementos (3, 6, 8, 2, 1, 3, 10 , 24)")
		class pruebaListaConMuchosElementos{
		DoubleEndedQueue<Integer> dlld;
		@BeforeEach
		void setup(){
			dlld = new DoublyLinkedListDeque<Integer>();
			dlld.append(3);
			dlld.append(6);
			dlld.append(8);
			dlld.append(2);
			dlld.append(1);
			dlld.append(3);
			dlld.append(10);
			dlld.append(24);
		}

		@AfterEach
		void fin(){
			dlld = null;
		}
		@Test
		@DisplayName("primer elemento de la lista")
		void TestContainsTrue(){
			assertTrue(dlld.contains(3));
			assertTrue(dlld.contains(2));
			assertTrue(dlld.contains(24));
		}
		@Test
		@DisplayName("Elemento no en la lista ")
		void TestNoContainsElement(){
			assertFalse(dlld.contains(142));
		}

		@Test
		@DisplayName("Quitar elemento repetido elimina solo el primero")
		void TestEliminarElementoRepetido(){
			DoubleEndedQueue<Integer> expectedValue = new DoublyLinkedListDeque<>();
			expectedValue.append(6);
			expectedValue.append(8);
			expectedValue.append(2);
			expectedValue.append(1);
			expectedValue.append(3);
			expectedValue.append(10);
			expectedValue.append(24);
			DoubleEndedQueue<Integer> actualValue = dlld;
			actualValue.remove(3);
			assertTrue(expectedValue.equals(actualValue));
		}

		@Test
		@DisplayName("Quitar elementos de la lista no repetidos")
		void TestEliminarElementosNoRepetidos(){
			dlld.remove(8);
			assertFalse(dlld.contains(8));
		}

		@Test
		@DisplayName("Quitar el ultimo elemento de la lista")
		void TestEliminarUltimoElemento(){
			dlld.remove(24);
			assertFalse(dlld.contains(24));
		}

		@Test
		@DisplayName("Quitar Elemento No En La Lista Salta Error")
		void TestEliminarElementoNoEnLaLista(){
			assertThrows(DoubleEndedQueueException.class, () -> dlld.remove(124));
		}
	}



}
