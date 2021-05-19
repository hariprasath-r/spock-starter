package in.hp.spock.basics

import spock.lang.Specification

class BlocksExampleSpec extends Specification {

    Stack stack

    def "setup"() {
        stack = new Stack<String>()
        // explicit condition
        assert stack.empty
    }

    def "Adding element to an empty stack should increase the size and make it not empty"() {
        given: "An element"
        def element1 = 'element1'

        when: "Adding element to the stack"
        stack.push(element1)

        then: "Should satisfy the below"
        and: "Stack should not be empty"
        !stack.empty

        and: "Size should be 1"
        stack.size() == 1

        and: "Should have the element on top"
        stack.peek() == element1
    }

    def "Exception example"() {
        when: "Popping an empty stack"
        stack.pop()

        then: "Should throw EmptyStackException"
        // thrown(EmptyStackException)
        // below is more clear and can make use of the exception
        EmptyStackException e = thrown()
        e.cause == null
    }

    def "Should not throw exception example"() {
        given: "A HashMap"
        def map = new HashMap<String, String>()

        when: "Adding a null key to the HashMap"
        map.put(null, 'value')

        then: "Should not throw NullPointerException"
        notThrown(NullPointerException)
    }

    def "Expect block example"() {
        expect: "Expect 2 greater than 1"
        Math.max(1, 2) == 2
    }
}
