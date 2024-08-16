internal class TweetCounts {
  private val data: Map<String, TreeMap<Int, Int>> = HashMap()

  fun recordTweet(tweetName: String, time: Int) {
    data.putIfAbsent(tweetName, TreeMap())
    val tm: Unit = data[tweetName]
    tm.put(time, tm.getOrDefault(time, 0) + 1)
  }

  fun getTweetCountsPerFrequency(
    freq: String, tweetName: String, startTime: Int, endTime: Int
  ): List<Int> {
    var f = 60
    if ("hour" == freq) {
      f = 3600
    } else if ("day" == freq) {
      f = 86400
    }
    val tm: Unit = data[tweetName]
    val ans: List<Int> = ArrayList()
    var i = startTime
    while (i <= endTime) {
      var s = 0
      val end: Int = min(i + f, endTime + 1)
      for (v in tm.subMap(i, end).values()) {
        s += v
      }
      ans.add(s)
      i += f
    }
    return ans
  }
}
/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
</Integer> */
