internal class AllOne {
  var root: Node = Node()
  var nodes: Map<String, Node> = HashMap()

  init {
    root.next = root
    root.prev = root
  }

  fun inc(key: String) {
    if (!nodes.containsKey(key)) {
      if (root.next === root || root.next.cnt > 1) {
        nodes.put(key, root.insert(Node(key, 1)))
      } else {
        root.next.keys.add(key)
        nodes.put(key, root.next)
      }
    } else {
      val curr = nodes[key]!!
      val next = curr.next
      if (next === root || next.cnt > curr.cnt + 1) {
        nodes.put(key, curr.insert(Node(key, curr.cnt + 1)))
      } else {
        next.keys.add(key)
        nodes.put(key, next)
      }
      curr.keys.remove(key)
      if (curr.keys.isEmpty()) {
        curr.remove()
      }
    }
  }

  fun dec(key: String) {
    val curr = nodes[key]!!
    if (curr.cnt == 1) {
      nodes.remove(key)
    } else {
      val prev = curr.prev
      if (prev === root || prev.cnt < curr.cnt - 1) {
        nodes.put(key, prev.insert(Node(key, curr.cnt - 1)))
      } else {
        prev.keys.add(key)
        nodes.put(key, prev)
      }
    }

    curr.keys.remove(key)
    if (curr.keys.isEmpty()) {
      curr.remove()
    }
  }

  val maxKey: String
    get() = root.prev.keys.iterator().next()

  val minKey: String
    get() = root.next.keys.iterator().next()
}

internal open class Node @kotlin.jvm.JvmOverloads constructor(key: String? = "", var cnt: Int = 0) {
  var prev: Node? = null
  var next: Node? = null
  var keys: Set<String> = HashSet()

  init {
    keys.add(key)
  }

  fun insert(node: Node): Node {
    node.prev = this
    node.next = this.next
    node.prev!!.next = node
    node.next!!.prev = node
    return node
  }

  fun remove() {
    prev!!.next = this.next
    next!!.prev = this.prev
  }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
