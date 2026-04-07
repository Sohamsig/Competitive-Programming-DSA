class Robot {

    int width, height;
    int x, y, dir;

    // Directions: East, North, West, South
    String[] directions = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        x = 0;
        y = 0;
        dir = 0; // East
    }

    public void step(int num) {
        int perimeter = 2 * (width + height) - 4;
        
        num %= perimeter;

    
        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
            return;
        }

        while (num > 0) {

            if (dir == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
            }

            else if (dir == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
            }

            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
            }

            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
            }

            if (num > 0) {
                dir = (dir + 1) % 4; // turn counterclockwise
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return directions[dir];
    }
}
