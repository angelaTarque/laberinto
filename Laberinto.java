public class Laberinto {
    public static boolean puedoSalir(int n, String[] maze) {
        boolean[][] visitado = new boolean[n][n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i].charAt(j) == '*') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        return buscarSalida(n, maze, visitado, x, y);
    }

    private static boolean buscarSalida(int n, String[] maze, boolean[][] visitado, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || visitado[x][y] || maze[x].charAt(y) == '?') {
            return false;
        }
        if (maze[x].charAt(y) == 'E') {
            return true;
        }
        
        visitado[x][y] = true;
        boolean puedoSalir = buscarSalida(n, maze, visitado, x + 1, y);
        if (!puedoSalir) {
            puedoSalir = buscarSalida(n, maze, visitado, x - 1, y);
        }
        if (!puedoSalir) {
            puedoSalir = buscarSalida(n, maze, visitado, x, y + 1);
        }
        if (!puedoSalir) {
            puedoSalir = buscarSalida(n, maze, visitado, x, y - 1);
        }

        return puedoSalir;
    }

    public static void main(String[] args) {
        int n = 5;
        String[] maze = {
            "*???*",
            "??***",
            "?*?*?",
            "?****",
            "E*???"
        };
        boolean puedoSalir = puedoSalir(n, maze);
        System.out.println("¿Puedo salir del laberinto? " + puedoSalir);
    }
}
