package baekjoon

// 수 정렬하기 4
//
//문제
//N개의 수가 주어졌을 때, 이를 내림차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//출력
//첫째 줄부터 N개의 줄에 내림차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력 1
//5
//1
//2
//3
//4
//5
//예제 출력 1
//5
//4
//3
//2
//1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val count = bufferedReader.readLine().toInt()
    val numbers = mutableListOf<Int>()
    repeat(count) {
        numbers.add(bufferedReader.readLine().toInt())
    }
    numbers.sortedDescending()
        .joinToString("\n")
        .also { println(it) }
}
