object rationals {
  val x = new Rational(1, 3)                      //> x  : week3.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week3.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week3.Rational = 3/2

  x + y                                           //> res0: week3.Rational = 22/21

  x - y - z                                       //> res1: week3.Rational = -79/42

  y + y                                           //> res2: week3.Rational = 10/7

  x < y                                           //> res3: Boolean = true

  x max y                                         //> res4: week3.Rational = 5/7

  new Rational(2)                                 //> res5: week3.Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numer = x / g
  def denom = y / g

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) = new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)

  def unary_- : Rational = new Rational(-this.numer, this.denom)

  def -(that: Rational) = this + -that

  override def toString = this.numer + "/" + this.denom
}