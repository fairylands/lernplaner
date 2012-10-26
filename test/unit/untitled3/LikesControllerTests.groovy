package untitled3

import grails.test.mixin.*

@TestFor(LikesController)
@Mock(Likes)
class LikesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/likes/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.likesInstanceList.size() == 0
        assert model.likesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.likesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.likesInstance != null
        assert view == '/likes/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/likes/show/1'
        assert controller.flash.message != null
        assert Likes.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/likes/list'

        populateValidParams(params)
        def likes = new Likes(params)

        assert likes.save() != null

        params.id = likes.id

        def model = controller.show()

        assert model.likesInstance == likes
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/likes/list'

        populateValidParams(params)
        def likes = new Likes(params)

        assert likes.save() != null

        params.id = likes.id

        def model = controller.edit()

        assert model.likesInstance == likes
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/likes/list'

        response.reset()

        populateValidParams(params)
        def likes = new Likes(params)

        assert likes.save() != null

        // test invalid parameters in update
        params.id = likes.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/likes/edit"
        assert model.likesInstance != null

        likes.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/likes/show/$likes.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        likes.clearErrors()

        populateValidParams(params)
        params.id = likes.id
        params.version = -1
        controller.update()

        assert view == "/likes/edit"
        assert model.likesInstance != null
        assert model.likesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/likes/list'

        response.reset()

        populateValidParams(params)
        def likes = new Likes(params)

        assert likes.save() != null
        assert Likes.count() == 1

        params.id = likes.id

        controller.delete()

        assert Likes.count() == 0
        assert Likes.get(likes.id) == null
        assert response.redirectedUrl == '/likes/list'
    }
}
