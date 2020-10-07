package baekjoon

// 1로 만들기
//문제
//정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
//
//입력
//첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
//
//출력
//첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
//
//예제 입력 1
//2
//예제 출력 1
//1
//예제 입력 2
//10
//예제 출력 2
//3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BOJ_1463.solution()
}

class BOJ_1463 {
    companion object {
        private val isVisited = BooleanArray(1_000_001) { false }

        fun solution() {
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val targetNumber = bufferedReader.readLine().toInt()
            val queue = LinkedList(listOf(Number(1)))

            while (queue.isNotEmpty()) {
//                println(queue)
                val number = queue.poll()
                if (number.value == targetNumber) {
                    println(number.count)
                    break
                }
//                queue.addAll(number.nexts(targetNumber))
                val first = number.value + 1
                val second = number.value * 2
                val third = number.value * 3

                if (first <= targetNumber && !isVisited[first]) {
                    isVisited[first] = true
                    queue.add(Number(first, number.count + 1))
                }
                if (second <= targetNumber && !isVisited[second]) {
                    isVisited[second] = true
                    queue.add(Number(second, number.count + 1))
                }
                if (third <= targetNumber && !isVisited[third]) {
                    isVisited[third] = true
                    queue.add(Number(third, number.count + 1))
                }
            }
        }

        data class Number(
            val value: Int,
            val count: Int = 0
        ) {
//            fun nexts(targetNumber: Int): List<Number> = setOf(value + 1, value * 2, value * 3).asSequence()
//                .filter { it <= targetNumber && !isVisited[it] }
//                .map { Number(it, count + 1) }
//                .toList()
//                .also { it.forEach { number -> isVisited[number.value] = true } }

        }
    }
    // 흠.. 시퀀스를 쓰니 오히려 메모리 초과가 났다.. 아무래도 메모리를 엄청 먹나보다.
}
