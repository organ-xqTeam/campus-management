package test;

import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.SysPost;

public class test {
	public static void main(String[] args) {

		String filePath_ = "D:/ruoyi/uploadPath/upload";
		System.out.println(filePath_.substring(1, 2));

		if (filePath_.substring(1, 2).equals(":")) {
			filePath_ = filePath_.substring(2, filePath_.length());
		}
		System.out.println(filePath_);

		
		
		String fileName = "1.jpg";
		fileName = fileName.replace("_", " ");
		
		String suffixImg = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		System.out.println(fileName);
		int counter = 0;
		fileName = Md5Utils.hash(fileName + System.nanoTime() + counter++);

		System.out.println(fileName+suffixImg);
	}
}
