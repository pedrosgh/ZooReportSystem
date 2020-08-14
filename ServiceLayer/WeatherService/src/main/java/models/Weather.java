package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weather {
    private int id; //instance id
    private double lat;
    private double lon; //location
    private int minTemp;
    private int maxTemp;
    private int avTemp; //minimum, maximum and average temperatures
    private boolean rain; //rain prediction

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getAvTemp() {
        return avTemp;
    }

    public void setAvTemp(int avTemp) {
        this.avTemp = avTemp;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }
}
