import java.util.Scanner;

//12:15
public class CNguoi {
	private String id, hten, ngay; // cmnd - họ tên - ngày tháng năm sinh
	private char phai; // nam (M), nữ (F)
	
	public CNguoi() {
		id = new String();
		hten = new String();
		ngay = new String();
		phai = 'M';
	}
	
	public CNguoi(CNguoi c) {
		id = new String(c.id);
		hten = new String(c.hten);
		ngay = new String(c.ngay);
		phai = c.phai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id : "); 
		id = sc.nextLine();
		System.out.println("Nhập họ tên : ");
		hten = sc.nextLine();
		System.out.println("Nhập ngày tháng năm sinh (dd-mm-yyyy) : ");
		ngay = sc.nextLine();
		System.out.println("Nhập giới tính nam (M) hay nữ (F) : ");
		phai = sc.next().charAt(0);
	}
	
	public void in() {
		System.out.println("Id : " + id 
						+ "\nHọ tên : " + hten
						+ "\nNgày tháng năm sinh : " + ngay
						+ "\nGiới tính : " + phai);
	}
	
	public String toString() {
		return ("Id : " + id 
						+ "\nHọ tên : " + hten
						+ "\nNgày tháng năm sinh : " + ngay
						+ "\nGiới tính : " + phai);
	}
	
	public long tinhLuong() {
		return 0;
	}
	
	public int layNgay() {
		String s[] = ngay.split("-");
		return Integer.parseInt(s[0]);
	}
	
	public int layThang() {
		String s[] = ngay.split("-");
		return Integer.parseInt(s[1]);
	}
	
	public int layNam() {
		String s[] = ngay.split("-");
		return Integer.parseInt(s[2]);
	}
	
	public String tenMuaClb() {
		return "";
	}
	
	public long layBanThang() {
		return 0L;
	}
	
	public static void main(String[] args) {
		CNguoi c1 = new CNguoi();
		c1.nhap();
		System.out.println("   - Thông tin đối tượng c1 : ");
		c1.in();
		
		System.out.println("   - Thông tin đối tượng c2 : ");
		CNguoi c2 = new CNguoi(c1);
		c2.in();
	}
	
}








