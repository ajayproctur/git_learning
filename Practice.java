class A{

}
class B extends A{

}
class C extends B{

}

class D extends C{

}

class E extends  D{

}

public class Practice {
    public static void main(String[] args) {
        A a=new E();
        C c=(D)a;
        A a1=new A();
        E e=(E) a1;
    }
}
