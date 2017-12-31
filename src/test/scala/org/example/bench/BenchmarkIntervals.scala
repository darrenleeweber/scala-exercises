package org.example.bench

import org.scalameter.api._
import org.example.scala.{Interval, IntervalTree, Intervals, Ranges}

object Benchmarks extends Bench.OfflineReport {

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


  /* tests on IntervalTree */

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
      using(randomIntervals) in {
        randomInterval => {
          val intervals = IntervalTree()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
          intervals.sorted.size
        }
      }
    }
    measure method "skipped" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = IntervalTree()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
          intervals.skipped.size
        }
      }
    }
  }

  /* tests on Intervals */

  performance of "Intervals" in {
    measure method "update" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Intervals()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
        }
      }
    }
    measure method "sorted" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Intervals()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
          intervals.sorted.size
        }
      }
    }
    measure method "skipped" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Intervals()
          for(i <- randomInterval) { intervals.update(new Interval(i)) }
          intervals.skipped.size
        }
      }
    }
  }


  /* tests on Ranges */

  performance of "Ranges" in {
    measure method "update" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Ranges()
          for(i <- randomInterval) {
            intervals.update(Range(i._1, i._2))
          }
        }
      }
    }
    measure method "sorted" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Ranges()
          for(i <- randomInterval) { intervals.update(Range(i._1, i._2)) }
          intervals.sorted.size
        }
      }
    }
    measure method "skipped" in {
      using(randomIntervals) in {
        randomInterval => {
          val intervals = Ranges()
          for(i <- randomInterval) { intervals.update(Range(i._1, i._2)) }
          intervals.skipped.size
        }
      }
    }
  }
}
