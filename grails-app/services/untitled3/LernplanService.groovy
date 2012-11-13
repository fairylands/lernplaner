package untitled3

class LernplanService {

    static transactional = false

    def serviceMethod() {




    }

    def zeitInZahl(float time){

        def number = time.intValue()+ ((time - time.intValue())/0.6)
        number = number.round(2)
        return number;

    }

    def zahlInZeit(float number){

        def time = number.intValue() + ((number - number.intValue())*0.6)

          time = time.round(2)
         return time;

    }
}
