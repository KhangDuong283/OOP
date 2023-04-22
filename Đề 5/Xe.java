import java.util.Scanner;

//11:25
public class Xe {
	private String soxe, loai, ngay;
	private char tthai;
	
	public char getTrangThai() {
		return tthai;
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
	
	public String getLoaiThangNam() {
		return loai + " tháng " + getThang() + " năm " + getNam();
	}
	
	public Xe() {
		soxe = new String();
		loai = new String();
		ngay = new String();
		tthai = 'C';
	}
	
	public Xe(Xe x) {
		soxe = new String(x.soxe);
		loai = new String(x.loai);
		ngay = new String(x.ngay);
		tthai = x.tthai;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số xe : "); 
		soxe = sc.nextLine();
		System.out.println("Nhập loại xe : "); 
		loai = sc.nextLine();
		System.out.println("Nhập ngày - tháng - năm (dd-mm-yyyy) đăng ký : ");
		ngay = sc.nextLine();
		System.out.println("Nhập trạng cho phép lưu hành có (C) hay không (K) : ");
		do {
			tthai = sc.next().toUpperCase().charAt(0);
			if (tthai != 'K' && tthai != 'C') 
				System.out.println("Nhập sai định dạng !!!");
		} while (tthai != 'K' && tthai != 'C');
	}
	
	public void in() {
		System.out.println("Số xe : " + soxe); 
		System.out.println("Loại xe : " + loai); 
		System.out.println("Ngày - tháng - năm (dd-mm-yyyy) đăng ký : " + ngay);
		System.out.println("Nhập trạng cho phép lưu hành " + tthai);
	}
	
	public String toString() {
		return "Số xe : " + soxe 
				+ "\nLoại xe : " + loai 
				+ "\nNgày - tháng - năm (dd-mm-yyyy) đăng ký : " + ngay
				+ "\nTrạng thái cho phép lưu hành " + tthai;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập đối tượng d1 : ");
		Xe d1 = new Xe();
		d1.nhap();
		System.out.println("Hiển thị đối tượng d1 : ");
		d1.in();
		
		Xe d2 = new Xe(d1);

		System.out.println("Hiển thị đối tượng d2 : ");
		d2.in();
	}
	
	
	
	
	
	
	
	
	
}
