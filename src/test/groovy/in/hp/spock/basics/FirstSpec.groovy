package in.hp.spock.basics

import spock.lang.Shared
import spock.lang.Specification

/**
 * Each spock test class should extend Specification
 * It is used to identify this is a spock test class and also provides methods to help testing
 * Each Specification can be considered as below
 *  fields
 *  fixture methods
 *  feature methods
 *  helper methods
 */
class FirstSpec extends Specification {

    /**
     * Both are incremented at each test run, observe the difference
     */
    def instanceVariable = 0
    @Shared def sharedVariable = 0

    /**
     * Fixtures in Spock. It supports the below fixtures
     * setupSpec    -> executes only once before all test cases
     * setup        -> executes before each test case
     * cleanup      -> executes after each test case
     * cleanupSpec  -> executes after all test cases are completed
     */
    def "setupSpec"() {
        reportHeader "<h2>First Spec Tests</h2>"
        reportInfo 'FirstSpec test cases are being executed'
    }

    def "setup"() {
        println 'Executing before each test case'
        println "instance variable value: ${instanceVariable++}"
        println "shared variable value: ${sharedVariable++}"
    }

    /**
     * Each spock test case can be divided into blocks
     * given, when, then, expect, where
     */
    def "first spock test"() {
        // given block is used to define the act of the test case
        given: "two values a and b"
        def a = 10
        def b = 20
        def c

        // when acts as an arrange block
        when: "when a is added with b"
        c = a + b

        // then acts as assertion block, all boolean expressions here are like assert statements
        then: "c = a + b"
        c == 30
    }

    def "second spock test"() {
        given: "two values a and b"
        def a = 10
        def b = 20

        // expect is a combination of when and then block
        expect: "a should always be less than b"
        a < b
    }

    def "cleanup"() {
        println 'Executing after each test case'
    }

    def "cleanupSpec"() {
        println 'FirstSpec test cases have completed execution'
    }
}
