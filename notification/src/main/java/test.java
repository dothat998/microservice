import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String abc = "$@#$@#$@#$@4";
        int so = 7;
        Boolean aBoolean = laChuoiSo(abc);
        Boolean aBoolean1 = laSoNguyenTo(so);
        if (aBoolean1){
            System.out.println("so nguyen to");
        }
        else {
            System.out.println("not thing ");
        }
        if (aBoolean){
            System.out.println("Day la chuoi so");
        }
        else {
            System.out.println("Khong la gi ca");
        }
    }
    public static Boolean laChuoiSo(String inputs) {

        if(inputs == null || (inputs != null && inputs.isEmpty())) {

            return false;

        }

        Pattern pattern = Pattern.compile(".*[^0-9].*");

        for (int i = 0; i < inputs.length(); i++) {

            String input = inputs.substring(i, i + 1);

            Boolean blCheck = !pattern.matcher(input).matches();

            if(!blCheck) {

                return false;

            }

        }

        return true;

    }
    public static Boolean laSoNguyenTo(int n) {

        if(n < 2) { return false;

        }

        int square = (int) Math.sqrt(n);

        for(int i = 2; i < square; i++) {

            if(i % 2 == 0) {

                return false;

            }

        }

         return true;
    }
}
