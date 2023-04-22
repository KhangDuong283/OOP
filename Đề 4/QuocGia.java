import java.util.Scanner;

//Dương Lập Khang, B2111802, đề 1 máy 24
public class QuocGia {
	private String msqg; // mã số quốc gia
	private String tenqg;
	private String tenthudo;
	private float GDP;
	
	public QuocGia() {
		msqg = new String();
		tenqg = new String();
		tenthudo = new String();
		GDP = 0.0f;
	}
	
	public QuocGia(QuocGia q) {
		msqg = new String(q.msqg);
		tenqg = new String(q.tenqg);
		tenthudo = new String(q.tenthudo);
		GDP = q.GDP;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã số quốc gia : ");
		msqg = sc.nextLine();
		System.out.println("Nhập tên quốc gia : ");
		tenqg = sc.nextLine();
		System.out.println("Nhập tên thủ đô : ");
		tenthudo = sc.nextLine();
		System.out.println("Nhập GDP : ");
		GDP = sc.nextFloat();

	}
	
	public void in() {
		System.out.println("Mã quốc gia : " + msqg
								+ "\nTen quốc gia : " + tenqg
								+ "\nTen thủ đô : " + tenthudo
								+ "\nGDP : " + GDP);
	}
	
	public String toString() {
		return ("Mã quốc gia : " + msqg
								+ "\nTen quốc gia : " + tenqg
								+ "\nTen thủ đô : " + tenthudo
								+ "\nGDP : " + GDP);
	}

	public char tenChauLuc() {
		return 'X';
	}
	
	public float layGDP() {
		return GDP;
	}
	
	public String layTenQG() {
		return tenqg;
	}
	
	
	
	public static void main(String[] args) {
		QuocGia qg1 = new QuocGia();
		System.out.println("Nhập quốc gia 1 : ");
		qg1.nhap();
		System.out.println("Thông tin quốc gia 1 : ");
		qg1.in();
		
		QuocGia qg2 = new QuocGia(qg1);
		System.out.println("\nThông tin quốc gia 2 : ");
		qg2.in();

		
	}
	
	
	
	
	
	
	
	
	
}
