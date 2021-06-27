package collections

object ScalaOptions {

  def main(args: Array[String]): Unit = {

    println(getterString())
    print(propergetter().get)

    val h = "bc.com"
    val p = "80"
    h.flatMap(x=>p.flatMap(y=> {
      println(x,y)
      ""
    }))
  }

  def unsafeMethod():String=null
  def backupMethod:String="No value"
  def getterString():String={
    val res = Option(unsafeMethod())
    res.getOrElse(backupMethod)
  }


  def propergetter():Option[String]={
    Option(unsafeMethod()).orElse(Option(backupMethod))
  }

}
