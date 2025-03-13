public class Sniper extends Gun {
    public Sniper(int initialBullets) {
        super("Sniper", initialBullets);
    }

    @Override
    public void shoot() {
        if (bullets >= 1) {
            bullets -= 1;
            System.out.println("Sniper fires: BOOM! Bullets left: " + bullets);
        } else {
            System.out.println("Sniper: No ammo remaining!");
        }
    }
}