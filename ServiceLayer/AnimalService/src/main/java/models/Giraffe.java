package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Giraffe extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the giraffe got up on its hind legs.");
    }
}
