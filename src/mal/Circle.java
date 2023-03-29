package mal;

public class Circle extends Shape {
    public void Circle_zeigen(){
        String text_temp="";
        System.out.println("\nCircle");

        byte count_space = 5;
        byte count_stern = 3;

        for (byte k =0; k<5; k++){
            count_space-=2;
            count_stern+=2;

            for(byte i = count_space; i>0;i--){
                text_temp += "  ";
            }

            for(byte j = count_stern; j>0;j--){
                text_temp += "* ";
            }
            System.out.println(text_temp);
        }



    }
}
