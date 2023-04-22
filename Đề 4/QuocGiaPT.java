import java.util.HashMap;
import java.util.Scanner;

public class QuocGiaPT extends QuocGia {
	private float ttho;
	private char chluc;
	private float dtich;
	
	public QuocGiaPT() {
		super();
		ttho = 0.0f;
		chluc = 'A';
		dtich = 0.0f;
	}
	
	public QuocGiaPT(QuocGiaPT qg) {
		super(qg);
		ttho = qg.ttho;
		chluc = qg.chluc;
		dtich = qg.dtich;
	}
	
	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tuổi thọ quốc gia : ");
		ttho = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhập tên châu lục A (Á) - W (ÂU) - M (MỸ) - U (ÚC) - P (PHI) : ");
		chluc = sc.next().charAt(0);
		System.out.println("Nhập diện tích : ");
		dtich = sc.nextFloat();
	}
	
	public char tenChauLuc() {
		return chluc;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số đối tượng : ");
		int n = sc.nextInt();
		QuocGia ds[] = new QuocGia[n];
		for (int i=0; i<n; i++) {
			System.out.println("Nhập quốc gia (0) hay quốc gia phát triển (1) : ");
			int c = sc.nextInt();
			if (c == 0) ds[i] = new QuocGia();
			else ds[i] = new QuocGiaPT();
			
			ds[i].nhap();
		}
		for (int i=0; i<n; i++) {
			System.out.println("Hiển thị danh sách thứ " + (i+1));
			ds[i].in();
		}
		
		System.out.println("Tên các quốc gia có GDP trên 500 ở Châu Phi : ");
		for (int i=0; i<n; i++) {
			if (ds[i].tenChauLuc() == 'P' && ds[i].layGDP() > 500)
				System.out.println(ds[i].layTenQG());
		}
		System.out.println("---------------------------------------");
		
		HashMap<Character, Float> gdpTB = new HashMap<>();
		for (int i=0; i<n; i++) {
			char key = ds[i].tenChauLuc();
				float sum = gdpTB.getOrDefault(key, 0.0f);
				gdpTB.put(key, sum + ds[i].layGDP());
		}
		for (Character key : gdpTB.keySet()) {
			int count = 0;
			for (int i=0; i<n; i++) 
				if (Character.toString(ds[i].tenChauLuc()).equals(key)) count++;
			System.out.println("GDP trung của : " + key 
									+ " là : " + gdpTB.get(key) / count);
		}
		
	}

	
	
	
}
