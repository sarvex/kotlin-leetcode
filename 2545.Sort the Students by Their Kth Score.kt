import java.util.*

internal class Solution {
  fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
    Arrays.sort(score) { a, b -> b[k] - a[k] }
    return score
  }
}
