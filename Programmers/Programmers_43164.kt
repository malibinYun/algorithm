//여행경로
//문제 설명
//주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.
//
//항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//모든 공항은 알파벳 대문자 3글자로 이루어집니다.
//주어진 공항 수는 3개 이상 10,000개 이하입니다.
//tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
//주어진 항공권은 모두 사용해야 합니다.
//만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
//모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
//입출력 예
//tickets	return
//[[ICN, JFK], [HND, IAD], [JFK, HND]]	[ICN, JFK, HND, IAD]
//[[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]	[ICN, ATL, ICN, SFO, ATL, SFO]
//입출력 예 설명
//예제 #1
//
//[ICN, JFK, HND, IAD] 순으로 방문할 수 있습니다.
//
//예제 #2
//
//[ICN, SFO, ATL, ICN, ATL, SFO] 순으로 방문할 수도 있지만 [ICN, ATL, ICN, SFO, ATL, SFO] 가 알파벳 순으로 앞섭니다.

fun main() {
    val stub1 = arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND")
    )
    val stub2 = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO")
    )
    println(Programmers_43164().solution(stub1).toList())
    println()
    println(Programmers_43164().solution(stub2).toList())
}

class Programmers_43164 {
    private var ticketCount = 0
    private var order = listOf<String>()
    private lateinit var tickets: Tickets

    fun solution(tickets: Array<Array<String>>): Array<String> {
        ticketCount = tickets.size
        this.tickets = Tickets(tickets.map { Ticket(it[0], it[1]) })

        visit("ICN", listOf("ICN"))
        return order.toTypedArray()
    }

    private fun visit(
        currentVisiting: String,
        order: List<String> = listOf(),
        usedTickets: List<Ticket> = listOf()
    ) {
        if (this.order.isNotEmpty()) return
        if (usedTickets.size == ticketCount) {
            this.order = order
            return
        }
        val currentTickets = tickets.getTicketsFromDeparture(currentVisiting).sortedBy { it.destination }
        for (currentTicket in currentTickets) {
            if (usedTickets.contains(currentTicket)) continue
            visit(currentTicket.destination, order + currentTicket.destination, usedTickets + currentTicket)
        }
    }

    class Ticket(
        val departure: String,
        val destination: String
    ) {
        fun hasDeparture(departure: String): Boolean = this.departure == departure
    }

    class Tickets(
        val values: List<Ticket>
    ) {
        fun getTicketsFromDeparture(departure: String) = values.filter { it.hasDeparture(departure) }
    }
}
