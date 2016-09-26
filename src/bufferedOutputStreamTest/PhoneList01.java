package bufferedOutputStreamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {
	// PhoneList01 은 스캐너 쓰지않고
	public static void main(String[] args) {
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
			// 기반스트림(byte기반)
			FileInputStream fis = new FileInputStream(file);

			// 보조스트림(byte -> shar)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			// 보조스트림(line단위 입력)
			br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t "
						+ ""); // 4개로
																		// 분리하는거
				// String tokens[] =line.split("\t");
				int index = 0;
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (index == 0) { // 이름
						System.out.print(token + ": ");
					} else if (index == 3) { // 번호
						System.out.print(token);
					} else {
						System.out.print(token + "-");
					}
					index++;
				}
				System.out.println("");
			}
		} catch (IOException ex) {
			System.out.println("error:" + ex);

		}finally{
			try{
				if(br != null){
					br.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}

}
