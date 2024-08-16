internal class FrequencyTracker {
  private val cnt: Map<Int, Int> = HashMap()
  private val freq: Map<Int, Int> = HashMap()

  fun add(number: Int) {
    freq.merge(cnt.getOrDefault(number, 0), -1) { a: Int, b: Int -> Integer.sum(a, b) }
    cnt.merge(number, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    freq.merge(cnt[number], 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun deleteOne(number: Int) {
    if (cnt.getOrDefault(number, 0) > 0) {
      freq.merge(cnt[number], -1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(number, -1) { a: Int, b: Int -> Integer.sum(a, b) }
      freq.merge(cnt[number], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
  }

  fun hasFrequency(frequency: Int): Boolean {
    return freq.getOrDefault(frequency, 0) > 0
  }
}
/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
