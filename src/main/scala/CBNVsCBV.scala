object CBNVsCBV {


  //called by name and called by value

  def main(args: Array[String]): Unit = {

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

  }


  def calledByValue(x: Long):Unit={
    println(x)
    println(x)
  }

  //powerful stuff can call at time when this will be called, especially in transactional code can be applied at X
  def calledByName(x: =>Long):Unit={

    println(x)
    println(x)

  }
}
