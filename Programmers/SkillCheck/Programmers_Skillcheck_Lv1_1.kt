//문제 설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
//제한 조건
//n은 10,000,000,000이하인 자연수입니다.
//
//입출력 예
//n	return
//12345	[5,4,3,2,1]

fun main(){
    val clazz = Programmers_Skillcheck_Lv1_1()

    println(clazz.solution(12345).toList())
}

class Programmers_Skillcheck_Lv1_1 {
    fun solution(n: Long): IntArray {
        return n.toString().toCharArray().reversedArray().map { it.toString() }.map { it.toInt() }.toTypedArray().toIntArray()
    }
}