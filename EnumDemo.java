

enum B{
    KF,KO,RC,FO;
}
enum C{
    A,B,C,E;//will get compile time error if we remove semicolon from here
    public static void main(String[] args) {
        
    }
}
enum D{
    A,B,C,D;
    public void methodOne(){

    }
}

enum E{
    ;
    public  void methodTwo(){

    }
}

enum F{
    // public void methodOne(){} invalid
}

enum P{
    // public void methodOne(){}
    // A,B,C,D->Enum constant must be declared in the first line
}
public class EnumDemo {
    public static void main(String[] args) {
        B[] bs=B.values();
        for(var b:bs){
            System.out.println(b+" : "+b.ordinal());
        }

        

    }
}
