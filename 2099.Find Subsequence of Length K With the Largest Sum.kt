internal class Solution {
  fun maxSubsequence(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> nums[i] - nums[j] }
    Arrays.sort(idx, n - k, n)
    val ans = IntArray(k)
    for (i in n - k until n) {
      ans[i - (n - k)] = nums[idx[i]]
    }
    return ans
  }
}
