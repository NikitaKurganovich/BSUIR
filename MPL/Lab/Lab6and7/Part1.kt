//Дано натуральное число P. Найдите все простые числа, не превосходящие числа P
import java.util.Scanner

fun main() {
    val reader = Scanner(System.`in`)
    print("Entre a natural number: ")
    val p:Int = reader.nextInt()

    for (i in 2..p) {
        if (isPrime(i)) {
            println(i)
        }
    }
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) {
        return false
    }
    for (i in 2..n / 2) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}