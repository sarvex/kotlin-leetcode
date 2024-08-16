import java.util.*

internal class Solution {
  private var mapping: IntArray

  fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
    this.mapping = mapping
    val n = nums.size
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(f(nums[i]), i)
    }
    Arrays.sort(arr) { a, b -> if (a[0] === b[0]) a[1] - b[1] else a[0] - b[0] }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = nums[arr[i][1]]
    }
    return ans
  }

  private fun f(x: Int): Int {
    var x = x
    if (x == 0) {
      return mapping[0]
    }
    var y = 0
    var k = 1
    while (x > 0) {
      val v = mapping[x % 10]
      y = k * v + y
      k *= 10
      x /= 10
    }
    return y
  }
}
