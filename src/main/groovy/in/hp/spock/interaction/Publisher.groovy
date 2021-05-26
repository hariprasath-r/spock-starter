package in.hp.spock.interaction

class Publisher {
    List<Subscriber> subscribers = []
    int messageCount = 0

    void send(String message){
        subscribers*.receive(message)
        messageCount++
    }
}
