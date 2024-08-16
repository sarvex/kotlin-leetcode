internal class BinaryIndexedTree(private val n: Int) {
  private val c = IntArray(n + 1)

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x], v)
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var ans = 0
    while (x > 0) {
      ans = max(ans, c[x])
      x -= x and -x
    }
    return ans
  }
}

internal class Solution {
  fun minOperations(target: IntArray, arr: IntArray): Int {
    val m = target.size
    val d: Map<Int, Int> = HashMap(m)
    for (i in 0 until m) {
      d.put(target[i], i + 1)
    }
    val nums: List<Int> = ArrayList()
    for (x in arr) {
      if (d.containsKey(x)) {
        nums.add(d[x])
      }
    }
    val tree = BinaryIndexedTree(m)
    var ans = 0
    for (x in nums) {
      val v = tree.query(x - 1) + 1
      ans = max(ans, v)
      tree.update(x, v)
    }
    return m - ans
  }
}
