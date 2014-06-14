object SieveOfEratosthenes {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)

  (primes take 7).toList                          //> res3: List[Int] = List(2, 3, 5, 7, 11, 13, 17)
}