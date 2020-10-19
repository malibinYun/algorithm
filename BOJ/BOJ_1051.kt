package baekjoon

// 숫자 정사각형
//문제
//N*M크기의 직사각형이 있다. 각 칸은 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.
//
//입력
//첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.
//
//출력
//첫째 줄에 정답 정사각형의 크기를 출력한다.
//
//예제 입력 1
//3 5
//42101
//22100
//22101
//예제 출력 1
//9

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (row, col) = bufferedReader.readLine().split(" ").map(String::toInt)
    val maxSquareLength = min(row, col)
    val rectangle = Array(row) {
        bufferedReader.readLine().toCharArray()
    }
    for (length in maxSquareLength downTo 1) {
        for (i in 0..(rectangle.size - length)) {
            for (j in 0..(rectangle[0].size - length)) {
                val squareVertex = rectangle[i][j]
                if (squareVertex == rectangle[i][j + length - 1] &&
                    squareVertex == rectangle[i + length - 1][j] &&
                    squareVertex == rectangle[i + length - 1][j + length - 1]
                ) {
                    println(length * length)
                    return
                }
            }
        }
    }
}
