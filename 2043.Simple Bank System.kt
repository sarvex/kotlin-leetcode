internal class Bank(private val balance: LongArray) {
  private val n = balance.size

  fun transfer(account1: Int, account2: Int, money: Long): Boolean {
    if (account1 > n || account2 > n || balance[account1 - 1] < money) {
      return false
    }
    balance[account1 - 1] -= money
    balance[account2 - 1] += money
    return true
  }

  fun deposit(account: Int, money: Long): Boolean {
    if (account > n) {
      return false
    }
    balance[account - 1] += money
    return true
  }

  fun withdraw(account: Int, money: Long): Boolean {
    if (account > n || balance[account - 1] < money) {
      return false
    }
    balance[account - 1] -= money
    return true
  }
}
/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
