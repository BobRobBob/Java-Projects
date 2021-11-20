import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;

public class MazeSolver {

    //0 = wall
    //1 = path
    //2 = destination

    static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Maze> mazes = readMazes();

        int i = 0;
        while(i < mazes.size()) {
            if (solveMaze(mazes.get(i))){
                System.out.println("You won! It took: " + (counter + 1) + " tries" + "\n");
                counter = 0;
            } else {
                System.out.println("No path, took: " + (counter + 1) + " tries to figure out" + "\n");
                counter = 0;
            }
            i++;
        }
    }

    private static boolean solveMaze(Maze m){
        //use push for stack functionality
        Position p = m.start;
        m.path.push(p);

        while(true){
            int y = m.path.peek().getY(); //get y position
            int x = m.path.peek().getX(); //get x position

            m.maze[y][x] = 0;

            //move down in the maze
            if(isValid(y+1, x, m)) {
                if (m.maze[y + 1][x] == 2) {
                    System.out.println("Moved up.");
                    return true;
                } else if (m.maze[y + 1][x] == 1) {
                    System.out.println("Moved down");
                    counter++;
                    m.path.push(new Position(y + 1, x));
                    continue;
                }
            }
            //move left in the maze
            if(isValid(y, x-1, m)) {
                if (m.maze[y][x - 1] == 2) {
                    System.out.println("Moved left.");
                    return true;
                } else if (m.maze[y][x - 1] == 1) {
                    System.out.println("Moved left");
                    counter++;
                    m.path.push(new Position(y, x - 1));
                    continue;
                }
            }
            //move up in the maze
            if(isValid(y - 1, x, m)) {
                if (m.maze[y - 1][x] == 2) {
                    System.out.println("Moved up.");
                    return true;
                } else if (m.maze[y - 1][x] == 1) {
                    System.out.println("Moved up");
                    counter++;
                    m.path.push(new Position(y - 1, x));
                    continue;
                }
            }
            //move right in the maze
            if(isValid(y, x + 1, m)) {
                if (m.maze[y][x + 1] == 2) {
                    System.out.println("Moved right.");
                    return true;
                } else if (m.maze[y][x + 1] == 1) {
                    System.out.println("Moved right");
                    counter++;
                    m.path.push(new Position(y, x + 1));
                    continue;
                }
            }
            m.path.pop();
            System.out.println("Moved back");
            counter++;
            if(m.path.size() <= 0){
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x, Maze m){
        if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length){
          return false;
        } return true;
    }

    public static ArrayList<Maze> readMazes() throws FileNotFoundException{
        ArrayList<Maze> mazes = new ArrayList<Maze>();
        Scanner in = new Scanner(new File("mazes3.txt"));

        while(in.hasNext()){
            Maze m = new Maze();
            int rows = Integer.parseInt(in.nextLine());

            m.maze = new int[rows][];

            for(int i = 0; i < rows; i++){
                String line = in.nextLine();
                m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
            }
            m.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));

            in.nextLine(); //moves to next maze

            mazes.add(m);
        }
        in.close();


        return mazes;
    }

}
