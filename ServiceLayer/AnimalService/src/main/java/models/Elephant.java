package models;

public class Elephant extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the elephant waved with its trump.");
    }
}
