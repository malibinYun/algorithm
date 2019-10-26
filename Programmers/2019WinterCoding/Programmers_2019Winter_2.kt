package programmers

fun main() {
    val clazz = Programmers_2019Winter_2()

    println(clazz.solution(1).toList())
    println(clazz.solution(2).toList())
    println(clazz.solution(3).toList())
    //println(clazz.solution(20).toList())
}

class Programmers_2019Winter_2 {
    fun solution(n: Int): IntArray {
        var answer = intArrayOf(0)

        for (i in 1 until n) {
            val reverse = reverseArr(answer)
            answer = answer.plus(0).plus(reverse)
        }

        return answer
    }

    fun reverseArr(arr: IntArray): IntArray {
        val reverse = IntArray(arr.size) { 0 }

        for (i in 0 until arr.size) {
            if (arr[i] == 0) {
                reverse[arr.size - 1 - i] = 1
            }
        }
        return reverse
    }
}