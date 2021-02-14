package com.github.eliascoelho911.dijkstra.graph

import com.github.eliascoelho911.dijkstra.exception.NodeAlreadyAddedInTheGraph
import com.github.eliascoelho911.dijkstra.exception.NodeNotFoundException
import com.github.eliascoelho911.dijkstra.exception.NodesAlreadyConnectedException
import kotlin.Double.Companion.MAX_VALUE

class Graph {
    private val nodes = mutableSetOf<Node>()
    private val vertices = mutableSetOf<Vertex>()

    fun addNode(name: String): Node {
        val distanceStart = 0.0.takeIf { nodes.size == 0 } ?: MAX_VALUE
        val newNode = Node(name = name, distanceStart = distanceStart)

        errorIfNodeAlreadyAddedInTheGraph(newNode)

        nodes.add(newNode)
        return newNode
    }

    private fun errorIfNodeAlreadyAddedInTheGraph(newNode: Node) {
        if (nodes.contains(newNode))
            throw NodeAlreadyAddedInTheGraph()
    }

    fun addVertex(start: Node, end: Node, weight: Double) {
        val vertex = Vertex(start, end, weight)
        errorIfNodesAlreadyConnected(vertex)

        if (vertex.containsAny(nodes))
            vertices.add(vertex)
        else
            throw NodeNotFoundException()
    }

    private fun errorIfNodesAlreadyConnected(vertex: Vertex) {
        if (vertices.contains(vertex))
            throw NodesAlreadyConnectedException()
    }

    fun contains(node: Node): Boolean =
        nodes.contains(node)

    fun findVertices(reference: Node): Set<Vertex> =
        vertices.mapNotNull { vertex ->
            vertex.takeIf { it.start == reference }
        }.toSet()

    fun findOpenLower(): Node? =
        nodes.filter { it.isOpen }.minByOrNull { it.distanceStart }

    fun hasOpenNode(): Boolean =
        nodes.any { it.isOpen }
}