internal class UndergroundSystem {
  private val ts: Map<Int, Int> = HashMap()
  private val names: Map<Int, String> = HashMap()
  private val d: Map<String, IntArray> = HashMap()

  fun checkIn(id: Int, stationName: String?, t: Int) {
    ts.put(id, t)
    names.put(id, stationName)
  }

  fun checkOut(id: Int, stationName: String, t: Int) {
    val key = names[id] + "-" + stationName
    val v = d.getOrDefault(key, IntArray(2))
    v[0] += t - ts[id]!!
    v[1]++
    d.put(key, v)
  }

  fun getAverageTime(startStation: String, endStation: String): Double {
    val key = "$startStation-$endStation"
    val v = d[key]!!
    return v[0].toDouble() / v[1]
  }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
