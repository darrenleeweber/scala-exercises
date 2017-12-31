package org.example.bench

import org.example.scala.{Interval, IntervalTree}
import org.scalameter.api._

object BenchIntervalTree extends Bench.OfflineReport {

  /* inputs */

  val intRange = 100
  val intSkip = 5

  val arraySizes: Gen[Int] = Gen.range("arraySize")(100, 900, 200) // scalastyle: ignore

  val randomIntervals: Gen[IndexedSeq[(Int, Int)]] = for { size <- arraySizes } yield {
    (0 to size).map { i:Int =>
      val r = util.Random.nextInt(intRange)
      (r, r + util.Random.nextInt(intSkip))
    }
  }

  val intervalsGenerator: Gen[IntervalTree] = for { randomInterval <- randomIntervals } yield {
    val intervals = IntervalTree()
    for(i <- randomInterval) { intervals.update(new Interval(i)) }
    intervals
  }

  /* tests */

  performance of "IntervalTree" in {
    measure method "update" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = IntervalTree()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
        }
      }
    }
    measure method "sorted" in {
      using(intervalsGenerator) in {
        intervals => intervals.sorted.size
      }
    }
    measure method "skipped" in {
      using(intervalsGenerator) in {
        intervals => intervals.skipped.size
      }
    }
  }
}
