internal class Solution {
  fun subarraySum(nums: IntArray, k: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    cnt.put(0, 1)
    var ans = 0
    var s = 0
    for (x in nums) {
      s += x
      ans += cnt.getOrDefault(s - k, 0)
      cnt.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
