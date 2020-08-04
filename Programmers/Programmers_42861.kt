import kotlin.math.max
import kotlin.math.min

//섬 연결하기
//문제 설명
//n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
//
//다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
//
//제한사항
//
//섬의 개수 n은 1 이상 100 이하입니다.
//costs의 길이는 ((n-1) * n) / 2이하입니다.
//임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
//같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
//모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
//연결할 수 없는 섬은 주어지지 않습니다.
//입출력 예
//
//n	costs	return
//4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
//입출력 예 설명
//
//costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.

fun main() {
    val stub = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(0, 2, 2),
        intArrayOf(1, 2, 5),
        intArrayOf(1, 3, 1),
        intArrayOf(2, 3, 8)
    )
    val clazz = Programmers_42861()
    println(clazz.solution(4, stub))
}

class Programmers_42861 {

    lateinit var cycleMap: MutableMap<Int, Int>

    fun solution(n: Int, costs: Array<IntArray>): Int {
        cycleMap = createCycleMap(n)

        val selectedEdges = mutableListOf<Edge>()
        val edges = costs.map { Edge(*it) }.sortedBy { it.weight }
        println(edges)
        for (edge in edges) {
            if (isUnion(edge.from, edge.to)) {
                println()
                continue
            }
            union(edge.from, edge.to)
            println()
            selectedEdges.add(edge)
        }
        return selectedEdges.sumBy { it.weight }
    }

    private fun createCycleMap(n: Int): MutableMap<Int, Int> {
        val cycleMap = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            cycleMap[i] = i
        }
        return cycleMap
    }

    private fun find(n: Int): Int {
        println("n : $n cycleMap[n] : ${cycleMap[n]}")
        if (cycleMap[n] == n) return n

        val aa = find(cycleMap[n]!!)
        cycleMap[n] = aa

        return aa
    }

    private fun union(from: Int, to: Int) {
        val fromRoot = find(from)
        val toRoot = find(to)
        cycleMap[toRoot] = fromRoot
    }

    private fun isUnion(from: Int, to: Int): Boolean {
        val fromRoot = find(from)
        val toRoot = find(to)
        return cycleMap[fromRoot] == cycleMap[toRoot]
    }

    class Edge(vararg data: Int) {
        val from: Int = min(data[0], data[1])
        val to: Int = max(data[0], data[1])
        val weight: Int = data[2]
    }
}


// 크루스칼 알고리즘 + union-find 알고리즘 없이 푼 코드..
//class Solution {
//    fun solution(n: Int, costs: Array<IntArray>): Int {
//        var cost = 0
//        val sortedCosts = costs.sortedBy { it[2] }
//        val visitedIslands = HashSet<Int>()
//        var builtBridgeCount = 0
//
//        while(builtBridgeCount != n - 1) {
//            if(builtBridgeCount != 0) {
//                val nextBridge = sortedCosts.first {
//                    visitedIslands.contains(it[0]) && !visitedIslands.contains(it[1])
//                            || visitedIslands.contains(it[1]) && !visitedIslands.contains(it[0])
//                }
//                cost += nextBridge[2]
//                visitedIslands.add(nextBridge[0])
//                visitedIslands.add(nextBridge[1])
//                builtBridgeCount++
//            } else {
//                val firstBridge = sortedCosts.first()
//                cost = firstBridge[2]
//                visitedIslands.add(firstBridge[0])
//                visitedIslands.add(firstBridge[1])
//                builtBridgeCount++
//            }
//        }
//        return cost
//    }
//}
