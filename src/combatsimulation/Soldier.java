public class Soldier {
    private String name;
    private Gun[] guns;
    private int currentGunIndex;
    private static final int MAX_GUNS = 3;

    public Soldier(String name) {
        this.name = name;
        this.guns = new Gun[MAX_GUNS];
        this.currentGunIndex = -1;
    }

    // Adds a gun to the first empty slot
    public void addGun(Gun gun) {
        for (int i = 0; i < MAX_GUNS; i++) {
            if (guns[i] == null) {
                guns[i] = gun;
                // Sets added gun as current gun if none selected
                if (currentGunIndex == -1) currentGunIndex = i;
                System.out.println(name + " picked up " + gun.getName());
                return;
            }
        }
        System.out.println(name + " cannot carry more than " + MAX_GUNS + " guns!");
    }

    // Removes a gun from a slot
    public void dropGun(int index) {
        if (index >= 0 && index < MAX_GUNS && guns[index] != null) {
            System.out.println(name + " dropped " + guns[index].getName());
            guns[index] = null;
            // Adjust current gun if needed
            if (currentGunIndex == index) {
                currentGunIndex = findNextAvailableGun();
            }
        } else {
            System.out.println("Invalid gun slot to drop!");
        }
    }

    // Changes the current gun by index
    public void switchGun(int index) {
        if (index >= 0 && index < MAX_GUNS && guns[index] != null) {
            currentGunIndex = index;
            System.out.println(name + " switched to " + guns[index].getName());
        } else {
            System.out.println("Cannot switch to that gun slot!");
        }
    }

    public void shoot() {
        if (currentGunIndex == -1 || guns[currentGunIndex] == null) {
            System.out.println(name + " has no gun equipped to shoot!");
        } else {
            guns[currentGunIndex].shoot();
        }
    }

    public void reloadCurrentGun(int bullets) {
        if (currentGunIndex != -1 && guns[currentGunIndex] != null) {
            guns[currentGunIndex].reload(bullets);
        } else {
            System.out.println(name + " has no gun to reload!");
        }
    }

    // Helper to find a new current gun after dropping
    private int findNextAvailableGun() {
        for (int i = 0; i < MAX_GUNS; i++) {
            if (guns[i] != null) return i;
        }
        return -1;
    }

   /*
    Shows which guns are equipped, their bullet counts,
    and which gun is currently selected
    */
    public void displayInventory() {
        System.out.println("\n" + name + "'s Inventory:");
        for (int i = 0; i < MAX_GUNS; i++) {
            if (guns[i] != null) {
                System.out.println("Slot " + i + ": " + guns[i].getName() + 
                                 " (Bullets: " + guns[i].getBullets() + ")" +
                                 (i == currentGunIndex ? " [Selected]" : ""));
            } else {
                System.out.println("Slot " + i + ": Empty");
            }
        }
        System.out.println();
    }
}