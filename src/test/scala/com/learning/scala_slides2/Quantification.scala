package com.learning.scala_slides2

/**
 * Квантификация
 * *************
 * @see https://twitter.github.io/scala_school/ru/type-basics.html#quantification
 */

object Quantification {

  def main(args: Array[String]): Unit = {

  }

  /* Иногда вы не заботитесь о том, чтобы дать имя типовой переменной, например: */
//  def count[A](l: List[A]) = l.size

  /* Вместо этого вы можете использовать "заменитель" - это короткая запись для: */
  def count(l: List[T forSome { type T }]) = l.size
//  def count(l: List[_]) = l.size




  /* Заметьте, что квантификация может получиться сложной: */
//  def drop1(l: List[_]) = l.tail
  /* А вдруг мы потеряли информацию о типе! Чтобы понять, что происходит, вернемся к "зубодробительному" синтаксису: */
  def drop1(l: List[T forSome { type T }]) = l.tail //>> drop1: (List[T forSome { type T }])List[T forSome { type T }]



  /* Вы можете также применять ограничения для замены типовых переменных: */
  def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode) // >> hashcodes: (Seq[_ <: AnyRef])Seq[Int]
//  hashcodes(Seq(1,2,3))
  /*
<console>:7: error: type mismatch;
found   : Int(1)
required: AnyRef
Note: primitive types are not implicitly converted to AnyRef.
You can safely force boxing by casting x.asInstanceOf[AnyRef].
       hashcodes(Seq(1,2,3))
   */
  println( hashcodes(Seq("one", "two", "three")) ) // >> res1: Seq[Int] = List(110182, 115276, 110339486)
}
