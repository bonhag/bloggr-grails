package bloggr

import grails.converters.JSON

class PostController {

    def index() { }
    def json() {
        render Post.list() as JSON
    }
}
