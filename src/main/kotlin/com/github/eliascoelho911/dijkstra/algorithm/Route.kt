package com.github.eliascoelho911.dijkstra.algorithm

import com.github.eliascoelho911.dijkstra.graph.Node

data class Route(
    val start: Node,
    val end: Node,
    val allNodes: List<Node>,
    val distance: Double
)