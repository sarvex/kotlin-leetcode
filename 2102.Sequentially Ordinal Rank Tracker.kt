internal class SORTracker {
  private val good: PriorityQueue<Map.Entry<Int, String>> = PriorityQueue { a, b ->
    if (a.getKey().equals(b.getKey()))
      b.getValue().compareTo(a.getValue())
    else
      a.getKey() - b.getKey()
  }
  private val bad: PriorityQueue<Map.Entry<Int, String>> = PriorityQueue { a, b ->
    if (a.getKey().equals(b.getKey()))
      a.getValue().compareTo(b.getValue())
    else
      b.getKey() - a.getKey()
  }

  fun add(name: String?, score: Int) {
    good.offer(Map.entry(score, name))
    bad.offer(good.poll())
  }

  fun get(): String {
    good.offer(bad.poll())
    return good.peek().getValue()
  }
}
/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
