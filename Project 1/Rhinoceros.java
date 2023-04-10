public class Rhinoceros {


    //instacne variables that are unique to each Rhinoceros
    private double hornLength;
    private String name;
    private int weight;


    //contructor that creates a Rhinoceros object and instantiates the instance variables
    public Rhinoceros (double h, String n, int w){
        hornLength = h;
        name = n;
        weight = w;
    }


    //getters and setters for each instance variable that
    //return the variable or modify the variable respectively
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public double getHornLength(){
        return hornLength;
    }
    public void setHornLength(double h){
        hornLength = h;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int w){
        weight = w;
    }


    //This method takes the name and weight of an object and determines how effective a rhinoceros would be at destroying it.
    //Then it prints a statement describing the results
    public void charge(String object, int objectWeight){
        if(objectWeight<15){
            System.out.println(name + " the rhino squished the " + object + " under its foot.");
        }
        else if(objectWeight<10000){
            System.out.println(name + " the rhino charged at the " + object +" and pierces it with its horn.");
        }
        else{
            System.out.println(name + " the rhino is able to deal some damage but the " + object + " is just too tough to be destroyed.");
        }
    }


    //This method takes a list of Rhinos as a parameter and, based on their horn length, describes their horn.
    public static void hornEval (Rhinoceros[] list){
        for(Rhinoceros x: list){
            if(x.getHornLength() < 12){
                System.out.println(x.getName() + " has a short horn.");
            }
            else if (x.getHornLength() < 30){
                System.out.println(x.getName() + " has a really big horn.");
            }
            else{
                System.out.println(x.getName() + " has a magnificent horn.");
            }
        }
    }
}
