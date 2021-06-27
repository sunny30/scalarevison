package patternmatching

import scala.util.Random

object PM1 {

  def main(args: Array[String]): Unit = {
    val random = new Random()
    val res = random.nextInt(3)
    println(res)
    val description = res match {
      case y@1 => "THE ONE"
      case z@2 => "THE TWO"
      case _=> "THE WILD"
    }
    println(description)


    case class Persron(name:String,id:Int)
    val sunny = Persron("sunny",89)

    val sdes = sunny match {
      case x@Persron("name", id)=>"GENERIC NAME"
      case y@Persron(_, 89)=> s"GOT 89 name is ${y.name}"
    }
    println(sdes)
    val exp = Product(Sum(Number(1),Number(2)),Sum(Number(3),Number(4),Product(Number(1),Number(9))))
    val exp1 = Sum(Number(1),Number(2))
    val formatString = getFormatString(exp)
    println(formatString)

  }

  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(expr: Expr*) extends Expr
  case class Product(expr: Expr*) extends Expr


 // val exp = Product(Sum(Number(1),Number(2)),Sum(Number(3),Number(4),Product(Number(1),Number(9))))


  def getFormatString(expr: Expr):String={

    expr match {
      case a@Number(n)=>s"${a.n}"
      case s@Sum(expr@_*) =>{
        s"(${s.expr.map(e=>{
          getFormatString(e)
        }).mkString("+")
        })"
      }
      case p@Product(expr@_*)=>{
        s"(${p.expr.map(e=>{
          getFormatString(e)
        }).mkString("*")
        })"
      }
    }

  }





}
