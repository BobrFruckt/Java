package cat_and_mouse;

import java.util.ArrayList;

public class Cat {
    private final String name;
    private final int speed;
    private final int weight;
    private final ArrayList<Mouse> caughtMice;

    public Cat(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.caughtMice = new ArrayList<>(100);
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<Mouse> getCaughtMice() {
        return new ArrayList<>(caughtMice);
    }

    public boolean catchMouse(Mouse mouse) {
        if (caughtMice.size() >= 100) {
            System.out.println(name + " не может поймать больше мышей - достигнут лимит!");
            return false;
        }

        if (this.speed > mouse.getSpeed()) {
            caughtMice.add(mouse);
            System.out.println(name + " поймал мышь со скоростью " + mouse.getSpeed());
            return true;
        }
        System.out.println(name + " не смог поймать мышь - недостаточно скорости!");
        return false;
    }

    public void attackCat(Cat otherCat) {
        if (this.weight > otherCat.getWeight()) {
            System.out.println(name + " атакует " + otherCat.getName() + " и побеждает!");

            ArrayList<Mouse> miceToTransfer = new ArrayList<>();
            for (Mouse mouse : otherCat.getCaughtMice()) {
                if (this.speed > mouse.getSpeed()) {
                    miceToTransfer.add(mouse);
                }
            }

            otherCat.caughtMice.removeAll(miceToTransfer);

            for (Mouse mouse : miceToTransfer) {
                if (caughtMice.size() < 100) {
                    caughtMice.add(mouse);
                } else {
                    System.out.println(name + " не может принять больше мышей - достигнут лимит!");
                    break;
                }
            }

            System.out.println(name + " забрал " + miceToTransfer.size() + " мышей у " + otherCat.getName());
        } else {
            System.out.println(name + " атаковал " + otherCat.getName() + ", но проиграл из-за меньшего веса!");
        }
    }
}