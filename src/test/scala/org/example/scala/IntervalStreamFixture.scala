package org.example.scala

class IntervalStreamFixture {

  def stream : List[(Int, Int)] = {
    List[(Int, Int)](
      (2, 6),
      (9, 12),
      (8, 9),
      (18, 21),
      (4, 7),
      (10, 11)
    )
  }

  def intervals: List[Interval] = {
    stream.map(new Interval(_))
  }

  def ranges: List[Range] = {
    stream.map { tuple:(Int, Int) => Range(tuple._1, tuple._2) }
  }

}
