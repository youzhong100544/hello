package com.hello;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

/**
	final
		final关键字的含义?
			final在Java中是一个保留的关键字，可以声明类（不能被继承）、方法（不能被重写）、以及变量（不能被修改）（成员变量、本地变量（局部变量））。
			一旦你将引用声明作final，你将不能改变这个引用了，编译器会检查代码，如果你试图将变量再次初始化的话，编译器会报编译错误


		什么是final类？
			使用final来修饰的类叫作final类。
			final类通常功能是完整的，它们不能被继承。
			Java中有许多类是final的，譬如String, Interger以及其他包装类。

			下面是final类的实例：
			final class PersonalLoan{
			}

			class CheapPersonalLoan extends PersonalLoan{  //compilation error: cannot inherit from final class
			}

		什么是final方法?

			final也可以声明方法。方法前面加上final关键字，代表这个方法不可以被子类的方法重写。
			如果你认为一个方法的功能已经足够完整了，子类中不需要改变的话，你可以声明此方法为final。
			final方法比非final方法要快，因为在编译的时候已经静态绑定了，不需要在运行时再动态绑定。
			下面是final方法的例子
			class PersonalLoan{
				public final String getName(){
					return "personal loan";
				}
			}

			class CheapPersonalLoan extends PersonalLoan{
				@Override
				public final String getName(){
					return "cheap personal loan"; //compilation error: overridden method is final
				}
			}
		什么是final变量？
			凡是对成员变量或者本地变量(在方法中的或者代码块中的变量称为本地变量)声明为final的都叫作final变量。
			final变量经常和static关键字一起使用，作为常量。
			下面是final变量的例子：

			public static final String LOAN = "loan";
			LOAN = new String("loan") //invalid compilation error

			final变量是只读的。



		final关键字的好处

			1、final关键字提高了性能。JVM和Java应用都会缓存final变量。
			2、final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。
			3、使用final关键字，JVM会对方法、变量及类进行优化。

		关于final的重要知识点

			1、final关键字可以用于成员变量、本地变量、方法以及类。
			2、final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。
			3、你不能够对final变量再次赋值。
			4、本地变量必须在声明时赋值。
			5、在匿名类中所有变量都必须是final变量。
			6、final方法不能被重写。
			7、final类不能被继承。
			8、final关键字不同于finally关键字，后者用于异常处理。
			9、final关键字容易与finalize()方法搞混，后者是在Object类中定义的方法，是在垃圾回收之前被JVM调用的方法。
			10、接口中声明的所有变量本身是final的。
			11、final和abstract这两个关键字是反相关的，final类就不可能是abstract的。
			12、final方法在编译阶段绑定，称为静态绑定(static binding)。
			13、没有在声明时初始化final变量的称为空白final变量(blank final variable)，它们必须在构造器中初始化，或者调用this()初始化。不这么做的话，编译器会报错“final变量(变量名)需要进行初始化”。
			14、将类、方法、变量声明为final能够提高性能，这样JVM就有机会进行估计，然后优化。
			15、按照Java代码惯例，final变量就是常量，而且通常常量名要大写：
				private final int COUNT = 10;

				对于集合对象声明为final指的是引用不能被更改，但是你可以向其中增加，删除或者改变内容。譬如：
					public static void main(String[] args) {
						final List ll = new ArrayList();
						ll.add("home loan");  //valid
						ll.add("personal loan"); //valid
						ll = new Vector();  //not valid
					}


=============================================================================================================
	为什么String类是不可变的？
		String是所有语言中最常用的一个类。
		我们知道在Java中，String是不可变的、final的。
		Java在运行时也保存了一个字符串池(String pool)，这使得String成为了一个特别的类。

		String类不可变性的好处

		1、只有当字符串是不可变的，字符串池才有可能实现。
		字符串池的实现可以在运行时节约很多heap空间，因为不同的字符串变量都指向池中的同一个字符串。
		但如果字符串是可变的，那么String interning将不能实现(译者注：String interning是指对不同的字符串仅仅只保存一个，即不会保存多个相同的字符串。)，因为这样的话，如果变量改变了它的值，那么其它指向这个值的变量的值也会一起改变。
		2、如果字符串是可变的，那么会引起很严重的安全问题。
		譬如，数据库的用户名、密码都是以字符串的形式传入来获得数据库的连接，或者在socket编程中，主机名和端口都是以字符串的形式传入。
		因为字符串是不可变的，所以它的值是不可改变的，否则黑客们可以钻到空子，改变字符串指向的对象的值，造成安全漏洞。
		3、因为字符串是不可变的，所以是多线程安全的，同一个字符串实例可以被多个线程共享。
		这样便不用因为线程安全问题而使用同步。字符串自己便是线程安全的。
		4、类加载器要用到字符串，不可变性提供了安全性，以便正确的类被加载。
		譬如你想加载java.sql.Connection类，而这个值被改成了myhacked.Connection，那么会对你的数据库造成不可知的破坏。
		5、因为字符串是不可变的，所以在它创建的时候hashcode就被缓存了，不需要重新计算。
		这就使得字符串很适合作为Map中的键，字符串的处理速度要快过其它的键对象。
		这就是HashMap中的键往往都使用字符串。
*/
public class DemoFinal {
	private static final String NAME = "test-final";
	private static final Logger LOGGER = Logger.getLogger(DemoFinal.class.toString());

	final List list = new ArrayList();
	//list.add("111");//compilation error


	public  void test() {
		List l = new ArrayList();
		l.add("home loan");  //valid
		l.add("personal loan"); //valid
		l = new Vector();  //not valid

		final List lll = new ArrayList();
		lll.add("home loan");  //valid
		lll.add("personal loan"); //valid
		//lll = new Vector();  //compilation error
	}

	public static void main(String[] args) {

		System.out.println(NAME);

		final List ll = new ArrayList();
		ll.add("home loan");  //valid
		ll.add("personal loan"); //valid
		//ll = new Vector();  //compilation error
	}
}
