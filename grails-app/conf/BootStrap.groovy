import untitled3.*

class BootStrap {

    def init = { servletContext ->

        //Terms:
        def mo1 = new Term(dayOfWeek: "Mo", starttime: 8.25, endtime: 10.75, duration: 2.5)
        def mo2 = new Term(dayOfWeek: "Mo", starttime: 11.00, endtime: 14.75, duration: 3.75)
        def di1 = new Term(dayOfWeek: "Di", starttime: 8.75, endtime: 11.75, duration: 3)
        def di2 = new Term(dayOfWeek: "Di", starttime: 12.5, endtime: 15.00, duration: 2.5)
        def mi1 = new Term(dayOfWeek: "Mi", starttime: 9.25, endtime: 12.5, duration: 3.25)
        def mi2 = new Term(dayOfWeek: "Mi", starttime: 13.00, endtime: 14.5, duration: 1.5)
        def do1 = new Term(dayOfWeek: "Do", starttime: 8.75, endtime: 11.75, duration: 3)
        def do2 = new Term(dayOfWeek: "Do", starttime: 13.00, endtime: 16.5, duration: 3.5)
        def fr1 = new Term(dayOfWeek: "Fr", starttime: 8.50, endtime: 10.00, duration: 1.5)
        def fr2 = new Term(dayOfWeek: "Fr", starttime: 10.25, endtime: 13.5, duration: 3.25)

        def sp = new Term(dayOfWeek: "Fr", starttime: 18.00, endtime: 20.00, duration: 2)
        sp.save(flush: true)
        def wga = new Term(dayOfWeek: "Mi", starttime: 17.15, endtime: 18.45, duration: 1.5)
        wga.save(flush: true)
        def nh = new Term(dayOfWeek: "Mi", starttime: 17.15, endtime: 18.45, duration: 1.5)
        nh.save(flush: true)

        //Subjects:
        def ra = new Subject(subjectname: "Rechnerarchitekturen", kuerzel: "RA", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mo1])
        ra.save(flush: true)
        mo1.subject = ra
        def bs = new Subject(subjectname: "Betriebssysteme", kuerzel: "BS", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mo2])
        bs.save(flush: true)
        mo2.subject = bs
        def db = new Subject(subjectname: "Datenbanken", kuerzel: "DB", typeOfExam: "keine", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [di1])
        db.save(flush: true)
        di1.subject = db
        def swe = new Subject(subjectname: "Softwareengineering", kuerzel: "SWE", typeOfExam: "Projekt", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [di2, mi1])
        swe.save(flush: true)
        di2.subject = swe
        mi1.subject = swe
        def fsa = new Subject(subjectname: "Formale Sprachen und Automaten",  kuerzel: "FSA", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [mi2, fr1])
        fsa.save(flush: true)
        mi2.subject = fsa
        fr1.subject = fsa
        def nt = new Subject(subjectname: "Netztechnik",  kuerzel: "NT", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [do1])
        nt.save(flush: true)
        do1.subject = nt
        def ma = new Subject(subjectname: "Mathe",  kuerzel: "MA", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [do2])
        ma.save(flush: true)
        do2.subject = ma
        def we = new Subject(subjectname: "Webengineering", kuerzel: "WE", typeOfExam: "Prüfung", hours: 100, selfstudy: 100, modul: "TTT", creditpoints: 42, term: [fr2])
        we.save(flush: true)
        fr2.subject = we

        //Save der Terms (Erst hier, damit sie nicht "weggeflusht" werden)

        mo1.save(flush: true)
        mo2.save(flush: true)
        di1.save(flush: true)
        di2.save(flush: true)
        mi1.save(flush: true)
        mi2.save(flush: true)
        do1.save(flush: true)
        do2.save(flush: true)
        fr1.save(flush: true)
        fr2.save(flush: true)

        //Professors:
        def baeh = new Professor(profname: "Bähnisch", subject: [ra])
        baeh.save(flush: true)
        ra.professor = baeh
        def grie = new Professor(profname: "Griesinger", subject: [bs])
        grie.save(flush: true)
        bs.professor = grie
        def herm = new Professor(profname: "Hermanns", subject: [db])
        herm.save(flush: true)
        db.professor = herm
        def nits = new Professor(profname: "Nitsche-Ruhland", subject: [swe])
        nits.save(flush: true)
        swe.professor = nits
        def schw = new Professor(profname: "Schwinn", subject: [fsa])
        schw.save(flush: true)
        fsa.professor =schw
        def wind = new Professor(profname: "Windholz", subject: [nt])
        wind.save(flush: true)
        nt.professor = wind
        def kick = new Professor(profname: "Kick", subject: [ma])
        kick.save(flush: true)
        ma.professor = kick
        def klei = new Professor(profname: "Klein", subject: [we])
        klei.save(flush: true)
        we.professor = klei

        //Course:
        def tinf = new Course(coursename: "TINF11B", beginnTheoriephase: new Date(350714925187200) ,subject: [ra, bs, db, swe, fsa, nt, ma, we])
        tinf.save(flush: true)

        //Likes:
        def sport = new Likes(likename: "Sport", priority: 5, term: [sp])
        sport.save(flush: true, failOnError: true)
        def nachhilfe = new Likes(likename: "Nachhilfe", priority: 5, term: [nh])
        nachhilfe.save(flush: true, failOnError: true)
        def wgabend = new Likes(likename: "WG-Abend", priority: 3, term: [wga])
        wgabend.save(flush: true, failOnError: true)

        //User:
        def hanne = new User(prename: "Hanne", surname: "Nobis", loginname: "hanne", password: "123", course: tinf, likes: [sport, nachhilfe])
        hanne.save(flush: true)
        def sophie = new User(prename: "Sophie", surname: "Eichhorn", loginname: "sophie", password: "321", course: tinf, likes: [wgabend])
        sophie.save(flush: true)
        def ano = new User(prename: "Ano", surname: "Nymus", loginname: "anonymus", password: "111", course: tinf, likes: [sport])
        ano.save(flush: true)

        def tinfTemp = Course.get(tinf.id)
        tinfTemp.speaker1 = hanne
        tinfTemp.speaker2 = ano


    }
    def destroy = {
    }
}