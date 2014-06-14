package TheWaterPouringProblem

// http://demonstrations.wolfram.com/WaterPouringProblem/
object test {
  val problem = new Pouring(Vector(4, 7))         //> problem  : TheWaterPouringProblem.Pouring = TheWaterPouringProblem.Pouring@5
                                                  //| 328f6ee
  problem.solutions(5)                            //> res0: Stream[TheWaterPouringProblem.test.problem.Path] = Stream(Fill(0) Pour
                                                  //| (0,1) Fill(0) Pour(0,1) Empty(1) Pour(0,1) Fill(0) Pour(0,1)--> Vector(0, 5)
                                                  //| , ?)
}