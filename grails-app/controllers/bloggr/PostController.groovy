package bloggr

import grails.converters.JSON

class PostController {

    def index() { }

    def list() {
        // if only life could be this simple...
        // render Post.list() as JSON

        def data = [
            posts: Post.list().collect { post ->
                outgoingPost(post)
            }
        ]

        render data as JSON
    }

    def show() {
        def post = Post.get(params.id)

        def data = [
            post: outgoingPost(post)
        ]

        render data as JSON
    }

    def update() {
        // id is implied by request (i.e., PUT /post/2)
        def post = Post.get(params.id)

        post.properties = request.JSON.post

        post.save()

        def data = [
            post: outgoingPost(post)
        ]

        render data as JSON
    }

    def outgoingPost(post) {
        [
            id: post.id,
            title: post.title,
            author: post.author,
            intro: post.intro,
            extended: post.extended,
            published_at: post.publishedAt.format("MM/dd/yyyy")
        ]
    }
}
