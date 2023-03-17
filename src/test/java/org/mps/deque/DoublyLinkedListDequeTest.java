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
	 * @author Alberto Castillo Sanchez
	 * @author Nikita Kulyukin Goryunov
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
	 *
	 * =================================================================================================
	 * =================================================================================================
	 *
	 * Pruebas segunda practica:
	 * 		Trabajando con lista vacia:
	 * 			metodo get()
	 * 			metodo sort()
	 *
	 *		Trabajando con lista de un elemento:
	 * 			metodo get()
	 * 			metodo sort()
	 *
	 * 		Trabajando con lista de dos elementos:
	 * 			metodo get()
	 * 			metodo sort()
	 *
	 * 		Trabajando con lista de tres elementos:
	 * 			metodo get()
	 * 			metodo sort()
	 *
	 *
	 *
	 *Trabajando con lista (3, 6, 8, 2, 1, 3, 10 , 24):
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
	@DisplayName("Pruebas primera practica")
	class pruebasPrimeraPractica {
		@Nested
		@DisplayName("Pruebas para listas con 0 elementos")
		class pruebasListasVacias {

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
		class pruebasListasUnElemento {

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
		class pruebasListasDosElementos {

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
		class pruebasListasTresElementos {

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
	class pruebasSegundaPractica {

		class Comparer implements Comparator<Integer> {

			public Comparer() {
			}

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}

		@Nested
		@DisplayName("Pruebas con lista vacia")
		class pruebasListasVacias {
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
			void listaVaciaGetNegativeIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista vacia con indice entre 0 y su tamano")
			void listaVaciaGetValidIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista vacia con indice mayor que su tamano")
			void listaVaciaGetBigIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			@DisplayName("Metodo Contains de la lista vacia")
			void listaVaciaContains() {
				assertFalse(dlld.contains(3));
			}

			@Test
			@DisplayName("Metodo Remove de la lista vacia")
			void listaVaciaRemove() {
				assertThrows(DoubleEndedQueueException.class, () -> dlld.remove(3));
			}

			@Test
			@DisplayName("Metodo Sort de la lista vacia")
			void listaVaciaElementosSort() {
				dlld.sort(integerComparator);
				assertNull(dlld.first());
				assertNull(dlld.last());
			}
		}

		@Nested
		@DisplayName("Pruebas con lista de un elemento")
		class pruebasListasUnElemento {
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
			void listaUnElementoGetNegativeIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 1 elemento e indice entre 0 y su tamano")
			void listaUnElementoGetValidIndex() {
				assertEquals(2, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 1 elemento y indice mayor que su tamano")
			void listaUnElementoGetBigIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(101));
			}

			@Test
			@DisplayName("Metodo Remove de la lista con 1 elemento")
			void listaUnElementoRemove() {
				dlld.remove(2);
				assertNull(dlld.first());
				assertNull(dlld.last());
			}

			@Test
			@DisplayName("Metodo Sort de la lista con 1 elemento")
			void listaUnElementoSort() {
				dlld.sort(integerComparator);
				assertEquals(2, dlld.first());
				assertEquals(2, dlld.last());
			}

		}

		@Nested
		@DisplayName("Pruebas con lista de dos elementos")
		class pruebasListasDosElementos {
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
			void listaDosElementosGetNegativeIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice entre 0")
			void listaDosElementosGetMinimumValidIndex() {
				assertEquals(3, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice indicando el ultimo elemento de la lista")
			void listaDosElementosGetMaximumValidIndex() {
				assertEquals(2, dlld.get(1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 2 elementos e indice mayor que su tamano")
			void listaDosElementosGetBigIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(341));
			}

			@Test
			@DisplayName("Metodo Sort de la lista con 2 elementos")
			void listaDosElementosSort() {
				dlld.sort(integerComparator);
				assertEquals(2, dlld.first());
				assertEquals(3, dlld.last());
			}


		}

		@Nested
		@DisplayName("Pruebas con lista de tres elementos")
		class pruebasListasTresElementos {
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
			void listaTresElementosGetNegativeIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(-1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice 0")
			void listaTresElementosGetMinimumValidIndex() {
				assertEquals(3, dlld.get(0));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice entre 0 y su tamano")
			void listaTresElementosGetNormalValidIndex() {
				assertEquals(2, dlld.get(1));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice indicando al ultimo elemento de la lista")
			void listaTresElementosGetMaximumValidIndex() {
				assertEquals(1, dlld.get(2));
			}

			@Test
			@DisplayName("Metodo Get de la lista con 3 elementos e indice mayor que su tamano")
			void listaTresElementosGetBigIndex() {
				assertThrows(IndexOutOfBoundsException.class, () -> dlld.get(110));
			}

			@Test
			@DisplayName("Metodo Sort de la lista con 3 elementos")
			void listaTresElementosSort() {
				dlld.sort(integerComparator);
				assertEquals(1, dlld.first());
				assertEquals(2, dlld.get(1));
				assertEquals(3, dlld.last());
			}
		}

		@Nested
		@DisplayName("Lista con elementos (3, 6, 8, 2, 1, 3, 10 , 24)")
		class pruebaListaConMuchosElementos {
			DoubleEndedQueue<Integer> dlld;

			@BeforeEach
			void setup() {
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
			void fin() {
				dlld = null;
			}

			@Test
			@DisplayName("Primer, ultimo e intermedio de la lista da true")
			void TestContainsTrue() {
				assertTrue(dlld.contains(3));
				assertTrue(dlld.contains(2));
				assertTrue(dlld.contains(24));
			}

			@Test
			@DisplayName("Elemento no en la lista da false")
			void TestNoContainsElement() {
				assertFalse(dlld.contains(142));
			}

			@Test
			@DisplayName("Quitar elemento repetido elimina solo el primero")
			void TestEliminarElementoRepetido() {
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
			void TestEliminarElementosNoRepetidos() {
				dlld.remove(8);
				assertFalse(dlld.contains(8));
			}

			@Test
			@DisplayName("Quitar el ultimo elemento de la lista")
			void TestEliminarUltimoElemento() {
				dlld.remove(24);
				assertFalse(dlld.contains(24));
			}

			@Test
			@DisplayName("Quitar Elemento No En La Lista Salta Error")
			void TestEliminarElementoNoEnLaLista() {
				assertThrows(DoubleEndedQueueException.class, () -> dlld.remove(124));
			}

			@Test
			@DisplayName("Equals de dos listas distintas da false")
			void DosListasDistintasDaFalse() {
				DoubleEndedQueue<Integer> expectedValue = new DoublyLinkedListDeque<>();
				expectedValue.append(2);
				expectedValue.append(4);

				assertFalse(expectedValue.equals(dlld));
			}
		}
			@Nested
			@DisplayName("Pruebas con lista de muchos elementos")
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
				void listaMuchosElementosSort() {
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
