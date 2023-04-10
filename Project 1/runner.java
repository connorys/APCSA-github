public class runner {
    public static void main (String args[]){
        Rhinoceros Todd = new Rhinoceros(35, "Todd", 4000);
        Rhinoceros Jeff = new Rhinoceros(20, "Jeff", 2000);
        Rhinoceros Steve = new Rhinoceros(8, "Steve", 3000);


        Todd.charge("soda can",1);
        Jeff.charge("car", 5000);
        Steve.charge("tank", 110000);

        Rhinoceros[] list = {Todd,Jeff,Steve};
        Rhinoceros.hornEval(list);
    }
}