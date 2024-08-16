internal class Solution {
  fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val n = plantTime.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> growTime[j] - growTime[i] }
    var ans = 0
    var t = 0
    for (i in idx) {
      t += plantTime[i]
      ans = max(ans, t + growTime[i])
    }
    return ans
  }
}
