package baekjoon

// 거북이
//문제
//상근이는 2차원 평면 위에서 움직일 수 있는 거북이 로봇을 하나 가지고 있다. 거북이 로봇에게 내릴 수 있는 명령은 다음과 같이 네가지가 있다.
//
//F: 한 눈금 앞으로
//B: 한 눈금 뒤로
//L: 왼쪽으로 90도 회전
//R: 오른쪽으로 90도 회전
//L과 R명령을 내렸을 때, 로봇은 이동하지 않고, 방향만 바꾼다. 명령을 나열한 것을 거북이 로봇의 컨트롤 프로그램이라고 한다.
//
//상근이는 자신의 컨트롤 프로그램으로 거북이가 이동한 영역을 계산해보려고 한다. 거북이는 항상 x축과 y축에 평행한 방향으로만 이동한다. 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이를 구하는 프로그램을 작성하시오. 단, 직사각형의 모든 변은 x축이나 y축에 평행이어야 한다.
//
//아래 그림에서 거북이는 가장 처음에 (0, 0)에 있고, 북쪽을 쳐다보고 있다. 컨트롤 프로그램이 FLFRFLBRBLB인 경우에 거북이는 아래와 같이 움직인다. 회색으로 빗금친 부분이 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형이다. 넓이는 4가 된다.
//
//
//
//거북이가 지나간 영역이 직사각형을 만들지 않는 경우도 있다. 예를 들어, FFLLFF인 경우에 거북이는 y축의 위로만 지나다닌다. 이 경우에 거북이가 지나간 영역을 모두 포함하는 직사각형은 선분이고, 선분은 한 변이 0인 직사각형으로 생각할 수 있다. 따라서, 선분의 경우에 넓이는 0이 된다.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 컨트롤 프로그램이 주어진다. 프로그램은 항상 문제의 설명에 나와있는 네가지 명령으로만 이루어져 있고, 길이는 500을 넘지 않는다.
//
//출력
//각 테스트 케이스에 대해서, 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이를 출력한다.
//
//예제 입력 1
//3
//FFLF
//FFRRFF
//FFFBBBRFFFBBB
//예제 출력 1
//2
//0
//9

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    BOJ_8911().solution()
}

class BOJ_8911 {
    var dx = 0
    var dy = 1

    var minX = 0
    var maxX = 0
    var minY = 0
    var maxY = 0

    var x = 0
    var y = 0

    private fun turnLeft() {
        val temp = dx
        dx = dy
        dy = -temp
    }

    private fun turnRight() {
        val temp = dx
        dx = -dy
        dy = temp
    }

    private fun init() {
        dx = 0
        dy = 1
        minX = 0
        maxX = 0
        minY = 0
        maxY = 0
        x = 0
        y = 0
    }

    fun solution() {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val testCount = bufferedReader.readLine().toInt()
        val stringBuilder = StringBuilder()
        repeat(testCount) {
            init()
            val orders = bufferedReader.readLine()
            for (order in orders) {
                when (order) {
                    'F' -> {
                        x += dx
                        y += dy
                        checkRange()
                    }
                    'B' -> {
                        x -= dx
                        y -= dy
                        checkRange()
                    }
                    'L' -> turnLeft()
                    'R' -> turnRight()
                }
            }
            stringBuilder.append(abs(maxX - minX) * abs(maxY - minY))
                .append("\n")
        }
        println(stringBuilder.toString())
    }

    private fun checkRange() {
        if (minX > x) minX = x
        if (maxX < x) maxX = x
        if (minY > y) minY = y
        if (maxY < y) maxY = y
    }
}
