internal class Solution {
  fun findPeaks(mountain: IntArray): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in 1 until mountain.size - 1) {
      if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
        ans.add(i)
      }
    }
    return ans
  }
}
