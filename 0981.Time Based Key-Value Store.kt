import java.util.*

internal class TimeMap {
  private val ktv: Map<String, TreeMap<Int, String>> = HashMap()

  fun set(key: String?, value: String?, timestamp: Int) {
    ktv.computeIfAbsent(key) { k -> TreeMap() }.put(timestamp, value)
  }

  fun get(key: String, timestamp: Int): String {
    if (!ktv.containsKey(key)) {
      return ""
    }
    val tv: Unit = ktv[key]
    val t: Int = tv.floorKey(timestamp)
    return if (t == null) "" else tv.get(t)
  }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
