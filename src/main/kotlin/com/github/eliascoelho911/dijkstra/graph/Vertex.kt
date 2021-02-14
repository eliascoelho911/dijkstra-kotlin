package com.github.eliascoelho911.dijkstra.graph

data class Vertex(
    val n1: Node,
    val n2: Node,
    val weight: Double
) {
    fun containsAny(nodes: Collection<Node>): Boolean {
        nodes.forEach { nodeOfGraph ->
            if (n1 == nodeOfGraph || n2 == nodeOfGraph)
                return true
        }

        return false
    }
}
