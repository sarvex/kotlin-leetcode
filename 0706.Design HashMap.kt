internal class MyHashMap {
  private val data = IntArray(1000001)

  init {
    Arrays.fill(data, -1)
  }

  fun put(key: Int, value: Int) {
    data[key] = value
  }

  fun get(key: Int): Int {
    return data[key]
  }

  fun remove(key: Int) {
    data[key] = -1
  }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
