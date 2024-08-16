internal class Solution {
  fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
    val cnt: Map<String, Int> = HashMap(senders.size)
    for (i in messages.indices) {
      var v = 1
      for (j in 0 until messages[i].length) {
        if (messages[i][j] == ' ') {
          ++v
        }
      }
      cnt.merge(senders[i], v) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = senders[0]
    for (e in cnt.entrySet()) {
      val k: String = e.getKey()
      val v: Int = e.getValue()
      if (cnt[ans]!! < v || (cnt[ans] === v && ans.compareTo(k) < 0)) {
        ans = k
      }
    }
    return ans
  }
}
