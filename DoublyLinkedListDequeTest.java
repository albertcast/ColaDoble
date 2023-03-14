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
			void listaVaciaGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			void listaVaciaGetValidIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(0));
			}

			@Test
			void listaVaciaGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			void listaVaciaContains(){

			}

			@Test
			void listaVaciaRemove(){

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
			void listaUnElementoGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			void listaUnElementoGetValidIndex(){
				assertEquals(2, dlld.get(0));
			}

			@Test
			void listaUnElementoGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(101));
			}

			@Test
			void listaUnElementoContains(){

			}

			@Test
			void listaUnElementoRemove() {

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
			void listaDosElementosGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			void listaDosElementosGetMinimumValidIndex(){
				assertEquals(3, dlld.get(0));
			}

			@Test
			void listaDosElementosGetMaximumValidIndex(){
				assertEquals(2, dlld.get(1));
			}

			@Test
			void listaDosElementosGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			void listaDosElementosContains(){

			}

			@Test
			void listaDosElementosRemove(){

			}

			@Test
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
			void listaTresElementosGet(){

			}

			@Test
			void listaTresElementosGetNegativeIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			void listaTresElementosGetMinimumValidIndex(){
				assertEquals(3, dlld.get(0));
			}

			@Test
			void listaTresElementosGetNormalValidIndex(){
				assertEquals(2, dlld.get(1));
			}

			@Test
			void listaTresElementosGetMaximumValidIndex(){
				assertEquals(1, dlld.get(2));
			}

			@Test
			void listaTresElementosGetBigIndex(){
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			void listaTresElementosContains(){

			}

			@Test
			void listaTresElementosRemove(){

			}

			@Test
			void listaTresElementosSort(){
				dlld.sort(integerComparator);
				assertEquals(1, dlld.first());
				assertEquals(2, dlld.get(1));
				assertEquals(3, dlld.last());
			}


		}



	}





}
