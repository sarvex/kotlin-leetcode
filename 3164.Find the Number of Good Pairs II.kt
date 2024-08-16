internal class Solution {
  fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val cnt1: Map<Int, Int> = HashMap()
    for (x in nums1) {
      if (x % k == 0) {
        cnt1.merge(x / k, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    if (cnt1.isEmpty()) {
      return 0
    }
    val cnt2: Map<Int, Int> = HashMap()
    for (x in nums2) {
      cnt2.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans: Long = 0
    val mx: Int = Collections.max(cnt1.keySet())
    for (e in cnt2.entrySet()) {
      val x: Int = e.getKey()
      val v: Int = e.getValue()
      var s = 0
      var y = x
      while (y <= mx) {
        s += cnt1.getOrDefault(y, 0)
        y += x
      }
      ans += 1L * s * v
    }
    return ans
  }
}
