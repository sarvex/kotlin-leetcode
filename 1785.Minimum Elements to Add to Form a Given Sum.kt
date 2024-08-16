internal class Solution {
  fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
    // long s = Arrays.stream(nums).asLongStream().sum();
    var s: Long = 0
    for (v in nums) {
      s += v.toLong()
    }
    val d: Long = abs(s - goal)
    return ((d + limit - 1) / limit).toInt()
  }
}
