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

        time = time.round(2).toString()

        return zeitabfrage(time)


    }

    def getEndtimeConverted() {
        def time = endtime.intValue() + ((endtime - endtime.intValue())*0.6)

        time = time.round(2).toString()

       return zeitabfrage(time)



    }

    def zeitabfrage(String time){

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
        else if(time.length() == 3){

            if(time[2]== '.'){
                time = time + '00'
                return time
            }
            else if(time[1]== '.'){
                time = time + '0'
                return time
            }
        }
        else if(time.length() == 2){
            time = time + '.00'
            return time
        }

        return time



    }
}
