import java.util.*

internal class MyCalendar {
  private val tm = TreeMap<Int, Int>()

  fun book(start: Int, end: Int): Boolean {
    var ent = tm.floorEntry(start)
    if (ent != null && ent.value > start) {
      return false
    }
    ent = tm.ceilingEntry(start)
    if (ent != null && ent.key < end) {
      return false
    }
    tm.put(start, end)
    return true
  }
}
/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */
