package org.example.scala

import scala.io.Source
import collection.immutable.Range

object RangeSkips {

  def parseInterval(line:String) : Range = {
    val Array(a,b) = line.split("\\s+").map(_.trim.toInt)
    Range(a, b) // an _open_ ended interval [a, b)
  }

  def getSource(args:Array[String]) : Source = {
    if (args.length > 0) {
      Source.fromFile(args(0))
    } else {
      Source.stdin
    }
  }

  def main(args:Array[String]) : Unit = {
    val ranges = Ranges()
    val source = getSource(args)
    for (line <- source.getLines) {
      ranges.update(parseInterval(line))
    }
    val result = ranges.skipped.mkString("skipped ranges:\n", "\n" ,"\n")
    println(result) // scalastyle:ignore
  }

}
