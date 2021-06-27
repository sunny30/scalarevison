package oops

object ScalaAbstractAndTrait {

  def main(args: Array[String]): Unit = {
    val macBook = new MacBook("grey macbook", 64)
    println(macBook.compute(100))


    val linkList = new LinkList(4)
    linkList.add(3)
    linkList.add(2)
    linkList.add(1)
    linkList.printList(linkList.head.asInstanceOf[LinkList])
  }

  abstract class Machine(name: String) {
    val id: String = "machine"
    val typeMachine = "simple machine"

    def performTask: Unit = {
      println("Machine Perform task")
    }


  }

  abstract class Laptop(val name: String, val architecture: Int) extends Machine(name = name) {
    def compute: Unit = {
      performTask
    }

    val yor: Int

    def compute(frequency: Int): Int
  }

  class MacBook(name: String, architecture: Int) extends Laptop(name, architecture = architecture) {
    override val yor: Int = 2020
    override val typeMachine: String = "Apple Macbook"

    override def compute(frequency: Int): Int = {
      frequency / 10
    }
  }

  //trait cannot have constructor parameter
  // multiple trait can be implemented
  abstract class MyList {
    var head: MyList
    var next: MyList

    // val value:Int
    def add(vaue: Int): MyList

    def isEmpty: Boolean
  }

  class LinkList(val nodeValue: Int) extends MyList {
    override var head: MyList = null
    override var next: MyList = null

    // override val value: Int = -1
    override def isEmpty: Boolean = {
      if (head.equals(null))
        true
      else
        false
    }


    override def add(vaue: Int): MyList = {
      val node = new LinkList(vaue)
      if(head==(null)){
        head = node
        head.next =null
      }else {
        //val node = new LinkList(vaue)
        node.next = head
        this.head = node
      }
      // head.value = node.nodeValue
      this.head
    }

    def printList(head: LinkList): Unit = {

      println(head.nodeValue)
      if (head.next != null)
        printList(head.next.asInstanceOf[LinkList])

    }
  }


}
