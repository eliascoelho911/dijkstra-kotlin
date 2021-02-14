package com.github.eliascoelho911.dijkstra.graph

import com.github.eliascoelho911.dijkstra.exception.NodeNotFoundException
import kotlin.Double.Companion.MAX_VALUE

class Graph {
    private val nodes = mutableSetOf<Node>()
    private val vertices = mutableSetOf<Vertex>()

    fun addNode(name: String): Node {
        val distanceStart = 0.0.takeIf { nodes.size == 0 } ?: MAX_VALUE
        val newNode = Node(name = name, distanceStart = distanceStart)
        nodes.add(newNode)
        return newNode
    }

    fun addVertex(n1: Node, n2: Node, weight: Double) {
        val vertex = Vertex(n1, n2, weight)

        if (vertex.containsAny(nodes))
            vertices.add(vertex)
        else
            throw NodeNotFoundException()
    }

    fun contains(node: Node): Boolean =
        nodes.contains(node)

    fun findVertices(reference: Node): Set<Vertex> =
        vertices.mapNotNull { vertex ->
            vertex.takeIf { it.n1 == reference }
        }.toSet()

    fun findOpenLower(): Node? =
        nodes.filter { it.isOpen }.minByOrNull { it.distanceStart }

    fun hasOpenNode(): Boolean =
        nodes.any { it.isOpen }
}