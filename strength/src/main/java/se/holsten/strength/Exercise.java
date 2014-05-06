package se.holsten.strength;

/**
 * Created by fredrik.holstensson on 2014-05-06.
 */
public class Exercise {
    private int _id;
    private String _name;
    private double _weight;
    private String _level;
    public Exercise(int id, String name){
        _id = id;
        _name = name;
        _weight = 0;
        _level = "-";
    }
    public int getId(){return _id;}
    public String getName() {return _name;}
    public void setWeight(double weight){_weight = weight;}
    public double getWeight(){return _weight;}
    public void setLevel(double weight){_weight = weight;}
    public double getLevel(){return _weight;}

}
