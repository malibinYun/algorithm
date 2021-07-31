package baekjoon

// 최대공약수와 최소공배수
//
//문제
//두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
//
//출력
//첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
//
//예제 입력 1
//24 18
//예제 출력 1
//6
//72

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val gcd = BOJ_2609.gcd(x, y)
    println(gcd)
    println(x * y / gcd)
}

class BOJ_2609 {

    companion object {
        tailrec fun gcd(a: Int, b: Int): Int {
            if (b == 0) return a
            return gcd(b, a % b)
        }
    }
}
