import java.util.Scanner;

//10 giờ
public class GDich {
	private int mgd; // mã giao dịch
	private String hten, ngay; // tên người giao dịch - ngày tháng năm
	private boolean tthai; // trạng thái giao dịch
	
	public GDich() {
		mgd = 0;
		hten = new String();
		ngay = new String();
		tthai = true;
	}
	
	public GDich(GDich gd) {
		mgd = gd.mgd;
		hten = new String(gd.hten);
		ngay = new String(gd.ngay);
		tthai = gd.tthai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã giao dịch : ");
		mgd = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập họ tên người giao dịch : ");
		hten = sc.nextLine();
		System.out.println("Nhập ngày giao dịch (dd-mm-yyyy) : ");
		ngay = sc.nextLine();
		System.out.println("Nhập trạng thái giao dịch (true) or (false) : ");
		tthai = sc.nextBoolean();
	}
	
	public String getNgay() {
		String s[] = ngay.split("-");
		return s[0];
	}
	
	public String getThang() {
		String s[] = ngay.split("-");
		return s[1];
	}
	
	public String getNam() {
		String s[] = ngay.split("-");
		return s[2];
	}
	
	public String getThangNam() {
		return "tháng " + getThang() + " năm " + getNam();
	}
	
	public void in() {
		System.out.println("Mã giao dịch : " + mgd 
				+ "\nHọ tên người giao dịch : " + hten
				+ "\nNgày giao dịch : " + ngay
				+ "\nTrạng thái : " + tthai + "\n");
	}
	
	public String toString() {
		return ("Mã giao dịch : " + mgd 
				+ "\nHọ tên người giao dịch : " + hten
				+ "\nNgày giao dịch : " + ngay
				+ "\nTrạng thái : " + tthai + "\n");
	}
	
	public int getMGD() {
		return mgd;
	}
	
	public float thanhTien() {
		return 0.0f;
	}
	
	public static void main(String[] args) {
		GDich gd1 = new GDich();
		gd1.nhap();
		System.out.println("\nThông tin giao dịch 1");
		gd1.in();
		
		GDich gd2 = new GDich(gd1);
		System.out.println("\nThông tin giao dịch 2");
		gd2.in();

	}

}
