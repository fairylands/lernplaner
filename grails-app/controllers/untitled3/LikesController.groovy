package untitled3

import grails.converters.XML


class LikesController {

    static scaffold = true

    LernplanService lernplanService

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

        withFormat {

            html { [userlikesList: tmpList, starttimesList: times , durationsList: durations] }
            xml { render([userlikesList: tmpList] as XML) }
        }
    }

    def saveLike = {

        def curUser =  User.findByLoginname(session.user.loginname)

        def float start = params.getFloat('starttime').round(2), end

        start = lernplanService.zeitInZahl(start)
        end = start +  params.getDouble('duration')

        def tmpTerm = new Term(dayOfWeek: params.dayOfWeek, starttime: start, endtime: end, duration: params.getDouble('duration'))
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

        withFormat {

            html { redirect (action: 'likes') }
            xml { render([success: true] as XML) }
        }
    }

    def deleteLike () {

        def curUser = User.findByLoginname(session.user.loginname)
        def tmpLike = curUser.likes.find { it.likename == params.name }

        curUser.removeFromLikes(tmpLike)

        withFormat {

            html { redirect(action: 'likes') }
            xml { render([success: true] as XML) }
        }
    }

    //def changeLike () {

    //    redirect(uri: '/likes/likes?likename=' + params.name)
    //}

    def changeterms () {

        def times = [], durations = []

        for (int i = 6; i<24; i++) {

            times.add(i + ".00")
            times.add(i + ".15")
            times.add(i + ".30")
            times.add(i + ".45")
        }

        times.add("24.00")

        for (float i = 0.25; i<=8; i+=0.25) {durations.add(i)}

        [starttimesList: times , durationsList: durations]
    }

    def addTerm() {

        def curUser = User.findByLoginname(session.user.loginname)
        def curLike =  curUser.likes.find {it.likename == params.likename}
        def float start = params.getFloat('starttime').round(2), end

        start = lernplanService.zeitInZahl(start)
        end = start +  params.getDouble('duration')

        def tmpTerm = new Term(dayOfWeek: params.dayOfWeek, starttime: start, endtime: end, duration: params.getDouble('duration'))

        tmpTerm.save(flush: true)

        curLike.addToTerm(tmpTerm)

        withFormat {

            html { redirect (action: 'changeterms', params: [name: params.likename]) }
            xml { render([success: true] as XML) }
        }

    }

    def removeTerm() {

        def curUser = User.findByLoginname(session.user.loginname)
        def curLike =  curUser.likes.find {it.likename == params.likename}
        def tmpTerm = curLike.term.find {it.id == params.termId.toLong()}

        curLike.removeFromTerm(tmpTerm)

        redirect(action: 'changeterms', params: [name: params.likename])
    }
}