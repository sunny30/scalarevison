package oops

object ScalaObject1 {

  def main(args: Array[String]): Unit = {
    val sc: SampleClass = SampleClass(3)
    val sc1 = SampleClass(3)
    val sc2 = SampleClass



    SampleClass.staticUtil //like a static util :)
    sc.printTask()

    println(sc == sc1)
    println(sc == sc2)
  }


}
//all the operators are function in  scala

class SampleClass(val n: Int) {


  def printTask(): Unit = {
    println(n)
  }

  def ==(sc:SampleClass):Boolean={
    this.n==sc.n
  }
}

object SampleClass {

  def apply(n: Int): SampleClass = new SampleClass(n)

  def apply(): SampleClass = new SampleClass(1)



  def staticUtil: Unit = {
    println("hello")
  }
}
