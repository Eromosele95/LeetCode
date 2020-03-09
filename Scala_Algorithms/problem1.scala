
import java.io.{File, PrintWriter}

import scala.annotation.tailrec
import scala.collection.immutable.LazyList
import scala.collection.immutable.LazyList.#::
import util.control.Breaks._



object problem1 {

  // Pythagorean Triples found in a somewhat efficient way.
  // 3+𝑘−1Combination3 tuples generated at most


  def pyth(i:Int):List[(Int,Int,Int)] = {
    unfold_with_pythcomp[(Int,Int,Int)](pythelper(i),pythcomp).toList
  }


  def unfold_with_pythcomp[A](l1: LazyList[Option[A]], f: Option[A] => Option[(A, A)]): LazyList[A] =
  // unfolds result list appending the "complement"
    l1 match {
      case LazyList() => LazyList()
      case x #:: y => f(x) match {
        case Some((l, r)) => l #:: r #::  unfold_with_pythcomp(y, f)
          // unfold the map with the complement
      }
    }

  def pythcomp(t: Option[(Int, Int, Int)]):
  Option[((Int, Int, Int), (Int, Int, Int))] = t match {
      //Creates a "complement" to add since (3,4,5) <-> (4,3,5)
    case Some((a, b, c)) => Some((a, b, c), (b, a, c))
  }

  def pythelper(n: Int): LazyList[Option[(Int, Int, Int)]] =
    unfold(Option(1, 1, 1)) {
      // Use unfold to generate list
      case None => None
      case Some(current) =>
        val maybeNext = current match {
          case (`n`, `n`, `n`) => None
          case (x, `n`, `n`) => Some(x + 1, x + 1, x + 1)
          case (x, y, `n`) => Some(x, y + 1, y + 1)
          case (x, y, z) => Some(x, y, z + 1)
        }
        Some((Some(current), maybeNext))
    }.take(nCr(`n`+3-1,3).toInt).filter({ // The formula for the number of combinations with repetition -
      case Some((a,b,c)) => a*a + b*b == c*c    // - allowed of 𝑘 objects from 𝑛 types is  𝑛+𝑘−1C𝑘
                                          // Ensures minimum number of lists is always generated
    })


  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns" + "for" + block.toString)
    result
  }



  def fact(n: Int): BigInt = { // These are just for efficiency, you may ignore
    @tailrec def go(n: Int, acc: BigInt): BigInt =
      if (n <= 0) acc
      else go(n - 1, BigInt(n) * acc)

    go(n, 1)

  }
  def nCr(n: Int, r: Int): BigInt = { // These are just for efficiency, you may ignore
    fact(n)/(fact(n-r) * fact(r))
  }

  // Implementation of unfold

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): LazyList[A] =
    f(z).map((p: (A, S)) => p._1 #:: unfold(p._2)(f)).getOrElse(LazyList.empty[A])


  def main(args: Array[String]): Unit = {
    println(pyth(10))

    val pw = new PrintWriter(new File("ass3.2_prob1.txt" ))
    pw.write(
      "The number of Pythagorean Triples Less than 10 =>" + pyth(10) + "\n" +
        "The number of Pythagorean Triples Less than 20 => " + pyth(20)  + "\n" +
        "The number of Pythagorean Triples Less than 30 =>  "+  pyth(30) + "\n" +
        "The number of Pythagorean Triples Less than 40 =>  "+  pyth(40) + "\n" +
        "The number of Pythagorean Triples Less than 40 =>  "+  pyth(50) + "\n"

    )
    pw.close()
  }



}

