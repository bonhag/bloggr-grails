class UrlMappings {

	static mappings = {
        "/posts"(controller: "post", action: "json")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
