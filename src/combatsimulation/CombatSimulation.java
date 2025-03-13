public class CombatSimulation {
    public static void main(String[] args) {
        Soldier soldier = new Soldier("Private Ryan");
        AK47 ak47 = new AK47(30);
        Pistol pistol = new Pistol(15);
        Sniper sniper = new Sniper(5);

        soldier.addGun(ak47);
        soldier.addGun(pistol);
        soldier.addGun(sniper);

        soldier.displayInventory();

        soldier.shoot();
        soldier.switchGun(1);
        soldier.shoot();
        soldier.switchGun(2);
        soldier.shoot();

        while (soldier.getClass() != null) {
            soldier.shoot();
            if (sniper.getBullets() == 0) break;
        }

        soldier.reloadCurrentGun(10);

        soldier.displayInventory();
        soldier.dropGun(1);
        soldier.addGun(new Pistol(20));
        soldier.displayInventory();

        soldier.dropGun(2);
        soldier.shoot();
    }
}