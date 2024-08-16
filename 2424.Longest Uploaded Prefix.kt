internal class LUPrefix(n: Int) {
  private var r = 0
  private val s: Set<Int> = HashSet()

  fun upload(video: Int) {
    s.add(video)
    while (s.contains(r + 1)) {
      ++r
    }
  }

  fun longest(): Int {
    return r
  }
}
/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
