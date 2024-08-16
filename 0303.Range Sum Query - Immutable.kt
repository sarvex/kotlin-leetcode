internal class NumArray(nums: IntArray) {
  private val s: IntArray

  init {
    val n = nums.size
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
  }

  fun sumRange(left: Int, right: Int): Int {
    return s[right + 1] - s[left]
  }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
