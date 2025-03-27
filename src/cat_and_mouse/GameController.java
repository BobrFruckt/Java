package cat_and_mouse;

import cat_and_mouse.Cat;
import cat_and_mouse.Mouse;

public class GameController {
    public static void runGame() {

        Cat tom = new Cat("Том", 10, 5);
        Cat jerry = new Cat("Джерри", 8, 4);

        Mouse fastMouse = new Mouse(9);
        Mouse slowMouse = new Mouse(5);

        tom.catchMouse(fastMouse);
        tom.catchMouse(slowMouse);

        jerry.catchMouse(fastMouse);
        jerry.catchMouse(slowMouse);

        tom.attackCat(jerry);

        System.out.println("\nРезультаты:");
        System.out.println(tom.getName() + " поймал " + tom.getCaughtMice().size() + " мышей");
        System.out.println(jerry.getName() + " поймал " + jerry.getCaughtMice().size() + " мышей");
    }
}