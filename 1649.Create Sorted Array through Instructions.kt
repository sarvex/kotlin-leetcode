internal class BinaryIndexedTree(private val n: Int) {
  private val c = IntArray(n + 1)

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] += v
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun createSortedArray(instructions: IntArray): Int {
    var m = 0
    for (x in instructions) {
      m = max(m, x)
    }
    val tree = BinaryIndexedTree(m)
    var ans = 0
    val mod = 1e9.toInt() + 7
    for (i in instructions.indices) {
      val x = instructions[i]
      val cost: Int = min(tree.query(x - 1), i - tree.query(x))
      ans = (ans + cost) % mod
      tree.update(x, 1)
    }
    return ans
  }
}
