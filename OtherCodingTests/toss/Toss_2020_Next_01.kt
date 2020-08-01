package codeingtest.toss

//[Android-1] 색상 코드에 Alpha 적용하기제출완료
//4초
//RGB Hex Color Code와 Alpha 값을 입력 받아 ARGB로 출력하십시오.
//
//
//조건
//
//컬러 코드는 #FFFFFF 처럼 #을 항상 포함하고,
//대문자와 숫자만 사용됩니다.
//Alpha 값은 0이상 100이하의 정수입니다.
//(Alpha 0 : 완전 투명 / Alpha 100 : 불투명)
//소수점 이하는 버림해주세요. (예시2 참고)
//
//
//입력 설명
//
//색상 코드와 Alpha값이 쉼표(,) 로 구분되어 입력됩니다.
//
//
//출력 설명
//
//투명도가 적용된 색상 코드를 출력해주십시오.
//입/출력 예시
//:
//공백
//:
//줄바꿈
//:
//탭
//예시 1
//입력
//#FFFFFF,0
//출력
//#00FFFFFF
//예시 2
//입력
//#FFFFFF,50
//출력
//#7FFFFFFF
//예시 3
//입력
//#00FF00,100
//출력
//#FF00FF00
//⋇ 입출력 형식을 잘 지켜주세요

fun main() {
    val (inputColorCode, inputAlpha) = readLine()!!.split(",")
    val colorCode = inputColorCode.replace("#", "")
    val alphaCode = convertPercentToHexCode(inputAlpha.toInt())
    println("#$alphaCode$colorCode")
}

private fun convertPercentToHexCode(percent: Int): String {
    val hex = 255 * percent / 100
    return "%02X".format(hex)
}
