internal class Skiplist {
  private val head = Node(-1, MAX_LEVEL)
  private var level = 0

  fun search(target: Int): Boolean {
    var curr = head
    for (i in level - 1 downTo 0) {
      curr = findClosest(curr, i, target)
      if (curr.next[i] != null && curr.next[i].`val` == target) {
        return true
      }
    }
    return false
  }

  fun add(num: Int) {
    var curr = head
    val lv = randomLevel()
    val node = Node(num, lv)
    level = max(level, lv)
    for (i in level - 1 downTo 0) {
      curr = findClosest(curr, i, num)
      if (i < lv) {
        node.next[i] = curr.next[i]
        curr.next[i] = node
      }
    }
  }

  fun erase(num: Int): Boolean {
    var curr = head
    var ok = false
    for (i in level - 1 downTo 0) {
      curr = findClosest(curr, i, num)
      if (curr.next[i] != null && curr.next[i].`val` == num) {
        curr.next[i] = curr.next[i].next[i]
        ok = true
      }
    }
    while (level > 1 && head.next[level - 1] == null) {
      --level
    }
    return ok
  }

  private fun findClosest(curr: Node, level: Int, target: Int): Node {
    var curr = curr
    while (curr.next[level] != null && curr.next[level].`val` < target) {
      curr = curr.next[level]
    }
    return curr
  }

  internal class Node(var `val`: Int, level: Int) {
    var next: Array<Node> = arrayOfNulls(level)
  }

  companion object {
    private const val MAX_LEVEL = 32
    private const val P = 0.25
    private val RANDOM: Random = Random()
    private fun randomLevel(): Int {
      var level = 1
      while (level < MAX_LEVEL && RANDOM.nextDouble() < P) {
        ++level
      }
      return level
    }
  }
}
/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
