import java.util.HashMap;
import java.util.Scanner;

//12:25
public class CThu extends CNguoi{
	private int so; // số áo thi đấu
	private String vtri;
	private long bthang; // bàn thắng
	private String mua; // mùa giải
	private String clbo; // tên câu lạc bộ
	
	public CThu() {
		super();
		so = 0;
		vtri = new String();
		bthang = 0L;
		mua = new String();
		clbo = new String();
	}
	
	public CThu(CThu c) {
		super(c);
		so = c.so;
		vtri = new String(c.vtri);
		bthang = c.bthang;
		mua = new String(c.mua);
		clbo = new String(c.clbo);
	}
	
	public String tenMuaClb() {
		return "CLB " + clbo + " ở mùa " + mua;
	}
	
	public long layBanThang() {
		return bthang;
	}
	
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số áo thi đấu : ");
		so = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập vị trí : ");
		vtri = sc.nextLine();
		System.out.println("Nhập số bàn thắng : ");
		bthang = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhập mùa giải : ");
		mua = sc.nextLine();
		System.out.println("Nhập tên câu lạc bộ : ");
		clbo = sc.nextLine();
	}
	
	public void in() {
		super.in();
		System.out.println("Số áo : " + so
						 + "\nSố bàn thắng : " + bthang
						 + "\nMùa giải : " + mua
						 + "\nTên câu lạc bộ : " + clbo
						 + "\nVi trí " + vtri);
		
	} 
	
	
	public String toString() {
		return super.toString() + ("Số áo : " + so
						 + "\nSố bàn thắng : " + bthang
						 + "\nMùa giải : " + mua
						 + "\nTên câu lạc bộ : " + clbo
						 + "\nVi trí " + vtri);
		
	}
	
	public long tinhLuong() {
		long luong = 7000000 + bthang * 500000;
		if (vtri == "thu mon") luong += 3000000;
		else if (vtri == "hau ve") luong += 4000000;
		else if (vtri == "trung ve") luong += 4500000;
		else if (vtri == "tien ve") luong += 5000000;
		else if (vtri == "tien dao") luong += 7000000;
		return (long) (luong*0.9);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số phần tử của danh sách : ");
		int n = sc.nextInt();
		CNguoi ds[] = new CNguoi[n];
		
		for (int i=0; i<n; i++) {
			System.out.println("Nhập con người (0) hay cầu thủ (1) : ");
			int c = sc.nextInt();
			
			if (c == 0) {
				ds[i] = new CNguoi(); 
			} else ds[i] = new CThu();
			
			System.out.println("\nNhập đối tượng thứ " + (i+1));
			ds[i].nhap();
		}
		
		for (int i=0; i<n; i++) {
			System.out.println("\nĐối tượng thứ " + (i+1));
			ds[i].in();
			System.out.println("Tiền lương của cầu thủ thứ " + (i+1));
			System.out.println(ds[i].tinhLuong());
		}
		
		HashMap<String, Long> tongBThang = new HashMap<>();
		
		for (int i=0; i<n; i++) {
			if (2023 - ds[i].layNam() >= 18 && 2023 - ds[i].layNam() <= 24) {
				String key = ds[i].tenMuaClb() + " ở độ tuổi 18-24";
				long sum = tongBThang.getOrDefault(key, 0L);
				tongBThang.put(key, sum + ds[i].layBanThang());
			} else if (2023 - ds[i].layNam() >= 25 && 2023 - ds[i].layNam() <= 28) {
				String key = ds[i].tenMuaClb() + " ở độ tuổi 25-28";
				long sum = tongBThang.getOrDefault(key, 0L);
				tongBThang.put(key, sum + ds[i].layBanThang());
			} else if (2023 - ds[i].layNam() > 28) {
				String key = ds[i].tenMuaClb() + " ở độ tuổi > 28";
				long sum = tongBThang.getOrDefault(key, 0L);
				tongBThang.put(key, sum + ds[i].layBanThang());
			}
		}
		for (String key : tongBThang.keySet()) {
			System.out.println("Tong ban thang cua " + key 
					+ " là : " + tongBThang.get(key));
		}
		
		
		
	}
	
	
	
	
	

}




