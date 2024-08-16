internal class Solution {
  fun maximumLength(nums: IntArray): Int {
    val cnt: Map<Long, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x.toLong(), 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var t: Int = cnt.remove(1L)
    var ans = if (t == null) 0 else t - (t % 2 xor 1)
    for (x in cnt.keySet()) {
      var x = x
      t = 0
      while (cnt.getOrDefault(x, 0) > 1) {
        x = x * x
        t += 2
      }
      t += cnt.getOrDefault(x, -1)
      ans = max(ans, t)
    }
    return ans
  }
}
