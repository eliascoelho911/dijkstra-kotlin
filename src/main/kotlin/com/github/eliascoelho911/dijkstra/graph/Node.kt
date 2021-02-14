package com.github.eliascoelho911.dijkstra.graph

data class Node(
    val name: String,
    var lastNode: Node? = null,
    var distanceStart: Double = Double.MAX_VALUE,
    var isOpen: Boolean = true
) {
    fun close() {
        isOpen = false
    }

    fun tryChangeDistanceStart(openLower: Node, vertex: Vertex) {
        val newDistanceStart = openLower.distanceStart + vertex.weight
        if (newDistanceStart < this.distanceStart) {
            this.distanceStart = newDistanceStart
            this.lastNode = openLower
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}
