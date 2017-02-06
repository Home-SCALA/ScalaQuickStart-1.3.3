package com.learning.scala_school.basics2

/**
 * Классы и Объекты могут иметь похожие имена.
 * В этом случае Объект называется ‘Объект-спутник’(Companion Object).
 * Чаще всего мы будем использовать Объекты-спутники с Фабриками объектов.
 *
 * @see http://daily-scala.blogspot.com/2009/09/companion-object.html
 */
class Bar3(foo: String) {
  override def toString = foo
}

object Bar3 {
  def apply(foo: String) = new Bar3(foo)
}

/**
 * http://ccfit.nsu.ru/~den/Scala/scala_slides2.pdf
 */
class Person (name: String){
  def getName(): String = { name }
}

object Person {
  def apply(name: String) = new Person(name)
}


object Source3 {

  def main(args: Array[String]) {
    var bar3 = Bar3("bar")
    println(bar3)

    var person = Person("abc")
    println( person.getName() )
  }
}
