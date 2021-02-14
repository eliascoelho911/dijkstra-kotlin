package com.github.eliascoelho911.dijkstra.algorithm

import com.github.eliascoelho911.dijkstra.exception.NodeNotFoundException
import com.github.eliascoelho911.dijkstra.graph.Graph
import com.github.eliascoelho911.dijkstra.graph.Node

class Dijkstra(private val graph: Graph) {
    fun shortestRoute(start: Node, end: Node): Route {
        if (!graph.contains(start) || !graph.contains(end))
            throw NodeNotFoundException()

        while (graph.hasOpenNode()) {
            val openLower: Node? = graph.findOpenLower()
            openLower?.let {
                openLower.close()
                val vertices = graph.findVertices(openLower)
                vertices.forEach { vertexOfOpenLower ->
                    val adjacentNode = vertexOfOpenLower.end
                    adjacentNode.tryChangeDistanceStart(openLower, vertexOfOpenLower)
                }
            }
        }

        return Route(start, end, findAllNodes(end), end.distanceStart)
    }

    private fun findAllNodes(
        end: Node
    ): MutableList<Node> {
        val allNodes = mutableListOf<Node>()
        var next: Node? = end
        while (next != null) {
            allNodes.add(next)
            next = next.lastNode
        }
        allNodes.sortBy { it.distanceStart }
        return allNodes
    }
}