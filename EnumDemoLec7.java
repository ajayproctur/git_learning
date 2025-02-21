

enum Prac{
    A,B,C,D,E,F,G;
    Prac(){
        System.out.println("Constructor Executed...");
    }
}

enum ConstDemo{
    A,B(),C(895),E(9024);//->No-arg,No-arg,int-arg,int-arg
    int price;
    ConstDemo(){
        this.price=60;
    }
    ConstDemo(int price){
        this.price=price;
    }
    public int getPrice() {
        return price;
    }
    
}

public class EnumDemoLec7 {
    public static void main(String[] args) {
        Prac p=Prac.A;//if we comment this line then Prac will not be loaded and hence constructor will not be executed
        // Prac p1=new Prac();->Invalid
        System.out.println("Hello Aj...");
        ConstDemo [] cd=ConstDemo.values();
        for(var a:cd){
            System.out.println(a+" "+a.getPrice());
        }
    }
}
