# 软件设计原则

## 开闭原则

**对扩展开放，对修改关闭**。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。

想要达到这样的效果，我们需要使用接口和抽象类。

因为抽象灵活性好，适应性广，只要抽象的合理，可以基本保持软件架构的稳定。而软件中易变的细节可以从抽象派生来的实现类来进行扩展，当软件需要发生变化时，只需要根据需求重新派生一个实现类来扩展就可以了。



## 里氏代换原则

任何基类可以出现的地方，子类一定可以出现。通俗理解：子类可以扩展父类的功能，但不能改变父类原有的功能。换句话说，子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。

如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的可复用性会比较差，特别是运用多态比较频繁时，程序运行出错的概率会非常大。



## 依赖倒转原则

高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象。简单的说就是要求对抽象进行编程，不要对实现进行编程，这样就降低了客户与实现模块间的耦合。



## 接口隔离原则

客户端不应该被迫依赖于它不使用的方法；一个类对另一个类的依赖应该建立在最小的接口上。



## 迪米特法则

迪米特法则又叫最少知识原则。

只和你的直接朋友交谈，不跟“陌生人”说话（Talk only to your immediate friends and not to strangers）。

其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。

迪米特法则中的“朋友”是指：当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等，这些对象同当前对象存在关联、聚合或组合关系，可以直接访问这些对象的方法。



## 合成复用原则

合成复用原则是指：尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。

通常类的复用分为继承复用和合成复用两种。

继承复用虽然有简单和易实现的优点，但它也存在以下缺点：

1. 继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类是透明的，所以这种复用又称为“白箱”复用。
2. 子类与父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，这不利于类的扩展与维护。
3. 它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化。


采用组合或聚合复用时，可以将已有对象纳入新对象中，使之成为新对象的一部分，新对象可以调用已有对象的功能，它有以下优点：

1. 它维持了类的封装性。因为成分对象的内部细节是新对象看不见的，所以这种复用又称为“黑箱”复用。
2. 对象间的耦合度低。可以在类的成员位置声明抽象。
3. 复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态地引用与成分对象类型相同的对象。





# 创建型模式

创建型模式的主要关注点是“怎样创建对象？”，它的主要特点是“将对象的创建与使用分离”。

这样可以降低系统的耦合度，使用者不需要关注对象的创建细节。

创建型模式分为：

* 单例模式
* 工厂方法模式
* 抽象工厂模式
* 原型模式
* 建造者模式

## 单例模式

### 概念

**定义**：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。

单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

**特点：**

 * 单例类只能有一个实例。
 * 单例类必须自己创建自己的唯一实例。
 * 单例类必须给所有其他对象提供这一实例。

**分类：**

> 	饿汉式： 类加载时就会导致该单实例对象被创建
>																	
> 	懒汉式： 类加载时不会导致该类单实例对象被创建，而是首次使用该对象时才会创建

**结构：**

* 单例类：只能创建一个实例的类
* 访问类：使用单例类

**作用：** 保证一个类仅有一个实例，并提供一个访问它的全局访问点。

**优缺点：**

优：

* 在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例
* 避免对资源的多重占用（比如写文件操作）
* 单例模式设置全局访问点，可以优化和共享资源的访问。

缺：

* 没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
* 功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。



### 实现

#### 饿汉式

##### 静态变量方式

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:08
 * @Description: 饿汉式(静态成员变量)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){}

    // 2.在本类中创建本类对象
    private static Singleton instance = new Singleton();

    // 3.提供一个公共的访问方式，让外界获取该对象
    public static Singleton getInstance(){
        return instance;
    }
}

// 该类是测试用
public class Test {
    public static void main(String[] args) {
        // 创建Singleton类的对象
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // 判断获取到的两个对象是否是同一个 true
        System.out.println(singleton1 == singleton2);
    }
}
```

说明：

1. 该方式在成员位置声明Singleton类型的静态变量，并创建Singleton类的对象instance。instance对象是随着类的加载而创建的。
2. 没有加锁，执行效率会提高。
3. 类加载时就初始化，浪费内存。

##### 静态代码块方式

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:21
 * @Description: 饿汉式(静态代码块)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量
    private static Singleton instance;  //初始为null

    // 3.在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    // 4.对外提供获取该类对象的方法
    public static Singleton getInstance(){
        return instance;
    }
}

```

说明：

1. 该方式在成员位置声明Singleton类型的静态变量，而对象的创建是在静态代码块中，也是对着类的加载而创建。
2. 和静态变量方式一样，浪费内存。



##### 枚举方式

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:45
 * @Description: 饿汉式(枚举实现)
 */
public enum Singleton {
    INSTANCE;
}

// 测试
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);
    }
}
```

说明：

1. 这是实现单例模式的最佳方法。
2. 更简洁，自动支持序列化机制，绝对防止多次实例化。
3. 枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式。
4. 线程安全、非懒加载、效率高。



#### 懒汉式

##### 线程不安全

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:31
 * @Description: 懒汉式(线程不安全方式)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量instance
    private static Singleton instance;

    // 3.对外提供访问方式
    public static Singleton getInstance(){
        if (instance == null){
            // 线程1等待，线程2获取到cpu执行权，也会进入判断里面，会导致变成多例
            instance = new Singleton();
        }
        return instance;
    }
}
```

说明：

1. 该方式在成员位置声明Singleton类型的静态变量，并没有进行对象的赋值操作，当调用getInstance()方法获取Singleton类的对象的时候才创建Singleton类的对象，这样就实现了懒加载的效果。
2. 如果是多线程环境，会出现线程安全问题。

3. 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。

##### 线程安全

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/10 23:42
 * @Description: 懒汉式(线程安全方式)
 */
public class Singleton {
    // 1.私有构造方法
    private Singleton(){}

    // 2.声明Singleton类型的变量instance
    private static Singleton instance;

    // 3.对外提供访问方式
    public static synchronized Singleton getInstance(){
        if (instance == null){
            // 线程1等待，线程2获取到cpu执行权，也会进入判断里面，会导致变成多例
            // 解决方式：增加synchronized同步锁
            instance = new Singleton();
        }
        return instance;
    }
}
```

说明：

1. 在对外提供的访问方法中加入`synchronized`关键字，既实现了懒加载，同时也解决了线程安全问题。
2. 但是在对外提供访问的方法上添加了`synchronized`关键字，导致该方法的执行效果特别低。

##### 双重检查锁

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:23
 * @Description: 懒汉式(双重检查锁)
 */
public class Singleton {

    // 1、私有构造方法
    private Singleton(){}

    // 2、声明Singleton类型的变量
    // volatile: 解决空指针异常问题，禁止指令重排（保证有序性）
    private static volatile Singleton instance;

    // 3、对外提供公共的访问方式
    public static Singleton getInstance(){
        // 第一次判断，如果instance的值不为null，不许抢占锁，直接返回对象
        if (instance == null){
            synchronized (Singleton.class) {
                // 第二次判断
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

说明：

1. 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
2. 添加 `volatile` 关键字之后的双重检查锁模式是一种比较好的单例实现模式，能够保证在多线程的情况下线程安全也不会有性能问题。

##### 静态内部类方式

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:36
 * @Description: 懒汉式(静态内部类)
 */
public class Singleton {

    // 1.私有构造方法
    private Singleton(){

    }

    // 2.定义一个静态内部类
    private static class SingletonHolder{
        // 在内部类中声明并初始化外部类对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.提供公共的访问方式
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
```

说明：

1. 静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。静态属性由于被 `static` 修饰，保证只被实例化一次，并且严格保证实例化顺序。
2. 第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，虚拟机加载SingletonHolder并初始化INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性。
3. 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。



### 存在的问题

> 破坏单例模式
>
> 其他两种实现方式：
>
> * 序列化和反序列化
> * 反射

##### 序列化和反序列化

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用序列化反序列化破坏单例模式
 */
public class Singleton implements Serializable {

    private Singleton(){};
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:55
 * @Description: 测试使用序列化反序列化破坏单例模式
 */
public class Test {
    public static void main(String[] args) throws Exception {
       // writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    // 从文件中取数据(对象)
    public static void readObjectFromFile() throws Exception {
        // 1.创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\workspace\\1.txt"));
        // 2.读取对象
        Singleton singleton = (Singleton) ois.readObject();
        System.out.println(singleton);
        // 3.释放资源
        ois.close();
    }

    // 向文件中写数据(对象)
    public static void writeObject2File() throws Exception{
        // 1.获取Singleton对象
        Singleton instance = Singleton.getInstance();
        // 2.创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\workspace\\1.txt"));
        // 3.写对象
        oos.writeObject(instance);
        // 4.释放资源
        oos.close();
    }
}
```

> 以上测试类两次调用readObjectFromFile()方法所读取的对象不是同一个，破坏了单例模式。

**解决方式**

> 在Singleton类中添加`readResolve()`方法，在反序列化时被反射调用，如果定义了这个方法，就返回这个方法的值，如果没有定义，则返回新new出来的对象。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用序列化反序列化破坏单例模式解决方案
 */
public class Singleton implements Serializable {

    private Singleton(){};
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    // 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:55
 * @Description: 测试使用序列化反序列化破坏单例模式解决方案
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    // 从文件中取数据(对象)
    public static void readObjectFromFile() throws Exception {
        // 1.创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\workspace\\1.txt"));
        // 2.读取对象
        // 由于定义了readResolve()方法，所以会去调用自定义的方法，如果没有调用readResolve()，则会去new一个
        Singleton singleton = (Singleton) ois.readObject();
        System.out.println(singleton);
        // 3.释放资源
        ois.close();
    }

    // 向文件中写数据(对象)
    public static void writeObject2File() throws Exception{
        // 1.获取Singleton对象
        Singleton instance = Singleton.getInstance();
        // 2.创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\workspace\\1.txt"));
        // 3.写对象
        oos.writeObject(instance);
        // 4.释放资源
        oos.close();
    }
}
```



##### 反射

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用反射破坏单例模式
 */
public class Singleton implements Serializable {

    private Singleton(){};
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/11 18:08
 * @Description: 测试使用反射破坏单例模式
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1.获取Singleton的字节码对象
        Class<Singleton> singletonClass = Singleton.class;
        // 2.获取无参构造方法对象
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        // 3.取消访问检查
        declaredConstructor.setAccessible(true);
        // 4.使用反射方式创建Singleton对象
        Singleton instance1 = declaredConstructor.newInstance();
        Singleton instance2 = declaredConstructor.newInstance();

        //true: 没有破坏了单例模式， false: 破坏了
        System.out.println(instance1 == instance2);
    }
}
```

> 上面测试类结果为false，破坏了单例模式

**解决方案**

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/11 17:52
 * @Description: 测试使用反射破坏单例模式解决方案
 */
public class Singleton implements Serializable {

    private static boolean flag = false;
    private Singleton(){
        synchronized (Singleton.class){
            // 判断flag的值是否是true，如果是true，说明非第一次访问，直接抛一个异常，如果是false的话，说明第一次访问
            if (flag){
                throw new RuntimeException("不能创建多个对象");
            }
            // 将flag的值设置为true
            flag = true;
        }
    };
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
```

说明：
	当通过反射方式调用构造方法进行创建创建时，直接抛异常，不运行此中操作。



## 工厂模式

**定义**：定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。

**分类**：简单工厂模式、工厂方法模式、抽象工厂模式。



### 简单工厂模式

* 我们把被创建的对象称为“产品”，把创建产品的对象称为“工厂”。如果要创建的产品不多，只要一个工厂类就可以完成，这种模式叫“简单工厂模式”。
* 简单工厂模式不是一种设计模式，反而比较像一种编程习惯。
* 简单工厂模式每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度，违背了“开闭原则”。



#### 结构

* 抽象产品：定义了产品的规范，描述了产品的主要特性和功能。
* 具体产品 ：实现或者继承抽象产品的子类
* 具体工厂 ：提供了创建产品的方法，调用者通过该方法来获取产品。



#### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/12 18:16
 * @Description: 咖啡类
 */
public abstract class Coffee {
    public abstract String getName();
    // 加糖
    public void addSugar(){
        System.out.println("加糖");
    }
    // 加奶
    public void addMilk(){
        System.out.println("加奶");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/12 19:49
 * @Description: TODO
 */
public class AmericanCoffee extends Coffee {
    @Override
    public String getName() {
        return "美式咖啡";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/12 19:24
 * @Description: 拿铁咖啡
 */
public class LatteCoffee extends Coffee {
    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:01
 * @Description: 简单咖啡工厂
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }
        return coffee;
    }
}

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

// 测试类
public class Test {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee c = store.orderCoffee("latte");
        System.out.println(c.getName());
    }
}
```

说明：

工厂（factory）处理创建对象的细节，一旦有了SimpleCoffeeFactory，CoffeeStore类中的orderCoffee()就变成此对象的客户，后期如果需要Coffee对象直接从工厂中获取即可。这样也就解除了和Coffee实现类的耦合，同时又产生了新的耦合，CoffeeStore对象和SimpleCoffeeFactory工厂对象的耦合，工厂对象和商品对象的耦合。后期如果再加新品种的咖啡，我们势必要需求修改SimpleCoffeeFactory的代码，违反了开闭原则。



#### 优缺点

**优点**：

* 封装了创建对象的过程，可以通过参数直接获取对象。把对象的创建和业务逻辑层分开，这样以后就避免了修改客户代码，如果要实现新产品直接修改工厂类，而不需要在原代码中修改，这样就降低了客户代码修改的可能性，更加容易扩展。
* 客户端无需知道所创建具体产品的类名，只需知道参数即可。
* 也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。

**缺点**

* 增加新产品时还是需要修改工厂类的代码，违背了“开闭原则”。
* 工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。
* 会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度。
* 系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂。



#### 使用场景

* 对于产品种类相对较少的情况，考虑使用简单工厂模式。使用简单工厂模式的客户端只需要传入工厂类的参数，不需要关心如何创建对象的逻辑，可以很方便地创建所需产品。



#### 扩展：静态工厂

```java
public class SimpleCoffeeFactory {
    public static Coffee createCoffee(String type){
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该咖啡");
        }
        return coffee;
    }
}
```

说明：使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。



### 工厂方法模式

"工厂方法模式”是对简单工厂模式的进一步抽象化，其好处是可以使系统在不修改原来代码的情况下引进新的产品，即满足开闭原则。



#### 结构

* 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。
* 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
* 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
* 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。



#### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:35
 * @Description: 抽象工厂
 */
public interface CoffeeFactory {
    // 创建咖啡对象的方法
    Coffee createCoffee();
}


/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:36
 * @Description: 美式咖啡工厂对象，专门用来生产咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:37
 * @Description: 拿铁咖啡工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}


/**
 * @Author: ww
 * @DateTime: 2022/4/12 20:34
 * @Description: 咖啡店类
 */
public class CoffeeStore {
    private CoffeeFactory factory;
    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }
    // 点咖啡
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建咖啡店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        // 创建工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        coffeeStore.setFactory(factory);

        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());

    }
}
```



#### 优缺点

**优点**：

* 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。

* 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则。

* 典型的解耦框架。

**缺点**：

* 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
* 抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。



#### 使用场景

- 客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
- 创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
- 客户不关心创建产品的细节，只关心产品的品牌。



### 抽象工厂模式

**定义**：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。

抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。

**使用条件**：

- 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
- 系统一次只可能消费其中某一族产品，即同族的产品一起使用。



#### 结构

* 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法，可以创建多个不同等级的产品。
* 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
* 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
* 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。



#### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:48
 * @Description: 抽象工厂
 */
public interface DessertFactory {

    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜品的功能
    Dessert createDessert();

}

//具体工厂
/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:49
 * @Description: 美式风味的甜品工厂，可生产美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
/**
 * @Author: ww
 * @DateTime: 2022/4/13 20:51
 * @Description: 意大利风味
 */
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
```

说明：如果要加同一个产品族的话，只需要再加一个对应的工厂类即可，不需要修改其他的类。



#### 优缺点

**优点**：

- 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
- 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
- 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。

**缺点**：

* 当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。



#### 使用场景

* 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
* 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
* 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。



## 原型模式

**定义**：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，根本无须知道对象创建的细节。



### 结构

* 抽象原型类：规定了具体原型对象必须实现的的 clone() 方法。
* 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
* 访问类：使用具体原型类中的 clone() 方法来复制新的对象。



### 实现

原型模式的克隆分为浅克隆和深克隆。

> 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
>
> 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。

* Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:26
 * @Description: 具体原型类
 */
public class Realizetype implements Cloneable{
    public Realizetype() {
        System.out.println("具体的原型对象被创建成功");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype)super.clone();
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建一个原型类对象
        Realizetype realizetype = new Realizetype();

        // 调用Realizetype类中的clone方法进行克隆
        Realizetype clone = realizetype.clone();

        System.out.println("原型对象和克隆出的对象是否是同一个对象？");
        System.out.println(realizetype == clone);
    }
}
```

测试结果：

> 具体的原型对象被创建完成
> 具体原型复制成功
> 原型对象和克隆出的对象是否是同一个对象？
> false



### 使用场景

- 对象之间相同或相似，即只是个别的几个属性不同的时候。
- 创建对象成本较大，例如初始化时间长，占用CPU太多，或者占用网络资源太多等，需要优化资源。
- 创建一个对象需要繁琐的数据准备或访问权限等，需要提高性能或者提高安全性。
- 系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值。



### 扩展：深克隆

**案例**：同一学校的“三好学生”奖状除了获奖人姓名不同，其他都相同，可以使用原型模式复制多个“三好学生”奖状出来，然后在修改奖状上的名字即可。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:32
 * @Description: 奖状类
 */
public class Citation implements Cloneable{

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {

        return (Citation)super.clone();
    }

    public void show() {
        System.out.println(student.getName() + "同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/13 21:39
 * @Description: TODO
 */
public class Student {

    // 学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 1.获取原型对象
        Citation citation = new Citation();
        // 创建CC学生对象
        Student student = new Student();
        student.setName("CC");
        citation.setStudent(student);
        // 2.获取奖状对象
        Citation citation1 = citation.clone();
        Student student1 = citation1.getStudent();
        student1.setName("龙龙");

        citation.show();
        citation1.show();
    }
}
```

输出结果：

> 龙龙同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！
> 龙龙同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！

说明：

student对象和student1对象是同一个对象，就会产生将student1对象中name属性值改为“龙龙”，两个Citation（奖状）对象中显示的都是龙龙。这就是浅克隆的效果，对具体原型类（Citation）中的引用类型的属性进行引用的复制。这种情况需要使用深克隆，而进行深克隆需要使用对象流。实现代码如下：

```java
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, Exception {
        // 1.获取原型对象
        Citation citation = new Citation();
        // 创建CC学生对象
        Student stu = new Student();
        stu.setName("CC");
        citation.setStudent(stu);

        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\workspace\\a.txt"));
        oos.writeObject(citation);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\workspace\\a.txt"));
        Citation citation1 = (Citation)ois.readObject();
        ois.close();
        Student stu1 = citation1.getStudent();
        stu1.setName("龙龙");

        citation.show();
        citation1.show();

    }
}
```

输出结果：

> CC同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！
> 龙龙同学：在2022学年第一学期中表现优秀，被评为三好学生。特发此状！

注：使用深克隆实现该案例时，Citation类和Student类必须实现Serializable接口，否则会抛NotSerializableException异常。



## 建造者模式

**定义**：将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。

* 分离了部件的构造(由Builder来负责)和装配(由Director负责)。 从而可以构造出复杂的对象。这个模式适用于：某个对象的构建过程复杂的情况。
* 由于实现了构建和装配的解耦。不同的构建器，相同的装配，也可以做出不同的对象；相同的构建器，不同的装配顺序也可以做出不同的对象。也就是实现了构建算法、装配算法的解耦，实现了更好的复用。
* 建造者模式可以将部件和其组装过程分开，一步一步创建一个复杂的对象。用户只需要指定复杂对象的类型就可以得到该对象，而无须知道其内部的具体构造细节。



### 结构

* 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
* 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
* 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
* 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。、



### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:27
 * @Description: 产品对象
 */
public class Bike {

    // 车架
    private String frame;
    // 车座
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:28
 * @Description: 抽象构造类
 */
public abstract class Builder {

    // 声明Bike类型变量并赋值
    protected Bike bike = new Bike();

    public abstract void builderFrame();

    public abstract void builderSeat();

    public abstract Bike createBike();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:30
 * @Description: 具体构造类
 */
public class MobileBuilder extends Builder{
    @Override
    public void builderFrame() {
        bike.setFrame("C牌车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("龙牌车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:32
 * @Description: 具体构建类
 */
public class OfoBuilder extends Builder{
    @Override
    public void builderFrame() {
        bike.setFrame("314车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("ll车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/14 19:34
 * @Description: 指挥者
 */
public class Director {
    // 声明Builder类型的变量
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    // 组装自行车
    public Bike construct(){
        builder.builderFrame();
        builder.builderSeat();
        return builder.createBike();
    }
}


public class Test {
    public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director(new MobileBuilder());
        // 组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
```

说明：

上面示例是 Builder模式的常规用法，指挥者类 Director 在建造者模式中具有很重要的作用，它用于指导具体构建者如何构建产品，控制调用先后次序，并向调用者返回完整的产品类，但是有些情况下需要简化系统结构，可以把指挥者类和抽象建造者进行结合。

```java
// 抽象 builder 类
public abstract class Builder {

    protected Bike mBike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike createBike();
    
    public Bike construct() {
        this.buildFrame();
        this.BuildSeat();
        return this.createBike();
    }
}
```

这样做确实简化了系统结构，但同时也加重了抽象建造者类的职责，也不是太符合单一职责原则，如果construct() 过于复杂，建议还是封装到 Director 中。



### 优缺点

**优点**：

- 封装性好，构建和表示分离。
- 扩展性好，各个具体的建造者相互独立，有利于系统的解耦。
- 客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。

**缺点**：

* 产品的组成部分必须相同，这限制了其使用范围。
* 如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。



### 使用场景

- 创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
- 创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。



# 结构型模式

结构型模式描述如何将类或对象按某种布局组成更大的结构。它分为类结构型模式和对象结构型模式，前者采用继承机制来组织接口和类，后者釆用组合或聚合来组合对象。

由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象结构型模式比类结构型模式具有更大的灵活性。

结构型模式分为以下 7 种：

* 代理模式
* 适配器模式
* 装饰者模式
* 桥接模式
* 外观模式
* 组合模式
* 享元模式



## 代理模式

**定义**：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。

**分类 **：Java中的代理按照代理类生成时机不同又分为静态代理和动态代理。静态代理代理类在编译期就生成，而动态代理代理类则是在Java运行时动态生成。动态代理又有JDK代理和CGLib代理两种。



### 结构

* 抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
* 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
* 代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。



### 静态代理

静态代理就是按照代理模式书写的代码，其特点是代理类和目标类在代码中是确定的，因此称为静态。静态代理可以在不修改目标对象功能的前提下，对目标功能进行扩展。

#### 实现

案例：火车站卖票

如果要买火车票的话，需要去火车站买票，坐车到火车站，排队等一系列的操作，显然比较麻烦。而火车站在多个地方都有代售点，我们去代售点买票就方便很多了。这个例子其实就是典型的代理模式，火车站是目标对象，代售点是代理对象。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:35
 * @Description: 卖火车票的接口(抽象主题类)
 */
public interface SellTickets {

    void sell();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:36
 * @Description: 火车站类(具体主题类)
 */
public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:37
 * @Description: 代理类
 */
public class ProxyPoint implements SellTickets{

    private TrainStation trainStation = new TrainStation();
    @Override
    public void sell() {
        System.out.println("代理类卖票");
        trainStation.sell();
    }
}

public class Test {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}
```

输出结果：

> 代理类卖票
> 火车站卖票

说明：从上面代码中可以看出测试类直接访问的是ProxyPoint类对象，也就是说ProxyPoint作为访问对象和目标对象的中介，同时也对sell方法进行了增强。



#### 优缺点

**优点**：

- 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
- 代理对象可以扩展目标对象的功能；
- 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性

**缺点**：

- 代理模式会造成系统设计中类的数量增加
- 在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
- 增加了系统的复杂度



### 动态代理

动态代理也叫 JDK 代理或接口代理，有以下特点：

- 代理对象不需要实现接口
- 代理对象的生成是利用 JDK 的 API 动态的在内存中构建代理对象
- 能在代码运行时动态地改变某个对象的代理，并且能为代理对象动态地增加方法、增加行为

一般情况下，动态代理的底层不用我们亲自去实现，可以使用线程提供的 API 。例如，在 Java 生态中，目前普遍使用的是 JDK 自带的代理和 GGLib 提供的类库。



#### JDK动态代理

Java中提供了一个动态代理类Proxy，Proxy并不是我们上述所说的代理对象的类，而是提供了一个创建代理对象的静态方法（newProxyInstance方法）来获取代理对象。

##### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:35
 * @Description: 卖火车票的接口(抽象主题类)
 */
public interface SellTickets {

    void sell();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:36
 * @Description: 火车站类(具体主题类)
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:49
 * @Description: 获取代理对象的工厂类 代理类也实现了对应的接口
 */
public class ProxyFactory {

    // 声明目标对象
    private TrainStation trainStation = new TrainStation();

    // 获取代理对象的方法
    public SellTickets getProxyObject(){
        // 返回代理对象
        /*
        * ClassLoader loader: 类加载器，用于加载代理类，可以通过目标对象获取类加载器
        * Class<?>[] interfaces： 代理类实现的接口的字节码对象
        * InvocationHandler h： 代理对象的调用处理程序
        * */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(trainStation.getClass().getClassLoader(), trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                    * invoke: 进行业务逻辑处理
                    * Object proxy: 代理对象，和proxyObject对象是同一个对象，在invoke方法中基本不用
                    * Method method：对接口中的方法进行封装的method对象
                    * Object[] args: 调用方法的实际参数
                    * 返回值：方法的返回值
                    * */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // System.out.println("invoke方法执行了");
                        System.out.println("jdk动态代理增强");
                        // 执行目标对象的方法
                        Object obj = method.invoke(trainStation, args);
                        return obj;
                    }
                });
        return proxyObject;
    }
}

public class Test {
    public static void main(String[] args) {
        // 获取代理对象
        // 1.创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        // 2.使用factory对象的方法获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
        System.out.println(proxyObject.getClass());
        // 让程序一直执行 以方便看到动态生成的代理对象
        while (true){

        }
    }
}
```

输出结果：

> jdk动态代理增强
> 火车站卖票

ProxyFactory是代理类吗？

ProxyFactory不是代理模式中所说的代理类，而代理类是程序在运行过程中动态的在内存中生成的类。通过阿里巴巴开源的 Java 诊断工具（Arthas【阿尔萨斯】）查看代理类的结构：

```java
public final class $Proxy0 extends Proxy implements SellTickets {
    private static Method m3;

    public final void sell() {
            this.h.invoke(this, m3, null);
    }

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
            m3 = Class.forName("com.itwang.pattern.proxy.jdk_proxy.SellTickets").getMethod("sell", new Class[0]);
    }  
}

public class Proxy implements java.io.Serializable {
    protected InvocationHandler h;
}
```

从上面的类中，我们可以看到以下几个信息：

* 代理类（$Proxy0）实现了SellTickets。这也就印证了我们之前说的真实类和代理类实现同样的接口。
* 代理类（$Proxy0）将我们提供了的匿名内部类对象传递给了父类。



##### 执行流程

    1. 在测试类中通过代理对象调用sell()方法
    2. 根据多态的特性，执行的是代理类（$Proxy0）中的sell()方法
    3. 代理类（$Proxy0）中的sell()方法中又调用了InvocationHandler接口的子实现类对象的invoke方法
    4. invoke方法通过反射执行了真实对象所属类(TrainStation)中的sell()方法



#### CGLIB动态代理

如果没有定义SellTickets接口，只定义了TrainStation(火车站类)。很显然JDK代理是无法使用了，因为JDK动态代理要求必须定义接口，对接口进行代理。

CGLIB是一个功能强大，高性能的代码生成包。它为没有实现接口的类提供代理，为JDK的动态代理提供了很好的补充。

CGLIB是第三方提供的包，所以需要引入jar包的坐标：

```xml
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.2.2</version>
</dependency>
```



##### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 18:36
 * @Description: 代理对象工厂，用来获取代理对象
 */
public class ProxyFactory implements MethodInterceptor {
    //声明火车站对象
    private TrainStation station = new TrainStation();

    public TrainStation getProxyObject(){
        // 创建Enhancer对象，类似jdk代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        // 设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调函数 会去自动调用intercept方法
        enhancer.setCallback(this);
        // 创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // System.out.println("该方法执行了");
        System.out.println("增强了该方法");
        // 要调用目标对象的方法
        TrainStation obj = (TrainStation) method.invoke(station,objects);
        return obj;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 17:36
 * @Description: 火车站类
 */
public class TrainStation{

    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 18:41
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        // 创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        // 获取代理对象
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
```

输出结果：

>增强了该方法
>火车站卖票



### 对比

* jdk代理和CGLIB代理

  使用CGLib实现动态代理，CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，在JDK1.6之前比使用Java反射效率要高。唯一需要注意的是，CGLib不能对声明为final的类或者方法进行代理，因为CGLib原理是动态生成被代理类的子类。

  在JDK1.6、JDK1.7、JDK1.8逐步对JDK动态代理优化之后，在调用次数较少的情况下，JDK代理效率高于CGLib代理效率，只有当进行大量调用的时候，JDK1.6和JDK1.7比CGLib代理效率低一点，但是到JDK1.8的时候，JDK代理效率高于CGLib代理。所以如果有接口使用JDK动态代理，如果没有接口使用CGLIB代理。

* 动态代理和静态代理

  动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。

  如果接口增加一个方法，静态代理模式除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。而动态代理不会出现该问题



### 优缺点

**优点：**

- 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
- 代理对象可以扩展目标对象的功能；
- 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；

**缺点：**

* 增加了系统的复杂度。



### 使用场景

* 远程（Remote）代理

  本地服务通过网络请求远程服务。为了实现本地到远程的通信，我们需要实现网络通信，处理其中可能的异常。为良好的代码设计和可维护性，我们将网络通信部分隐藏起来，只暴露给本地服务一个接口，通过该接口即可访问远程服务提供的功能，而不必过多关心通信部分的细节。

* 防火墙（Firewall）代理

  当你将浏览器配置成使用代理功能时，防火墙就将你的浏览器的请求转给互联网；当互联网返回响应时，代理服务器再把它转给你的浏览器。

* 保护（Protect or Access）代理

  控制对一个对象的访问，如果需要，可以给不同的用户提供不同级别的使用权限。



## 适配器模式

**定义**：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。

适配器模式分为类结构型模式和对象结构型模式两种，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。

### 结构

* 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
* 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
* 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。



### 类适配器

#### 实现

实现方式：定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件。

案例：读卡器

现有一台电脑只能读取SD卡，而要读取TF卡中的内容的话就需要使用到适配器模式。创建一个读卡器，将TF卡中的内容读取出来。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:00
 * @Description: 目标接口
 */
public interface SDCard {
    // 读取
    String readSD();
    // 写入
    void writeSD(String msg);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:01
 * @Description: SDCard实现类
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "SDCard read msg: hello SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard:"+msg);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 20:53
 * @Description: 适配者类的接口
 */
public interface TFCard {
    // 读取
    String readTF();
    // 写入
    void writeTF(String msg);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 20:57
 * @Description: 适配者类
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        String msg = "TFCard read msg: hello TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard:"+msg);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:09
 * @Description: 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card ");
        writeTF(msg);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:03
 * @Description: 计算机类
 */
public class Computer  {

    // 从SD卡中读取数据
    public String readSD(SDCard sdCard){
        if (sdCard == null){
            throw new NullPointerException("sdcard is not null");
        }
        return sdCard.readSD();
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建计算机对象
        Computer computer = new Computer();
        // 读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("========================");

        // 使用该计算机读取TF卡中数据
        // 定义适配器类
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
```

输出结果：

>SDCard read msg: hello SDCard
>
>adapter read tf card 
>TFCard read msg: hello TFCard

说明：

类适配器模式违背了合成复用原则。类适配器是客户类有一个接口规范的情况下可用，反之不可用。



### 对象适配器

实现方式：对象适配器模式可釆用将现有组件库中已经实现的组件引入适配器类中，该类同时实现当前系统的业务接口。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:09
 * @Description: 适配器类
 */
public class SDAdapterTF implements SDCard {

    // 声明适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card ");
        tfCard.writeTF(msg);
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建计算机对象
        Computer computer = new Computer();
        // 读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("========================");

        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        // 使用该电脑读取TF卡中的数据
        String msg1 = computer.readSD(sdAdapterTF);
        System.out.println(msg1);
    }
}
```



### 优缺点

**优点**：

- 客户端通过适配器可以透明地调用目标接口。
- 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
- 将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
- 在很多业务场景中符合开闭原则。

**缺点**：

- 适配器编写过程需要结合业务场景全面考虑，可能会增加系统的复杂性。
- 增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。



### 使用场景

* 以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
* 使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。



## 装饰器模式

**定义**：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。



### 结构

* 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
* 具体构件（ConcreteComponent）角色：实现抽象构件，通过装饰角色为其添加一些职责。
* 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
* 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。



### 实现

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:43
 * @Description: 快餐类(抽象构建角色)
 */
public abstract class FastFood {

    private float price; //价格
    private String desc; //描述

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:46
 * @Description: 炒饭类(具体构建角色)
 */
public class FriedRice extends FastFood{
    public FriedRice(){
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:48
 * @Description: 炒面类(具体构建角色)
 */
public class FriedNoodles extends FastFood{
    public FriedNoodles() {
        super(12,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:49
 * @Description: 装饰者类(抽象装饰者角色)
 */
public abstract class Garnish extends FastFood{

    // 声明快餐类的变量
    private FastFood fastFood;

    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:52
 * @Description: 培根类(具体装饰者角色)
 */
public class Bacon extends Garnish{
    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
    }

    @Override
    public float cost() {
        // 计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/15 21:52
 * @Description: 鸡蛋类(具体装饰者角色)
 */
public class Egg extends Garnish{
    public Egg(FastFood fastFood) {
        super(1, "鸡蛋", fastFood);
    }

    @Override
    public float cost() {
        // 计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}

public class Test {
    public static void main(String[] args) {
        // 点一份炒饭
        FastFood food = new FriedRice();
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 再加个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
        System.out.println("=============================");
        // 加个培根
        food = new Bacon(food);
        System.out.println(food.getDesc()+ " "+ food.cost());
    }
}
```

输出结果：

> 炒饭 10.0
>
> 鸡蛋炒饭 11.0
>
> 鸡蛋鸡蛋炒饭 12.0
>
> 培根鸡蛋鸡蛋炒饭 14.0



### 优缺点

**优点**

- 装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
- 通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果
- 装饰器模式完全遵守开闭原则

**缺点**

* 装饰器模式会增加许多子类，过度使用会增加程序得复杂性。



### 使用场景

* 当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。

  不能采用继承的情况主要有两类：

  * 第一类是系统中存在大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长；
  * 第二类是因为类定义不能继承（如final类）

* 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。

* 当对象的功能要求可以动态地添加，也可以再动态地撤销时。



## 桥接模式

**定义**：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。



### 结构

* 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
* 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
* 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
* 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。



### 实现

案例：视频播放器

需要开发一个跨平台视频播放器，可以在不同操作系统平台（如Windows、Mac、Linux等）上播放多种格式的视频文件，常见的视频格式包括RMVB、AVI、WMV等。该播放器包含了两个维度，适合使用桥接模式。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:47
 * @Description: 视频文件(实现化角色)
 */
public interface VideoFile  {
    // 解码
    void decode(String fileName);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:50
 * @Description: avi视频文件(具体实现化角色)
 */
public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件："+ fileName);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:51
 * @Description: rmvb视频文件(具体实现化角色)
 */
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb文件：" + fileName);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:52
 * @Description: 抽象的操作系统类(抽象化角色)
 */
public abstract class OperatingSystemVersion {
    protected VideoFile videoFile;

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:54
 * @Description: windows(扩展抽象化角色)
 */
public class Windows extends OperatingSystemVersion{
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 16:55
 * @Description: mac(扩展抽象化角色)
 */
public class Mac extends OperatingSystemVersion{
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}

public class Test {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Windows(new AviFile());
        os.play("葫芦娃");
    }
}
```

输出结果：

> avi视频文件：葫芦娃



### 优缺点

**优点**：

* 桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。
* 实现细节对客户透明

**缺点**：

* 由于聚合关系建立在抽象层，要求开发者针对抽象化进行设计与编程，能正确地识别出系统中两个独立变化的维度，这增加了系统的理解与设计难度。



### 使用场景

* 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
* 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
* 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系。



## 外观模式

**定义**：又名门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体的细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。

外观（Facade）模式是“迪米特法则”的典型应用

![image-20220416204643187](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//image-20220416204643187.png)



### 结构

* 外观（Facade）角色：为多个子系统对外提供一个共同的接口。
* 子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
* 客户（Client）角色：通过一个外观角色访问各个子系统的功能。



### 实现

案例：智能家电控制

小明的爷爷已经60岁了，一个人在家生活：每次都需要打开灯、打开电视、打开空调；睡觉时关闭灯、关闭电视、关闭空调；操作起来都比较麻烦。所以小明给爷爷买了智能音箱，可以通过语音直接控制这些智能家电的开启和关闭。

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:05
 * @Description: 电灯类
 */
public class Light {

    public void on(){
        System.out.println("开灯");
    }

    public void off(){
        System.out.println("关灯");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:07
 * @Description: 空调类
 */
public class AirCondition {
    public void on() {
        System.out.println("打开空调");
    }

    public void off() {
        System.out.println("关闭空调");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:06
 * @Description: 电视
 */
public class TV {
    public void on() {
        System.out.println("打开电视");
    }

    public void off() {
        System.out.println("关闭电视");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:07
 * @Description: 外观类，用户主要和该类对象进行交互
 */
public class SmartAppliancesFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    // 通过语音控制
    public void say(String message){
        if (message.contains("打开")){
            on();
        } else if (message.contains("关闭")){
            off();
        } else {
            System.out.println("小度已经断开了");
        }
    }

    // 一键打开
    public void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    // 一键关闭
    public void off(){
        light.off();
        tv.off();
        airCondition.off();
    }
}

public class Test {
    public static void main(String[] args) {
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();
        smartAppliancesFacade.say("全部打开");
        System.out.println("=================");
        smartAppliancesFacade.say("全部关闭");
    }
}
```



### 优缺点

**优点**：

* 降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
* 对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
* 降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。

**缺点：**

* 不符合开闭原则，修改很麻烦。
* 不能很好地限制客户使用子系统类，很容易带来未知风险。



### 使用场景

* 对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。
* 当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。
* 当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性。



## 组合模式

**定义**：又名部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。

组合模式一般用来描述整体与部分的关系，它将对象组织到树形结构中，顶层的节点被称为根节点，根节点下面可以包含树枝节点和叶子节点，树枝节点下面又可以包含树枝节点和叶子节点，树形结构图如下：

![image-20220416205301517](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//image-20220416205301517.png)

由上图可以看出，其实根节点和树枝节点本质上属于同一种数据类型，可以作为容器使用；而叶子节点与树枝节点在语义上不属于用一种类型。但是在组合模式中，会把树枝节点和叶子节点看作属于同一种数据类型（用统一接口定义），让它们具备一致行为。

这样，在组合模式中，整个树形结构中的对象都属于同一种类型，带来的好处就是用户不需要辨别是树枝节点还是叶子节点，可以直接进行操作，给用户的使用带来极大的便利。



### 结构

* 抽象构件（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。在透明式的组合模式中抽象构件还声明访问和管理子类的接口；在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成。（总的抽象类或接口，定义一些通用的方法，比如新增、删除）
* 树叶构件（Leaf）角色：是组合中的叶节点对象，它没有子节点，用于继承或实现抽象构件。
* 树枝构件（Composite）角色 / 中间构件：是组合中的分支节点对象，它有子节点，用于继承和实现抽象构件。它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。



### 实现

案例：软件菜单

如下图，我们在访问别的一些管理系统时，经常可以看到类似的菜单。一个菜单可以包含菜单项（菜单项是指不再包含其他内容的菜单条目），也可以包含带有其他菜单项的菜单，因此使用组合模式描述菜单就很恰当，我们的需求是针对一个菜单，打印出其包含的所有菜单以及菜单项的名称。

![image-20200208182322313](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//image-20200208182322313.png)

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 17:54
 * @Description: 菜单组件类(抽象根结点)
 */
public abstract class MenuComponent {
    protected String name;
    //  菜单层级
    protected int level;

    //添加菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //移除菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    //获取菜单名称
    public String getName(){
        return name;
    }

    // 打印菜单名称的方法(包含子菜单和菜单项)
    public abstract void print();
}
/*这里的MenuComponent定义为抽象类，因为有一些共有的属性和行为要在该类中实现，Menu和MenuItem类就可以只覆盖自己感兴趣的方法，而不用搭理不需要或者不感兴趣的方法，举例来说，Menu类可以包含子菜单，因此需要覆盖add()、remove()、getChild()方法，但是MenuItem就不应该有这些方法。这里给出的默认实现是抛出异常，你也可以根据自己的需要改写默认实现。*/

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:00
 * @Description: 菜单项类(树枝结点)
 */
public class Menu extends MenuComponent{
    private List<MenuComponent> menuComponentList = new ArrayList<MenuComponent>();

    public Menu(String name, int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        // 打印菜单名称
        for (int i = 1; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
        // 打印子菜单和菜单项
        for (MenuComponent component : menuComponentList) {
            component.print();
        }
    }
}
//Menu类已经实现了除了getName方法的其他所有方法，因为Menu类具有添加菜单，移除菜单和获取子菜单的功能。

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:06
 * @Description: 菜单项类(叶子结点角色)
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name,int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        // 打印菜单项的名称
        for (int i = 1; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建菜单树
        MenuComponent menu1 = new Menu("菜单管理",2);
        menu1.add(new MenuItem("页面访问",3));
        menu1.add(new MenuItem("展开菜单",3));
        menu1.add(new MenuItem("编辑菜单",3));
        menu1.add(new MenuItem("删除菜单",3));
        menu1.add(new MenuItem("新增菜单",3));

        MenuComponent menu2 = new Menu("权限管理",2);
        menu2.add(new MenuItem("页面访问",3));
        menu2.add(new MenuItem("提交保存",3));

        MenuComponent menu3 = new Menu("角色管理",2);
        menu3.add(new MenuItem("页面访问",3));
        menu3.add(new MenuItem("新增角色",3));
        menu3.add(new MenuItem("修改角色",3));

        // 创建一级菜单
        MenuComponent component = new Menu("系统管理",1);
        // 将二级菜单添加到一级菜单中
        component.add(menu1);
        component.add(menu2);
        component.add(menu3);

        // 打印菜单名称(如果有子菜单就一起打印)
        component.print();
    }
}
//MenuItem是菜单项，不能再有子菜单，所以添加菜单，移除菜单和获取子菜单的功能并不能实现。
```

输出结果：

>系统管理
>---菜单管理
>------页面访问
>------展开菜单
>------编辑菜单
>------删除菜单
>------新增菜单
>---权限管理
>------页面访问
>------提交保存
>---角色管理
>------页面访问
>------新增角色
>------修改角色



### 组合模式分类

在使用组合模式时，根据抽象构件类的定义形式，我们可将组合模式分为透明组合模式和安全组合模式两种形式。

* 透明组合模式

  透明组合模式中，抽象根节点角色中声明了所有用于管理成员对象的方法，比如在示例中 `MenuComponent` 声明了 `add`、`remove` 、`getChild` 方法，这样做的好处是确保所有的构件类都有相同的接口。透明组合模式也是组合模式的标准形式。

  透明组合模式的缺点是不够安全，因为叶子对象和容器对象在本质上是有区别的，叶子对象不可能有下一个层次的对象，即不可能包含成员对象，因此为其提供 add()、remove() 等方法是没有意义的，这在编译阶段不会出错，但在运行阶段如果调用这些方法可能会出错（如果没有提供相应的错误处理代码）

* 安全组合模式

  在安全组合模式中，在抽象构件角色中没有声明任何用于管理成员对象的方法，而是在树枝节点 `Menu` 类中声明并实现这些方法。安全组合模式的缺点是不够透明，因为叶子构件和容器构件具有不同的方法，且容器构件中那些用于管理成员对象的方法没有在抽象构件类中定义，因此客户端不能完全针对抽象编程，必须有区别地对待叶子构件和容器构件。

  ![组合模式-安全性](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E7%BB%84%E5%90%88%E6%A8%A1%E5%BC%8F-%E5%AE%89%E5%85%A8%E6%80%A7.png)



### 优缺点

**优点**：

* 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让客户端忽略了层次的差异，方便对整个层次结构进行控制。
* 客户端可以一致地使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端代码。
* 在组合模式中增加新的树枝节点和叶子节点都很方便，无须对现有类库进行任何修改，符合“开闭原则”。
* 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子节点和树枝节点的递归组合，可以形成复杂的树形结构，但对树形结构的控制却非常简单。

**缺点**：

* 设计较复杂，客户端需要花更多时间理清类之间的层次关系；
* 不容易限制容器中的构件；
* 不容易用继承的方法来增加构件的新功能。



### 使用场景

组合模式正是应树形结构而生，所以组合模式的使用场景就是出现树形结构的地方。

比如：文件目录显示，多级目录呈现等树形结构数据的操作。



## 享元模式

**定义**：运用共享技术来有效地支持大量细粒度对象的复用。它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似对象的开销，从而提高系统资源的利用率。



### 结构

享元（Flyweight ）模式中存在以下两种状态：

1. 内部状态，即不会随着环境的改变而改变的可共享部分。
2. 外部状态，指随环境改变而改变的不可以共享的部分。享元模式的实现要领就是区分应用中的这两种状态，并将外部状态外部化



* 抽象享元角色（Flyweight）：是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。
* 具体享元（Concrete Flyweight）角色：实现抽象享元角色中所规定的接口。
* 非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
* 享元工厂（Flyweight Factory）角色：负责创建和管理享元角色。当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，如果存在则提供给客户；如果不存在的话，则创建一个新的享元对象。



享元模式结构图：

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//image-20220416210422721.png" alt="image-20220416210422721" style="zoom: 67%;" />

- UnsharedConcreteFlyweight 是非享元角色，里面包含了非共享的外部状态信息 info；
- Flyweight 是抽象享元角色，里面包含了享元方法 operation(UnsharedConcreteFlyweight state)，非享元的外部状态以参数的形式通过该方法传入；
- ConcreteFlyweight 是具体享元角色，包含了关键字 key，它实现了抽象享元接口；
- FlyweightFactory 是享元工厂角色，它是关键字 key 来管理具体享元；
- 客户角色通过享元工厂获取具体享元，并访问具体享元的相关方法。



### 实现

案例：俄罗斯方块

众所周知的俄罗斯方块中的一个个方块，如果在俄罗斯方块这个游戏中，每个不同的方块都是一个实例对象，这些对象就要占用很多的内存空间，下面利用享元模式进行实现。

类图：

![享元模式](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E4%BA%AB%E5%85%83%E6%A8%A1%E5%BC%8F.png)

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:32
 * @Description: 抽象享元角色
 */
public abstract class AbstractBox {

    // 获取图形的方法
    public abstract String getShape();

    // 显示图形及颜色
    public void display(String color){
        System.out.println("方块形状：" + getShape() + "," + "颜色：" + color);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:35
 * @Description: I图形类(具体享元角色)
 */
public class IBox extends AbstractBox{
    @Override
    public String getShape() {
        return "I";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:35
 * @Description: L图形类(具体享元角色)
 */
public class LBox extends AbstractBox{
    @Override
    public String getShape() {
        return "L";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:35
 * @Description: O图形类(具体享元角色)
 */
public class OBox extends AbstractBox{
    @Override
    public String getShape() {
        return "O";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 18:36
 * @Description: 工厂类，将该类设计为单例
 */
public class BoxFactory {
    private HashMap<String, AbstractBox> map;

    // 在构造方法中进行初始化操作
    private BoxFactory(){
        map = new HashMap<String, AbstractBox>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("O",new OBox());
    }

    private static BoxFactory factory = new BoxFactory();

    // 提供一个方法获取该工厂类对象
    public static BoxFactory getInstance(){
        return factory;
    }

    // 根据名称获取图形对象
    public AbstractBox getShape(String name){
        return map.get(name);
    }
}

public class Test {
    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox i = BoxFactory.getInstance().getShape("I");
        i.display("red");
        // 获取L图形对象
        AbstractBox l = BoxFactory.getInstance().getShape("L");
        l.display("yellow");
        // 获取O图形对象
        AbstractBox o = BoxFactory.getInstance().getShape("O");
        o.display("black");
        AbstractBox o1 = BoxFactory.getInstance().getShape("O");
        o1.display("blue");

        System.out.println(o == o1);
    }
}
```

输出结果：

> 方块形状：I,颜色：red
> 方块形状：L,颜色：yellow
> 方块形状：O,颜色：black
> 方块形状：O,颜色：blue
> true



### 优缺点

**优点**：

- 极大减少内存中相似或相同对象数量，节约系统资源，提供系统性能
- 享元模式中的外部状态相对独立，且不影响内部状态

**缺点**：

* 为了使对象可以共享，需要将享元对象的部分状态外部化，分离内部状态和外部状态，使程序逻辑复杂
* 读取享元模式的外部状态会使得运行时间稍微变长



### 使用场景

- 一个系统有大量相同或者相似的对象，造成内存的大量耗费。
- 对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
- 在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源，因此，应当在需要多次重复使用享元对象时才值得使用享元模式。



# 行为型模式

行为型模式用于描述程序在运行时复杂的流程控制，即描述多个类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，它涉及算法与对象间职责的分配。

行为型模式分为类行为模式和对象行为模式，前者采用继承机制来在类间分派行为，后者采用组合或聚合在对象间分配行为。由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象行为模式比类行为模式具有更大的灵活性。

行为型模式分为：

* 模板方法模式
* 策略模式
* 命令模式
* 职责链模式
* 状态模式
* 观察者模式
* 中介者模式
* 迭代器模式
* 访问者模式
* 备忘录模式
* 解释器模式

以上 11 种行为型模式，除了模板方法模式和解释器模式是类行为型模式，其他的全部属于对象行为型模式。



## 模板方法模式

**定义**：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。



### 结构

* 抽象类（Abstract Class）：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。

  * 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。

  * 基本方法：是实现算法各个步骤的方法，是模板方法的组成部分。基本方法又可以分为三种：

    * 抽象方法(Abstract Method) ：一个抽象方法由抽象类声明、由其具体子类实现。

    * 具体方法(Concrete Method) ：一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承。

    * 钩子方法(Hook Method) ：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。

      一般钩子方法是用于判断的逻辑方法，这类方法名一般为isXxx，返回值类型为boolean类型。

* 具体子类（Concrete Class）：实现抽象类中所定义的抽象方法和钩子方法，它们是一个顶级逻辑的组成步骤。



### 实现

案例：炒菜

炒菜的步骤是固定的，分为倒油、热油、倒蔬菜、倒调料品、翻炒等步骤。现通过模板方法模式来用代码模拟。类图如下：

![模板方法模式](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E6%A8%A1%E6%9D%BF%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F.png)

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:16
 * @Description: 抽象类，定义模板方法和基本方法
 */
public abstract class AbstractClass {

    public final void cookProcess() {
        //第一步：倒油
        this.pourOil();
        //第二步：热油
        this.heatOil();
        //第三步：倒蔬菜
        this.pourVegetable();
        //第四步：倒调味料
        this.pourSauce();
        //第五步：翻炒
        this.fry();
    }

    public void pourOil() {
        System.out.println("倒油");
    }

    //第二步：热油是一样的，所以直接实现
    public void heatOil() {
        System.out.println("热油");
    }

    //第三步：倒蔬菜是不一样的（一个下包菜，一个是下菜心）
    public abstract void pourVegetable();

    //第四步：倒调味料是不一样
    public abstract void pourSauce();


    //第五步：翻炒是一样的，所以直接实现
    public void fry(){
        System.out.println("炒啊炒啊炒到熟啊");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:19
 * @Description: TODO
 */
public class ConcreteClass_BaoCai extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是辣椒");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:19
 * @Description: TODO
 */
public class ConcreteClass_CaiXin extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}

public class Test {
    public static void main(String[] args) {
        //炒手撕包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();

        //炒蒜蓉菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
```

> 注意：为防止恶意操作，一般模板方法都加上 final 关键词。



### 优缺点

**优点**

* 它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
* 它在父类中提取了公共的部分代码，便于代码复用。
* 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。

**缺点**

* 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象，间接地增加了系统实现的复杂度。
* 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
* 由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。



### 使用场景

* 法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
* 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制。



## 策略模式

**定义**：该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。



### 结构

* 抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
* 具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。、
* 环境（Context）类：持有一个策略类的引用，最终给客户端调用。



### 实现

案例：促销活动

一家百货公司在定年度的促销活动。针对不同的节日（春节、中秋节、圣诞节）推出不同的促销活动，由促销员将促销活动展示给客户。类图如下：

![策略模式](https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F.png)

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:36
 * @Description: 抽象策略类
 */
public interface Strategy {

    void show();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:39
 * @Description: 春节(具体策略类)
 */
public class StrategyA implements Strategy{
    public void show() {
        System.out.println("买一送一");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:39
 * @Description: 中秋节(具体策略类)
 */
public class StrategyB implements Strategy{
    public void show() {
        System.out.println("满200元减50元");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:40
 * @Description: 端午(具体策略类)
 */
public class StrategyC implements Strategy{
    public void show() {
        System.out.println("满1000元加一元换购任意200元以下商品");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/16 22:43
 * @Description: 促销员(环境类)，用于连接上下文
 */
public class SalesMan {

    // 聚合策略类对象
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    //向客户展示促销活动
    public void salesManShow(){
        strategy.show();
    }
}

public class Test {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();
    }
}
```



### 优缺点

**优点**

* 策略类之间可以自由切换

  由于策略类都实现同一个接口，所以使它们之间可以自由切换。

* 易于扩展

  增加一个新的策略只需要添加一个具体的策略类即可，基本不需要改变原有的代码，符合“开闭原则“

* 避免使用多重条件选择语句（if else），充分体现面向对象设计思想。

**缺点**

* 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
* 策略模式将造成产生很多策略类，增加维护难度，可以通过使用享元模式在一定程度上减少对象的数量。



### 使用场景

* 一个系统需要动态地在几种算法中选择一种时，可将每个算法封装到策略类中。
* 一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句。
* 系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时。
* 系统要求使用算法的客户不应该知道其操作的数据时，可使用策略模式来隐藏与算法相关的数据结构。
* 多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为。



## 命令模式

**定义**：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。



### 结构

* 抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
* 具体命令类（Concrete Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
* 实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
* 调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。



### 实现

案例：点餐

顾客将订单交给服务员，服务员再将订单交给厨师

服务员： 就是调用者角色，由她来发起命令。

厨师： 就是接收者角色，真正命令执行的对象。

订单： 命令中包含订单。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E5%91%BD%E4%BB%A4%E6%A8%A1%E5%BC%8F.png" alt="命令模式" style="zoom: 80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:41
 * @Description: 抽象命令类
 */
public interface Command {
    //只需要定义一个统一的执行方法
    void execute();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:42
 * @Description: 具体命令类
 */
public class OrderCommand implements Command{

    // 持有接受者对象
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Map<String, Integer> foodDir = order.getFoodDir();
        // 遍历map集合
        Set<String> keys = foodDir.keySet();
        for (String foodName : keys) {
            receiver.makeFood(foodName, foodDir.get(foodName));
        }

        System.out.println(order.getDiningTable() + "桌的饭做好了");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:37
 * @Description: 订单类
 */
public class Order {

    // 餐桌号码
    private int diningTable;

    // 所下的餐品和份数
    private Map<String,Integer> foodDir = new HashMap<String , Integer>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, int num) {
        foodDir.put(name,num);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:40
 * @Description: 厨师类
 */
public class SeniorChef {
    public void makeFood(String name, int num){
        System.out.println(num + "份" + name);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 14:48
 * @Description: 服务员类(请求者角色)
 */
public class Waiter {

    // 持有多个命令对象
    private List<Command> commands = new ArrayList<Command>();

    public void setCommands(Command cmd){
        commands.add(cmd);
    }

    // 发起命令的方法
    public void orderUp(){
        System.out.println("服务员：新订单来了");
        for (Command command : commands) {
            if (command != null){
                command.execute();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        //创建2个order
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("炒面",1);
        order1.setFood("可乐",2);

        Order order2 = new Order();
        order2.setDiningTable(3);
        order2.setFood("粥",1);
        order2.setFood("雪碧",1);

        // 创建接收者
        SeniorChef receiver = new SeniorChef();
        //将订单和接收者封装成命令对象
        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        //创建调用者 waiter
        Waiter invoker = new Waiter();
        invoker.setCommands(cmd1);
        invoker.setCommands(cmd2);

        // waiter发起命令
        invoker.orderUp();
    }
}
```



### 优缺点

**优点**

* 降低系统的耦合度。命令模式能将调用操作的对象与实现该操作的对象解耦。
* 增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，它满足“开闭原则”，对扩展比较灵活。
* 可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。
* 方便实现 Undo 和 Redo 操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。
* 可以在现有命令的基础上，增加额外功能。比如日志记录，结合装饰器模式会更加灵活。

**缺点**

* 使用命令模式可能会导致某些系统有过多的具体命令类。
* 系统结构更加复杂。



### 使用场景

* 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
* 系统需要在不同的时间指定请求、将请求排队和执行请求。
* 系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作，可以将命令对象存储起来，采用备忘录模式来实现。



## 责任链模式

**定义**：为了避免请求发送者与多个请求处理者耦合在一起，于是将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。

在责任链模式中，客户只需要将请求发送到责任链上即可，无须关心请求的处理细节和请求的传递过程，请求会自动进行传递。所以责任链将请求的发送者和请求的处理者解耦了。

责任链模式的本质是解耦请求与处理，让请求在处理链中能进行传递与被处理；理解责任链模式应当理解其模式，而不是其具体实现。责任链模式的独到之处是将其节点处理者组合成了链式结构，并允许节点自身决定是否进行请求处理或转发，相当于让请求流动起来。



### 结构

* 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
* 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
* 客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。



### 实现

案例：请假流程系统

请假一天以下的假只需要小组长同意即可；请假1天到3天的假还需要部门经理同意；请求3天到7天还需要总经理同意才行。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E8%B4%A3%E4%BB%BB%E9%93%BE%E6%A8%A1%E5%BC%8F.png" alt="责任链模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:32
 * @Description: 请假条类
 */
public class LeaveRequest {

    // 姓名
    private String name;
    // 请假天数
    private int num;
    // 请假内容
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:34
 * @Description: 抽象处理者类
 */
public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    // 该领导处理的请假天数区间
    private int numStart;
    private int numEnd;

    // 声明后继者(上级领导)
    private Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    // 设置上级领导对象
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    // 各级领导处理请假条的方法
    protected abstract void handleLeave(LeaveRequest leave);

    // 提交请假条
    public final void submit(LeaveRequest leave){
        // 该领导进行审批
        this.handleLeave(leave);
        if (this.nextHandler != null && leave.getNum() > this.numEnd){
            // 提交给上级领导进行审批
            this.nextHandler.submit(leave);
        } else {
            System.out.println("流程结束！");
        }
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:41
 * @Description: 小组长类(具体的处理者)
 */
public class GroupLeader extends Handler {

    public GroupLeader(){
        //小组长处理1-3天的请假
        super(0,Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= NUM_ONE){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("小组长审批：同意。");
        }else {
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("小组长审批：太久了，请找部门经理");
        }
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:43
 * @Description: 部门经理(具体的处理者)
 */
public class Manager extends Handler{

    public Manager(){
        super(Handler.NUM_ONE,Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= Handler.NUM_THREE){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("部门经理审批：同意。");
        } else {
            System.out.println("部门经理审批：太久了，请找总经理");
        }
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/17 18:45
 * @Description: 总经理(具体的处理者)
 */
public class GeneralManager extends Handler{
    public GeneralManager() {
        //部门经理处理7天以上的请假
        super(Handler.NUM_THREE,Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        if (leave.getNum() <= Handler.NUM_SEVEN){
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
            System.out.println("总经理审批：同意。");
        } else{
            System.out.println("总经理审批：太久了，不同意");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建请假条对象
        LeaveRequest leave = new LeaveRequest("小龙",8,"回家当卷王");

        // 创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);
        
        groupLeader.submit(leave);
    }
}
```



### 优缺点

**优点**

* 降低了对象之间的耦合度

  该模式降低了请求发送者和接收者的耦合度。

* 增强了系统的可扩展性

  可以根据需要增加新的请求处理类，满足开闭原则。

* 增强了给对象指派职责的灵活性

  当工作流程发生变化，可以动态地改变链内的成员或者修改它们的次序，也可动态地新增或者删除责任。

* 责任链简化了对象之间的连接

  一个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。

* 责任分担

  每个类只需要处理自己该处理的工作，不能处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。

**缺点**

* 不能保证每个请求一定被处理。由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传到链的末端都得不到处理。
* 对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。
* 职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，如可能会造成循环调用。



### 使用场景

* 多个对象可以处理一个请求，但具体由哪个对象处理该请求在运行时自动确定。
* 可动态指定一组对象处理请求，或添加新的处理者。
* 需要在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。



### 分类

1. 纯的职责链模式：一个请求必须被某一个处理者对象所接收，且一个具体处理者对某个请求的处理只能采用以下两种行为之一：自己处理（承担责任）；把责任推给下家处理。
2. 不纯的职责链模式：允许出现某一个具体处理者对象在承担了请求的一部分责任后又将剩余的责任传给下家的情况，且一个请求可以最终不被任何接收端对象所接收。



## 状态模式

**定义**：对有状态的对象，把复杂的“判断逻辑”提取到不同的状态对象中，允许状态对象在其内部状态发生改变时改变其行为。



### 结构

* 环境类（Context）角色：也称为上下文，它定义了客户端需要的接口，内部维护一个当前状态，并负责具体状态的切换。
* 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为，可以有一个或多个行为。
* 具体状态（Concrete State）角色：实现抽象状态所对应的行为，并且在需要的情况下进行状态切换。



### 实现

案例：通过按钮来控制一个电梯的状态，一个电梯有开门状态，关门状态，停止状态，运行状态。每一种状态改变，都有可能要根据其他状态来更新处理。例如，如果电梯门现在处于运行时状态，就不能进行开门操作，而如果电梯门是停止状态，就可以执行开门操作。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E7%8A%B6%E6%80%81%E6%A8%A1%E5%BC%8F.png" alt="状态模式" style="zoom:67%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:34
 * @Description: 抽象状态类
 */
public abstract class LiftState {

    // 声明环境角色类变量
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 电梯开启
    public abstract void open();
    // 电梯关闭
    public abstract void close();
    // 电梯运行
    public abstract void run();
    // 电梯停止
    public abstract void stop();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:37
 * @Description: 电梯开启状态类
 */
public class OpenningState extends LiftState{
    @Override
    public void open() {
        System.out.println("电梯开启");
    }

    @Override
    public void close() {
        // 状态修改
        super.context.setLiftState(Context.closeingState);
        // 调用当前状态中的Context中的close方法
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
    }

    @Override
    public void stop() {
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:37
 * @Description: 运行
 */
public class RunningState extends LiftState{
    @Override
    public void open() {
        //do nothing
    }

    //电梯门关闭？这是肯定了
    @Override
    public void close() {//虽然可以关门，但这个动作不归我执行
        //do nothing
    }

    //这是在运行状态下要实现的方法
    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }

    //这个事绝对是合理的，光运行不停止还有谁敢做这个电梯？！估计只有上帝了
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:38
 * @Description: 关闭
 */
public class ClosingState extends LiftState{
    @Override
    //电梯门关闭，这是关闭状态要实现的动作
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    //电梯门关了就跑
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    //电梯门关着，我就不按楼层
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:38
 * @Description: 停止
 */
public class StoppingState extends LiftState{
    @Override
    public void open() {
        //状态修改
        super.context.setLiftState(Context.openningState);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().open();
    }

    @Override
    public void close() {//虽然可以关门，但这个动作不归我执行
        //状态修改
        super.context.setLiftState(Context.closeingState);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().close();
    }

    //停止状态再跑起来，正常的很
    @Override
    public void run() {
        //状态修改
        super.context.setLiftState(Context.runningState);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().run();
    }

    //停止状态是怎么发生的呢？当然是停止方法执行了
    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 17:34
 * @Description: 环境角色类
 */
public class Context {
    //定义出所有的电梯状态
    public final static OpenningState openningState = new OpenningState(); //开门状态，这时候电梯只能关闭
    public final static ClosingState closeingState = new ClosingState(); //关闭状态，这时候电梯可以运行、停止和开门
    public final static RunningState runningState = new RunningState(); //运行状态，这时候电梯只能停止
    public final static StoppingState stoppingState = new StoppingState(); //停止状态，这时候电梯可以开门、运行

    //定义一个当前电梯状态变量
    private LiftState liftState;

    public LiftState getLiftState() {
        return this.liftState;
    }

    // 设置当前状态对象
    public void setLiftState(LiftState liftState) {
        // 当前环境改变
        this.liftState = liftState;
        // 设置当前状态对象中的Context对象
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new RunningState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
```



### 优缺点

**优点**

* 将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为。
* 允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
* 状态类职责明确，有利于程序的扩展。通过定义新的子类很容易地增加新的状态和转换。

**缺点**

* 状态模式的使用必然会增加系统类和对象的个数。 
* 状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱。
* 状态模式对"开闭原则"的支持并不太好。



### 使用场景

* 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为时，就可以考虑使用状态模式。
* 一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时。



## 观察者模式

**定义**：又被称为发布-订阅（Publish/Subscribe）模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。





### 结构

* 抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
* 具体主题（Concrete Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
* 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
* 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。



### 实现

案例：在使用微信公众号时，大家都会有这样的体验，当你关注的公众号中有新内容更新的话，它就会推送给关注公众号的微信用户端。我们使用观察者模式来模拟这样的场景，微信用户就是观察者，微信公众号是被观察者，有多个的微信用户关注了程序猿这个公众号。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E8%A7%82%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F.png" alt="观察者模式" style="zoom: 80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:08
 * @Description: 抽象观察者类
 */
public interface Observer {

    void update(String message);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:14
 * @Description: 具体观察者角色类
 */
public class WeiXinUser implements Observer{

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:07
 * @Description: 抽象主题角色类
 */
public interface Subject {

    // 添加订阅者(观察者对象)
    void attach(Observer observer);

    // 删除订阅者
    void detach(Observer observer);

    //通知订阅者更新消息
    void notify(String message);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:12
 * @Description: 具体被观察者
 */
public class SubscriptionSubject implements Subject{
    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> weiXinUserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            observer.update(message);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();
        //创建微信用户
        WeiXinUser user1 = new WeiXinUser("卷王1");
        WeiXinUser user2 = new WeiXinUser("卷王2");
        WeiXinUser user3 = new WeiXinUser("卷王3");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("反卷专栏更新了");
    }
}
```



### 优缺点

**优点**

* 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。
* 目标与观察者之间建立了一套触发机制。

**缺点**

* 目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。
* 当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率。



### 使用场景

* 对象间存在一对多关系，一个对象的状态发生改变会影响其他对象。
* 当一个抽象模型有两个方面，其中一个方面依赖于另一方面时。



## 中介者模式

**定义**：定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。





### 结构

* 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
* 具体中介者（Concrete Mediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
* 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
* 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。



### 实现

案例：租房

现在租房基本都是通过房屋中介，房主将房屋托管给房屋中介，而租房者从房屋中介获取房屋信息。房屋中介充当租房者与房屋所有者之间的中介者。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E4%B8%AD%E4%BB%8B%E8%80%85%E6%A8%A1%E5%BC%8F.png" alt="中介者模式" style="zoom: 80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:30
 * @Description: 抽象中介者类
 */
public abstract class Mediator {
    public abstract void contact(String message, Person person);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:32
 * @Description: 抽象同事类
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:35
 * @Description: 具体的同事角色类
 */
public class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介联系
    public void contact(String message){
        mediator.contact(message, this);
    }

    //获取信息
    public void getMessage(String message){
        System.out.println("房主" + name +"获取到的信息：" + message);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:33
 * @Description: 具体同事角色类
 */
public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介沟通的方法
    public void contact(String message) {
        mediator.contact(message, this);
    }

    // 获取信息的方法
    public void getMessage(String message){
        System.out.println("租房者" + name +"获取到的信息：" + message);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:37
 * @Description: 具体的中介者角色类
 */
public class MediatorStructure extends Mediator{

    // 聚合租房者和房主对象
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Person person) {
        //如果是房主，则租房者获得信息
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {    //反则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        //一个房主、一个租房者、一个中介机构
        MediatorStructure mediator = new MediatorStructure();

        //房主和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("需要租三室的房子");
        houseOwner.contact("我这有三室的房子，你需要租吗？");
    }
}
```



### 优缺点

**优点**

* 类之间各司其职，符合迪米特法则。
* 降低了对象之间的耦合性，使得对象易于独立地被复用。
* 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。

**缺点**

* 中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越臃肿，变得复杂且难以维护。



### 使用场景

* 系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解。
* 当想创建一个运行于多个类之间的对象，又不想生成新的子类时。





## 迭代器模式

**定义**：提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。



### 结构

* 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
* 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
* 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
* 具体迭代器（Concretelterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。



### 实现

案例：定义一个可以存储学生对象的容器对象，将遍历该容器的功能交由迭代器实现，涉及到的类如下：

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E8%BF%AD%E4%BB%A3%E5%99%A8%E6%A8%A1%E5%BC%8F.png" alt="迭代器模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:51
 * @Description: 抽象迭代器角色接口
 */
public interface StudentIterator {
    // 判断是否还有元素
    boolean hasNext();
    // 获取下一个元素
    Student next();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:52
 * @Description: 具体迭代器角色类
 */
public class StudentIteratorImpl implements StudentIterator{

    private List<Student> list;
    // 遍历位置
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:54
 * @Description: 抽象聚合角色接口
 */
public interface StudentAggregate {
    // 添加学生
    void addStudent(Student student);

    // 删除学生
    void removeStudent(Student student);

    // 获取迭代器对象
    StudentIterator getStudentIterator();
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:55
 * @Description: 具体聚合角色类
 */
public class StudentAggregateImpl implements StudentAggregate{

    // 学生列表
    private List<Student> list = new ArrayList<Student>();

    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 18:50
 * @Description: 学生类
 */
public class Student {
    private String name;
    private String number;

    public Student() {
    }

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        // 创建聚合对象
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        // 添加元素
        aggregate.addStudent(new Student("张三","100000"));
        aggregate.addStudent(new Student("李四","100001"));
        aggregate.addStudent(new Student("王五","100002"));

        // 遍历聚合对象
        // 1.获取迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();
        // 2.遍历
        while (iterator.hasNext()){
            // 3.获取元素
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
```

### 优缺点

**优点**

* 访问一个聚合对象的内容而无须暴露它的内部表示。
* 遍历任务交由迭代器完成，这简化了聚合类。
* 它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。
* 增加新的聚合类和迭代器类都很方便，无须修改原有代码。
* 封装性良好，为遍历不同的聚合结构提供一个统一的接口。

**缺点**

* 增加了类的个数，这在一定程度上增加了系统的复杂性。



### 使用场景

* 当需要为聚合对象提供多种遍历方式时。
* 当需要为遍历不同的聚合结构提供一个统一的接口时。
* 当访问一个聚合对象的内容而无须暴露其内部细节的表示时。



## 访问者模式

**定义**：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。



### 结构

* 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
* 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
* 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
* 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
* 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。



### 实现

案例：给宠物喂食

当然宠物还分为狗，猫等，要给宠物喂食的话，主人可以喂，其他人也可以喂食



<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F.png" alt="访问者模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:31
 * @Description: 抽象访问者角色类
 */
public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:35
 * @Description: 具体访问者角色类
 */
public class Owner implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂狗");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:35
 * @Description: 具体访问者角色类
 */
public class Someone implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂狗");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:32
 * @Description: 持续角色元素类
 */
public interface Animal {

    // 接收访问者访问的功能
    void accept(Person person);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:33
 * @Description: 具体元素角色类
 */
public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        // 访问者喂食
        person.feed(this);
        System.out.println("cat");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:33
 * @Description: 具体元素角色类
 */
public class Dog implements Animal{
    @Override
    public void accept(Person person) {
        // 访问者喂食
        person.feed(this);
        System.out.println("dog");
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:36
 * @Description: 对象结构类
 */
public class Home {

    private List<Animal> nodeList = new ArrayList<Animal>();

    //添加元素
    public void add(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        for (Animal node : nodeList) {
            node.accept(person);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());

        Owner owner = new Owner();
        home.action(owner);

        Someone someone = new Someone();
        home.action(someone);
    }
}
```

### 优缺点

**优点**

* 扩展性好。能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
* 复用性好。可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度。
* 灵活性好。访问者模式将数据结构与作用于结构上的操作解耦，使得操作集合可相对自由地演化而不影响系统的数据结构。
* 符合单一职责原则。访问者模式把相关的行为封装在一起，构成一个访问者，使每一个访问者的功能都比较单一。

**缺点**

* 增加新的元素类很困难。在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”。
* 破坏封装。访问者模式中具体元素对访问者公布细节，这破坏了对象的封装性。
* 违反了依赖倒置原则。访问者模式依赖了具体类，而没有依赖抽象类。



### 使用场景

* 对象结构相对稳定，但其操作算法经常变化的程序。
* 对象结构中的对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构。



## 备忘录模式

**定义**：又叫快照模式，在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到原先保存的状态。

备忘录模式能记录一个对象的内部状态，当用户后悔时能撤销当前操作，使数据恢复到它原先的状态。



### 结构

* 发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
* 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
* 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。



备忘录有两个等效的接口：

* **窄接口**：管理者(Caretaker)对象（和其他发起人对象之外的任何对象）看到的是备忘录的窄接口(narror Interface)，这个窄接口只允许他把备忘录对象传给其他的对象。
* **宽接口**：与管理者看到的窄接口相反，发起人对象可以看到一个宽接口(wide Interface)，这个宽接口允许它读取所有的数据，以便根据这些数据恢复这个发起人对象的内部状态。



### 实现

案例：游戏中的某个场景，一游戏角色有生命力、攻击力、防御力等数据，在打Boss前和后一定会不一样的，我们允许玩家如果感觉与Boss决斗的效果不理想可以让游戏恢复到决斗之前的状态。

要实现上述案例，有两种方式：

* “白箱”备忘录模式
* “黑箱”备忘录模式

#### 白箱备忘录模式

备忘录角色对任何对象都提供一个接口，即宽接口，备忘录角色的内部所存储的状态就对所有对象公开。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E7%99%BD%E7%AE%B1%E5%A4%87%E5%BF%98%E5%BD%95%E6%A8%A1%E5%BC%8F.png" alt="白箱备忘录模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:59
 * @Description: 游戏角色类(发起人角色)
 */
public class GameRole {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    // 初始化内部状态
    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    // 战斗
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    // 保存角色状态
    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    // 恢复角色状态
    public void recoverState(RoleStateMemento roleStateMemento) {
        // 将备忘录对象中存储的状态赋值给当前对象的成员
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    // 显示状态
    public void stateDisplay() {
        System.out.println("角色生命力：" + vit);
        System.out.println("角色攻击力：" + atk);
        System.out.println("角色防御力：" + def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:06
 * @Description: 备忘录对象管理角色
 */
public class RoleStateCaretaker {
    // 声明备忘录对象
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:02
 * @Description: 游戏状态存储类(备忘录类)
 */
public class RoleStateMemento {
    private int vit;
    private int atk;
    private int def;

    public RoleStateMemento() {
    }

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("------------大战Boss前------------");
        //大战Boss前
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        //保存进度
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        System.out.println("------------大战Boss后------------");
        //大战Boss时，损耗严重
        gameRole.fight();
        gameRole.stateDisplay();
        System.out.println("------------恢复之前状态------------");
        //恢复之前状态
        gameRole.recoverState(roleStateCaretaker.getRoleStateMemento());
        gameRole.stateDisplay();
    }
}
```

> 注：白箱备忘录模式是破坏封装性的。



#### 黑箱备忘录模式

备忘录角色对发起人对象提供一个宽接口，而为其他对象提供一个窄接口。在Java语言中，实现双重接口的办法就是将**备忘录类**设计成**发起人类**的内部成员类。

将 `RoleStateMemento` 设为 `GameRole` 的内部类，从而将 `RoleStateMemento` 对象封装在 `GameRole` 里面；在外面提供一个标识接口 `Memento` 给 `RoleStateCaretaker` 及其他对象使用。这样 `GameRole` 类看到的是 `RoleStateMemento` 所有的接口，而`RoleStateCaretaker`  及其他对象看到的仅仅是标识接口 `Memento` 所暴露出来的接口，从而维护了封装型。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E9%BB%91%E7%AE%B1%E5%A4%87%E5%BF%98%E5%BD%95%E6%A8%A1%E5%BC%8F.png" alt="黑箱备忘录模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:13
 * @Description: 备忘录接口，对外提供窄接口
 */
public interface Memento {
    // 标识接口，不需要实现任何方法
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 20:59
 * @Description: 游戏角色类(发起人角色)
 */
public class GameRole {
    // 生命力
    private int vit;
    // 攻击力
    private int atk;
    // 防御力
    private int def;

    // 初始化内部状态
    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    // 战斗
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    // 保存角色状态
    public Memento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    // 恢复角色状态
    public void recoverState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        // 将备忘录对象中存储的状态赋值给当前对象的成员
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    // 显示状态
    public void stateDisplay() {
        System.out.println("角色生命力：" + vit);
        System.out.println("角色攻击力：" + atk);
        System.out.println("角色防御力：" + def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    private class RoleStateMemento implements Memento {
        private int vit;
        private int atk;
        private int def;

        public RoleStateMemento() {
        }

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }

        public int getVit() {
            return vit;
        }

        public void setVit(int vit) {
            this.vit = vit;
        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:06
 * @Description: 备忘录对象管理角色
 */
public class RoleStateCaretaker {
    // 声明备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("------------大战Boss前------------");
        //大战Boss前
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        //保存进度
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("------------大战Boss后------------");
        //大战Boss时，损耗严重
        gameRole.fight();
        gameRole.stateDisplay();
        System.out.println("------------恢复之前状态------------");
        //恢复之前状态
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();
    }
}
```



### 优缺点

**优点**

* 提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。
* 实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
* 简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，并由管理者进行管理，这符合单一职责原则。

**缺点**

* 资源消耗大。如果要保存的内部状态信息过多或者特别频繁，将会占用比较大的内存资源。



### 使用场景

* 需要保存与恢复数据的场景，如玩游戏时的中间结果的存档功能。
* 需要提供一个可回滚操作的场景，如 Word、记事本、Photoshop，idea等软件在编辑时按 Ctrl+Z 组合键，还有数据库中事务操作。



## 解释器模式

**定义**：给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解析器来解释语言中的句子。也就是说，用编译语言的方式来分析应用中的实例。这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。

在解释器模式中，我们需要将待解决的问题，提取出规则，抽象为一种“语言”。比如加减法运算，规则为：由数值和+-符号组成的合法序列，“1+3-2” 就是这种语言的句子。

解释器就是要解析出来语句的含义。但是如何描述规则呢？

**文法（语法）规则：**

文法是用于描述语言的语法结构的形式规则。

```
expression ::= value | plus | minus
plus ::= expression ‘+’ expression   
minus ::= expression ‘-’ expression  
value ::= integer
```

> 注意： 这里的符号“::=”表示“定义为”的意思，竖线 | 表示或，左右的其中一个，引号内为字符本身，引号外为语法。

上面规则描述为 ：

表达式可以是一个值，也可以是plus或者minus运算，而plus和minus又是由表达式结合运算符构成，值的类型为整型数。

**句子**：

句子是语言的基本单位，是语言集中的一个元素，它由终结符构成，能由“文法”推导出。

**抽象语法树：**

在计算机科学中，抽象语法树（AbstractSyntaxTree，AST），或简称语法树（Syntax tree），是源代码语法结构的一种抽象表示。它以树状的形式表现编程语言的语法结构，树上的每个节点都表示源代码中的一种结构。

用树形来表示符合文法规则的句子。

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//image-20200215225227616.png" alt="image-20200215225227616" style="zoom: 33%;" />



### 结构

* 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
* 终结符表达式（Terminal Expression）角色：是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
* 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
* 环境（Context）角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
* 客户端（Client）：主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，然后调用解释器的解释方法，当然也可以通过环境角色间接访问解释器的解释方法。



### 实现

案例：设计实现加减法的软件

<img src="https://cdn.jsdelivr.net/gh/binbinit/imageBed@main//%E8%A7%A3%E9%87%8A%E5%99%A8%E6%A8%A1%E5%BC%8F.png" alt="解释器模式" style="zoom:80%;" />

```java
/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:46
 * @Description: 抽象表达式类
 */
public abstract class AbstractExpression {
    public abstract int interpret(Context context);
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:50
 * @Description: 加法表达式(非终结符表达式角色)
 */
public class Plus extends AbstractExpression{

    // +号左右两边的表达式
    private AbstractExpression left;
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:50
 * @Description: 减法表达式(非终结符表达式角色)
 */
public class Minus extends AbstractExpression{

    // -号左右两边的表达式
    private AbstractExpression left;
    private AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:47
 * @Description: 环境角色类
 */
public class Context {
    // 存储变量及其对应的值
    private Map<Variable, Integer> map = new HashMap<Variable, Integer>();

    // 添加
    public void assign(Variable var, Integer value) {
        map.put(var, value);
    }

    // 获取
    public int getValue(Variable var) {
        Integer value = map.get(var);
        return value;
    }
}

/**
 * @Author: ww
 * @DateTime: 2022/4/18 21:48
 * @Description: 封装变量的类
 */
public class Variable extends AbstractExpression{

    // 声明存储变量名的存储变量
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        // 返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Test {
    public static void main(String[] args) {
        Context context = new Context();

        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");
        Variable e = new Variable("e");

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);
        context.assign(e, 5);

        AbstractExpression expression = new Minus(new Plus(new Plus(new Plus(a, b), c), d), e);

        System.out.println(expression + " = " + expression.interpret(context));
    }
}
```



### 优缺点

**优点**

* 扩展性好。由于在解释器模式中使用类来表示语言的文法规则，因此可以通过继承等机制来改变或扩展文法。
* 容易实现。在语法树中的每个表达式节点类都是相似的，所以实现其文法较为容易。

**缺点**

* 执行效率较低。解释器模式中通常使用大量的循环和递归调用，当要解释的句子较复杂时，其运行速度很慢，且代码的调试过程也比较麻烦。
* 会引起类膨胀。解释器模式中的每条规则至少需要定义一个类，当包含的文法规则很多时，类的个数将急剧增加，导致系统难以管理与维护。
* 可应用的场景比较少。在软件开发中，需要定义语言文法的应用实例非常少，所以这种模式很少被使用到。



### 使用场景

* 当语言的文法较为简单，且执行效率不是关键问题时。
* 当问题重复出现，且可以用一种简单的语言来进行表达时。

* 当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候。
