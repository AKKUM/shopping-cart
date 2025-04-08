package com.akkum

sealed trait Item {
  def name: String
  def price: BigDecimal
}

case object Apple extends Item {

  override def price: BigDecimal = 0.60
  override def name: String = "Apple"

  def buyOneGetOneFree (items : Seq[Item]): BigDecimal = {
    val itemAmount = items.size
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

case object Banana extends Item {

  override def name: String = "Banana"

  override def price: BigDecimal = 0.20

  def buyOneGetOneFree (items : Seq[Item]): BigDecimal = {
    val itemAmount = items.size
    Math.ceil(itemAmount.toDouble /2)* price
  }

}

class Checkout {

  def calculate (items: Seq[String]) : BigDecimal = {
    val itemList = items.map {
      case "Apple" => Apple
      case "Orange" => Orange
      case "Banana" => Banana
    }
    val grouped = itemList.groupBy(_.name)
    val requiredKey = Set("Apple", "Banana")
    val actualKey = applyOffers(grouped).keySet
    if(requiredKey.subsetOf(actualKey)){
      val v = applyOffers(grouped).minBy(_._2)
      (applyOffers(grouped) - v._1).values.sum
    } else {
      applyOffers(grouped).values.sum
    }
  }

  private def applyOffers(itemsGroup: Map[String, Seq[Item]]) : Map[String, BigDecimal] = {
    itemsGroup.map {
      case ("Apple", appleItems) => "Apple" -> Apple.buyOneGetOneFree(appleItems)
      case ("Orange", orangeItems) => "Orange" -> Orange.threeForTwo(orangeItems)
      case ("Banana", bananaItems)  => "Banana" -> Banana.buyOneGetOneFree(bananaItems)
      case (name, items) => name -> items.map(_.price).foldLeft(BigDecimal(0))(_+_)
    }
  }

}


