internal class Solution {
  fun minOperations(nums: IntArray): Int {
    var ans = 0
    var mx = 0
    for (v in nums) {
      mx = max(mx, v)
      ans += Integer.bitCount(v)
    }
    ans += Integer.toBinaryString(mx).length - 1
    return ans
  }
}
