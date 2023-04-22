import java.util.Scanner;

// Dương Lập Khang 
// B2111802
// Đề 2
// Máy 24
public class DCo {	
	private String ten, ngay;
	private float dtich;

	
	public DCo() {
		ten = new String();
		ngay = new String();
		dtich = 0.0f;
	}
	
	public DCo(DCo d) {
		ten = new String(d.ten);
		ngay = new String(d.ngay);
		dtich = d.dtich;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nMời bạn nhập tên động cơ : ");
		ten = sc.nextLine();
		System.out.print("\nMời bạn nhập dung tích : ");
		dtich = sc.nextFloat();
		ngay = sc.nextLine();
		System.out.print("\nMời bạn nhập ngày-tháng-năm (dd-mm-yyy) sản xuất : ");
		ngay = sc.nextLine();
	}
	
	public void in() {
		System.out.println("\n[" + ten + ", " + dtich + ", " +  ngay + "]\n");
	}
	
	public String toString() {
		return ("\n[" + ten + ", " + dtich + ", " +  ngay + "]\n");
	}
	
	public String getTenDCo() {
		return ten;
	}
	
	public int getNgayDCo() {
		String a[] = ngay.split("-");
		return Integer.parseInt(a[0]);
	}
	public int getThangDCo() {
		String a[] = ngay.split("-");
		return Integer.parseInt(a[1]);
	}
	public int getNamDCo() {
		String a[] = ngay.split("-");
		return Integer.parseInt(a[2]);
	}
	
	public float getDTich() {
		return dtich;
	}
	
	public static void main(String[] args) {
		DCo d1 = new DCo();
		d1.nhap();
		System.out.println("Nhập thông tin động cơ d1 : ");
		d1.in();
		
		System.out.println("Thông tin động cơ d2 sao chép từ động cơ d1 \n");
		DCo d2 = new DCo(d1);
		d2.in();
	}

}
