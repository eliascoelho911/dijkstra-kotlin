package com.github.eliascoelho911.dijkstra.graph

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VertexTest {
    @Test
    fun mustToFindNodeInVertexWhenHeIsPresent() {
        val a = Node("A")
        val b = Node("B")
        val vertex = Vertex(a, b, 2.0)
        assertTrue(vertex.containsAny(listOf(a)))
    }

    @Test
    fun mustNotToFindNodeInVertexWhenHeIsNotPresent() {
        val a = Node("A")
        val b = Node("B")
        val vertex = Vertex(a, b, 2.0)
        assertFalse(vertex.containsAny(listOf(Node("s"))))
    }
}