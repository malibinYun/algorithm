package baekjoon

// 개미
//문제
//개미 여러 마리가 길이가 lcm인 막대 위에 있다. 각 개미의 이동 속도는 모두 일정하며, 1cm/s이다. 개미가 막대의 마지막까지 걸어간다면, 개미는 그 즉시 떨어지게 된다. 또, 두 개미가 만나게 된다면, 방향을 반대로 바꾸어 걸어가게 된다.
//
//가장 처음에 막대 상에서 개미의 위치를 알고 있다. 하지만, 개미가 어느 방향으로 움직이는 지는 알 수가 없다. 이때, 모든 개미가 땅으로 떨어질 때까지 가능한 시간 중 가장 빠른 시간과 느린 시간을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 막대의 길이와 개미의 수 n이 주어진다. 다음 n개 줄에는 숫자가 하나씩 주어지며, 이 숫자는 개미의 초기 위치를 나타낸다. 입력으로 주어지는 모든 수는 1,000,000보다 작거나 같으며, 공백으로 구분되어져 있다. 개미의 위치는 막대 왼쪽 끝에서부터 떨어진 거리이다.
//
//출력
//각 테스트 케이스에 대해서, 두 숫자를 출력한다. 첫 번째 숫자는 개미가 모두 땅으로 떨어지는 가능한 시간 중 가장 빠른 시간, 두 번째 숫자는 가장 늦은 시간이다.
//
//제한
//1 ≤ n ≤ 100000
//1 ≤ l ≤ 1000000
//개미의 위치는 정수
//0 ≤ 개미의 위치 ≤ l
//예제 입력 1
//2
//10 3
//2
//6
//7
//214 7
//11
//12
//7
//13
//176
//23
//191
//예제 출력 1
//4 8
//38 207

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val testCount = bufferedReader.readLine().toInt()
    val stringBuilder = StringBuilder()
    repeat(testCount) {
        var max = Int.MIN_VALUE
        var min = Int.MIN_VALUE
        val (length, antCount) = bufferedReader.readLine().split(" ").map(String::toInt)
        repeat(antCount) {
            val position = bufferedReader.readLine().toInt()
            val diff = length - position
            val maxDiff = max(position, diff)
            val minDiff = min(position, diff)
            max = max(max, maxDiff)
            min = max(min, minDiff)
        }
        stringBuilder.append("$min $max\n")
    }
    println(stringBuilder.toString())
}
