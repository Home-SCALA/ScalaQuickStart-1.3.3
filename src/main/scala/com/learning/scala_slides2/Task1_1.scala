package com.learning.scala_slides2

/**
 * Написать программу, которая распечатывает свои аргументы с помощью рекурсивной функции
 */
object Task1_1 {

  def getParam(): Int = { print("ACTIONs "); 100 }

  /* Передача по значению - в параметрах сперва выполняется тело метода, а потом вохвращается результат (уже как в качестве параметрп) */
  def byValueParam(param: Int) = { print("byValue "); param }

  /* Передача по имени - по сути здесь в параметрах передается тольео сама ссылка на метод...а выполняется этот метод уже непосредственно на момент вызова */
  def byNameParam(param: => Int) = { print("byName "); param }

  def main(args: Array[String]): Unit = {
    println( getParam() )
    println( byValueParam(getParam) )
    println( byNameParam(getParam) )

    var iArgs: Array[Int] = Array(1,2,3,4,5,6,7,8,9,10)

//    for(iArg <- iArgs) print( iArg + " " )

//    println( func(4) ) // 1+2+3+4 = 10
//    aPrint(iArgs.length-1, iArgs) // 1+2+3+4 = 10
    aPrint(iArgs) // 1+2+3+4 = 10


    println()
//    val pri = println("aaaaaa")
//    pri
    /* #4 делаю простой вызов моей функции... */
    funcPrint2(iArgs, typePrint22)
    println()
    funcPrint2(iArgs, typePrint11)
  }

//  def aPrint(index: Int): Int = if (index==0) 0 else index+func(index-1)
//  def aPrint(index: => Int): Int = if (index==0) 0 else index+func(index-1)
  private def aPrint(args: Array[Int]) {
    def aPrint(index: => Int, args: Array[Int]): Int = {
      print( args(index) + " " )
      if (index>0) aPrint(index-1, args)
      0
    }

    aPrint(args.length-1, args)
  }


  /* #1 пишу реализацию своей рекурсивной функции, которая умеет печатать массив-данных... */
  private def funcPrint22(index: Int, args: Array[Int]): Int = {
    print( args(index) + " " )

    if (index>0) funcPrint22(index-1, args)
    0
  }
  /* #2 декларирую что эта моя функция будет иметь конкретный тип...(ПАТТЕРН) */
  val typePrint22: (Int, Array[Int]) => Int = funcPrint22
  val typePrint11: (Array[Int]) => Unit = aPrint
  /* #3 декларирую условную функцию, которая умеет задавать параметры...ДИЗАЙН-ПАТТЕРН АДАПТЕР */
  def funcPrint2(args: Array[Int], func: ((Int, Array[Int]) => Int)) = func(args.length-1, args)
  def funcPrint2(args: Array[Int], func: ((Array[Int]) => Unit)) = func(args)
  /*
   * Такой подход всегда лучще, потому-что:
   * - код имеет более гибкую расширяемость...для разных случаев
   * - сама реализация кода более открыта, что позволяет лучше его тестировать...
   */
}
