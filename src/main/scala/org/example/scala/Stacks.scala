package org.example.scala

/*
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/tutorial/
 *
 * To run this with an example input in `in.txt`:
 * cat in.txt | sbt "runMain org.example.scala.Stacks"
 */

object Stacks {

  def main(args: Array[String]) {
    val stack = new StackInt()
    val queryTotal = scala.io.StdIn.readLine().toInt
    var queryCount = 0
    while (queryCount < queryTotal) {
      val queryArr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      if (queryArr.head == 1) {
        stack.pop match {
          case Some(cost) => println(cost) // scalastyle:ignore
          case None => println("No Food")  // scalastyle:ignore
        }
      } else {
        stack.push(queryArr.last)
      }
      queryCount += 1
    }
  }
}
