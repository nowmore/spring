package JDBC;

public class Customer {
    int     ID;
    int     age;
    String  name;

    public Customer(){}
    public Customer(int ID, String name, int age){
        this.ID     = ID;
        this.name   = name;
        this.age    = age;
    }
    public int      getID(){ return this.ID;}
    public int      getAge(){return this.age;}
    public String   getName(){return this.name;}
    public void     setID(int ID){this.ID = ID;}
    public void     setAge(int age) {this.age = age;}
    public void     setName(String name) {this.name = name;}

    @Override
    public String toString() {
        String str = String.format("id = %d's name is %s, %d years old!", ID, name, age);
        /*return "id = " + ID + "'s Name is " + name + ", " + age + "years old!";*/
        return str;
    }
}
