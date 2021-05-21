package in.hp.spock.datadriven

import spock.lang.Rollup
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Spec helps to understand Data Driven Testing using Spock
 */
class DataDrivenSpec extends Specification {

    // the input parameters are optional as it is interpreted from the data table headers
    def "Maximum of #a and #b is #c"(a, b, c) {
        expect: "Maximum of a and b should be c"
        c == Math.max(a, b)

        where: "Given a, b, c"
        /*
        // first row is called table header
        a | b | c
        3 | 3 | 3
        4 | 5 | 4
        */
        __ // sequence of two or more underscore can be used to separate data tables
        a | _
        5 | _
        2 | _
        __ // sequence of two or more underscore can be used to separate data tables
        b || c
        6 || 6
        1 || 2
    }

    /**
     * Using @Unroll annotation shows individual iterations while reporting
     */
    @Unroll
    def "Minimum of two numbers"() {
        expect: "Minimum of a and b is c"
        Math.min(a, b) == c

        where: "Given a, b, c"
        // alternatively, semicolon can also be used to separate columns
        a; b; ; c
        1; 2; ; 1
        10; 11; 10
    }

    /**
     * Using @Rollup annotation does not show all the iterations of the data table while reporting
     */
    @Rollup
    def "Single variable testing from data table"() {
        expect: "Value should be greater than 0"
        a > 0

        where: "Given variable a"
        /*
        // can be represented as below
        a | _
        1 | _
        2 | _
        */
        // more cleaner approach as the left shift operator supplies values to the variable
        a << [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def "Multi variable data pipes example"() {
        expect:
        println "a: ${a}, b: ${b}, c: ${c}"

        // Have fun understanding the below test case :)
        where:
        [a, [b, _, c]] << [
                ['a1', 'a2'].permutations(),
                [
                        ['b1', 'd1', 'c1'],
                        ['b2', 'd2', 'c2']
                ]
        ].combinations()

        /**
         * Hint for the above.
         * Try it separately in a script. If not successful read below
         *
         * The first param for a will be supplied as below
         * ['a1', 'a2'].permutations() -> [['a1', 'a2'], ['a2', 'a1']]
         *
         * Second param by itself expects 3 variables b, _, c -> Here _ is skipped
         * The combinations returns like below
         * [['a1', 'a2'], ['b1', 'd1', 'c1']]
         * [['a2', 'a1'], ['b1', 'd1', 'c1']]
         *
         * Refer: PermutationCombinations.groovy
         */
    }

    // we can also access other data variables
    def "Accessing Other Data Variables Example"() {
        expect:
        println "a: ${a}, b: ${b}, c: ${c}, d: ${d}, e: ${e}"

        where:
        a | b
        3 | a + 1
        7 | a + 2
        0 | a + 3

        and:
        c = 1

        and:
        d     | e
        a * 2 | b * 2
        a * 3 | b * 3
        a * 4 | b * 4
    }

    // we can assign data variables using other variables also
    def "Data Variable Assignment"() {
        expect:
        println "a: ${a}, b: ${b}, c: ${c}"

        where:
        a = 3
        b = Math.random() * 100
        c = a > b ? a : b
    }

    // we can also combine data table, pipe and variable
    def "Combining Data Table, Pipe and Variable"() {
        expect:
        println "a: ${a}, b: ${b}, c: ${c}, d: ${d}"

        where:
        a | b
        1 | a + 1
        7 | a + 2
        0 | a + 3

        c << [3, 4, 0]

        d = a > c ? a : c
    }

}
