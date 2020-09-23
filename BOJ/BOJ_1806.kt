package baekjoon

// 부분합
//문제
//10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다. 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.
//
//출력
//첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
//
//예제 입력 1 
//10 15
//5 1 3 5 10 7 4 9 2 8
//예제 출력 1 
//2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val tokens = StringTokenizer(bufferedReader.readLine())
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = tokens.nextToken().toInt()
    }

    var minLength = Int.MAX_VALUE
    var tailIndex = 0
    var headIndex = 0
    var sum = numbers[0]
    while (true) {
        if (sum >= s) {
            minLength = min(minLength, headIndex - tailIndex + 1)
        }
        if (sum <= s) {
            if (headIndex >= numbers.size - 1) break
            sum += numbers[++headIndex]
        } else {
            sum -= numbers[tailIndex++]
        }
    }
    if (minLength == Int.MAX_VALUE) println(0)
    else println(minLength)
}
//이건 투포인터 사용해서 두번째로 푼거 밑은 처음 푼거

//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//import kotlin.math.min
//
//fun main() {
//    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
//    val (n, S) = bufferedReader.readLine().split(" ").map { it.toInt() }
//    val numbers = IntArray(n)
//    val tokens = StringTokenizer(bufferedReader.readLine())
//    for (i in 0 until n) {
//        numbers[i] = tokens.nextToken().toInt()
//    }
//    var minLength = Int.MAX_VALUE
//    for (i in numbers.indices) {
//        var sum = 0
//        for (j in i until numbers.size) {
//            sum += numbers[j]
//            if (sum >= S) {
//                minLength = min(minLength, j - i + 1)
//                break
//            }
//        }
//    }
//    if (minLength == Int.MAX_VALUE) println(0)
//    else println(minLength)
//}
//처음했던 이 코드도 맞았던거다. ㅅㅂ ㅋㅋ stringTokenizer를 애용하자 ^^
