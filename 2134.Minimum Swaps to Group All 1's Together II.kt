internal class Solution {
  fun minSwaps(nums: IntArray): Int {
    val k: Int = Arrays.stream(nums).sum()
    val n = nums.size
    var cnt = 0
    for (i in 0 until k) {
      cnt += nums[i]
    }
    var mx = cnt
    for (i in k until n + k) {
      cnt += nums[i % n] - nums[(i - k + n) % n]
      mx = max(mx, cnt)
    }
    return k - mx
  }
}
