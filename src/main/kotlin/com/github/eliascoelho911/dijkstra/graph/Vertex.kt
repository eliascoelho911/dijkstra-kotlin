package com.github.eliascoelho911.dijkstra.graph

data class Vertex(
    val start: Node,
    val end: Node,
    val weight: Double
) {
    fun containsAny(nodes: Collection<Node>): Boolean {
        nodes.forEach { nodeOfGraph ->
            if (start == nodeOfGraph || end == nodeOfGraph)
                return true
        }

        return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vertex

        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + end.hashCode()
        return result
    }

}
