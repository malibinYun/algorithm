//가장 큰 수
//
//문제 설명
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//numbers의 길이는 1 이상 100,000 이하입니다.
//numbers의 원소는 0 이상 1,000 이하입니다.
//정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//입출력 예
//numbers	return
//[6, 10, 2]	6210
//[3, 30, 34, 5, 9]

import java.util.*
import kotlin.Comparator

fun main() {
    val stub1 = intArrayOf(6, 10, 2)
    val stub2 = intArrayOf(3, 30, 34, 5, 9)
    val stub3 = intArrayOf(40, 404)
    val stub4 = intArrayOf(70, 0, 0, 0)
    val stub5 = intArrayOf(2, 22, 223)
    val stub6 = intArrayOf(110, 1, 10, 101, 100)

    println(solution(stub1))
    println(solution(stub2))
    println(solution(stub3))
    println(solution(stub4))
    println(solution(stub5))
}

fun solution(numbers: IntArray): String {
    if (numbers.all { it == 0 }) {
        return "0"
    }
    return ArrayList(numbers.map { it.toString() })
        .sortedWith(Comparator { s1, s2 -> (s2 + s1).compareTo(s1 + s2) })
        .joinToString(separator = "")
}

//fun solution(numbers: IntArray): String { //실패
//    if (numbers.all { it == 0 }) {
//        return "0"
//    }
//    return ArrayList(numbers.map {
//        if (it.toString().length == 1) {
//            return@map ("${it}00$")
//        }
//        if (it.toString().length == 2) {
//            return@map ("${it}0#")
//        }
//        if (it.toString().length == 3) {
//            return@map ("$it@")
//        }
//        it.toString()
//    })
//        .sortedDescending()
//        .joinToString(separator = "") {
//            it.replace("00\$", "")
//                .replace("0#", "")
//                .replace("@", "")
//        }
//}
