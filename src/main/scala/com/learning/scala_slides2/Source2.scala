package com.learning.scala_slides2

/**
 * Функции как тип
 */

class Food {
  def transforms(quickly: Boolean) = if (quickly) 10 else 1000
  def @?#! = 0
}

class Human {
  def quickly() = true
  def licks(food: Food) = food.transforms(!quickly())
  def eats(food: Food) = food transforms quickly
  def ####(food: Food) = food @?#!
  def lives { this eats new Food } // eats new Food - compilation error
  def life { this.lives }
}


object Source2 {

  def main(args: Array[String]): Unit = {
    println( "sumResult1 = " + sumResult1 )
//    println( "sumAsValue = " + sumAsValue )
    println( "sumResult2 = " + sumResult2 )
    println( "sumResult3 = " + sumResult3 )
  }

  def sum(x: Int, y: Int) = x+y          // пускай эта функция будет являться определенным типом, которая принимает 'Int,Int', а возвращает 'Int'
                                         // такую функцию можно перегрузить много раз - и тогда это уже будет другая функция (другого типа...)
  val sumResult1 = sum(1,2)              // '1,2' >> '3' >> обычный способ выхова функции, а возвращаемый результат присваиваем переменной...

  val sumAsValue: (Int,Int) => Int = sum // '1,2' >> '<function2>' >> определяем аннонимную функцию для конкретного типа...а дальше Scala-компилятор сам умеет находить этот тип перегруженной функции и подставляет его в момент вызова
  // а теперь красиво разнесем код-определения и код-вызова типа перегруженной функции:
  def sumMeta(x: Int, y: Int, sumF: ((Int,Int) => Int)) = sumF(x,y) // вынесем в отдельный метод определение аннонимной функции для конкретного типа...
  val sumResult2 = sumMeta(1,2,sum)        // '1,2' >> '3' >> вынесем вызов типа перегруженной функции сюда...на этапе присвоении переменной
  val sumResult3 = sumMeta(1,2,sumAsValue) // '1,2' >> '3' >> вынесем вызов типа перегруженной функции сюда...на этапе присвоении переменной

}
