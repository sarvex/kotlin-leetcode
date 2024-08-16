internal class Logger {
  private val limiter: Map<String, Int>

  /** Initialize your data structure here.  */
  init {
    limiter = HashMap()
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns
   * false. If this method returns false, the message will not be printed. The timestamp is in
   * seconds granularity.
   */
  fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
    val t = limiter.getOrDefault(message, 0)
    if (t > timestamp) {
      return false
    }
    limiter.put(message, timestamp + 10)
    return true
  }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
