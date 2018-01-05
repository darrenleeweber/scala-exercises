package org.example.scala

/*
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/unique-subarrays/
 *
 * A contiguous subarray is defined as unique if all the integers contained within
 * it occur exactly once. There is a unique weight associated with each of the
 * subarray. Unique weight for any subarray equals it's length if it's unique, 0
 * otherwise. Your task is to calculate the sum of unique weights of all the
 * contiguous subarrays contained within a given array.
 *
 * ## Input
 *
 * First line of the input contains an integer T, denoting the number of testcases.
 *
 * 2 * T lines follow, where first line of each testcase contains an integer N
 * denoting the number of integers in the given array. Last line of each testcase
 * then contains N single space separated integers
 *
 * ## Output
 *
 * Print the summation of unique weights of all the subarrays for each test case in a separate line.
 */


object ArraySubarrays {

  def main(args: Array[String]) {
    var n = 0
    var arr: Array[Int] = Array.fill(1)(0)

    val tasks = scala.io.StdIn.readLine().toInt
    for (task <- Range(0, tasks)) {
      n = scala.io.StdIn.readLine().toInt
      arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      println(ArrayUniqueSubarrays().sum(arr)) // scalastyle:ignore
    }
  }
}
