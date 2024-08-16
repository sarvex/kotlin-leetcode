internal class Solution {
  fun getAverages(nums: IntArray, k: Int): IntArray {
    var k = k
    k = k shl 1 or 1
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    if (k > n) {
      return ans
    }
    var s: Long = 0
    for (i in 0 until k) {
      s += nums[i].toLong()
    }
    var j = k / 2
    ans[j] = (s / k).toInt()
    for (i in k until n) {
      s += (nums[i] - nums[i - k]).toLong()
      ans[++j] = (s / k).toInt()
    }
    return ans
  }
}
