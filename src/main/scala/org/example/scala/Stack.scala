package org.example.scala

// scala collection Stack is deprecated, so ...

trait Stack[T] {
  private var stack = List.empty[T]

  def pop: Option[T] = {
    stack.headOption match {
      case Some(i) => stack = stack.tail; Some(i)
      case _ => None
    }
  }

  def push(i: T): Unit = {
    stack = i :: stack
  }

  def size: Int = {
    stack.size
  }
}
