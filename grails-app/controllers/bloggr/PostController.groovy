package bloggr

import grails.converters.JSON

class PostController {

    def index() { }
    def list() {
        // if only life could be this simple...
        // render Post.list() as JSON

        def results = Post.list()
        render(contentType: "application/json") {
            posts = array {
                for (p in results) {
                    post id: p.id,
                         title: p.title,
                         author: p.author,
                         intro: p.author,
                         extended: p.extended,
                         published_at: p.publishedAt.format("MM/dd/yyyy")
                }
            }
        }
    }
}
