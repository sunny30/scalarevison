package implicits

object Implicits1 {

  def main(args: Array[String]): Unit = {
    case class Person(name:String){
      def greet:Unit={
        println(s"Hello ${name}")
      }
    }

    implicit def stringtoPerson(name:String):Person={
      Person(name)
    }

    "Sunny".greet


    def inc(x:Int)(implicit amount:Int):Int=x+amount

    implicit val a = 10
    println(inc(2))




  }





}
