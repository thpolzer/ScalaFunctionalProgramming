object exercise2 {
  def balance (chars:List[Char]):Boolean = {
    def checkBalance(counter: Int, chars:List[Char]): Boolean ={
      if (chars.isEmpty && counter == 0)true
      else if (chars.isEmpty && counter > 0)false
      else if (chars.head == ')' && counter == 0)false
      else if (chars.head == ')' && counter > 0)checkBalance(counter-1,chars.tail)
      else if (chars.head == '(')checkBalance(counter+1,chars.tail)
      else checkBalance(counter,chars.tail)
    }
    checkBalance(0,chars)
  }

  var mylist = "()".toList
  balance(mylist)


}