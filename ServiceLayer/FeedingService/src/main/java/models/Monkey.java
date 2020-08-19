package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Monkey extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the monkey walked on his hands.");
    }
}