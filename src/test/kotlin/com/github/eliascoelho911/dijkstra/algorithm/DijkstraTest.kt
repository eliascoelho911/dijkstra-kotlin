package com.github.eliascoelho911.dijkstra.algorithm

import com.github.eliascoelho911.dijkstra.exception.NodeNotFoundException
import com.github.eliascoelho911.dijkstra.graph.Graph
import com.github.eliascoelho911.dijkstra.graph.Node
import org.junit.Test
import kotlin.test.assertEquals

class DijkstraTest {
    private val graph = Graph()
    private val dijkstra = Dijkstra(graph)

    @Test(expected = NodeNotFoundException::class)
    fun mustThrowExceptionWhenStartNodeNotFoundInGraph() {
        val b = graph.addNode("B")
        dijkstra.shortestRoute(Node("A"), b)
    }

    @Test(expected = NodeNotFoundException::class)
    fun mustThrowExceptionWhenEndNodeNotFoundInGraph() {
        val b = graph.addNode("B")
        dijkstra.shortestRoute(b, Node("A"))
    }

    @Test
    fun mustToCalculateShortestRouteWhenAllVertexAreDirect() {
        val a = graph.addNode("A")
        val b = graph.addNode("B")
        val c = graph.addNode("C")
        val d = graph.addNode("D")
        val e = graph.addNode("E")
        val f = graph.addNode("F")
        val g = graph.addNode("G")

        graph.apply {
            addVertex(a, b, 3.0)
            addVertex(a, c, 1.0)
            addVertex(a, d, 7.0)
            addVertex(b, d, 1.0)
            addVertex(c, d, 3.0)
            addVertex(d, e, 3.0)
            addVertex(d, f, 5.0)
            addVertex(d, g, 7.0)
            addVertex(e, g, 3.0)
            addVertex(f, g, 3.0)
        }
        assertEquals(Route(a, g, listOf(a, c, d, e, g), 10.0), dijkstra.shortestRoute(a, g))
    }
}