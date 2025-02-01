import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        Inventory inventory = new Inventory();

        inventory.addItems(new Item("Iron Sword", "Common"));
        inventory.addItems(new Item("Iron Sword", "Common"));
        inventory.addItems(new Item("Iron Sword", "Common"));

        inventory.addItems(new Item("Pistol", "Great"));

        while(true)
        {
            System.out.println("\nMenu");
            System.out.println("\n1. Display my collection");
            System.out.println("2. Add new items to my collection");
            System.out.println("3. Upgrade my items");
            System.out.println("4. Finish");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice)
            {
                case 1:
                    inventory.displayCollectioin();
                    break;
                case 2:
                    System.out.print("Enter item name you want to add ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter your preferred rarity (Common, Great, Rare, Epic, Epic 1, Epic 2) ");
                    String newRarity = scanner.nextLine();
                    inventory.addItems(new Item(name, newRarity));
                    break;
                case 3:
                    System.out.print("Enter item name you want to upgrade ");
                    String upgradeName = scanner.nextLine();
                    scanner.nextLine();
                    inventory.upgradeItem(upgradeName);
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Please choose an option from the menu");
            }
        }
    }
}