package baekjoon

// 오름세
//문제
//주식투자를 좋아하는 정인이는 주가의 오름세를 살펴보려고 한다.
//
//정인이는 n일 동안 매일 주가를 적어놓았고, 여기서 오름세를 찾아보려고 한다.
//
//n일 동안의 주가를 p1, p2, ..., pn이라고 했을 때, 오름세란 부분수열 pi1 < pi2 < ... < pik (i1 < i2 < ... ik)을 말한다.
//
//n일 동안 주가가 주어졌을 때, 가장 긴 오름세를 찾는 프로그램을 작성하시오.
//
//입력
//입력은 여러개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 주가를 관찰한 날의 수 N (N ≤ 100000)이 주어진다. 둘째 줄에는 관찰한 주가가 첫 날부터 순서대로 주어진다. 주가는 한 개 이상의 공백으로 구분되어 있으며, 그 외의 위치에서도 자유롭게 나올 수 있다. 주가는 100,000보다 작거나 같은 자연수이다.
//
//출력
//각 테스트 케이스에 대해서 입력으로 주어진 주가의 가장 긴 오름세의 길이를 출력한다.
//
//예제 입력 1
//6
//5 2 1 4 5 3
//3
//1 1 1
//4
//4 3 2 1
//예제 출력 1
//3
//1
//1

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val stringBuilder = StringBuilder()

    while (scanner.hasNext()) {
        val count = scanner.nextInt()
        val numbers = IntArray(count)
        repeat(count) {
            numbers[it] = scanner.nextInt()
        }

        var length = 1
        val array = IntArray(count)
        array[0] = numbers[0]

        for (i in 1 until count) {
            val headOfArray = array[length - 1]
            val current = numbers[i]
            if (current > headOfArray) {
                array[length++] = current
                continue
            }
            if (current < headOfArray) {
                array[lowerBound(array, 0, length - 1, current)] = current
                continue
            }
        }
        stringBuilder.append("$length\n")
    }
    println(stringBuilder.toString())
}

fun lowerBound(arr: IntArray, startIndex: Int, endIndex: Int, target: Int): Int {
    var left = startIndex
    var right = endIndex
    while (left <= right) {
        val middle = (left + right) / 2
        if (arr[middle] < target) left = middle + 1
        else right = middle - 1
    }
    return left
}

// 최장증가부분수열 가장 긴 증가하는 부분 수열
// 이분탐색
