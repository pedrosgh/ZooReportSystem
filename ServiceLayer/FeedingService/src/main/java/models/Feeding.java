package models;

public class Feeding {
    //Food prices - will later be placed inside a DB rather than stored here
    private final double MEAT_PRICE = 6; // €/Kg
    private final double FISH_PRICE = 4;
    private final double LEAF_PRICE = 1.75;
    private final double FRUIT_PRICE = 2.25;

    private int rId, avTemp;
    private int nLions, nTigers, nMonkeys, nGiraffes, nElephants;
    private double meatAmount, fishAmount, leafAmount, fruitAmount;
    private double foodCosts, hungerVariation;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getAvTemp() {
        return avTemp;
    }

    public void setAvTemp(int avTemp) {
        this.avTemp = avTemp;
    }

    public int getnLions() {
        return nLions;
    }

    public void setnLions(int nLions) {
        this.nLions = nLions;
    }

    public int getnTigers() {
        return nTigers;
    }

    public void setnTigers(int nTigers) {
        this.nTigers = nTigers;
    }

    public int getnMonkeys() {
        return nMonkeys;
    }

    public void setnMonkeys(int nMonkeys) {
        this.nMonkeys = nMonkeys;
    }

    public int getnGiraffes() {
        return nGiraffes;
    }

    public void setnGiraffes(int nGiraffes) {
        this.nGiraffes = nGiraffes;
    }

    public int getnElephants() {
        return nElephants;
    }

    public void setnElephants(int nElephants) {
        this.nElephants = nElephants;
    }

    public double getMeatAmount() {
        return meatAmount;
    }

    public void setMeatAmount(double meatAmount) {
        this.meatAmount = meatAmount;
    }

    public double getFishAmount() {
        return fishAmount;
    }

    public void setFishAmount(double fishAmount) {
        this.fishAmount = fishAmount;
    }

    public double getLeafAmount() {
        return leafAmount;
    }

    public void setLeafAmount(double leafAmount) {
        this.leafAmount = leafAmount;
    }

    public double getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(double fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public double getFoodCosts() {
        return foodCosts;
    }

    public void setFoodCosts(double foodCosts) {
        this.foodCosts = foodCosts;
    }

    public void feedAnimals() {
        hungerVariation = 1;
        if(avTemp < 10) hungerVariation = 1.15;
        if(avTemp > 25) hungerVariation = 0.9;

        foodCosts = 0;
        foodCosts += calculateLionFeedingCost();
        foodCosts += calculateTigerFeedingCost();
        foodCosts += calculateMonkeyFeedingCost();
        foodCosts += calculateGiraffeFeedingCost();
        foodCosts += calculateElephantFeedingCost();
    }

    private double calculateLionFeedingCost() {

        double meatCosts = nLions * (50 * hungerVariation) * MEAT_PRICE;
        double fishCosts = nLions * (70 * hungerVariation) * FISH_PRICE;
        double fruitCosts = nLions * (100 * hungerVariation) * FRUIT_PRICE;

        if(meatCosts < fishCosts && meatCosts < fruitCosts) {
            meatAmount = 50 * hungerVariation;
            return meatCosts;
        } else if (fishCosts < meatCosts && fishCosts < fruitCosts) {
            fishAmount = 70 * hungerVariation;
            return fishCosts;
        } else {
            fruitAmount = 100 * hungerVariation;
            return fruitCosts;
        }
    }

    private double calculateTigerFeedingCost() {
        double meatCosts = nTigers * (50/2 * hungerVariation) * MEAT_PRICE;
        double fishCosts = nTigers * (70/2 * hungerVariation) * FISH_PRICE;
        double fruitCosts = nTigers * (100/2 * hungerVariation) * FRUIT_PRICE;

        if(meatCosts < fishCosts && meatCosts < fruitCosts && meatCosts > 0) {
            meatAmount += 50/2 * hungerVariation;
            return meatCosts;
        } else if (fishCosts < meatCosts && fishCosts < fruitCosts && fishCosts > 0) {
            fishAmount += 70/2 * hungerVariation;
            return fishCosts;
        } else {
            fruitAmount += 100/2 * hungerVariation;
            return fruitCosts;
        }
    }

    private double calculateMonkeyFeedingCost() {
        double fruitCosts = nMonkeys * (25 * hungerVariation) * FRUIT_PRICE;
        double leafCosts = nMonkeys * (20 * hungerVariation) * LEAF_PRICE;

        if(leafCosts < fruitCosts) {
            leafAmount = 20 * hungerVariation;
            return leafCosts;
        } else {
            fruitAmount += 25 * hungerVariation;
            return fruitCosts;
        }
    }

    private double calculateGiraffeFeedingCost() {
        double fruitCosts = nGiraffes * (Math.pow(25, 2) * hungerVariation) * FRUIT_PRICE;
        double leafCosts = nGiraffes * (Math.pow(20, 2) * hungerVariation) * LEAF_PRICE;

        if(leafCosts < fruitCosts) {
            leafAmount += Math.pow(20, 2) * hungerVariation;
            return leafCosts;
        } else {
            fruitAmount += Math.pow(25, 2) * hungerVariation;
            return fruitCosts;
        }
    }

    private double calculateElephantFeedingCost() {
        double fruitCosts = nGiraffes * (Math.pow(25, 2) * 2 * hungerVariation) * FRUIT_PRICE;
        double leafCosts = nGiraffes * (Math.pow(20, 2) * 2 * hungerVariation) * LEAF_PRICE;

        if(leafCosts < fruitCosts) {
            leafAmount += Math.pow(20, 2) * 2 * hungerVariation;
            return leafCosts;
        } else {
            fruitAmount += (Math.pow(25, 2) * 2 * hungerVariation);
            return fruitCosts;
        }
    }

}
