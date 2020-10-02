package baekjoon

// 로봇 청소기
//문제
//로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
//
//로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
//
//로봇 청소기는 다음과 같이 작동한다.
//
//현재 위치를 청소한다.
//현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
//로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
//
//입력
//첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
//
//둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
//
//셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.
//
//로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
//
//출력
//로봇 청소기가 청소하는 칸의 개수를 출력한다.
//
//예제 입력 1
//3 3
//1 1 0
//1 1 1
//1 0 1
//1 1 1
//예제 출력 1
//1
//예제 입력 2
//11 10
//7 4 0
//1 1 1 1 1 1 1 1 1 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 1 1 1 1 0 1
//1 0 0 1 1 0 0 0 0 1
//1 0 1 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0 1
//1 0 0 0 0 0 0 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 1 1 0 1
//1 0 0 0 0 0 0 0 0 1
//1 1 1 1 1 1 1 1 1 1
//예제 출력 2
//57

import java.io.BufferedReader
import java.io.InputStreamReader
import baekjoon.BOJ_14503.Block
import baekjoon.BOJ_14503.Direction

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (height, width) = bufferedReader.readLine().split(" ").map { it.toInt() }
    var (botY, botX, directionNumber) = bufferedReader.readLine().split(" ").map { it.toInt() }
    var botDirection = Direction.from(directionNumber)
    val field = Array(height) { y ->
        val cursor = bufferedReader.readLine().split(" ").map { it.toInt() }
        Array(width) { x -> Block(x, y, cursor[x]) }
    }
    var cleanCount = 0
    while (true) {
        val currentField = field[botY][botX]
//        println("CURRENT    [$botX,$botY]   Direction : $botDirection")
        if (currentField.isNotClean()) {
            currentField.clean()
            cleanCount++
//            println("CLEAN AT   [$botX,$botY]   Acc : $cleanCount")
        }
        val nextDirection = botDirection.of(Direction.WEST)
        val nextBotX = botX + nextDirection.dx
        val nextBotY = botY + nextDirection.dy
        val nextField = field[nextBotY][nextBotX]

        if (nextField.type == 0 && nextField.isNotClean()) {
            botDirection = nextDirection
            botX = nextBotX
            botY = nextBotY
//            println("TURN LEFT AND GO")
            continue
        }

        if (Direction.values().all { field[botY + it.dy][botX + it.dx].isClean || field[botY + it.dy][botX + it.dx].type == 1 }) {
            val backDirection = botDirection.of(Direction.SOUTH)
            val backX = botX + backDirection.dx
            val backY = botY + backDirection.dy
            if (field[backY][backX].type == 1) {
//                println("END")
                break
            }
            botX = backX
            botY = backY
//            println("BACK")
            continue
        }

        if (nextField.type == 1 || nextField.isClean) {
            botDirection = nextDirection
//            println("TURN LEFT")
            continue
        }
    }
    println(cleanCount)
}

class BOJ_14503 {
    data class Block(
        val x: Int,
        val y: Int,
        val type: Int,
        var isClean: Boolean = false
    ) {
        fun isNotClean(): Boolean = !isClean

        fun clean() {
            isClean = true
        }
    }

    enum class Direction(
        val dx: Int,
        val dy: Int
    ) {
        EAST(1, 0),
        WEST(-1, 0),
        SOUTH(0, 1),
        NORTH(0, -1);

        fun of(direction: Direction): Direction = when (this) {
            EAST -> when (direction) {
                EAST -> SOUTH
                WEST -> NORTH
                SOUTH -> WEST
                NORTH -> EAST
            }
            WEST -> when (direction) {
                EAST -> NORTH
                WEST -> SOUTH
                SOUTH -> EAST
                NORTH -> WEST
            }
            SOUTH -> when (direction) {
                EAST -> WEST
                WEST -> EAST
                SOUTH -> NORTH
                NORTH -> SOUTH
            }
            NORTH -> direction
        }

        companion object {
            fun from(number: Int): Direction = when (number) {
                0 -> NORTH
                1 -> EAST
                2 -> SOUTH
                else -> WEST
            }
        }
    }
}
