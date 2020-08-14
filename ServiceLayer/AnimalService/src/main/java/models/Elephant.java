package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Elephant extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the elephant waved with its trump.");
    }
}
