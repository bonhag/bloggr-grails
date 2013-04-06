import bloggr.Post

class BootStrap {

    def init = { servletContext ->
        new Post(
            title: "Hi, Mom!",
            author: "Jeff Bonhag",
            intro: "Well, it's happened again.  Here we are!",
            extended: "Can you believe it?",
            publishedAt: new Date("12/27/2012")
        ).save()

        new Post(
            title: "Hi, Liz!",
            author: "Jeff Bonhag",
            intro: "It's getting dark in the world...",
            extended: "*Jesus Lives* is what my guitar says.  I __love__ it!",
            publishedAt: new Date()
        ).save()
    }
    def destroy = {
    }
}
