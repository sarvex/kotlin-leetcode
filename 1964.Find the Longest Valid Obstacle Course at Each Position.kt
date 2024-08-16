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
    var s = 0
    while (x > 0) {
      s = max(s, c[x])
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
    val nums = obstacles.clone()
    Arrays.sort(nums)
    val n = nums.size
    val ans = IntArray(n)
    val tree = BinaryIndexedTree(n)
    for (k in 0 until n) {
      val x = obstacles[k]
      val i: Int = Arrays.binarySearch(nums, x) + 1
      ans[k] = tree.query(i) + 1
      tree.update(i, ans[k])
    }
    return ans
  }
}
