package com.learning.scala_slides2

/**
 * Напишите рекурсивную функцию, которая проверяет строку на то что для каждой открывающей скобки есть соответствующая закрывающая.
 * Сигнатура функции:
    def balance(chars: List[Char]): Boolean
 * Примеры корректных строк:
    (if (zero? x) max (/ 1 x))
    I told him (that it’s not (yet) done). (But he wasn’t listening)
 * Примеры некорректных строк:
    :-)
    ())(
 * Строка конвертируется в список символов List[Char] с помощью функции toList:
    "(just an) example".toList
 */
object Task1_4 {

  def main(args: Array[String]): Unit = {
    val str1 = "(if (zero? x) max (/ 1 x))"
    val str2 = "())("

    check(str1, transform)

    /////////////
    println()
    println( symbolCount('(', ')', str1) )

    println("-----------------------")

//    case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
//    case 'B' => 2
    println( "countHoles = " + countMatchs(Array('R', 'R', 'R', 'a', 'b')) )
    println( "countHoles = " + countMatchs(Array('B', 'a', 'b')) )

//    val str3: String = "QRO" //val str3: String = "QROPAD"
//    println( "countHoles-2 = " + countMatchs(str1.toList) )
//    println( "countHoles-2 = " + countMatchs(str3.toList) )
    println( "countHoles-2 = " + countMatchs("QROPAD".toList) ) // 6
    println( "countHoles-2 = " + countMatchs("qwebrt".toList) ) // 0
    println( "countHoles-2 = " + countMatchs("RRb".toList) )    // 2
    println( "countHoles-2 = " + countMatchs("B".toList) )      // 2
  }

  def transform(arg: String) = arg.toList

  def check(arg: String, func: ((String) => List[Char])) {
      for(a <- func(arg)){
        a match {
          case '(' => print("_" + a + "_ ")
          case ')' => print("_" + a + "_ ")
          case _ => print(a + " ")
        }
      }
  }

  /////////////

  def symbolCount(c1: Char, c2 : Char, str: String): Int = {
    var count = 0
    val args: List[Char] = str.toList

    for(arg <- args){
      if(arg.equals(c1)) count += 1
      if(arg.equals(c2)) if(0<count) count -= 1

//      arg match {
//        case c1 => count += 1
////        case c2 => count -= 1
//      }
    }
    count
  }

  /**
   *
   * @see https://gist.github.com/kings13y/882292
   * @see http://alvinalexander.com/photos/scala-sequences-head-tail-init-last
   */
  def countMatchs(chars: Array[Char]): Int = chars match {
    case Array() => 0
    case _ => countMatchs(chars.tail) + (chars.head match {
      case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
      case 'B' => 2
      case _ => 0
    })
  }

//  def countMatchs(chars: List[Char]): Int = chars match {
//    case List() => 0
//    case _ => countMatchs(chars.tail) + (chars.head match {
//      case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
//      case 'B' => 2
//      case _ => 0
//    })
//  }

  def countMatchs(chars: List[Char]): Int =
  chars match {
    case List() => 0 // если список пустой - тогда возвращаем '0'
    case _ => countMatchs(chars.tail) + (chars.head match { // берем порядковый элемент с конца
      case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
      case 'B' => 2
      case _ => 0 // на все остальное - возвращаем '0'
    })
  }

}
