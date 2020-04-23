// 감소하는 수
// 문제
//음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
//
//입력
//첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 N번째 감소하는 수를 출력한다.
//
//예제 입력 1
//18
//예제 출력 1
//42

package baekjoon

import java.util.*

var descendingNum = LongArray(1023) { it.toLong() }
val queue: Queue<Long> = LinkedList<Long>(descendingNum.toList().subList(1, 10))
var index = 9

fun main() {
    val n = readLine()!!.toInt()

    if (n < 10) {
        println(descendingNum[n])
        return
    }

    if (n > 1022) {
        println(-1)
        return
    }

    while (index <= n) {
        if(queue.isEmpty()) break
        val front = queue.remove()
        for (i in 0 until front % 10) {
            val newNum = front * 10 + i
            descendingNum[++index] = newNum
            queue.add(newNum)
        }
    }
    print(descendingNum[n])
}
