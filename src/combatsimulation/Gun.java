public abstract class Gun {
    protected String name;
    protected int bullets;

    // initializes a gun with a name and bullet count
    public Gun(String name, int initialBullets) {
        this.name = name;
        this.bullets = initialBullets;
    }

    public abstract void shoot();

    public void reload(int bullets) {
        this.bullets += bullets;
        System.out.println(name + " reloaded. Current bullets: " + this.bullets);
    }

 // Get methods provide access to the protected fields
    public String getName() {
        return name;
    }

    public int getBullets() {
        return bullets;
    }
}