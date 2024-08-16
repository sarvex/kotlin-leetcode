internal class Solution {
  fun ladderLength(beginWord: String?, endWord: String, wordList: List<String?>?): Int {
    val words: Set<String> = HashSet(wordList)
    val q: Queue<String> = ArrayDeque()
    q.offer(beginWord)
    var ans = 1
    while (!q.isEmpty()) {
      ++ans
      for (i in q.size() downTo 1) {
        val s: String = q.poll()
        val chars: CharArray = s.toCharArray()
        for (j in chars.indices) {
          val ch = chars[j]
          var k = 'a'
          while (k <= 'z') {
            chars[j] = k
            val t = String(chars)
            if (!words.contains(t)) {
              ++k
              continue
            }
            if (endWord == t) {
              return ans
            }
            q.offer(t)
            words.remove(t)
            ++k
          }
          chars[j] = ch
        }
      }
    }
    return 0
  }
}
