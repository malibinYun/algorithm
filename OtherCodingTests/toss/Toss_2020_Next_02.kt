package codeingtest.toss

//[Android-2] 공통 구역 찾기
//4초
//토스신용카드 발급을 희망하는 사용자들이 있습니다.
//
//마케팅과 혜택 개발을 위한 데이터로 활용하기 위해 같은 지역에 거주하는 사용자들을 구분하려고 할 때,
//
//발급 신청서에 기록된 사용자들의 주소지를 가장 작은 행정구역 단위로 그룹핑하는 프로그램을 작성해주십시오.
//
//
//
//입력 설명
//
//첫 번째 줄에는 각 발급 신청자들의 주소지 수 N이 주어집니다.
//두 번째 줄부터 N줄에 걸쳐 발급을 희망하는 사람들의 주소지가 주어집니다.
//이 때, 주소지들의 행정구역 단위는 온점(.)으로 구분합니다.
//입력된 주소지의 가장 마지막 주소 단위는 버립니다.
//입/출력 예시 4번 참고
//한 주소지당 2단계 이상의 구역이 입력됩니다.
//
//
//출력 설명
//
//입력된 주소지들을 모두 포함하는 가장 작은 행정구역
//모두 포함하는 구역을 찾을 수 없을 경우, 없음을 출력합니다.
//입력할 주소지의 수가 1 이하일 경우, 없음을 출력합니다.
//입/출력 예시
//:
//공백
//:
//줄바꿈
//:
//탭
//예시 1
//입력
//3
//경기도.수원시.영통구.법조로
//경기도.수원시.영통구.삼성로
//경기도.수원시.영통구.법조로30
//출력
//경기도.수원시.영통구
//예시 2
//입력
//4
//서울특별시.송파구.충민로
//경기도.성남시.분당구.불정로
//서울특별시.송파구.충민로3
//서울특별시.송파구
//출력
//없음
//예시 3
//입력
//2
//경기도.안산시.상록구.초지1로
//경기도.안산시.상록구.초지1로20
//출력
//경기도.안산시.상록구
//예시 4
//입력
//2
//경기도.안양시.만안구
//경기도.안양시.만안구.덕천로
//출력
//경기도.안양시
//⋇ 입출력 형식을 잘 지켜주세요

private val addresses = mutableListOf<Address>()

fun main() {
    val addressCount = readLine()!!.toInt()
    repeat(addressCount) {
        val addressTokens = readLine()!!.split(".").discardLast()
        addresses.add(Address(addressTokens))
    }
    if (addresses.size == 1) {
        println("없음")
        return
    }
    printMinimumGroup(findMinimumGroup(addresses.first()))
}

private fun List<String>.discardLast(): List<String> {
    return this.subList(0, this.lastIndex)
}

private fun findMinimumGroup(inputAddress: Address): List<String> {
    return addresses.map { it.getMatchedMinimumGroup(inputAddress) }
        .distinct()
        .minBy { it.size } ?: emptyList()
}

private fun printMinimumGroup(tokens: List<String>) {
    if (tokens.size <= 1) println("없음")
    else println(tokens.joinToString("."))
}

data class Address(val tokens: List<String>) {
    fun getMatchedMinimumGroup(address: Address): List<String> {
        val tokens = mutableListOf<String>()
        for (token in address.tokens) {
            if (this.contains(token)) tokens.add(token)
            else return tokens
        }
        return tokens
    }

    private fun contains(token: String): Boolean {
        return this.tokens.contains(token)
    }
}
