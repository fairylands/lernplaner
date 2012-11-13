package untitled3

class LikesController {

    static scaffold = true

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
        }
    }

    def likes() {

        def curUser = User.findByLoginname(session.user.loginname)
        def tmpList = curUser.likes

        [userlikesList: tmpList]
    }

    def saveLike = {

        def curUser =  User.findByLoginname(session.user.loginname)

        def tmpTerm = new Term(dayOfWeek: params.dayOfWeek, starttime: params.getDouble('starttime'), endtime: (params.getDouble('starttime') + params.getDouble('duration')), duration: params.getDouble('duration'))
            tmpTerm.save(flush: true)

        def tmpLike = new Likes(likename: params.likename, priority: params.priority, term: [tmpTerm])

        if (curUser.likes.likename.contains(params.likename)) {

        }

        tmpLike.save()           //LÃƒÂ¤sst sich nicht flushen

            curUser.addToLikes(tmpLike)

        redirect (action: 'likes')

    }
}
