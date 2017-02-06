package com.learning.scala_slides2

class Person (name: String, var age: Int) {
  def this(name: String) = this(name, 0)

  def getName(): String = name
  def ggetAge(): Int = age

  def setAge(age: Int): Unit = { this.age = age }
}

object Person {
  def apply(name: String) = new Person(name)
  def apply(name: String, age: Int) = new Person(name, age)
}


object Source0 {

  def main(args: Array[String]): Unit = {
    var person: Person = Person("Sasha")
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )

    person = Person("Sasha", 34)
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )

    person.setAge(39)
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )
  }

}
