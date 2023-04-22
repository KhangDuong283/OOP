import java.util.HashMap;
import java.util.Scanner;

//11:35
public class ChuyenXe {
	private int msc; // mã chuyến xe
	private String tenlx; // tên người lái xe
	private String nden; // nơi đến
	private float dthu; // doanh thu
	private Xe x;
	
	public ChuyenXe() {
		msc = 0;
		tenlx = new String();
		nden = new String();
		dthu = 0.0f;
		x = new Xe();
	}
	
	public ChuyenXe(ChuyenXe c) {
		msc = c.msc;
		tenlx = new String(c.tenlx);
		nden = new String(c.nden);
		dthu = c.dthu;
		x = new Xe(c.x);
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã chuyến xe : ");
		msc = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập tên người lái xe : ");
		tenlx = sc.nextLine();
		System.out.println("Nhập nơi đến : ");
		nden = sc.nextLine();
		System.out.println("Nhập doanh thu : ");
		dthu = sc .nextFloat();
		sc.nextLine();
		System.out.println("Nhập thông tin xe : ");
		x.nhap();
	}
	
	public void in() {
		System.out.println("Mã chuyến xe : " + msc
						+ "\nTên người lái xe : " + tenlx
						+ "\nNơi đến : " + nden
						+ "\nDoanh thu : " + dthu
						+ "\nThông tin xe : " + x);
	}
	
	public String toString() {
		return ("Mã chuyến xe : " + msc
						+ "\nTên người lái xe : " + tenlx
						+ "\nNơi đến : " + nden
						+ "\nDoanh thu : " + dthu
						+ "\nThông tin xe : " + x);
	}
	
	public float loiNhuan() {
		return (float) (dthu * 0.3);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số chuyến xe : ");
		int m = sc.nextInt();
		ChuyenXe ds1[] = new ChuyenXe[m];
		
		for (int i=0; i<m; i++) {
			ds1[i] = new ChuyenXe();
			System.out.println("\nNhập chuyến xe thứ " + (i+1));
			ds1[i].nhap();
		}
		
		for (int i=0; i<m; i++) {
			System.out.println("\nChuyến xe thứ " + (i+1));
			ds1[i].in();
		}
		
		System.out.println("\nMã số của các chuyến xe bị hủy hoặc có doanh thu dưới 100.000");
		for (int i=0; i<m; i++) {
			if (ds1[i].x.getTrangThai() == 'K' || ds1[i].dthu < 100000) 
				System.out.println("Mã số chuyến xe thứ " + (i+1) + " : "+ ds1[i].msc);
		}
		
		HashMap<String, Float> tongLoiNhuan = new HashMap<>();
		for (int i=0; i<m; i++) {
			String key = ds1[i].x.getLoaiThangNam();
			float sum = tongLoiNhuan.getOrDefault(key, 0.0f);
			tongLoiNhuan.put(key, sum + ds1[i].loiNhuan());
		}
		
		for (String key : tongLoiNhuan.keySet()) {
			System.out.println("Tổng lợi nhuận của " + key 
					+ " là : " + tongLoiNhuan.get(key));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
