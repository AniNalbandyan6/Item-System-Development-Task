public class Item {
    String name;
    String rarity;
    int upgradeCount;

    public Item(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public int getUpgradeCount()
    {
        return upgradeCount;
    }

    @Override
    public String toString() {
        return name ;
    }

    public void setRarity(String newRarity) {
        this.rarity = newRarity;
        if (rarity.equals("Epic")) {
            this.upgradeCount = 0;
        }
    }

    public void upgradedCount() {
        this.upgradeCount++;
    }
}