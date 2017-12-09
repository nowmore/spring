package AutoFill;

public class Person {
    private String  name;
    private String  addr;
    private int     age;
    private Ability ability;

    public Person(){}

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public Ability getAbility() {
        return ability;
    }

    public int getAge() {
        return age;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old, live in %s, who can %s", name, age, addr, ability);
    }
}
