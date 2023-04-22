import java.util.HashMap;
import java.util.Scanner;

public class Xe {
	private String so, ten;
	private long gia;
	private char tthai;
	private DCo d;
	
	public Xe() {
		so = new String();
		ten = new String();
		gia = 0L;
		tthai = 'K';
		d = new DCo();
	}
	
	public Xe(Xe x) {
		so = new String(x.so);
		ten = new String(x.ten);
		gia = x.gia;
		tthai = x.tthai;
		d = new DCo(x.d);
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nMời bạn nhập biển số xe : ");
		so = sc.nextLine();
		System.out.print("\nMời bạn nhập tên chủ xe : ");
		ten = sc.nextLine();
		System.out.print("\nMời bạn nhập giá xe : ");
		gia = sc.nextLong();
		String x = sc.nextLine();
		System.out.print("\nMời bạn nhập trạng thái cho phép "
				+ "lưu hành có (C) hay không (K) : ");
		tthai = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.println("\nMời bạn nhập thông tin động cơ : ");
		d.nhap();
	}
	
	public void in() {
		System.out.println("\nBiển số : " + so 
								+ "\nTên chủ xe : " + ten 
								+ "\nGiá xe : " + gia
								+ "\nTrạng thái : " + tthai
								+ "\n Thông tin động cơ : " + d);
	}
	
	public String toString() {
		return ("\nBiển số : " + so 
								+ "\nTên chủ xe : " + ten 
								+ "\nGiá xe : " + gia
								+ "\nTrạng thái : " + tthai
								+ "\n Thông tin động cơ : " + d);
	}


	public float lePhiTrcBa() {
		return (float) (gia * 0.1);
	}
	
	public boolean check() {
		if (d.getNamDCo() > 2000) return false;
		if (d.getNamDCo() == 2000 && d.getThangDCo() > 10) return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap số lượng xe : ");
		int n = sc.nextInt();
		Xe ds1[] = new Xe[n];
		for (int i=0; i<n; i++) {
			System.out.println("\nNhập xe thứ " + (i+1) + " : ");
			ds1[i] = new Xe();
			ds1[i].nhap();
		}
		
		for (int i=0; i<n; i++) {
			System.out.println("Thông tin xe thứ " + (i+1));
			ds1[i].in();
			System.out.println("Lệ phí trước bạ của xe thứ " 
					+ (i+1) + " là : " + ds1[i].gia * 0.1 + "\n");
		}
		
		for (int i=0; i<n; i++) {
			if (ds1[i].tthai == 'K' || ds1[i].gia < 10000000) {
				System.out.println("Biển số xe của các xe bị hủy hoặc thu hồi hoặc có giá trị dưới 10.000.000 : ");
				System.out.println("Biển số của xe thứ " + (i+1) +" : " + ds1[i].so);
			}
		}
		
		
		HashMap<String, Float> dco = new HashMap<>();
		
		for (int i=0; i<n; i++) {
			if (ds1[i].check()) {
				
				String key = ds1[i].d.getTenDCo();
				if (dco.containsKey(key)) {
					dco.put(key, dco.get(key) + ds1[i].lePhiTrcBa());				
				} else {
					dco.put(key, ds1[i].lePhiTrcBa());
				}
				
			}
		} 		
		
		for (String key : dco.keySet()) {
			System.out.println("Lệ phí trước bạ của loại xe " + key 
					+ " là : " + dco.get(key));
		}

		
		
	}

}
