package untitled3

class Term {

    String dayOfWeek
    float starttime
    float endtime
    float duration



    static belongsTo = [subject: Subject, term: Term]

    static constraints = {

        subject nullable: true //Weil es ja auch Terms gibt, die zu einem Like gehören
        term nullable: true
    }


    def getStarttimeConverted() {
        def time = starttime.intValue() + ((starttime - starttime.intValue())*0.6)

        return time
    }

    def getEndtimeConverted() {
        def time = endtime.intValue() + ((endtime - endtime.intValue())*0.6)

        return time
        /*
        time = time.toString()

        if(time.length()==5){
            return time
        }
        else if(time.length() == 4){

            if(time[2]== '.'){
                time= time + '0'
                return time
            }
            else if(time[1]=='.')  {
                return time
            }
        }
        else if(){




        }
        */

    }
}
