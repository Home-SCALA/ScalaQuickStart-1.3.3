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
    val str = "(just an) example"

    check(str, transform)
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
  def chars(c1: Char, c2: Char): Boolean = {
    true
  }

  def openChar(c: Char, args: List[Char], count: Int): Int = {
    for(a <- args){
      if(a.equals(c)) openChar(c,args,count+1)
      else 1
    }
  }

}
