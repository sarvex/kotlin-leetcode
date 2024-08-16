internal class AuthenticationManager(private val t: Int) {
  private val d: Map<String, Int> = HashMap()

  fun generate(tokenId: String?, currentTime: Int) {
    d.put(tokenId, currentTime + t)
  }

  fun renew(tokenId: String, currentTime: Int) {
    if (d.getOrDefault(tokenId, 0) <= currentTime) {
      return
    }
    generate(tokenId, currentTime)
  }

  fun countUnexpiredTokens(currentTime: Int): Int {
    var ans = 0
    for (exp in d.values()) {
      if (exp > currentTime) {
        ++ans
      }
    }
    return ans
  }
}
/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
