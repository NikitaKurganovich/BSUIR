//Используя перегрузку методов, создайте программу для перевода часов и минут в минуты и для перевода минут в часы и минуты.
import java.util.Scanner

fun convert(hours: Int, minutes: Int): Int {
    return (hours * 60) + minutes
}

fun convert(minutes: Int): Pair<Int, Int> {
    val hours = minutes / 60
    val remainingMinutes = minutes % 60
    return Pair(hours, remainingMinutes)
}

fun main() {
    val reader = Scanner(System.`in`)
    print("Entre a hours: ")
    val hours:Int = reader.nextInt()

    print("Entre a minutes: ")
    val minutes:Int = reader.nextInt()

    val convertedMinutes = convert(hours, minutes)
    println("$hours hours and $minutes minutes is equal to $convertedMinutes minutes")
    
    print("Entre a minutes: ")
    val totalMinutes:Int = reader.nextInt()

    val (hours2, minutes2) = convert(totalMinutes)
    println("$totalMinutes minutes is equal to $hours2 hours and $minutes2 minutes")
}




