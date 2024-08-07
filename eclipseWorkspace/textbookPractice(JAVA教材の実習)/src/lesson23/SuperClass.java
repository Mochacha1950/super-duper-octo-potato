package ddafsda;

public class SuperClass {
//	SuperClass() {
//		System.out.println("SuperClass constructor");
//	}

	SuperClass(int x) {
		System.out.println("SuperClass constructor with argument: " + x);
	}
}

class SubClass extends SuperClass {
//	SubClass() {
//        // Implicit call to super() happens here if not explicitly provided
//        System.out.println("SubClass constructor");
//    }
	
    SubClass(int y) {
    	super(y);
        // Explicit call to SuperClass constructor with argument
        System.out.println("SubClass constructor with argument: " + y);
    }
}

