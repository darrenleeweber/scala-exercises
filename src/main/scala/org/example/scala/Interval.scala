package org.example.scala

/**
  * An inclusive set, i.e. [a, a] denotes the set {a}
  * @param lower - lower end of the interval (inclusive)
  * @param upper - upper end of the interval (inclusive)
  */
case class Interval(lower:Int, upper:Int) {

  /**
    * isValid when lower <= upper
    * @return boolean
    */
  def isValid : Boolean = {
    lower <= upper
  }
}
