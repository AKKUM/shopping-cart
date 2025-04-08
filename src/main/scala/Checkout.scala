package com.akkum

sealed abstract trait Item {
  def name: String
  def price: BigDecimal
}

case object Apple extends Item {

  override def price: BigDecimal = 0.60
  override def name: String = "Apple"

  def buyOneGetOneFree (itemAmount: Int): BigDecimal = {
    Math.ceil(itemAmount.toDouble / 2) * price
  }
}

case object Orange extends Item {

  override def price: BigDecimal = 0.25
  override def name: String = "Orange"
  
  def threeForTwo (items : Seq[Item]) : BigDecimal = {
    items.grouped(3).map {
      group => group.take(2).map(_.price).sum
    }
  }.sum
}

class Checkout {

  def calculate (items: Seq[String]) : BigDecimal = {
    val itemList = items.map {
      case "Apple" => Apple
      case "Orange" => Orange
    }
    val grouped = itemList.groupBy(_.name)
    applyOffers(grouped)

  }

  def applyOffers(itemsGroup: Map[String, Seq[Item]]) : BigDecimal = {

    itemsGroup.map {
      case ("Apple", appleItems) => {
        Apple.buyOneGetOneFree(appleItems.size)
        
      }
      case ("Orange", orangeItems) => Orange.threeForTwo(orangeItems)

    }.sum
  }

}


