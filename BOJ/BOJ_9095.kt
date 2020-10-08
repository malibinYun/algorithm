package baekjoon

//1, 2, 3 더하기
//문제
//정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
//
//1+1+1+1
//1+1+2
//1+2+1
//2+1+1
//2+2
//1+3
//3+1
//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
//
//출력
//각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
//
//예제 입력 1
//3
//4
//7
//10
//예제 출력 1
//7
//44
//274

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BOJ_9095().solution()
}

class BOJ_9095 {
    fun solution() {
        val stringBuilder = StringBuilder()
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val testCount = bufferedReader.readLine().toInt()
        repeat(testCount) {
            val input = bufferedReader.readLine().toInt()
            val queue = LinkedList(listOf(0))
            var count = 0
            while (queue.isNotEmpty()) {
                val number = queue.poll()
                if (number == input) {
                    count++
                    continue
                }
                val first = number + 1
                val second = number + 2
                val third = number + 3

                if (first <= input) {
                    queue.add(first)
                }
                if (second <= input) {
                    queue.add(second)
                }
                if (third <= input) {
                    queue.add(third)
                }
            }
            stringBuilder.append("$count\n")
        }
        print(stringBuilder.toString())
    }

}
