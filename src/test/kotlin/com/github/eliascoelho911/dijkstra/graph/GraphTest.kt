package com.github.eliascoelho911.dijkstra.graph

import org.junit.Assert.*
import org.junit.Test

class GraphTest {
    private val graph = Graph()

    @Test
    fun mustFindNodeWithLowerDistanceStart() {
        graph.addNode("0").apply { distanceStart = 25.0 }
        val lower = graph.addNode("1").apply { distanceStart = 20.0 }
        assertEquals(lower, graph.findOpenLower())
    }

    @Test
    fun mustFindAllVerticesOfTheNode() {
        val n1 = graph.addNode("0")
        val n2 = graph.addNode("1")
        val n3 = graph.addNode("2")
        graph.addVertex(n1, n2, 3.0)
        graph.addVertex(n1, n3, 3.0)
        graph.addVertex(n2, n3, 3.0)
        assertEquals(setOf(Vertex(n1, n2, 3.0), Vertex(n1, n3, 3.0)), graph.findVertices(n1))
    }

    @Test
    fun mustToReturnTrueWhenHaveOpenNode() {
        graph.addNode("a")
        assertTrue(graph.hasOpenNode())
    }

    @Test
    fun mustToReturnFalseWhenDontHaveOpenNode() {
        graph.addNode("a").apply { close() }
        assertFalse(graph.hasOpenNode())
    }
}