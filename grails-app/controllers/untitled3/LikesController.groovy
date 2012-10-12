package untitled3

import org.springframework.dao.DataIntegrityViolationException

class LikesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [likesInstanceList: Likes.list(params), likesInstanceTotal: Likes.count()]
    }

    def create() {
        [likesInstance: new Likes(params)]
    }

    def save() {
        def likesInstance = new Likes(params)
        if (!likesInstance.save(flush: true)) {
            render(view: "create", model: [likesInstance: likesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'likes.label', default: 'Likes'), likesInstance.id])
        redirect(action: "show", id: likesInstance.id)
    }

    def show(Long id) {
        def likesInstance = Likes.get(id)
        if (!likesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "list")
            return
        }

        [likesInstance: likesInstance]
    }

    def edit(Long id) {
        def likesInstance = Likes.get(id)
        if (!likesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "list")
            return
        }

        [likesInstance: likesInstance]
    }

    def update(Long id, Long version) {
        def likesInstance = Likes.get(id)
        if (!likesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (likesInstance.version > version) {
                likesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'likes.label', default: 'Likes')] as Object[],
                        "Another user has updated this Likes while you were editing")
                render(view: "edit", model: [likesInstance: likesInstance])
                return
            }
        }

        likesInstance.properties = params

        if (!likesInstance.save(flush: true)) {
            render(view: "edit", model: [likesInstance: likesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'likes.label', default: 'Likes'), likesInstance.id])
        redirect(action: "show", id: likesInstance.id)
    }

    def delete(Long id) {
        def likesInstance = Likes.get(id)
        if (!likesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "list")
            return
        }

        try {
            likesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'likes.label', default: 'Likes'), id])
            redirect(action: "show", id: id)
        }
    }
}
