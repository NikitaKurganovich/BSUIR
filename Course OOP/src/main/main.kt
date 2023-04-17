import course.*
import main.coursefiles.*
fun main(){
    val petya = User("Petr","GGs")
    val item = Item(2.0,ITEM_DESCRIPTION,"Item")
    println("User's name is ${petya.login}")
    println(item.itemName)
    println(item.description)
    val rect = Drawing()
    val temp = Pricol()
    temp.sayNigger()
    rect.draw()
}