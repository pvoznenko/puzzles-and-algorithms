object SQRTNewtonsMethod {
  // SQRT Newton's method

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //]]> sqrt: (x: Double)Double

  sqrt(0.001)                                     //]]> res1: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //]]> res2: Double = 3.1633394544890125E-11
  sqrt(1.0e20)                                    //]]> res3: Double = 1.0000021484861237E10
  sqrt(1.0e50)                                    //]]> res4: Double = 1.0000003807575104E25

  /**
   * Using Stream and lazy
   */

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001    //> isGoodEnough: (guess: Double, x: Double)Boolean

  sqrtStream(0.001) filter (isGoodEnough(_, 0.001))
                                                  //> res4: scala.collection.immutable.Stream[Double] = Stream(0.0316227824507010
                                                  //| 5, ?)
}