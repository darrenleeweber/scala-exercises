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
 * ## Solution notes
 *
 * Array.sliding(len).distinct is a brute force option, but takes too long.  The
 * two-pointer algorithm and formula is more efficient.
 *
 * See commentary on the two-pointer algorithm at
 * - https://tp-iiita.quora.com/The-Two-Pointer-Algorithm
 */

case class ArrayUniqueSubarrays() {

  def sum(arr: Array[Int]): Long = {
    val n = arr.length
    var sum: Long = 0
    var i: Int = 0
    var j: Int = 0
    var s = collection.mutable.Set[Int]()
    while ( i < n ) {
      while ( j < n && ! s.contains(arr(j)) ) {
        s += arr(j)
        j += 1
      }
      sum += ((j - i).toLong * (j - i + 1).toLong) / 2
      s.remove(arr(i))
      i += 1
    }
    sum
  }
}
