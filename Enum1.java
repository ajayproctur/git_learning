

public enum Enum1 {
    KF,KO,RO,FO
}

class Test{
    public static void main(String[] args) {
        Enum1 [] e=Enum1.values();
        for(var en:e){
            
            System.out.println(en);
        }
    }
}