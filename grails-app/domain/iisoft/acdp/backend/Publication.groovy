package iisoft.acdp.backend

class Publication {

    long         idCategory
    String       title
    String       whoPublishedIt
    String       text
    Date         date
    int          cantSubscribers
    List<String> tags
    List<String> subscribers

    Publication(){
        cantSubscribers = 0
        subscribers     = []
    }

    static belongsTo = Category

    static constraints = {
        idCategory      nullable:false
        title           nullable:false
        whoPublishedIt  nullable:false
        text            nullable:false
        cantSubscribers nullable:false
        date            nullable:true
    }

    boolean isSubscribed(String userName) {
        subscribers.contains(userName)
    }

    def subscribe(String userName) {
        subscribers.add(userName)
        cantSubscribers += 1
    }

    def unsubscribe(String userName) {
        subscribers.remove(userName)
        cantSubscribers -= 1
    }
}
