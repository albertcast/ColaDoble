package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class DoublyLinkedListDequeTest {

	/*
	 * Autor: Alberto Castillo Sanchez
	 *
	 * Prueba primera practica:
	 * Trabajando con lista vacia:
	 * 		metodo First()
	 * 		metodo Last()
	 * 		metodo size()
	 * 		metodo DeleteFirst()
	 * 		metodo DeleteLast()
	 * 		metodo append()
	 * 		metodo prepend()
	 *		metodo contains() -> DoubleEndedQueueException();
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
	 * =================================================================================================
	 * =================================================================================================
	 *
	 * Pruebas segunda practica:
	 * 		Trabajando con lista vacia:
	 * 			metodo get()
	 * 			metodo contains()
	 * 			metodo remove()
	 * 			metodo sort()
	 *
	 *		Trabajando con lista de un elemento:
	 * 			metodo get()
	 * 			metodo contains()
	 * 			metodo remove()
	 * 			metodo sort()
	 *
	 * 		Trabajando con lista de dos elementos:
	 * 			metodo get()
	 * 			metodo contains()
	 * 			metodo remove()
	 * 			metodo sort()
	 *
	 * 		Trabajando con lista de tres elementos:
	 * 			metodo get()
	 * 			metodo contains()
	 * 			metodo remove()
	 * 			metodo sort()
	 *
	 *
	 *
	 *
	 * Trabajando con lista de elementos: (3, 2, 4, 8, 3, 10):
	 * 		metodo contains(3) -> True (Primer elemento)
	 * 		metodo contains(8) -> True (Elemento intermedio)
	 * 		metodo contains(10) -> True (Ultimo elemnento)
	 * 		metodo contains(24) -> False (Elemento no en la lista)
	 *
	 */
	@Nested
	@DisplayName("Pruebas primera practica")
	class pruebasPrimeraPractica{
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
			@DisplayName("Metodo First de la lista vacia")
			void listaVaciaFirst() {
				assertNull(dlld.first());
			}

			@Test
			@DisplayName("Metodo Last de la lista vacia")
			void listaVaciaLast() {
				assertNull(dlld.last());
			}

			@Test
			@DisplayName("Metodo Size de la lista vacia")
			void listaVaciaSize() {
				int expectedResult = 0;
				assertEquals(expectedResult, dlld.size());
			}

			@Test
			@DisplayName("Metodo deleteFirst de la lista vacia")
			void listaVaciaBorrarPrimero() {
				assertThrows(DoubleEndedQueueException.class, () -> dlld.deleteFirst());
			}

			@Test
			@DisplayName("Metodo deleteLast de la lista vacia")
			void listaVaciaBorrarUltimo() {
				assertThrows(DoubleEndedQueueException.class, () -> dlld.deleteLast());
			}

			@Test
			@DisplayName("Metodo append de la lista vacia")
			void listaVaciaAnadirAlFinal() {
				dlld.append(2);
				assertEquals(2, dlld.last());
				assertEquals(2, dlld.first());
				assertEquals(1, dlld.size());
			}

			@Test
			@DisplayName("Metodo prepend de la lista vacia")
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
			@DisplayName("Metodo First de la lista con 1 elemento")
			void listaUnElementoFirst() {
				assertEquals(2, dlld.first());
			}

			@Test
			@DisplayName("Metodo Last de la lista con 1 elemento")
			void listaUnElementoLast() {
				assertEquals(2, dlld.last());
			}

			@Test
			@DisplayName("Metodo Size de la lista con 1 elemento")
			void listaUnElementoSize() {
				assertEquals(1, dlld.size());
			}

			@Test
			@DisplayName("Metodo DeleteFirst de la lista con 1 elemento")
			void listaUnElementoBorrarPrimero() {
				dlld.deleteFirst();
				assertNull(dlld.first());
				assertNull(dlld.last());
				assertEquals(0, dlld.size());
			}

			@Test
			@DisplayName("Metodo DeleteLast de la lista con 1 elemento")
			void listaUnElementoBorrarUltimo() {
				dlld.deleteLast();
				assertNull(dlld.first());
				assertNull(dlld.last());
				assertEquals(0, dlld.size());
			}

			@Test
			@DisplayName("Metodo Append de la lista con 1 elemento")
			void listaUnElementoAnadirAlFinal() {
				dlld.append(3);
				assertEquals(2, dlld.first());
				assertEquals(3, dlld.last());
				assertEquals(2, dlld.size());
			}

			@Test
			@DisplayName("Metodo Prepend de la lista con 1 elemento")
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
			@DisplayName("Metodo First de la lista con 2 elementos")
			void listaDosElementosFirst() {
				assertEquals(2, dlld.first());
			}

			@Test
			@DisplayName("Metodo Last de la lista con 2 elementos")
			void listaDosElementosLast() {
				assertEquals(3, dlld.last());
			}

			@Test
			@DisplayName("Metodo Size de la lista con 2 elementos")
			void listaDosElementosSize() {
				assertEquals(2, dlld.size());
			}

			@Test
			@DisplayName("Metodo DeleteFirst de la lista con 2 elementos")
			void listaDosElementosDeleteFirst() {
				dlld.deleteFirst();
				assertEquals(3, dlld.first());
				assertEquals(3, dlld.last());
				assertEquals(1, dlld.size());

			}

			@Test
			@DisplayName("Metodo DeleteLast de la lista con 2 elementos")
			void listaDosElementosDeleteLast() {
				dlld.deleteLast();
				assertEquals(2, dlld.first());
				assertEquals(2, dlld.last());
				assertEquals(1, dlld.size());
			}

			@Test
			@DisplayName("Metodo Append de la lista con 2 elementos")
			void listaDosElementosAnadirAlFinal() {
				dlld.append(4);
				assertEquals(2, dlld.first());
				assertEquals(4, dlld.last());
				assertEquals(3, dlld.size());
			}

			@Test
			@DisplayName("Metodo Prepend de la lista con 2 elementos")
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
			@DisplayName("Metodo First de la lista con 3 elementos")
			void listaTresElementosFirst() {
				assertEquals(1, dlld.first());
			}

			@Test
			@DisplayName("Metodo Last de la lista con 3 elementos")
			void listaTresElementosLast() {
				assertEquals(3, dlld.last());
			}

			@Test
			@DisplayName("Metodo Size de la lista con 3 elementos")
			void listaTresElementosSize() {
				assertEquals(3, dlld.size());
			}

			@Test
			@DisplayName("Metodo DeleteFirst de la lista con 3 elementos")
			void listaTresElementosDeleteFirst() {
				dlld.deleteFirst();
				assertEquals(2, dlld.first());
				assertEquals(3, dlld.last());
				assertEquals(2, dlld.size());

			}

			@Test
			@DisplayName("Metodo DeleteLast de la lista con 3 elementos")
			void listaTresElementosDeleteLast() {
				dlld.deleteLast();
				assertEquals(1, dlld.first());
				assertEquals(2, dlld.last());
				assertEquals(2, dlld.size());
			}

			@Test
			@DisplayName("Metodo Append de la lista con 3 elementos")
			void listaTresElementosAnadirAlFinal() {
				dlld.append(4);
				assertEquals(1, dlld.first());
				assertEquals(4, dlld.last());
				assertEquals(4, dlld.size());
			}

			@Test
			@DisplayName("Metodo Prepend de la lista con 3 elementos")
			void listaTresElementosAnadirAlPrincipio() {
				dlld.prepend(0);
				assertEquals(0, dlld.first());
				assertEquals(3, dlld.last());
				assertEquals(4, dlld.size());
			}
		}
	}

	@Nested
	@DisplayName("Pruebas segunda practica")
	class pruebasSegundaPractica{

		class Comparer implements Comparator<Integer>{

			public Comparer(){}
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}

		@Nested
		@DisplayName("Pruebas con lista vacia")
		class pruebasListasVacias{
			private DoublyLinkedListDeque<Integer> dlld;
			Comparator<Integer> integerComparator;
			@BeforeEach
			void Comienzo() {

				dlld = new DoublyLinkedListDeque<Integer>();
				integerComparator = new Comparer();
			}

			@AfterEach
			void Fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Metodo Get de la lista vacia con indice negativo")
			void listaVaciaGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista vacia con indice entre 0 y su tamano")
			void listaVaciaGetValidIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista vacia con indice mayor que su tamano")
			void listaVaciaGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			@DisplayName("Metodo Contains de la lista vacia")
			void listaVaciaContains(){
				assertThrows(DoubleEndedQueueException.class, ()-> dlld.contains(3));
			}

			@Test
			@DisplayName("Metodo Remove de la lista vacia")
			void listaVaciaRemove(){

			}

			@Test
			@DisplayName("Metodo Sort de la lista vacia")
			void listaVaciaElementosSort(){
				dlld.sort(integerComparator);
				assertNull(dlld.first());
				assertNull(dlld.last());
			}
		}
		@Nested
		@DisplayName("Pruebas con lista de un elemento")
		class pruebasListasUnElemento{
			private DoublyLinkedListDeque<Integer> dlld;
			Comparator<Integer> integerComparator;
			@BeforeEach
			void Comienzo() {
				dlld = new DoublyLinkedListDeque<Integer>();
				dlld.append(2);
				integerComparator = new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				};
			}
			@AfterEach
			void Fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Metodo Get de la lista con 1 elemento e indice negativo")
			void listaUnElementoGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 1 elemento e indice entre 0 y su tamano")
			void listaUnElementoGetValidIndex(){
				assertEquals(2, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 1 elemento y indice mayor que su tamano")
			void listaUnElementoGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(101));
			}

			@Test
			@DisplayName("Metodo Contains de la lista con 1 elemento")
			void listaUnElementoContains(){

			}

			@Test
			@DisplayName("Metodo Remove de la lista con 1 elemento")
			void listaUnElementoRemove() {

			}

			@Test
			@DisplayName("Metodo Sort de la lista con 1 elemento")
			void listaUnElementoSort(){
				dlld.sort(integerComparator);
				assertEquals(2, dlld.first());
				assertEquals(2, dlld.last());
			}

		}

		@Nested
		@DisplayName("Pruebas con lista de dos elementos")
		class pruebasListasDosElementos{
			private DoublyLinkedListDeque<Integer> dlld;
			Comparator<Integer> integerComparator;
			@BeforeEach
			void Comienzo() {
				dlld = new DoublyLinkedListDeque<Integer>();
				dlld.append(3);
				dlld.append(2);
				integerComparator = new Comparer();
			}

			@AfterEach
			void Fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice negativo")
			void listaDosElementosGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice entre 0")
			void listaDosElementosGetMinimumValidIndex(){
				assertEquals(3, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice indicando el ultimo elemento de la lista")
			void listaDosElementosGetMaximumValidIndex(){
				assertEquals(2, dlld.get(1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice mayor que su tamano")
			void listaDosElementosGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(341));
			}

			@Test
			@DisplayName("Metodo Contains de la lista con 2 elementos")
			void listaDosElementosContains(){

			}

			@Test
			@DisplayName("Metodo Remove de la lista con 2 elementos")
			void listaDosElementosRemove(){

			}

			@Test
			@DisplayName("Metodo Sort de la lista con 2 elementos")
			void listaDosElementosSort(){
				dlld.sort(integerComparator);
				assertEquals(2, dlld.first());
				assertEquals(3, dlld.last());
			}


		}

		@Nested
		@DisplayName("Pruebas con lista de tres elementos")
		class pruebasListasTresElementos{
			private DoublyLinkedListDeque<Integer> dlld;
			Comparator<Integer> integerComparator;
			@BeforeEach
			void Comienzo() {
				dlld = new DoublyLinkedListDeque<Integer>();
				dlld.append(2);
				dlld.append(1);
				dlld.prepend(3);
				integerComparator = new Comparer();
			}
			@AfterEach
			void Fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice negativo")
			void listaTresElementosGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice 0")
			void listaTresElementosGetMinimumValidIndex(){
				assertEquals(3, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice entre 0 y su tamano")
			void listaTresElementosGetNormalValidIndex(){
				assertEquals(2, dlld.get(1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice indicando al ultimo elemento de la lista")
			void listaTresElementosGetMaximumValidIndex(){
				assertEquals(1, dlld.get(2));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice mayor que su tamano")
			void listaTresElementosGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			@DisplayName("Metodo Contains de la lista con 3 elementos")
			void listaTresElementosContains(){

			}

			@Test
			@DisplayName("Metodo Remove de la lista con 3 elementos")
			void listaTresElementosRemove(){

			}

			@Test
			@DisplayName("Metodo Sort de la lista con 3 elementos")
			void listaTresElementosSort(){
				dlld.sort(integerComparator);
				assertEquals(1, dlld.first());
				assertEquals(2, dlld.get(1));
				assertEquals(3, dlld.last());
			}


		}

		@Nested
		@DisplayName("Pruebas con lista de tres elementos")
		class pruebasListasMuchosElementos {
			private DoublyLinkedListDeque<Integer> dlld;
			Comparator<Integer> integerComparator;
			@BeforeEach
			void Comienzo() {
				dlld = new DoublyLinkedListDeque<Integer>();
				dlld.append(2);
				dlld.append(1);
				dlld.prepend(3);
				dlld.append(23);
				dlld.append(13);
				dlld.append(43);
				dlld.append(25);
				dlld.prepend(4);
				dlld.prepend(15);
				dlld.prepend(12);
				integerComparator = new Comparer();
			}
			@AfterEach
			void Fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Metodo Sort de la lista con muchos elementos")
			void listaMuchosElementosSort(){
				dlld.sort(integerComparator);
				assertEquals(1, dlld.first());
				assertEquals(2, dlld.get(1));
				assertEquals(3, dlld.get(2));
				assertEquals(4, dlld.get(3));
				assertEquals(12, dlld.get(4));
				assertEquals(13, dlld.get(5));
				assertEquals(15, dlld.get(6));
				assertEquals(23, dlld.get(7));
				assertEquals(25, dlld.get(8));
				assertEquals(43, dlld.last());
			}
		}
	}
}
