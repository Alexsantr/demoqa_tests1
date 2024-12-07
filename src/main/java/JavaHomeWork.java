public class JavaHomeWork {
    public static  void main (String...args)
    {
        int oInt = 6;
        int tInt = 2;
        double fDouble = 3.0;
        System.out.println("Арифметические операции");
        System.out.println(oInt +tInt);
        System.out.println(oInt -tInt);
        System.out.println(oInt *tInt);
        System.out.println(oInt /tInt);

        System.out.println("\n"+"Арифметические операторы int and double ");
        System.out.println(oInt +fDouble);
        System.out.println(oInt -fDouble);
        System.out.println(oInt *fDouble);
        System.out.println(oInt /fDouble);

        System.out.println("\n"+"Логические операторы");
        System.out.println(oInt >fDouble);
        System.out.println(oInt <fDouble);
        System.out.println(oInt >=fDouble);
        System.out.println(oInt <=fDouble);

        System.out.println("\n"+"Минимальные и максимальнгые занчения float and double вещественные типы и приметивные int and byte");
        System.out.println("Float.MIN_VALUE: " + Float.MIN_VALUE);
        System.out.println("Float.MAX_VALUE: " + Float.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE: " + Byte.MAX_VALUE);
        System.out.println("Byte.MAX_VALUE: " + Byte.MIN_VALUE);



        int maxInteger = Integer.MAX_VALUE +2;
        int minInteger = Integer.MIN_VALUE -2;
        byte maxByte = (byte) (Byte.MAX_VALUE+1);
        byte minByte = (byte) (Byte.MIN_VALUE -1);
        double maxDouble = Double.MAX_VALUE *2;
        float maxFloat = Float.MAX_VALUE *2;

        System.out.println("\n"+"Переполнение при арифметической операции вещественные типы и приметивные типы");
        System.out.println("Integer.MAX_VALUE:"+maxInteger);
        System.out.println("Integer.MIN_VALUE:"+minInteger);
        System.out.println("Byte.MAX_VALUE:"+maxByte);
        System.out.println("Byte.MIN_VALUE:"+minByte);
        System.out.println("Double.MAX_VALUE:"+maxDouble);
        System.out.println("Float.MAX_VALUE:"+maxFloat);







    }
}
