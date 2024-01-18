package ch06

class P3_2 {
    fun reorderLogFiles( logs: Array<String>): Array<String> {
        val letterList = mutableListOf<String>()
        val digitList = mutableListOf<String>()

        for( log in logs ) {
            println( "::::::::::::: " +  log.split(" ")[1][0] )
            if ( Character.isDigit( log.split(" ")[1][0] ) ) {
                digitList.add(log)
            } else {
                letterList.add(log)
            }
        }

        // letterList sort
        letterList.sortWith( Comparator {s1: String, s2: String ->
            //
            val s1x = s1.split(" ", limit = 2 )
            val s2x = s2.split(" ", limit = 2 )

            // 사전순 비교
            val compared = s1x[1].compareTo( s2x[1] )
            if ( compared == 0 ) {
                // 사전순이 같으면 식별자로 비교
                s1x[0].compareTo( s2x[0] )
            } else {
                // 동일하면 0, 순서가 앞이면 1, 순서가 뒤면 -1
                compared
            }
        })

        // letterList + digitList
        letterList.addAll( digitList )

        return letterList.toTypedArray()
    }
}