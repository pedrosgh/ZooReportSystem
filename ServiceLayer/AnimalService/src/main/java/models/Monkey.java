package models;

public class Monkey extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the monkey walked on his hands.");
    }
}