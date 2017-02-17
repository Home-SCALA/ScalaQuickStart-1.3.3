package com.learning.scala_slides2.array

object Source1 {

  def countMatchs(chars: Array[Char]): Int = chars match {
    case Array() => 0
    case _ => countMatchs(chars.tail) + (chars.head match {
      case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
      case 'B' => 2
      case _ => 0
    })
  }

}
