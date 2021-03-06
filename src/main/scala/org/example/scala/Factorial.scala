package org.example.scala

object Factorial {

  /*
   * For large N, it throws a stack overflow
   */
  def recursive(n:BigInt): BigInt = {
    if(n < 0) {
      throw new ArithmeticException
    } else if(n <= 1) {
      1
    } else {
      n * recursive(n - 1)
    }
  }

  /*
   * A tail recursive method is compiled to avoid stack overflow
   */
  @scala.annotation.tailrec
  def recursiveTail(n:BigInt, acc:BigInt = 1): BigInt = {
    if(n < 0) {
      throw new ArithmeticException
    } else if(n <= 1) {
      acc
    } else {
      recursiveTail(n - 1, n * acc)
    }
  }

  /*
   * A while loop
   */
  def loop(n:BigInt): BigInt = {
    if(n < 0) {
      throw new ArithmeticException
    } else if(n <= 1) {
      1
    } else {
      var acc = 1
      var idx = 1
      while(idx <= n) {
        acc = idx * acc
        idx += 1
      }
      acc
    }
  }

}