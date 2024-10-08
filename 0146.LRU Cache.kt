internal open class Node {
  var key: Int = 0
  var `val`: Int = 0
  var prev: Node? = null
  var next: Node? = null

  constructor()

  constructor(key: Int, `val`: Int) {
    this.key = key
    this.`val` = `val`
  }
}

internal class LRUCache(private val capacity: Int) {
  private val cache: Map<Int, Node> = HashMap()
  private val head = Node()
  private val tail = Node()
  private var size = 0

  init {
    head.next = tail
    tail.prev = head
  }

  fun get(key: Int): Int {
    if (!cache.containsKey(key)) {
      return -1
    }
    val node = cache[key]!!
    moveToHead(node)
    return node.`val`
  }

  fun put(key: Int, value: Int) {
    if (cache.containsKey(key)) {
      val node = cache[key]!!
      node.`val` = value
      moveToHead(node)
    } else {
      var node = Node(key, value)
      cache.put(key, node)
      addToHead(node)
      ++size
      if (size > capacity) {
        node = removeTail()
        cache.remove(node.key)
        --size
      }
    }
  }

  private fun moveToHead(node: Node) {
    removeNode(node)
    addToHead(node)
  }

  private fun removeNode(node: Node) {
    node.prev!!.next = node.next
    node.next!!.prev = node.prev
  }

  private fun addToHead(node: Node) {
    node.next = head.next
    node.prev = head
    head.next = node
    node.next!!.prev = node
  }

  private fun removeTail(): Node {
    val node = tail.prev
    removeNode(node!!)
    return node
  }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
