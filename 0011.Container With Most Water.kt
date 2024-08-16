internal class Solution {
  fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var ans = 0
    while (i < j) {
      val t: Int = min(height[i], height[j]) * (j - i)
      ans = max(ans, t)
      if (height[i] < height[j]) {
        ++i
      } else {
        --j
      }
    }
    return ans
  }
}
