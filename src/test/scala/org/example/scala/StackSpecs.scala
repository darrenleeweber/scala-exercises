package org.example.scala

class StackSpecs extends SpecHelper {

  describe("Stack.push") {
    it("works") {
      val stack = new StackInt()
      stack.push(1)
      assert(stack.size == 1)
    }
  }

  describe("Stack.pop returns an Option") {
    describe("with data in the stack") {
      it("returns Some") {
        val stack = new StackInt()
        stack.push(1)
        val i = stack.pop
        assert(i.isInstanceOf[Some[Int]])
        assert(stack.size == 0)
      }
    }
    describe("with an empty stack") {
      it("returns None") {
        val stack = new StackInt()
        val i = stack.pop
        assert(i.isInstanceOf[None.type])
        assert(stack.size == 0)
      }
    }
  }

  describe("Stack.size") {
    describe("with data in the stack") {
      it("works") {
        val stack = new StackInt()
        stack.push(1)
        assert(stack.size == 1)
      }
    }
    describe("with an empty stack") {
      it("works") {
        val stack = new StackInt()
        assert(stack.size == 0)
      }
    }
  }

}
