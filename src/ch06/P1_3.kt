package ch06

class P1_3 {

    fun isPalindrome( s: String ): Boolean {
        val startTime = System.nanoTime()
        var start = 0
        var end = s.length - 1

        while ( start < end ) {

            /* Java의 switch문은 반드시 변수 지정이 필요하지만
            코틀린의 when은 변수 지정하지 않아도 조건만 일치한다면 분기 처리 가능 */
            when {
                // start 유효문자 판별
                !Character.isLetterOrDigit( s[start] ) -> start++
                // end 유효문자 판별
                !Character.isLetterOrDigit( s[end] ) -> end--

                else -> {
                    // 이 외에는 유효한 문자이므로 모두 소문자 변경하여 비교
                    if ( Character.toLowerCase( s[start] ) != Character.toLowerCase( s[end] ) ) {
                        // 일치하지 않으면 false
                        return false
                    }
                    // 일치하면 start, end 중앙으로 이동
                    start++
                    end--
                }
            }
        }
        val endTime = System.nanoTime()
        println( "실행 시간 : " + ( endTime - startTime ) + "ns" )
        // 모두 일치하면 true
        return true
    }
}