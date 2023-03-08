package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Usando como item un entero
 *
 * Tests para probar el funcionamiento de la clase DequeNode con las siguientes pruebas:
 *  Para nodo Vacio:
 *      Test1: nodo previous -> null
 *      Test2: nodo next -> null
 *      Test3: isFirst -> true
 *      Test4:  isLast -> true
 *      Test5:  isNotTerminal -> False
 *  para nodo con Previous = node(4, null, null):
 *       Test1: nodo previous -> node (4, null, null)
 *       Test2: nodo next -> null
 *       Test3: isFirst -> false
 *       Test4:  isLast -> true
 *       Test5:  isNotTerminal -> false
 *
 *  Para nodo con next = node (6, null, null)
 *      Test1: nodo previous -> null
 *      Test2: nodo next -> node(6, null, null)
 *      Test3: isFirst -> true
 *      Test4:  isLast -> false
 *      Test5:  isNotTerminal -> false
 *
 *  Para nodo con next = (4, null, null) y previous = node(6, 0, 0)
 *      Test1: nodo previous -> node (4, null, null)
 *      Test2: nodo next -> node(6, null, null)
 *      Test3: isFirst -> false
 *      Test4:  isLast -> false
 *      Test5:  isNotTerminal -> true
 */


class DequeNodeTest {
    DequeNode<Integer> node = null;
    @BeforeEach
    void setup() {
        node = new DequeNode<Integer>(0, null, null);
    }
    @Nested
    @DisplayName("Test para nodo singular")
    class SingularNode {
    	
    	
        @Test
        @DisplayName("Test previous es null")
        void testPreviousSingleNode() {
            assertNull(node.getPrevious());
        }

        @Test
        @DisplayName("Test next es null")
        void testNextSingleNode() {
            assertNull(node.getNext());
        }

        @Test
        @DisplayName("Test isFirst es True")
        void testIsFirstSingleNode() {
            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("Test isLast es True")
        void testIsLastSingleNode() {
            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("Test isNotTerminal es False")
        void testIsNotTerminalSingleNode() {
            assertFalse(node.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("Test para nodo con Previous")
    class NodeWithPrevious{
        DequeNode<Integer> previous;
        @BeforeEach
        void setup(){
            previous = new DequeNode<>(4, null, null);
            node.setPrevious(previous);
        }

        @Test
        @DisplayName("Test previous es node(4, null, null)")
        void testPreviousNode () {
            DequeNode<Integer> expectedNode = previous;
            DequeNode<Integer> actualNode = node.getPrevious();
            assertEquals(expectedNode, actualNode);

        }
        @Test
        @DisplayName("Test next es null")
        void testNextSingleNode () {
            assertNull(node.getNext());
        }
        @Test
        @DisplayName("Test isFirst es False")
        void testIsFirstSingleNode () {
            assertFalse(node.isFirstNode());
        }
        @Test
        @DisplayName("Test isLast es True")
        void testIsLastSingleNode () {
            assertTrue(node.isLastNode());
        }
        @Test
        @DisplayName("Test isNotTerminal es False")
        void testIsNotTerminalSingleNode () {
            assertFalse(node.isNotATerminalNode());
        }

    }
}