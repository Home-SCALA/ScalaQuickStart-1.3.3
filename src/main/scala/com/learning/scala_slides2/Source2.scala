package com.learning.scala_slides2

/**
 * @see http://ccfit.nsu.ru/~den/Scala/scala_slides2.pdf
 */

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
    var person: Person = Person("Sasha")
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )

    person = Person("Sasha", 34)
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )

    person.setAge(39)
    println( "Person> name:" + person.getName() + " age=" + person.ggetAge() )


    println( sum1(1,2) )
    println( sum2(1,2) )
    println( sum4(1,2) )
    println( sum5(1,2) )
    println( sum6(1,2) )
    println( sum7(1,2) )


    println( "sumResult1 = " + sumResult1 )
//    println( "sumAsValue = " + sumAsValue )
    println( "sumResult2 = " + sumResult2 )
    println( "sumResult3 = " + sumResult3 )


    println( "sumFunc = " + sumFunc )
    println( "sumMeta1 = " + sumMeta1(1,2,sumFunc) )                 // (обычный вариант) когда анонимная функция определяющая тип перегруженной функции находится в переменной...
    println( "sumMeta1 = " + sumMeta1(1,2,(x: Int, y: Int) => x+y) ) // (вариант) когда на лету определяем анонимную функцию что определяет тип перегруженной функции...
    println( "sumMeta1 = " + sumMeta1(1,2,(x,y) => x+y) )            // вариант-1 когда Scala-компилятор сам умеет находить тип по перечисленным параметрам...
    println( "sumMeta1 = " + sumMeta1(1,2,_+_) )                     // вариант-2 когда Scala-компилятор сам умеет находить параметры и тип по этим параметрам...


    println( func(10) )
    println( funcAsObject(10) )
    println( funcAsObject.apply(10) )
    println( funcAsValue.apply(10) ) // func.apply(10) – compilation error

    println(funcAsValue + " result: " + funcAsValue(10)) // <function1> result: 10
    println(myfunc + " result: " + myfunc(10))           // My func! result: 100
  }

  ///////////////////////////////////// Функции ////////////////////////////////////
  def sum1(x: Int, y: Int): Int = { x+y }           // '1,2' >> '3' >> обычный (полная декларация) вариант для функции с несколькими инструкциями которая что-то принимает и что-то возвращает...
  def sum2(x: Int, y: Int) = { print("sum="); x+y } // '1,2' >> 'sum=3' >> короткий (плохой) вариант для функции с несколькими инструкциями которая что-то принимает и что-то возвращает...
//  def sum3(x: Int, y: Int) = print("sum="); x+y   // '1,2' >> короткий (НЕправильный) вариант для функции с несколькими инструкциями - ошибка компиляции...

  def sum4(x: Int, y: Int): Int = x+y     // '1,2' >> '3' >> короткий (правильный) вариант можно писать когда функция только с одной инструкцией...
  def sum5(x: Int, y: Int) = x+y          // '1,2' >> '3' >> короткий (плохой) вариант можно писать когда функция только с одной инструкцией...

  def sum6(x: Int, y: Int): Unit = { print("sum=" + (x+y) ); x+y } // '1,2' >> возвращает 'Unit' >> обычный (полная декларация) вариант для функции с несколькими инструкциями которая что-то принимает и ничего НЕвозвращает...
  def sum7(x: Int, y: Int) { x+y }                                 // '1,2' >> возвращает 'Unit' >> короткий (плохой) вариант для функции с несколькими инструкциями которая что-то принимает и ничего НЕвозвращает...

  ///////////////////////////////////// Функции как тип ////////////////////////////////////
  def sum(x: Int, y: Int) = x+y          // пускай эта функция будет являться определенным типом, которая принимает 'Int,Int', а возвращает 'Int'
                                         // такую функцию можно перегрузить много раз - и тогда это уже будет другая функция (другого типа...)
  val sumResult1 = sum(1,2)              // '1,2' >> '3' >> обычный способ выхова функции, а возвращаемый результат присваиваем переменной...

  val sumAsValue: (Int,Int) => Int = sum // '1,2' >> '<function2>' >> определяем аннонимную функцию для конкретного типа...а дальше Scala-компилятор сам умеет находить этот тип перегруженной функции и подставляет его в момент вызова
  // а теперь красиво разнесем код-определения и код-вызова типа перегруженной функции:
  def sumMeta(x: Int, y: Int, sumF: ((Int,Int) => Int)) = sumF(x,y) // вынесем в отдельный метод определение аннонимной функции для конкретного типа...
  val sumResult2 = sumMeta(1,2,sum)        // '1,2' >> '3' >> вынесем вызов типа перегруженной функции сюда...на этапе присвоении переменной
  val sumResult3 = sumMeta(1,2,sumAsValue) // '1,2' >> '3' >> вынесем вызов типа перегруженной функции сюда...на этапе присвоении переменной

  ///////////////////////////////////// Анонимные функции ////////////////////////////////////
  val sumFunc = (x: Int, y: Int) => x+y                              // (обычный способ) определяем аннонимную переменую для конкретного типа функции...
  def sumMeta1(x: Int, y: Int, sumF: ((Int,Int) => Int)) = sumF(x,y) // (обычный способ) вынесли вызов типа перегруженной функции...

  ///////////////////////////////////// Функция как объект ////////////////////////////////////
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
