package org.example.scala

import scala.io.Source

object IntervalSkips {

  def parseInterval(line:String) : Interval = {
    val Array(a,b) = line.split("\\s+").map(_.trim.toInt)
    Interval(a, b) // an _inclusive_ interval
  }

  def getSource(args:Array[String]) : Source = {
    if (args.length > 0) {
      Source.fromFile(args(0))
    } else {
      Source.stdin
    }
  }

  def main(args:Array[String]) : Unit = {
    val intervals = Intervals()
    val source = getSource(args)
    for (line <- source.getLines) {
      intervals.update(parseInterval(line))
    }
    val result = intervals.skipped.mkString("skipped intervals:\n", "\n" ,"\n")
    println(result) // scalastyle:ignore
  }

}
