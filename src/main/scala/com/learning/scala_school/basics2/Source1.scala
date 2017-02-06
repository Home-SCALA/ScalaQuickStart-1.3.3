package com.learning.scala_school.basics2

/**
 * Метод apply – это синтаксический сахар, здесь наш экземпляр объекта выглядит так, будто мы просто вызываем метод, но это не так.
 */

class Bar1 {
  def apply() = 10
}

object Source1 {

  def main(args: Array[String]) {
    var bar1 = new Bar1
    print( bar1() )
  }

}
