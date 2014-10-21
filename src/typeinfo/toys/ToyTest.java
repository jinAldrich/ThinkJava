//: typeinfo/toys/ToyTest.java
// Testing class Class.
package typeinfo.toys;

import static net.mindview.util.Print.*;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy() {
	}

	Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
		print("\n");
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		System.out.println("============================");
		for (Class face : c.getInterfaces())
			printInfo(face);
		System.out.println("============================");
		Class up = c.getSuperclass();
		//Class up = c.getSuperclass().getSuperclass();
		Object obj = null;
		Object obj1 = null;
		Object obj2 = null;
		Object obj3 = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
			obj1 = up.newInstance();
			obj2 = up.newInstance();
			obj3 = up.newInstance();
			System.out.println("obj: " + obj);
			System.out.println("obj1: " + obj1);
			System.out.println("obj2: " + obj2);
			System.out.println("obj3: " + obj3);
		} catch (InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
} /*
 * Output: Class name: typeinfo.toys.FancyToy is interface? [false] Simple name:
 * FancyToy Canonical name : typeinfo.toys.FancyToy Class name:
 * typeinfo.toys.HasBatteries is interface? [true] Simple name: HasBatteries
 * Canonical name : typeinfo.toys.HasBatteries Class name:
 * typeinfo.toys.Waterproof is interface? [true] Simple name: Waterproof
 * Canonical name : typeinfo.toys.Waterproof Class name: typeinfo.toys.Shoots is
 * interface? [true] Simple name: Shoots Canonical name : typeinfo.toys.Shoots
 * Class name: typeinfo.toys.Toy is interface? [false] Simple name: Toy
 * Canonical name : typeinfo.toys.Toy
 */// :~
