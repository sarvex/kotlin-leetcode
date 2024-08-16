internal class TopVotedCandidate(persons: IntArray, times: IntArray) {
  private val times: IntArray
  private val wins: IntArray

  init {
    val n = persons.size
    wins = IntArray(n)
    this.times = times
    val cnt = IntArray(n)
    var cur = 0
    for (i in 0 until n) {
      val p = persons[i]
      ++cnt[p]
      if (cnt[cur] <= cnt[p]) {
        cur = p
      }
      wins[i] = cur
    }
  }

  fun q(t: Int): Int {
    var i: Int = Arrays.binarySearch(times, t + 1)
    i = if (i < 0) -i - 2 else i - 1
    return wins[i]
  }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
