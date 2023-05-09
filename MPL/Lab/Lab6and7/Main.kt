//Дано натуральное число P. Найдите все простые числа, не превосходящие числа P

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

fun main() {
    
    val p = readLine()
    
    for (i in 2..p) {
        if (isPrime(i)) {
            println(i)
        }
    }
}

