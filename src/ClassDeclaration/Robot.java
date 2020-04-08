package ClassDeclaration;
/*На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
        Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
        В начальный момент робот находится в некоторой позиции на поле.
        Также известно, куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести
        робота в заданную точку игрового поля.

        Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
Direction, направление взгляда робота,  — это перечисление:
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
        В метод передано: toX == 3, toY == 0; начальное состояние робота такое:
        robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();
        */

import java.math.*;
import java.util.Arrays;

public class Robot {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    int x;
    int y;
    Direction dir;

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (dir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
        }
    }

    public void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
    }

    public void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
    }


    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction direct = robot.getDirection();
        int x = robot.getX();
        int y = robot.getY();

        if (direct.equals(Direction.LEFT)) {
            robot.turnRight();
        } else if (direct.equals(Direction.RIGHT)) {
            robot.turnLeft();
        } else if (direct.equals(Direction.DOWN)) {
            robot.turnRight();
            robot.turnRight();
        }

        if (toX > x) {
            System.out.println("Робот поворачивает вправо");
            robot.turnRight();
            for (int i = x; i < toX; i++) {
                System.out.println("Робот движется вперед");
                robot.stepForward();
            }
            if (toY > y) {
                System.out.println("Робот поворачивает влево");
                robot.turnLeft();
                for (int i = y; i < toY; i++) {//
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            } else if (toY < y) {
                System.out.println("Робот поворачивает вправо");
                robot.turnRight();
                for (int i = toY; i < y; i++) {//
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            }

        } else if (toX < x) {
            System.out.println("Робот поворачивает влево");
            robot.turnLeft();
            for (int i = toX; i < x; i++) {
                System.out.println("Робот движется вперед");
                robot.stepForward();
            }
            if (toY > y) {
                System.out.println("Робот поворачивает вправо");
                robot.turnRight();
                for (int i = y; i < toY; i++) {
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            } else if (toY < y) {
                System.out.println("Робот поворачивает влево");
                robot.turnLeft();
                for (int i = toY; i < y; i++) {
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            }

        } else {
            if (toY > y) {
                for (int i = y; i < toY; i++) {
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            } else if (toY < y) {
                System.out.println("Робот поворачивает влево");
                robot.turnLeft();
                System.out.println("Робот поворачивает влево");
                robot.turnLeft();
                for (int i = toY; i < y; i++) {
                    System.out.println("Робот движется вперед");
                    robot.stepForward();
                }
            }
        }
    }
}
