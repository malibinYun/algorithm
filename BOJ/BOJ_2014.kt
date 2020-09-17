package baekjoon

// 소수의 곱
//문제
//K개의 소수가 있다. 이때, 이 소수들 중에서 몇 개를 곱해서 얻게 되는 수들이 있을 것이다. 소수들을 선택할 때에는 같은 수를 선택해도 되며, 주어지는 소수 자체도 포함시키자.
//
//예를 들어 세 소수가 2, 5, 7이었다면, 이러한 곱들을 오름차순으로 나타내 보면, 2, 4, 5, 7, 8, 10, 14, 16, 20, 25, 28, 32, 35, 등이 된다.
//
//K개의 소수가 주어졌을 때, 이러한 소수의 곱들 중에서 N번째 수를 구해 보자. 단 정답은 231보다 작은 자연수이다.
//
//입력
//첫째 줄에 K(1 ≤ K ≤ 100), N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 K개의 소수가 오름차순으로 주어진다. 같은 소수가 여러 번 주어지는 경우는 없으며, 주어지는 소수는 모두 541보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 문제에서 설명한 대로 소수의 곱을 나열했을 때, N번째 오는 것을 출력한다.
//
//예제 입력 1
//4 19
//2 3 5 7
//예제 출력 1
//27

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
//    val runtime = Runtime.getRuntime()
//    runtime.gc()
//    println("used : ${(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)}MB")

    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (primeCount, N) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val primeNumbers = bufferedReader.readLine().split(" ").map { it.toLong() }
    val priorityQueue = PriorityQueue<Long>(primeNumbers)
    val memory = HashSet<Long>(primeNumbers)

    repeat(N - 1) {
        val number = priorityQueue.poll()
        for (primeNumber in primeNumbers) {
            val newNumber = number * primeNumber
            if (memory.contains(newNumber)) continue
            priorityQueue.add(newNumber)
            memory.add(newNumber)

            if (number % primeNumber == 0L) break
        }
    }
    println(priorityQueue.peek())
//    println("size : ${priorityQueue.size}")
//    println("used : ${(runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)}MB")
}

// 중복된 수를 큐에 넣는것을 방지하기 위해서 또, 최소한의 숫자를 넣기위해서
// 큐에서 꺼낸 수와 소수들을 곱할 때, 꺼낸 수가 소수의 약수이면 더이상의 소수들과의 곱을 수행하지 않는다.
// 참 이해가 잘 되지 않는구나...
