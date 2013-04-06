package bloggr

import grails.converters.JSON

class PostController {

    def index() { }

    def list() {
        // if only life could be this simple...
        // render Post.list() as JSON

        def data = [
            posts: Post.list().collect { p ->
                [
                    id: p.id,
                    title: p.title,
                    author: p.author,
                    intro: p.intro,
                    extended: p.extended,
                    published_at: p.publishedAt.format("MM/dd/yyyy")
                ]
            }
        ]

        render data as JSON
    }

    def show() {
        def post = Post.get(params.id)

        def data = [
            post: [
                id: post.id,
                title: post.title,
                author: post.author,
                intro: post.intro,
                extended: post.extended,
                published_at: post.publishedAt.format("MM/dd/yyyy")
            ]
        ]

        render data as JSON
    }
}
