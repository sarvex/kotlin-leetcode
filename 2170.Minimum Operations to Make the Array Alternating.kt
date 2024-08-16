internal class Solution {
  fun minimumOperations(nums: IntArray): Int {
    val a = f(nums, 0)
    val b = f(nums, 1)
    val n = nums.size
    if (a[0] != b[0]) {
      return n - (a[1] + b[1])
    }
    return n - max(a[1] + b[3], a[3] + b[1])
  }

  private fun f(nums: IntArray, i: Int): IntArray {
    var i = i
    var k1 = 0
    var k2 = 0
    val cnt: Map<Int, Int> = HashMap()
    while (i < nums.size) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      i += 2
    }
    for (e in cnt.entrySet()) {
      val k: Int = e.getKey()
      val v: Int = e.getValue()
      if (cnt.getOrDefault(k1, 0) < v) {
        k2 = k1
        k1 = k
      } else if (cnt.getOrDefault(k2, 0) < v) {
        k2 = k
      }
    }
    return intArrayOf(k1, cnt.getOrDefault(k1, 0), k2, cnt.getOrDefault(k2, 0))
  }
}
