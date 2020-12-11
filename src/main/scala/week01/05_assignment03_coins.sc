object exercise3 {

  def countChanges(money: Int, coins: List[Int]): Int = {

    def calcCountChanges(money: Int, coins: List[Int]): Int = {

      if (money == 0 || coins.isEmpty)0
      else if (money - coins.head == 0)1
      else if (money - coins.head < 0)0
      else calcCountChanges(money - coins.head,coins) + calcCountChanges(money,coins.tail)


    }


    calcCountChanges(money,coins.sorted)

  }

  val coins = List(5,2,1)
  countChanges(9,coins)

}