internal class Solution(private var nums: IntArray) {
  private val original: IntArray = Arrays.copyOf(nums, nums.size)
  private val rand: Random

  init {
    this.rand = Random()
  }

  fun reset(): IntArray {
    nums = Arrays.copyOf(original, original.size)
    return nums
  }

  fun shuffle(): IntArray {
    for (i in nums.indices) {
      swap(i, i + rand.nextInt(nums.size - i))
    }
    return nums
  }

  private fun swap(i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
