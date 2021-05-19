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
}
