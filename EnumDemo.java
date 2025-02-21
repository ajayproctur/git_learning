enum B{
    KF,KO,RC,FO;
}
public class EnumDemo {
    public static void main(String[] args) {
        B[] bs=B.values();
        for(var b:bs){
            System.out.println(b+" : "+b.ordinal());
        }

        

    }
}
