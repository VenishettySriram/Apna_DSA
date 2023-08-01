package OOPs;

public class CopyConstructor {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "Ram";
		s1.rollno = 456;
		s1.password = "abcd";
		s1.marks[0] = 100;
		s1.marks[1] = 90;
		s1.marks[2] = 80;
		//Copying an object properties into new object
		Student s2 = new Student(s1);
		s2.password = "xyz";
		s1.marks[2] = 100;
		for (int i = 0; i < 3; i++) {
			System.out.print(s2.marks[i] + " ");
		}
	}
}
class Student {
	String name;
	int rollno;
	String password;
	int[] marks;
	Student() {
		System.out.println("Non paramters passed");
		this.marks = new int[3];
	}
	Student(String name) {
		this.name = name;
		this.marks = new int[3];
	}
	Student(int rollno) {
		this.rollno = rollno;
		this.marks = new int[3];
	}

	Student(String name, int rollno, String password) {
		this.name = name;
		this.rollno = rollno;
		this.password = password;
		this.marks = new int[3];
	}
	//shallow copy constructor
//	Student(Student s1) {
//		this.name = name;
//		this.rollno = rollno;
//		this.marks = s1.marks;
//	}
	//deep copy constructor
	Student(Student s1) {
		marks = new int[3];
		this.name = s1.name;
		this.rollno = s1.rollno;
		for (int i = 0; i < marks.length; i++) {
			this.marks[i] = s1.marks[i];
		}
	}
}