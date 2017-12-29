package org.example.scala

case class Intervals() {
  private val vals = new collection.mutable.ListBuffer[Interval]

  /**
    * Build a sequence of skipped Interval
    * @return Seq[Interval]
    */
  def skipped : Seq[Interval] = {
    sorted.sliding(2).collect { skippedInterval }.toSeq
  }

  /**
    * Sort a sequence of Interval by each Interval.start
    * @return Option[Interval]
    */
  def sorted : Seq[Interval] = vals.toSeq.sortWith(_.start < _.start)

  /**
    * Append an Interval
    * @param value Interval
    */
  def update(value:Interval) : Unit = {
    vals += value
  }

  private

  /**
    * Interval is an inclusive range, i.e. [a,b]
    * Check that the end value is lower than the start - 1 from the next interval; when it contains the start -1,
    * the sequence of intervals is continuous, e.g. (6,7) followed by (7,8) is continuous
    * when each interval is inclusive.
    *
    * Interval(6,7).toList  ->  List[Int] = List(6, 7)
    * Interval(8,9).toList  ->  List[Int] = List(8, 9)
    * Interval(6,7).contains( Interval(8,9).start )  ->  Boolean = false
    * Interval(6,7).contains( Interval(8,9).start - 1 )  ->  Boolean = true
    *
    * @param intervals Seq[Interval] - a pair of Interval
    * @return Interval
    */
  val skippedInterval: PartialFunction[Seq[Interval],Interval] = new PartialFunction[Seq[Interval], Interval] {
    def apply(seq: Seq[Interval]): Interval = {
      val a = seq.head
      val b = seq.last
      Interval(a.end + 1, b.start - 1)
    }
    def isDefinedAt(seq: Seq[Interval]): Boolean = {
      val a = seq.head
      val b = seq.last
      ! a.contains(b.start - 1)
    }
  }

}
