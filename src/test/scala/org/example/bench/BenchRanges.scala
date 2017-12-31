package org.example.bench

import org.example.scala.Ranges
import org.scalameter.api._

object BenchRanges extends Bench.OfflineReport {

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

  val intervalRanges: Gen[Ranges] = for { randomInterval <- randomIntervals } yield {
    val intervals = Ranges()
    for(i <- randomInterval) {
      intervals.update(Range(i._1, i._2))
    }
    intervals
  }

  /* tests */

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
      using(intervalRanges) in {
        ranges => ranges.sorted.size
      }
    }
    measure method "skipped" in {
      using(intervalRanges) in {
        ranges => ranges.skipped.size
      }
    }
  }
}
