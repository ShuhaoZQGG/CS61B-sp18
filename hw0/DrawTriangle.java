public class DrawTriangle {
    public static void drawTriangle(int rows) {
        for (int i = 0; i <= rows; i += 1) {
            for (int j = 0; j <= i; j += 1) {
                System.out.print('*');
            }
            System.out.println( );
        }
    }
    public static void main (String[] args) {
        drawTriangle(5);
    }
}