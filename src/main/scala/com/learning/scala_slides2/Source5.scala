package com.learning.scala_slides2

/**
 * Передача параметров
 */

object Source5 {

  def main(args: Array[String]): Unit = {
    println( info )              // param 100
    println( callByValue(info) ) // param by value 100
    println( callByName(info) )  // by name param 100
  }

  def info(): Int = { print("param "); 100 }

  /* Передача по значению */
  def callByValue(param: Int) = { print("by value "); param }

  /* передача по имени - позволяет избежать ненужных вычислений */
  def callByName(param: => Int) = { print("by name "); param }


  /* Передача параметра по имени позволяет избежать ненужных вычислений: */
//  def search(pattern: String, cache: Array[String], con: => Connection) {
//    if(findInCache(pattern, cache)) true
//    else if(findInDB(pattern, con)) true
//    else false
//  }
  /* Соединение с базой устанавливается только тогда, когда в кэше не нашли. */

}
