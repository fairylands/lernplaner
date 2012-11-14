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

        def times = [], durations = []

        for (int i = 6; i<24; i++) {

            times.add(i + ".00")
            times.add(i + ".15")
            times.add(i + ".30")
            times.add(i + ".45")
        }

        times.add("24.00")

        for (float i = 0.25; i<=8; i+=0.25) {durations.add(i)}

        [userlikesList: tmpList, starttimesList: times , durationsList: durations]
    }

    def saveLike = {

        def curUser =  User.findByLoginname(session.user.loginname)

        def double end

        end = params.getDouble('starttime') + (params.getDouble('duration') - (params.getDouble('duration')%1))

        switch (params.getDouble('duration')%1) {

            case 0.25: end += 0.15; break;
            case 0.5: end += 0.30; break;
            case 0.75: end += 0.45; break;
        }


        def tmpTerm = new Term(dayOfWeek: params.dayOfWeek, starttime: params.getDouble('starttime'), endtime: end, duration: params.getDouble('duration'))
            tmpTerm.save(flush: true)

        if (curUser.likes.likename.contains(params.likename)) {

            def tmpLike = Likes.findByLikename(params.likename)

            tmpLike.priority = params.getDouble('priority')
            tmpLike.addToTerm(tmpTerm)
        } else {

            def tmpLike = new Likes(likename: params.likename, priority: params.priority, term: [tmpTerm])
            tmpLike.save(flush: true)
            curUser.addToLikes(tmpLike)
        }


        redirect (action: 'likes')

    }

    def deleteLike () {

        //def tmpLike = Likes.findByLikename(params.name)
        def curUser = User.findByLoginname(session.user.loginname)
        def tmpLike = curUser.likes.find { it.likename == params.name }

        curUser.removeFromLikes(tmpLike)

        flash.message = "Like entfernt."

        redirect(action: 'likes')
    }

    def changeLike () {

        redirect(uri: '/likes/likes?likename=' + params.name)
    }

    def checkFreeTime() {

        def boolean time = true

        return time
    }

    def changeterms () {

        def curUser = User.findByLoginname(session.user.loginname)
        def tmpList = curUser.likes

        def times = [], durations = []

        for (int i = 6; i<24; i++) {

            times.add(i + ".00")
            times.add(i + ".15")
            times.add(i + ".30")
            times.add(i + ".45")
        }

        times.add("24.00")

        for (float i = 0.25; i<=8; i+=0.25) {durations.add(i)}

        [userlikesList: tmpList, starttimesList: times , durationsList: durations]
    }
}
