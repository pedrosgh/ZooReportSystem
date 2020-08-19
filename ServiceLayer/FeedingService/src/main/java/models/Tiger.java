package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tiger extends Animal {
    @Override
    public void doTrick() {
        System.out.println(this.getName() + " the tiger jumped up the platforms.");
    }
}
