class UrlMappings {

	static mappings = {
        "/posts"(controller: "post", action: "list")
        "/posts/$id"(controller: "post", action: "show")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	//	"/"(view:"/index")
		"500"(view:'/error')
	}
}
