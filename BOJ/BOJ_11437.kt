package baekjoon

// LCA
//문제
//N(2 ≤ N ≤ 50,000)개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.
//
//두 노드의 쌍 M(1 ≤ M ≤ 10,000)개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.
//
//입력
//첫째 줄에 노드의 개수 N이 주어지고, 다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다. 그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고, 다음 M개 줄에는 정점 쌍이 주어진다.
//
//출력
//M개의 줄에 차례대로 입력받은 두 정점의 가장 가까운 공통 조상을 출력한다.
//
//예제 입력 1
//15
//1 2
//1 3
//2 4
//3 7
//6 2
//3 8
//4 9
//2 5
//5 11
//7 13
//10 4
//11 15
//12 5
//14 7
//6
//6 11
//10 9
//2 6
//7 6
//8 13
//8 15
//예제 출력 1
//2
//4
//2
//1
//3
//1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val clazz = BOJ_11437()
    clazz.solution()
}

class BOJ_11437 {
    private val nodes = mutableMapOf<Int, Node>()
    private val memory = mutableMapOf<Pair<Int, Int>, Int>()

    fun solution() {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val edgeCount = bufferedReader.readLine().toInt()
        nodes[1] = Node(1)
        val queue = LinkedList<Pair<Int, Int>>()
        repeat(edgeCount - 1) {
            val (number1, number2) = bufferedReader.readLine().split(" ").map { it.toInt() }
            if (nodes[number1] == null && nodes[number2] == null) {
                queue.add(number1 to number2)
                return@repeat
            }
            if (nodes[number1] == null) nodes[number1] = Node(number1, nodes[number2]!!, nodes[number2]!!.level + 1)
            else nodes[number2] = Node(number2, nodes[number1]!!, nodes[number1]!!.level + 1)
        }
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val number1 = pair.first
            val number2 = pair.second
            if (nodes[number1] == null && nodes[number2] == null) {
                queue.add(number1 to number2)
                continue
            }
            if (nodes[number1] == null) nodes[number1] = Node(number1, nodes[number2]!!, nodes[number2]!!.level + 1)
            else nodes[number2] = Node(number2, nodes[number1]!!, nodes[number1]!!.level + 1)
        }

        val stringBuilder = StringBuilder()
        val questionCount = bufferedReader.readLine().toInt()
        repeat(questionCount) {
            val (number1, number2) = bufferedReader.readLine().split(" ").map { it.toInt() }
            val answer = memory[number1 to number2] ?: searchCommonParent(nodes[number1]!!, nodes[number2]!!)
            memory[number1 to number2] = answer
            stringBuilder.append("$answer\n")
        }
        println(stringBuilder.toString())
    }

    private fun searchCommonParent(node1: Node, node2: Node): Int {
        if (node1.level > node2.level) return searchCommonParent(findParent(node1, node2.level), node2)
        if (node1.level < node2.level) return searchCommonParent(node1, findParent(node2, node1.level))
        if (node1.number == node2.number) return node1.number
        var n1 = node1
        var n2 = node2
        while (n1.number != n2.number) {
            n1 = n1.parent!!
            n2 = n2.parent!!
        }
        return n1.number
    }

    private fun findParent(node: Node, targetLevel: Int): Node {
        var parent = node.parent!!
        while (parent.level != targetLevel) {
            parent = parent.parent!!
        }
        return parent
    }

    data class Node(
        val number: Int,
        val parent: Node? = null,
        val level: Int = 0
    )
}
