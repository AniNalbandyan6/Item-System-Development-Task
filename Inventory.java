import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventory {
    public final List<Item> itemList = new ArrayList<>();

    public void addItems(Item item)
    {
        itemList.add(item);
        System.out.println(item.name + " added to your collection");
    }

    public void displayCollectioin()
    {
        System.out.println("~ Your Collection ~");
        if(itemList.isEmpty())
        {
            System.out.println("Your collection is empty. Play the game to fill it");
        }

        Set<String> rarityGroups = new HashSet<>();
        for (Item item  : itemList)
        {
            rarityGroups.add(item.getRarity());
        }
        for (String rarity : rarityGroups)
        {
            System.out.println(rarity + " ");
            for (Item item : itemList)
            {
                if (item.getRarity().equals(rarity))
                {
                    System.out.println(" " + item);
                }
            }
        }
    }

    public void upgradeItem(String itemName) {
        Item itemToUpgrade = findItem(itemName);

        if (itemToUpgrade == null) {
            System.out.println("No such item in your collection");
            return;
        }

        switch (itemToUpgrade.getRarity()) {
            case "Common":
                upgradeCommon(itemToUpgrade);
                break;
            case "Great":
                upgradeGreat(itemToUpgrade);
                break;
            case "Rare":
                upgradeRare(itemToUpgrade);
                break;
            case "Epic":
                upgradeEpic(itemToUpgrade);
                break;
            case "Epic1":
                upgradeEpic1(itemToUpgrade);
                break;
            case "Epic2":
                upgradeEpic2(itemToUpgrade);
                break;
            default:
                System.out.println("No upgrades possible");
        }
    }

    private Item findItem(String name) {
        return itemList.stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private void upgradeCommon(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Common") && i.getName().equals(item.getName())).count();
        if (count >= 3) {
            item.setRarity("Great");
            System.out.println(item.getName() + " upgraded to Great!");
            itemList.removeIf(i -> i.getRarity().equals("Common") && i.getName().equals(item.getName()) && !i.equals(item));
        } else {
            System.out.println("Not enough Common items to upgrade. Continue adding items to your collection");
        }
    }

    private void upgradeGreat(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Great") && i.getName().equals(item.getName())).count();
        if (count >= 3) {
            item.setRarity("Rare");
            System.out.println(item.getName() + " upgraded to Rare!");
            itemList.removeIf(i -> i.getRarity().equals("Great") && i.getName().equals(item.getName()) && !i.equals(item));
        } else {
            System.out.println("Not enough Great items to upgrade. Continue adding items to your collection");
        }
    }

    private void upgradeRare(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Rare") && i.getName().equals(item.getName())).count();
        if (count >= 3) {
            item.setRarity("Epic");
            System.out.println(item.getName() + " upgraded to Epic!");
            itemList.removeIf(i -> i.getRarity().equals("Rare") && i.getName().equals(item.getName()) && !i.equals(item));
        } else {
            System.out.println("Not enough Rare items to upgrade. Continue adding items to your collection.");
        }
    }

    private void upgradeEpic(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Epic") && i.getName().equals(item.getName())).count();
        if (count >= 2) {
            item.setRarity("Epic1");
            System.out.println(item.getName() + " upgraded to Epic1!");
            item.upgradedCount();
        } else {
            System.out.println("Not enough Epic items to upgrade. Continue adding items to your collection.");
        }
    }

    private void upgradeEpic1(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Epic") && i.getName().equals(item.getName())).count();
        if (count >= 2) {
            item.setRarity("Epic2");
            System.out.println(item.getName() + " upgraded to Epic2!");
            item.upgradedCount();
        } else {
            System.out.println("Not enough Epic1 items to upgrade. Continue adding items to your collection");
        }
    }

    private void upgradeEpic2(Item item) {
        long count = itemList.stream().filter(i -> i.getRarity().equals("Epic 2") && i.getName().equals(item.getName())).count();
        if (count >= 3) {
            item.setRarity("Legendary");
            System.out.println(item.getName() + " upgraded to Legendary!");
            item.upgradedCount();
        } else {
            System.out.println("Not enough Epic2 items to upgrade. Continue adding items to your collection");
        }
    }
}
