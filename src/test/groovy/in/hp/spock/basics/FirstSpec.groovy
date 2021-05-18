package in.hp.spock.basics

import spock.lang.Specification

/**
 * Each spock test class should extend Specification
 * It is used to identify this is a spock test class and also provides methods to help testing
 */
class FirstSpec extends Specification {

    /**
     * Each spock test case can be divided into blocks
     * given, when, then, expect, where
     */
    def "first spock test"() {
        // given block is used to define the act of the test case
        given:
        def a = 10
        def b = 20
        def c

        // when acts as an arrange block
        when:
        c = a + b

        // then acts as assertion block, all boolean expressions here are like assert statements
        then:
        c == 30
    }
}
