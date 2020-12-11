object session {

  def and(a:Boolean, b:Boolean):Boolean = {
    if (a) b else false
  }

  def or(a:Boolean, b:Boolean): Boolean = {
    if (a) a else b
  }

  and (true, false)
  and (false,true)
  and (false,false)
  and(true,true)

  or(false,false)
  or(false,true)
  or(false,true)
  or(true,true)

}