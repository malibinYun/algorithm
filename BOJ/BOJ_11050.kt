package baekjoon

// 이항 계수 1
//
//문제
//자연수 과 정수 가 주어졌을 때 이항 계수
//를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 과 가 주어진다. (1 ≤  ≤ 10, 0 ≤  ≤ )
//
//출력
//
//를 출력한다.
//
//예제 입력 1
//5 2
//예제 출력 1
//10

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    var (N, K) = bufferedReader.readLine().split(" ").map { it.toInt() }
    if (K == 0 || N == K) {
        println(1)
    } else {
        if ((N - K) < K) K = N - K
        var total = 1
        for (i in 1..K) {
            total *= N
            N--
        }
        for (j in 1..K) {
            total /= j
        }
        println(total)
    }
}
