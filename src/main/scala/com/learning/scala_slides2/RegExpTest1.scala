package com.learning.scala_slides2

/**
 * Scala: Regular Expression Patterns
 * **********************************
 * @see http://www.scala-lang.org/old/node/122
 */

object RegExpTest1 extends App {

  def containsScala(x: String): Boolean = {
    val z: Seq[Char] = x
    z match {
      case Seq('q' | 'a' | 'c' | 'a' | 'l' | 'a', rest@_*) =>
        println("rest is: '" + rest + "'")
        true
      case Seq(_*) =>
        println("-")
        false
    }
  }

  print("a > "); containsScala("a")
  print("b > "); containsScala("b")
  print("ab > "); containsScala("ab")
  print("bd > "); containsScala("bd")
  println()
  print("abcdl > "); containsScala("abcdl")
  print("bcdl > "); containsScala("bcdl")
  print("acavvv > "); containsScala("acavvv")
  print("acala > "); containsScala("acala")
  println()
  print("q > "); containsScala("q")
  print("qa > "); containsScala("qa")
  print("qac > "); containsScala("qac")
  print("qaca > "); containsScala("qaca")
  print("aca > "); containsScala("aca")

}
