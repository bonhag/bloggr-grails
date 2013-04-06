package bloggr

import grails.converters.JSON

class PostController {

    def index() { }
    def list() {
        // if only life could be this simple...
        // render Post.list() as JSON
        def data = [ posts: Post.list() ]
        render data as JSON
    }
}
