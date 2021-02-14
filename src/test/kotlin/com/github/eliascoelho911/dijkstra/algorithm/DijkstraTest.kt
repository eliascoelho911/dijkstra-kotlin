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
    fun mustToCalculateShortestRoute() {
        val a = graph.addNode("A")
        val b = graph.addNode("B")
        val c = graph.addNode("C")
        val d = graph.addNode("D")
        val e = graph.addNode("E")
        val f = graph.addNode("F")
        val g = graph.addNode("G")
        val h = graph.addNode("H")
        val i = graph.addNode("I")

        graph.apply {
            addVertex(a, b, 1.0)
            addVertex(a, c, 10.0)
            addVertex(a, d, 5.0)
            addVertex(b, c, 10.0)
            addVertex(b, e, 8.0)
            addVertex(b, f, 4.0)
            addVertex(c, d, 1.0)
            addVertex(c, f, 4.0)
            addVertex(d, g, 1.0)
            addVertex(e, f, 10.0)
            addVertex(e, h, 20.0)
            addVertex(f, h, 5.0)
            addVertex(f, i, 10.0)
            addVertex(f, g, 1.0)
            addVertex(g, i, 30.0)
            addVertex(h, i, 6.0)
        }
        assertEquals(Route(a, i, listOf(a, b, f, i), 15.0), dijkstra.shortestRoute(a, i))
    }
}