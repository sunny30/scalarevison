package oops

object ScalaExceptionHandling {

  def main(args: Array[String]): Unit = {
    tryCatch()
  }


  def get42(isException:Boolean):Int={
    if(isException)
      throw new RuntimeException("thrown error")
    else{
       42
    }
  }

  def tryCatch():Unit={
    try{
      get42(true)
    }catch{
      case e:RuntimeException=> println(e.getMessage)
    }finally {
      println("Done")
    }
  }
}
