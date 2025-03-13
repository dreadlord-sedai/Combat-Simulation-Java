public class AK47 extends Gun {
    public AK47(int initialBullets) {
        super("AK47", initialBullets);
    }

    @Override
    public void shoot() {
        if (bullets >= 3) {
            bullets -= 3;
            System.out.println("AK47 fires: Trrrrrr...! Bullets left: " + bullets);
        } else {
            System.out.println("AK47: Not enough bullets to fire! Bullets left: " + bullets);
        }
    }
}