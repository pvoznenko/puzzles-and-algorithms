// Counting Change
// Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin
// denominations. For example, there are 3 ways to give change for 4 if you have coins with
// denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.

object CountingChange {
  def countChange(money: Int, coins: List[Int]): Int = {
    def _countChange(money: Int, coins: List[Int]): Int =
      if (money == 0) 1
      else if (money < 0) 0
      else if (coins.isEmpty) 0
      else _countChange(money, coins.tail) + _countChange(money - coins.head, coins)

    if (money <= 0 || coins.isEmpty) 0
    else _countChange(money, coins)
  }                                               //> countChange: (money: Int, coins: List[Int])Int

  countChange(300, List(5, 10, 20, 50, 100, 200, 500))
                                                  //> res0: Int = 1022
}