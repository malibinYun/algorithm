package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

// 미네크래프트
//문제
//미네크래프트에 있는 디디는 집을 짓기 위해 돌을 채취하려고 한다. N개의 바위들이 일렬로 놓여져 있고, 디디는 현재 첫 번째 바위에 위치해 있다. 각 바위 i는 서로 같거나 다른 강도를 가지고 있어서, 바위에서 돌을 채취하기 위해 해야 하는 곡괭이질의 수 Ki 또한 서로 같거나 다르다. 디디는 돌을 채취하기 위해 다음과 같은 행동을 할 수 있다.
//
//시간 1을 소비하여, 디디가 위치해 있는 바위에 곡괭이질을 1번 한다.
//시간 P를 소비하여, 이웃한 바위로 이동한다.
//디디에게 T만큼의 시간이 주어졌을 때, 채취할 수 있는 돌의 최대 개수를 출력하는 프로그램을 작성하라.
//
//입력
//첫째 줄에 정수 N(1 ≤ N ≤ 105), T(1 ≤ T ≤ 109), P(1 ≤ P ≤ 105)가 공백으로 구분되어 주어진다.
//
//둘째 줄에 바위 i(i = 1, 2, ..., N)를 채취하기 위해 필요한 곡괭이질의 수 Ki(1 ≤ Ki ≤ 105)가 공백으로 구분되어 주어진다.
//
//출력
//문제의 정답을 출력하라.
//
//예제 입력 1 
//6 17 1
//3 5 2 6 9 1
//예제 출력 1 
//4

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val cursor = bufferedReader.readLine().split(" ")
    val rockCount = cursor[0].toInt()
    val time = cursor[1].toLong()
    val moveTime = cursor[2].toLong()

    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    var sumTimes = 0L
    var count = 0
    val rocks = bufferedReader.readLine().split(" ").map { it.toInt() }
    repeat(rockCount) {
        priorityQueue.add(rocks[it])
        sumTimes += rocks[it]
        while (sumTimes > time - moveTime * it) {
            val removeRock = priorityQueue.poll() ?: break
            sumTimes -= removeRock
        }
        count = max(count, priorityQueue.size)
    }
    println(count)
}

// 각 바위로 옮길때마다 해당 바위에서 쓸 수 있는 총 시간이 달라진다고 생각하면 되겟다.
//  3   5   2   6   9   1
//  17  16  15  14  13  12
//  totalTime - moveTime * index 이런 식으로.
// 바위를 처음부터 하나씩 넣고, 총합이 해당 바위에서 사용할 수 있는 총 시간보다 크다면,
// 현재 캔 바위는 캐지 못하는 바위이므로 뱉어버리고 다음껄로 넘어간다.
// 이것을 무한반복.
// 이걸 대체 어떻게 생각한걸까 이양반들은 ...
// 아직 다 이해되지 않은 코드이다. 더 공부해야한다.
