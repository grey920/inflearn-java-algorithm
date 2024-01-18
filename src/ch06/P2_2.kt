package ch06

class P2_2 {
    fun reverseString( s: CharArray ): Unit {
        var start = 0
        var end = s.size - 1

        while ( start < end ) {
            // also 사용하여 우아하게 스왑 (temp 변수 필요 없음)
            s[start] = s[end].also { s[end] = s[start] }

            // move pointer
            start++
            end--
        }
    }
}