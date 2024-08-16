internal class Solution {
  fun divisibleTripletCount(nums: IntArray, d: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    var ans = 0
    val n = nums.size
    for (j in 0 until n) {
      for (k in j + 1 until n) {
        val x = (d - (nums[j] + nums[k]) % d) % d
        ans += cnt.getOrDefault(x, 0)
      }
      cnt.merge(nums[j] % d, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
