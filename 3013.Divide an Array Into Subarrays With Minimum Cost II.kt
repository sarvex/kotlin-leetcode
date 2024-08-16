internal class Solution {
  fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
    var result: Long = MAX_VALUE
    var sum = 0L
    val n = nums.size
    val set1
        : TreeSet<Int> = TreeSet { a, b -> if (nums[a] == nums[b]) a - b else nums[a] - nums[b] }
    val set2
        : TreeSet<Int> = TreeSet { a, b -> if (nums[a] == nums[b]) a - b else nums[a] - nums[b] }
    for (i in 1 until n) {
      set1.add(i)
      sum += nums[i].toLong()
      if (set1.size() >= k) {
        val x: Int = set1.pollLast()
        sum -= nums[x].toLong()
        set2.add(x)
      }
      if (i - dist > 0) {
        result = min(result, sum)
        val temp: Int = i - dist
        if (set1.contains(temp)) {
          set1.remove(temp)
          sum -= nums[temp].toLong()
          if (set2.size() > 0) {
            val y: Int = set2.pollFirst()
            sum += nums[y].toLong()
            set1.add(y)
          }
        } else {
          set2.remove(i - dist)
        }
      }
    }
    return result + nums[0]
  }
}
