package models;

public class Tiger extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the tiger jumped up the platforms.");
    }
}
