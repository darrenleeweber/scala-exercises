package org.example.scala

case class IntervalTree() {
  // the TreeMap is ordered by the key natural ordering
  private val tree: collection.mutable.TreeMap[Int,Int] = new collection.mutable.TreeMap[Int,Int]

  /**
    * Build a sequence of skipped Interval
    * @return Seq[Interval]
    */
  def skipped : Seq[Interval] = {
    sorted.sliding(2).collect { skippedInterval }.toSeq
  }

  /**
    * A sequence of intervals sorted by start
    * @return Seq[(Int,Int)]
    */
  def sorted : Seq[Interval] = tree.map(new Interval(_)).toSeq

//  def sorted : Seq[Interval] = tree.map(tuple => Interval(tuple._1, tuple._2))

  /**
    * Insert an Interval into the tree
    * - the TreeMap is sorted by Interval.start
    * @param value Interval
    */
  def update(value: Interval) : Unit = {
    tree += (value.start -> value.end)
  }

  private

  /**
    * Interval is an inclusive range, i.e. [a,b]
    * Check that the end value is lower than the start - 1 from the next interval; when it contains the start -1,
    * the sequence of intervals is continuous, e.g. [6,7] followed by [7,8] is continuous for inclusive intervals.
    *
    * Interval(6,7).toList  ->  List(6, 7)
    * Interval(8,9).toList  ->  List(8, 9)
    * Interval(6,7).contains( Interval(8,9).start )      ->  false
    * Interval(6,7).contains( Interval(8,9).start - 1 )  ->  true
    *
    * @return Interval
    */
  val skippedInterval: PartialFunction[Seq[Interval],Interval] = new PartialFunction[Seq[Interval], Interval] {
    def apply(seq: Seq[Interval]): Interval = {
      Interval(seq.head.end + 1, seq.last.start - 1)
    }
    def isDefinedAt(seq: Seq[Interval]): Boolean = {
      ! seq.head.contains(seq.last.start - 1)
    }
  }

}
