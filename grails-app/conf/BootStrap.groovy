import untitled3.*

class BootStrap {

    def init = { servletContext ->

        //Terms:
        def mo1 = new Term(dayOfWeek: "Mo", starttime: 8.15, endtime: 10.45, duration: 2.5)
                mo1.save(flush: true)
        def mo2 = new Term(dayOfWeek: "Mo", starttime: 11.00, endtime: 14.45, duration: 3.45)
                mo2.save(flush: true)
        def di1 = new Term(dayOfWeek: "Di", starttime: 8.45, endtime: 11.45, duration: 3)
                di1.save(flush: true)
        def di2 = new Term(dayOfWeek: "Di", starttime: 12.30, endtime: 15.00, duration: 2.5)
                di2.save(flush: true)
        def mi1 = new Term(dayOfWeek: "Mi", starttime: 9.15, endtime: 12.30, duration: 3.25)
                mi1.save(flush: true)
        def mi2 = new Term(dayOfWeek: "Mi", starttime: 13.00, endtime: 14.30, duration: 1.5)
                mi2.save(flush: true)
        def do1 = new Term(dayOfWeek: "Do", starttime: 8.45, endtime: 11.45, duration: 3)
                do1.save(flush: true)
        def do2 = new Term(dayOfWeek: "Do", starttime: 13.00, endtime: 16.30, duration: 3.5)
                do2.save(flush: true)
        def fr1 = new Term(dayOfWeek: "Fr", starttime: 8.30, endtime: 10.00, duration: 1.5)
                fr1.save(flush: true)
        def fr2 = new Term(dayOfWeek: "Fr", starttime: 10.15, endtime: 13.30, duration: 3.25)
                fr2.save(flush: true)

        def sp = new Term(dayOfWeek: "Fr", starttime: 18.00, endtime: 20.00, duration: 2)
                sp.save(flush: true)
        def pi = new Term(dayOfWeek: "Mi", starttime: 17.15, endtime: 18.45, duration: 1.5)
                pi.save(flush: true)

        //Subjects:
        def ra = new Subject(subjectname: "Rechnerarchitekturen", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mo1])
                ra.save(flush: true)
        def bs = new Subject(subjectname: "Betriebssysteme", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mo2])
                bs.save(flush: true)
        def db = new Subject(subjectname: "Datenbanken", typeOfExam: "keine", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [di1])
                db.save(flush: true)
        def swe = new Subject(subjectname: "Softwareengineering", typeOfExam: "Projekt", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [di2, mi1])
                swe.save(flush: true)
        def fsa = new Subject(subjectname: "Formale Sprachen und Automaten", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mi2, fr1])
                fsa.save(flush: true)
        def nt = new Subject(subjectname: "Netztechnik", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [do1])
                nt.save(flush: true)
        def ma = new Subject(subjectname: "Rechnerarchitekturen", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [do1])
                ma.save(flush: true)
        def we = new Subject(subjectname: "Webengineering", typeOfExam: "Pruefung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [fr2])
                we.save(flush: true)

        //Professors:
        new Professor(profname: "Beahnisch", subject: [ra]).save(flush: true)
        new Professor(profname: "Griesinger", subject: [bs]).save(flush: true)
        new Professor(profname: "Hermanns", subject: [db]).save(flush: true)
        new Professor(profname: "Nitsche-Ruhland", subject: [swe]).save(flush: true)
        new Professor(profname: "Schwinn", subject: [fsa]).save(flush: true)
        new Professor(profname: "Windholz", subject: [nt]).save(flush: true)
        new Professor(profname: "Kick", subject: [ma]).save(flush: true)
        new Professor(profname: "Klein", subject: [we]).save(flush: true)

        //Course:
        def tinf = new Course(coursename: "TINF11B", subject: [ra, bs, db, swe, fsa, nt, ma, we])
                tinf.save(flush: true)

        //Likes:
        def sport = new Likes(likename: "Sport", priority: 5, term: [sp])
                sport.save(flush: true)
        def piano = new Likes(likename: "Klavier", priority: 3, term: [pi])
                piano.save(flush: true)

        //User:
        def hanne = new User(prename: "Hanne", surname: "Nobis", loginname: "hanne", password: "123", course: tinf, likes: [sport])
                hanne.save(flush: true)
        def sophie = new User(prename: "Sophie", surname: "Eichhorn", loginname: "sophie", password: "321", course: tinf, likes: [piano])
                sophie.save(flush: true)
        def ano = new User(prename: "Ano", surname: "Nymus", loginname: "anonymus", password: "111", course: tinf, likes: [sport, piano])
                ano.save(flush: true)

        def tinfTemp = Course.get(tinf.id)
        tinfTemp.speaker1 = hanne
        tinfTemp.speaker2 = ano





    }
    def destroy = {
    }
}
