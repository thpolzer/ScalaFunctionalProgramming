object session {
  val romanNumerals = Map ("I"->1,"V"->5,"X"->10,"L"->50,"C"->100,"M"->1000)
  romanNumerals("I")
  romanNumerals("L")

  val capitalOfCountry = Map("US"->"Washington D.C", "Switzerland"->"Bern")

  // check whether a key exists
  //capitalOfCountry("Andorra")
  capitalOfCountry get ("Andorra")
  capitalOfCountry get ("US")
}