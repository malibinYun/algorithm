package baekjoon

//문제
//정수로 이루어진 크기가 같은 배열 A, B, C, D가 있다.
//
//A[a], B[b], C[c], D[d]의 합이 0인 (a, b, c, d) 쌍의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 배열의 크기 n (1 ≤ n ≤ 4000)이 주어진다. 다음 n개 줄에는 A, B, C, D에 포함되는 정수가 공백으로 구분되어져서 주어진다. 배열에 들어있는 정수의 절댓값은 최대 228이다.
//
//출력
//합이 0이 되는 쌍의 개수를 출력한다.
//
//예제 입력 1
//6
//-45 22 42 -16
//-41 -27 56 30
//-36 53 -37 77
//-36 30 -75 -46
//26 -38 -10 62
//-32 -54 -6 45
//예제 출력 1
//5
// 이분탐색 두 번으로 중복 수의 범위 인덱스를 찾아서 개수를 구했던 문제.

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val size = bufferedReader.readLine().toInt()
    val arrA = IntArray(size)
    val arrB = IntArray(size)
    val arrC = IntArray(size)
    val arrD = IntArray(size)
    repeat(size) { i ->
        val cursor = bufferedReader.readLine().split(" ").map { it.toInt() }
        arrA[i] = cursor[0]
        arrB[i] = cursor[1]
        arrC[i] = cursor[2]
        arrD[i] = cursor[3]
    }
    val combinedAB = IntArray(size * size)
    val combinedCD = IntArray(size * size)
    var index = 0
    for (i in 0 until size) {
        for (j in 0 until size) {
            combinedAB[index] = arrA[i] + arrB[j]
            combinedCD[index++] = arrC[i] + arrD[j]
        }
    }
    combinedCD.sort()

    var count = 0L
    for (left in combinedAB) {
        var startIndex = 0
        var endIndex = combinedCD.size
        while (startIndex < endIndex) {
            val middleIndex = (startIndex + endIndex) / 2
            if (left + combinedCD[middleIndex] >= 0) endIndex = middleIndex
            else startIndex = middleIndex + 1
        }
        val lowerBoundary = endIndex
        startIndex = 0
        endIndex = combinedCD.size
        while (startIndex < endIndex) {
            val middleIndex = (startIndex + endIndex) / 2
            if (left + combinedCD[middleIndex] > 0) endIndex = middleIndex
            else startIndex = middleIndex + 1
        }
        val upperBoundary = endIndex
        count += upperBoundary - lowerBoundary
    }
    println(count)
}
// endIndex에 size-1해서 틀려왔는데 이걸 없애니 된다. 대체 뭘까? 아직도 이유를 모르겠다.
