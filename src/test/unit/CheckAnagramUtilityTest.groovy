import spock.lang.Specification

class CheckAnagramUtilityTest extends Specification{

    def 'Test CheckAnagramUtility | String s is null'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex(null, "abc")

        then:
        result.size()== 0

    }

    def 'Test CheckAnagramUtility | String s is empty'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("", "abc")

        then:
        result.size()== 0

    }

    def 'Test CheckAnagramUtility | String p is null'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("abc", null)

        then:
        result.size()== 0

    }

    def 'Test CheckAnagramUtility | String p is empty'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("abc", "")

        then:
        result.size()== 0

    }

    def 'Test CheckAnagramUtility | success scenario 1'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("cbaebabacd", "abc")

        then:
        result.size()== 2
        result[0]== 0
        result[1]== 6

    }

    def 'Test CheckAnagramUtility | success scenario 2'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("abab", "ab")

        then:
        result.size()== 3
        result[0]== 0
        result[1]== 1
        result[2]== 2
    }

    def 'Test CheckAnagramUtility | s and p of equal length'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("abc", "abc")

        then:
        result.size()== 1
        result[0]== 0
    }

    def 'Test CheckAnagramUtility | p is greater length from s'(){
        given:
        def util= new CheckAnagramUtility()

        when:
        def result= util.anagramStartIndex("abc", "abcd")

        then:
        result.size()== 0
    }
}
