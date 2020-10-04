package baekjoon

//친구 네트워크
//문제
//민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.
//
//어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
//
//친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.
//
//출력
//친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
//
//예제 입력 1
//2
//3
//Fred Barney
//Barney Betty
//Betty Wilma
//3
//Fred Barney
//Betty Wilma
//Barney Betty
//예제 출력 1
//2
//3
//4
//2
//2
//4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val testCount = bufferedReader.readLine().toInt()
    val stringBuilder = StringBuilder()

    repeat(testCount) {
        val friendsNetwork = FriendsNetwork()
        val relationCount = bufferedReader.readLine().toInt()
        repeat(relationCount) {
            val friends = bufferedReader.readLine().split(" ")
            stringBuilder.append("${friendsNetwork.countFriends(friends)}\n")
        }
    }
    println(stringBuilder.toString())
}

class FriendsNetwork {
    private val friends = mutableMapOf<String, Node>()

    fun countFriends(friendNames: List<String>): Int {
        joinFriends(friendNames)
        return findRootFriend(friendNames[0]).count
    }

    private fun joinFriends(friendNames: List<String>) {
        for (friendName in friendNames) {
            this.friends.computeIfAbsent(friendName) { Node(it, it) }
        }
        val friend1 = findRootFriend(friendNames[0])
        val friend2 = findRootFriend(friendNames[1])
        if (friend1 == friend2) return
        friend1.count += friend2.count
        friend2.rootName = friend1.rootName
    }

    private fun findRootFriend(name: String): Node {
        val node = friends[name]!!
        if (node.isRoot()) return node

        val rootNode = findRootFriend(node.rootName)
        node.rootName = rootNode.rootName
        return rootNode
    }
}

data class Node(
    val name: String,
    var rootName: String,
    var count: Int = 1
) {
    fun isRoot(): Boolean {
        return name == rootName
    }
}
