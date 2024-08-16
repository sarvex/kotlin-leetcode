internal class Solution {
  fun highFive(items: Array<IntArray>): Array<IntArray> {
    var size = 0
    val s: Array<PriorityQueue> = arrayOfNulls<PriorityQueue>(101)
    val n = 5
    for (item in items) {
      val i = item[0]
      val score = item[1]
      if (s[i] == null) {
        ++size
        s[i] = PriorityQueue(n)
      }
      s[i].offer(score)
      if (s[i].size() > n) {
        s[i].poll()
      }
    }
    val res = Array(size) { IntArray(2) }
    var j = 0
    for (i in 0..100) {
      if (s[i] == null) {
        continue
      }
      val avg = sum(s[i]) / n
      res[j][0] = i
      res[j++][1] = avg
    }
    return res
  }

  private fun sum(q: PriorityQueue<Int>): Int {
    var s = 0
    while (!q.isEmpty()) {
      s += q.poll()
    }
    return s
  }
}
