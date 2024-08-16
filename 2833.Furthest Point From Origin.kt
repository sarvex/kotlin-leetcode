internal class Solution {
  fun furthestDistanceFromOrigin(moves: String): Int {
    return abs(count(moves, 'L') - count(moves, 'R')) + count(moves, '_')
  }

  private fun count(s: String, c: Char): Int {
    var cnt = 0
    for (i in 0 until s.length) {
      if (s[i] == c) {
        ++cnt
      }
    }
    return cnt
  }
}
