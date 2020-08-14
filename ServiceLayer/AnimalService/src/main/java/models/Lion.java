package models;

public class Lion extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the lion growled.");
    }
}
