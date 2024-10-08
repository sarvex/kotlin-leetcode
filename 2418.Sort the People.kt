import java.util.*

internal class Solution {
  fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    val n = names.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> heights[j] - heights[i] }
    val ans: Array<String> = arrayOfNulls(n)
    for (i in 0 until n) {
      ans[i] = names[idx[i]]
    }
    return ans
  }
}
