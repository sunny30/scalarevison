object GCDFunction {

  def main(args: Array[String]): Unit = {

    println(gcd(7,27))
    println(gcd(9,27))
  }

  def gcd(a:Int, b:Int):Int={
    if(b==0)
      return a
    else{
       gcd(b, a%b) ;
    }
  }
}
