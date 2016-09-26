package bufferedOutputStreamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneList02 {

	public static void main(String[] args) {
		// PhoneList01 은 스캐너 쓰지않고
		BufferedReader br = null;
		try {
			File file = new File("Phone.txt");
			if (file.exists() == false) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println("************파일 정보*************");
			System.out.println(file.getAbsolutePath()); // 파일 경로 이름
			System.out.println(file.length() + "Bytes"); // 파일 길이
			// Date date = new Date(file.lastModified()); //최근 수정된 날짜 정보
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a
			// hh:mm:ss");
			// System.out.println(sdf.format(date));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss").format(file.lastModified())); // 압축한거
			System.out.println("************전화번호 리스트*************");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String name = sc.next();
				String phone01 = sc.next();
				String phone02 = sc.next();
				String phone03 = sc.next();

				System.out.println(name + ": " + phone01 + "-" + phone02 + "-" + phone03);
			}

		} catch (IOException ex) {
			System.out.println("error:" + ex);

		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
