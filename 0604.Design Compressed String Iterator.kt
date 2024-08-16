internal class StringIterator(compressedString: String) {
  private val d: List<Node> = ArrayList()
  private var p = 0

  init {
    val n = compressedString.length
    var i = 0
    while (i < n) {
      val c = compressedString[i]
      var x = 0
      while (++i < n && Character.isDigit(compressedString[i])) {
        x = x * 10 + (compressedString[i].code - '0'.code)
      }
      d.add(Node(c.code, x))
    }
  }

  fun next(): Char {
    if (!hasNext()) {
      return ' '
    }
    val ans = d[p].c
    if (--d[p].x === 0) {
      ++p
    }
    return ans
  }

  fun hasNext(): Boolean {
    return p < d.size() && d[p].x > 0
  }
}

internal open class Node(@kotlin.jvm.JvmField var c: Char, @kotlin.jvm.JvmField var x: Int)
/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
