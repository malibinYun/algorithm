import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val clazz = Programmers_Skillcheck_Lv1_2()

    println(clazz.solution(5, 24))
}

class Programmers_Skillcheck_Lv1_2 {
    fun solution(a: Int, b: Int): String {
        val dayList = listOf("", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

        val month = if (a < 10) "0$a" else "$a"
        val day = if (b < 10) "0$b" else "$b"

        val inputDate = "2016$month$day"

        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val date = dateFormat.parse(inputDate)

        val calendar = Calendar.getInstance().apply { time = date }
        val dayIndex = calendar.get(Calendar.DAY_OF_WEEK)

        return dayList[dayIndex]
    }
}