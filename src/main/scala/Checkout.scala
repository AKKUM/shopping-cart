package com.akkum

sealed trait Item {
  def name: String
  def price: BigDecimal
}

case object Apple extends Item {

  override def price: BigDecimal = 0.60
  override def name: String = "Apple"
}

case object Orange extends Item {

  override def price: BigDecimal = 0.25
  override def name: String = "Orange"
}

class Checkout {
  
  def calculate (items: Seq[String]) : BigDecimal = {
    items.map {
      case "Apple" => Apple.price
      case "Orange" => Orange.price  
    }.sum
  }
  
}


