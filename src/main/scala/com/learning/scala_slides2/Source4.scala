package com.learning.scala_slides2

/**
 * Функция как объект
 */
object Source4 {

  def main(args: Array[String]): Unit = {
    println( func(10) )
    println( funcAsObject(10) )
    println( funcAsObject.apply(10) )
    println( funcAsValue.apply(10) ) // func.apply(10) – compilation error

    println(funcAsValue + " result: " + funcAsValue(10)) // <function1> result: 10
    println(myfunc + " result: " + myfunc(10))           // My func! result: 100
  }

  def func(x: Int) = x               // это будет транслироваться как метод в Java
  val funcAsObject: Function[Int, Int] = func
  val funcAsValue: Int => Int = func // это будет поле типа Function[Int, Int]
  val funcAsValue2 = func _          // без _ непонятно - присвоение или вызов?

  class MyFunc extends Function[Int, Int] {
    override def toString() = "My Func!"
    def apply(x: Int) = x*x
  }

  val myfunc: Int => Int = new MyFunc
}
