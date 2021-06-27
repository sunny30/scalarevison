package oops

object ScalaInheritence {

  def main(args: Array[String]): Unit = {
    val citizen = Citizen("Sunny",34,"India")
    println(citizen.signature())
    citizen.printerName()
  }

  class Human(val name:String,val age:Int){
    def signature():String={
      name+" "+age
    }

    def printerName():Unit={
      println(name)
    }

  }

  class Citizen(override  val name:String, override val age:Int, country:String) extends Human(name,age)
  {
    override def signature(): String = {
      s"""${this.name} $age $country"""
    }
  }

  object Citizen{
    def apply(name: String, age: Int, country: String): Citizen = new Citizen(name, age, country)
  }

}
