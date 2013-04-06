class UrlMappings {

	static mappings = {
        "/posts"(controller: "post", action: "list")
        "/posts/$id"(controller: "post") {
            action = [GET: "show", PUT: "update"]
        }

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	//	"/"(view:"/index")
		"500"(view:'/error')
	}
}
