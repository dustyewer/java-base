package kaoshi;

public class Kaoshi2 {



  public static void main(String[] args) {
    //
      Child child = new Child("e");
  }
}
/*第一个规则：子类的构造过程中，必须调用其父类的构造方法。
一个类，如果我们不写构造方法，那么编译器会帮我们加上一个默认的构造方法,
所谓默认的构造方法，就是没有参数的构造方法，但是如果你自己写了构造方法，
那么编译器就不会给你添加了，所以有时候当你new一个子类对象的时候，
肯定调用了子类的构造方法，但是在子类构造方法中我们并没有显示的调用基类的构造方法，
就是没写，如：super(); 并没有这样写，但是这样就会调用父类没有参数的构造方法，
如果父类中没有没有参数的构造方法就会出错。*/

/* 第二个规则：如果子类的构造方法中没有显示的调用基类构造方法，
则系统默认调用基类无参数的构造方法注意：如果子类的构造方法中既没有显示的调用基类构造方法，
而基类中又没有默认无参的构造方法，则编译出错，所以，通常我们需要显示的：super(参数列表)，
来调用父类有参数的构造函数。*/
class Pepole{
    String name;
    public Pepole(){
    System.out.println(1);
    }
    public Pepole(String name){
    System.out.println(2);
    this.name=name;
    }
}

class Child extends Pepole{
    Pepole father;
    public  Child(String name) {
    System.out.println(3);
    this.name=name;
    father=new Pepole(name+":F");
    }
    public Child(){
    System.out.println(4);
    }
}


