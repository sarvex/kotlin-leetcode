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
  fun subarraysWithMoreZerosThanOnes(nums: IntArray): Int {
    val n = nums.size
    val base = n + 1
    val tree = BinaryIndexedTree(n + base)
    tree.update(base, 1)
    val mod = 1e9.toInt() + 7
    var ans = 0
    var s = 0
    for (x in nums) {
      s += if (x == 0) -1 else 1
      ans += tree.query(s - 1 + base)
      ans %= mod
      tree.update(s + base, 1)
    }
    return ans
  }
}
