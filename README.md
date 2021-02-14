# Dijkstra's algorithm
Algorithm in <b>Kotlin</b> for to calculate a shortest route the a graph with Dijktra's algorithm.
<h4> 🚀 Concluded </h4>

### 🎲 Hot to use?
- First, create a graph:
```kotlin
  val graph = Graph()
```
- Then add all nodes in the graph:
```kotlin
  val a = graph.addNode("A")
  val b = graph.addNode("B")
  val c = graph.addNode("C")
  val d = graph.addNode("D")
  val e = graph.addNode("E")
  val f = graph.addNode("F")
  val g = graph.addNode("G")
  val h = graph.addNode("H")
  val i = graph.addNode("I")
```
- Now make all the connections:
```kotlin
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
```
- Finally, calculate the shortest path using the "shortestRoute" method of the Dijkstra class, inserting the start and end node as an argument:
```kotlin
  val dijkstra = Dijkstra(graph)
  val route: Route = dijkstra.shortestRoute(a, i)
```
### 🛠 Language
- [Kotlin](https://kotlinlang.org/)

