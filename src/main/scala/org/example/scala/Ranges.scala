package org.example.scala

import collection.immutable.Range

case class Ranges() {
  val vals = new collection.mutable.ListBuffer[Range]

  /**
    * Build a sequence of skipped Range
    * @return Seq[Range]
    */
  def skipped : Seq[Range] = {
    sorted.sliding(2).collect { skippedInterval }.toSeq
  }

  /**
    * Sort a sequence of Range by each Range.min
    * @return Option[Range]
    */
  def sorted : Seq[Range] = vals.toSeq.sortWith(_.start < _.start)

  /**
    * Append a Range
    * @param value Range
    */
  def update(value:Range) : Unit = {
    vals += value
  }

  private

  /**
    * Range(a,b) is an open ended interval, i.e. [a,b)
    * Check that the max value is lower than the min - 1 from the next interval;
    * when it contains the min -1, the sequence of intervals is continuous, e.g.
    *
    * Range(6,7).toList  ->  List(6)
    * Range(7,8).toList  ->  List(7)
    * Range(6,7).contains(Range(7,8).start)      ->  false
    * Range(6,7).contains(Range(7,8).start - 1)  ->  true
    *
    * @return Range
    */
  val skippedInterval: PartialFunction[Seq[Range],Range] = new PartialFunction[Seq[Range], Range] {
    def apply(seq: Seq[Range]): Range = {
      val a = seq.head
      val b = seq.last
      // Note: Range(a,b).end == b == Range(a,b).toList.last + 1
      Range(a.end, b.start)
    }
    def isDefinedAt(seq: Seq[Range]): Boolean = {
      val a = seq.head
      val b = seq.last
      ! a.contains(b.start - 1)
    }
  }

}
