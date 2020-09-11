package baekjoon

//문제
//스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
//
//보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
//
//이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
//
//각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
//
//보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.
//
//입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
//
//출력
//최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.
//
//예제 입력 1
//5 5
//#####
//#..B#
//#.#.#
//#RO.#
//#####
//예제 출력 1
//1
//예제 입력 2
//7 7
//#######
//#...RB#
//#.#####
//#.....#
//#####.#
//#O....#
//#######
//예제 출력 2
//5
//예제 입력 3
//7 7
//#######
//#..R#B#
//#.#####
//#.....#
//#####.#
//#O....#
//#######
//예제 출력 3
//5
//예제 입력 4
//10 10
//##########
//#R#...##B#
//#...#.##.#
//#####.##.#
//#......#.#
//#.######.#
//#.#....#.#
//#.#.#.#..#
//#...#.O#.#
//##########
//예제 출력 4
//-1
//예제 입력 5
//3 7
//#######
//#R.O.B#
//#######
//예제 출력 5
//1
//예제 입력 6
//10 10
//##########
//#R#...##B#
//#...#.##.#
//#####.##.#
//#......#.#
//#.######.#
//#.#....#.#
//#.#.##...#
//#O..#....#
//##########
//예제 출력 6
//7
//예제 입력 7
//3 10
//##########
//#.O....RB#
//##########
//예제 출력 7
//-1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (rowCount, cellCount) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val inputs = Array(rowCount) { Array(cellCount) { "" } }

    var redPosition = BOJ_13460.Position(-1, -1)
    var bluePosition = BOJ_13460.Position(-1, -1)
    var goalPosition = BOJ_13460.Position(-1, -1)
    repeat(rowCount) {
        val input = bufferedReader.readLine()
        for (i in input.indices) {
            inputs[it][i] = input[i].toString()
            when (input[i]) {
                'R' -> redPosition = BOJ_13460.Position(i, it)
                'B' -> bluePosition = BOJ_13460.Position(i, it)
                'O' -> goalPosition = BOJ_13460.Position(i, it)
                else -> {
                }
            }
        }
    }
    val field = BOJ_13460.Field(
        inputs,
        redPosition,
        bluePosition,
        goalPosition
    )
    val queue: Queue<BOJ_13460.Field> = LinkedList<BOJ_13460.Field>(mutableListOf(field))
    while (queue.isNotEmpty()) {
        val currentField = queue.poll()
//        println("currentField : ${currentField.tryCount}")
//        println(currentField)
//        println()
        if (currentField.isFinish()) {
            if (currentField.isFail()) continue

            println(currentField.tryCount)
            return
        }
        if (currentField.isFail()) continue

        if (currentField.previousDirection == null) {
            val nextFields = BOJ_13460.Direction.values().map { currentField.tilt(it) }
            queue.addAll(nextFields)
        } else {
            val nextDirections = BOJ_13460.Direction.values().toMutableList().apply {
                remove(currentField.previousDirection!!)
            }
            val nextFields = nextDirections.map { currentField.tilt(it) }
            queue.addAll(nextFields)
        }
    }

    println(-1)
}

class BOJ_13460 {

    enum class Direction(val dx: Int, val dy: Int) {
        LEFT(-1, 0),
        RIGHT(1, 0),
        UP(0, -1),
        DOWN(0, 1);
    }

    data class Field(
        val values: Array<Array<String>>,
        val redPosition: Position,
        val bluePosition: Position,
        val goalPosition: Position,
        val tryCount: Int = 0,
        var previousDirection: Direction? = null
    ) {
        fun isFail() = bluePosition == goalPosition || tryCount > 10

        fun isFinish() = redPosition == goalPosition

        fun tilt(direction: Direction): Field {
            val first: Position
            val firstName: String
            val second: Position
            val secondName: String
            val redPosition = this.redPosition.copy()
            val bluePosition = this.bluePosition.copy()

            when (direction) {
                Direction.LEFT -> {
                    if (redPosition.x < bluePosition.x) {
                        first = redPosition
                        second = bluePosition
                        firstName = "R"
                        secondName = "B"

                    } else {
                        first = bluePosition
                        second = redPosition
                        firstName = "B"
                        secondName = "R"
                    }
                }
                Direction.RIGHT -> {
                    if (redPosition.x < bluePosition.x) {
                        first = bluePosition
                        second = redPosition
                        firstName = "B"
                        secondName = "R"
                    } else {
                        first = redPosition
                        second = bluePosition
                        firstName = "R"
                        secondName = "B"
                    }
                }
                Direction.UP -> {
                    if (redPosition.y < bluePosition.y) {
                        first = redPosition
                        second = bluePosition
                        firstName = "R"
                        secondName = "B"
                    } else {
                        first = bluePosition
                        second = redPosition
                        firstName = "B"
                        secondName = "R"
                    }
                }
                Direction.DOWN -> {
                    if (redPosition.y < bluePosition.y) {
                        first = bluePosition
                        second = redPosition
                        firstName = "B"
                        secondName = "R"
                    } else {
                        first = redPosition
                        second = bluePosition
                        firstName = "R"
                        secondName = "B"
                    }
                }
            }

            val newValues = values.map { it.copyOf() }.toTypedArray()
            newValues[first.y][first.x] = "."
            while (true) {
                if (first == goalPosition) break
                val nextPosition = first.of(direction)
                // .이 아니면 멈춰야함
                if (newValues[nextPosition.y][nextPosition.x] != "." && newValues[nextPosition.y][nextPosition.x] != "O") break
                first.go(direction)
            }
            if (first != goalPosition) {
                newValues[first.y][first.x] = firstName
            }

            newValues[second.y][second.x] = "."
            while (true) {
                if (second == goalPosition) break
                val nextPosition = second.of(direction)
                // .이 아니면 멈춰야함
                if (newValues[nextPosition.y][nextPosition.x] != "." && newValues[nextPosition.y][nextPosition.x] != "O") break
                second.go(direction)
            }
            if (second != goalPosition) {
                newValues[second.y][second.x] = secondName
            }

            return copy(
                values = newValues,
                redPosition = redPosition,
                bluePosition = bluePosition,
                tryCount = tryCount + 1,
                previousDirection = direction
            )
        }

        override fun toString(): String {
            return values.joinToString("\n") { it.joinToString(" ") }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Field

            if (!values.contentDeepEquals(other.values)) return false
            if (redPosition != other.redPosition) return false
            if (bluePosition != other.bluePosition) return false
            if (goalPosition != other.goalPosition) return false

            return true
        }

        override fun hashCode(): Int {
            var result = values.contentDeepHashCode()
            result = 31 * result + redPosition.hashCode()
            result = 31 * result + bluePosition.hashCode()
            result = 31 * result + goalPosition.hashCode()
            return result
        }
    }

    data class Position(
        var x: Int,
        var y: Int
    ) {
        fun of(direction: Direction) = Position(x + direction.dx, y + direction.dy)

        fun go(direction: Direction) {
            this.x += direction.dx
            this.y += direction.dy
        }
    }
}

// 간과했던점
// 1. 이전에 갔던 방향을 또 가는 중복을 허용했었음. ex)LLLLLLLLLL 이런게 엄청나게 생겨버림.
// 이전에 갔던 방향을 필드가 기억함으로써 그 중복에 해당하는 방향을 가지 않게 하니 시간초과를 면했음.

// 2. R이 통과후 B가 통과하는 경우에는 그냥 그 경우를 버리면 되는데, 실패했으므로 실패값인 -1을 리턴해버리는 코드를 작성했었음.
// 버리고 다음걸 확인해야되는데 그렇지 않고 그냥 멈춰버린게 실수

