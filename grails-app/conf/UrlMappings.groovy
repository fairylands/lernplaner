class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        /* --- REST - Schnittstelle -------------------------------------------------------- */
        //show: http://localhost:8080/untitled3/likes/likes.xml

        "/restinterface/$id?"(controller: "likes") {
            action = [GET: "likes", PUT: "addTerm", DELETE: "deleteLike", POST: "saveLike"]
        }

		"/"(view: "index")
		"500"(view:'/error')
	}
}
