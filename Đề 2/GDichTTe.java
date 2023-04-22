import java.util.HashMap;
import java.util.Scanner;

public class GDichTTe extends GDich {
	private float dgia; // đơn giá
	private float tgia; // tỷ giá
	private int sluong; 
	private char loai; // loại tiền tệ
	
	public GDichTTe() {
		super();
		dgia = 0.0f;
		tgia = 0.0f;
		sluong = 0;
		loai = 'V';
	}
	
	public GDichTTe(GDichTTe gd) {
		super(gd);
		dgia = gd.dgia;
		tgia = gd.tgia;
		sluong = gd.sluong;
		loai = gd.loai;
	}
	
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập đơn giá : ");
		dgia = sc.nextFloat();
		System.out.println("Mời nhập số lượng : ");
		sluong = sc.nextInt();
		System.out.println("Mời nhập loại tiền tệ Việt Nam (V) hay USD (U) hay Euro (E) : ");
		loai = sc.next().charAt(0);
		System.out.println("Mời nhập tỷ giá : ");
		tgia = sc.nextFloat();
	}
	
	public void in() {
		super.in();
		System.out.println("Đơn giá : " + dgia 
						+ "\nSố lượng : " + sluong 
						+ "\nLoại : " + loai
						+ "\nTỷ giá : " + tgia + "\n");
	}
	
	public String toString() {
		return super.toString() + ("Đơn giá : " + dgia 
						+ "\nSố lượng : " + sluong 
						+ "\nLoại : " + loai
						+ "\nTỷ giá : " + tgia + "\n");
	}
	
	public float thanhTien() {
		return (float) sluong * dgia * tgia;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số giao dịch : ");
		int n = sc.nextInt();
		GDich ds[] = new GDich[n];
		int c = 0;
		for (int i=0; i<n; i++) {
			System.out.println("Nhập giao dịch thứ " + (i+1) 
								+ "\nVàng (0) hay tien te (1)");
			
			c = sc.nextInt();
			if (c == 0) ds[i] = new GDich();
			else ds[i] = new GDichTTe();
			
			ds[i].nhap();
		}
		for (int i=0; i<n; i++) {
			System.out.println("Giao dịch thứ " + (i+1));
			ds[i].in();
		}
		
		System.out.println("Ma giao dich tien te co gia tri tren 100000 VND: ");
		for(int i = 0; i < n; i++)
			if(ds[i].thanhTien() > 100000)
				System.out.println("Ma GD: " + ds[i].getMGD());
		System.out.println("------------------------------");
		
		HashMap<String, Float> tong = new HashMap<>();
		for (int i=0; i<n; i++) {
			String key = ds[i].getThangNam();
			if (!tong.containsKey(key)) {
				tong.put(key, ds[i].thanhTien());
			} else tong.put(key, tong.get(key) + ds[i].thanhTien());
		}
		
		for (String key : tong.keySet()) {
			System.out.println("Số tiền giao dịch vào " + key + " là : " + tong.get(key));
		}
	}

}
