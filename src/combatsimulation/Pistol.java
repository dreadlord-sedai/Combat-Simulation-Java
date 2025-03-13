public class Pistol extends Gun {
    public Pistol(int initialBullets) {
        super("Pistol", initialBullets);
    }

    @Override
    public void shoot() {
        if (bullets >= 1) {
            bullets -= 1;
            System.out.println("Pistol fires: BANG! Bullets left: " + bullets);
        } else {
            System.out.println("Pistol: Out of bullets!");
        }
    }
}