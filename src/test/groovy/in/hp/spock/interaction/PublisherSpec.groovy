package in.hp.spock.interaction

import spock.lang.Specification

/**
 * Test Spec is an example of Interaction Based Testing in Spock
 */
class PublisherSpec extends Specification {

    Publisher publisher = new Publisher()

    // creating mock objects
    def subscriber1 = Mock(Subscriber)
    // groovy will infer the type
    Subscriber subscriber2 = Mock()

    def setup() {
        // both the below statements can be used to add subscribers to the list
        publisher.subscribers << subscriber1 // groovy shorthand for List.add()
        publisher.getSubscribers().add(subscriber2)
    }

    def "should send messages to all subscribers"() {
        when:
        publisher.send("Hello")

        then:
        // expecting each subscriber to receive the message only once
        1 * subscriber1.receive("Hello")
        1 * subscriber2.receive("Hello")
    }
}
