package baekjoon

// 트리의 지름
//문제
//트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
//
//입력
//트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2≤V≤100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. (정점 번호는 1부터 V까지 매겨져 있다고 생각한다)
//
//먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.
//
//출력
//첫째 줄에 트리의 지름을 출력한다.
//
//예제 입력 1
//5
//1 3 2 -1
//2 4 4 -1
//3 1 2 4 3 -1
//4 2 4 3 3 5 6 -1
//5 4 6 -1
//예제 출력 1
//11

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    BOJ_1167().solution()
}

class BOJ_1167 {
    private lateinit var graph: HashMap<Int, MutableList<Int>>
    private lateinit var weights: HashMap<Pair<Int, Int>, Int>
    private lateinit var isVisited: BooleanArray
    private var max = Int.MIN_VALUE
    private var maxIndex = 0

    fun solution() {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val vertexCount = bufferedReader.readLine().toInt()
        graph = HashMap()
        weights = HashMap()
        repeat(vertexCount) {
            val cursor = bufferedReader.readLine().split(" ").map(String::toInt)
            val vertex = cursor[0]
            for (i in 1 until cursor.size step 2) {
                if (cursor[i] == -1) break
                val otherVertex = cursor[i]
                val weight = cursor[i + 1]

                graph.computeIfAbsent(vertex) { mutableListOf() }.add(otherVertex)
                weights[Pair(min(vertex, otherVertex), max(vertex, otherVertex))] = weight
            }
        }
        isVisited = BooleanArray(vertexCount + 1) { false }

        travel(1, 0)
        max = Int.MIN_VALUE
        for (i in isVisited.indices) {
            isVisited[i] = false
        }
        travel(maxIndex, 0)

        println(max)
    }

    private fun travel(start: Int, acc: Int) {
        isVisited[start] = true
        if (max < acc) {
            max = acc
            maxIndex = start
        }
        for (nextVisit in graph[start]!!) {
            if (isVisited[nextVisit]) continue
            val pair = Pair(min(start, nextVisit), max(start, nextVisit))
            travel(nextVisit, acc + weights[pair]!!)
        }
        isVisited[start] = false
    }
}
