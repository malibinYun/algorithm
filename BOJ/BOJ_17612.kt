package baekjoon

//쇼핑몰
//문제
//대형 쇼핑몰에서 쇼핑을 마친 N명의 고객들이 계산을 하고 쇼핑몰을 떠나고자 계산대 앞에 줄을 서 있다. 각 고객은 커다란 짐수레(cart)에 물건을 담아 계산대로 간다. 쇼핑몰에는 아래 그림과 같이 K개의 계산대가 병렬로 배치되어 있다.  쇼핑몰 안내원들은 계산대에 온 사람들을 가장 빨리 계산을 마칠 수 있는 계산대로 안내를 한다. 안내원은 각 계산대에서 기다리고 있는 사람들이 계산을 하는데 얼마나 걸리는지 이미 알고 있다.
//
//
//
//안내원이 고객을 계산대로 안내할 때 두 계산대에서 기다려야 할 시간이 같을 경우에는 가장 번호가 작은 계산대로 안내를 한다. 즉 3번, 5번 계산대에서 기다릴 시간이 똑같이 15분으로 최소일 경우에는 3번으로 안내를 한다.
//
//계산을 마친 고객은 출구를 통하여 쇼핑몰을 완전히 빠져 나간다. 만일 계산대에서 계산을 마친 고객의 시간이 동일하다면 출구에 가까운 높은 번호 계산대의 고객부터 먼저 빠져나간다. 예를 들어 두 계산대 4번과 10번에서 두 고객이 동시에 계산을 마쳤다면 계산대의 번호가 더 높은 10번 계산대의 고객이 먼저 쇼핑몰을 나간다. 물건을 계산하는 데에는 종류에 관계없이 동일하게 1분이 소요된다. 즉, 물건이 w개 있는 손님이 계산을 마치는 데에는 정확히 w분이 소요된다.
//
//여러분은 계산대로 들어가기 위하여 줄을 서 있는 고객 N명의 정보( 회원번호, 구매한 물건의 수)를 알고 있을 때, 이들이 계산을 하고 쇼핑몰을 빠져나오는 순서를 구해야 한다. 계산대로 들어가고 계산대에서 나오는데 걸리는 시간은 없다고 가정한다.
//
//입력
//입력의 첫 줄에는 2개의 정수 N(1 ≤ N ≤ 100,000)과 k(1 ≤ k ≤ 100,000)가 주어진다. 다음 줄부터 N개의 줄에 걸쳐 고객 N명의 정보가 줄 맨 앞의 고객부터 맨 뒤 고객까지 순서대로 주어진다. i번째 줄은 줄의 앞에서 i번째 고객의 회원번호 idi(1 ≤ idi ≤ 1,000,000)와 그가 구입한 물건의 수 wi(1 ≤ wi ≤ 20)로 이루어져 있다. N명의 회원번호는 모두 다르다.
//
//출력
//고객 N명의 회원번호를 쇼핑몰을 빠져나가는 순서대로 r1, r2, ..., rN이라 할 때, 1×r1 + 2×r2 + ... + N×rN의 값을 출력한다. 출력값이 int 범위를 넘어갈 수 있음에 유의하라.
//
//예제 입력 1
//10 3
//123 4
//21 5
//34 14
//56 1
//45 7
//723 5
//55 7
//13 5
//910 10
//73 3
//예제 출력 1
//13900

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (customerCount, counterCount) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val counterPool = PriorityQueue<Counter>((1..counterCount).map { Counter(it) })
    val customers = mutableListOf<Customer>()
    repeat(customerCount) {
        val (id, stuffCount) = bufferedReader.readLine().split(" ").map { it.toLong() }

        val counter = counterPool.poll()
        counter.accTime += stuffCount
        val customer = Customer(id, counter.accTime, counter.number)
        customers.add(customer)
        counterPool.add(counter)
    }
    customers.sort()
    var answer = 0L
    for (i in customers.indices) {
        answer += customers[i].id * (i + 1)
    }
    println(answer)
}

data class Customer(
    val id: Long,
    var accMinTime: Long,
    var counterNumber: Int
) : Comparable<Customer> {

    override fun compareTo(other: Customer): Int = when {
        this.accMinTime > other.accMinTime -> 1
        this.accMinTime < other.accMinTime -> -1
        else -> when {
            this.counterNumber < other.counterNumber -> 1
            this.counterNumber > other.counterNumber -> -1
            else -> 0
        }
    }
}

data class Counter(
    val number: Int,
    var accTime: Long = 0L
) : Comparable<Counter> {

    override fun compareTo(other: Counter): Int = when {
        this.accTime > other.accTime -> 1
        this.accTime < other.accTime -> -1
        else -> when {
            this.number > other.number -> 1
            this.number < other.number -> -1
            else -> 0
        }
    }
}
