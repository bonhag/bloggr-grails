package bloggr

import grails.converters.JSON

class PostController {

    def index() { }
    def list() {
        render Post.list() as JSON
    }
}
