package easymall.POI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateExcel {
	public void print() {
		//1、创建Workbook
        Workbook workbook = new HSSFWorkbook();
        //2、创建sheet,默认名字是sheet1，sheet2...
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("会员列表");
        //3、创建row 参数是0代表第1行，参数是1代表第二行...
        Row row0 = sheet.createRow(0);
        Row row2 = sheet.createRow(2);
        Row row3 = sheet.createRow(3);
        Row row4 = sheet.createRow(4);
        Row row5 = sheet.createRow(5);
        Row row6 = sheet.createRow(6);
        Row row7 = sheet.createRow(7);
        //4、创建cell 第0列
        org.apache.poi.ss.usermodel.Cell cell0 = row0.createCell(0);
        //5、在cell中填充数据
        cell0.setCellValue("EasyMall销售业绩表");
        
        cell0 = row2.createCell(0);
        org.apache.poi.ss.usermodel.Cell cell1 = row2.createCell(1);
        cell0.setCellValue("爱疯9s");
        cell1.setCellValue(3);
        
        cell0 = row3.createCell(0);
        cell1 = row3.createCell(1);
        cell0.setCellValue("滑雪套装");
        cell1.setCellValue(2);
        
        cell0 = row4.createCell(0);
        cell1 = row4.createCell(1);
        cell0.setCellValue("banana");
        cell1.setCellValue(5);
        
        cell0 = row5.createCell(0);
        cell1 = row5.createCell(1);
        cell0.setCellValue("金士顿内存条");
        cell1.setCellValue(10);
        
        cell0 = row6.createCell(0);
        cell1 = row6.createCell(1);
        cell0.setCellValue("沙发");
        cell1.setCellValue(3);
        
        cell0 = row7.createCell(0);
        cell1 = row7.createCell(1);
        cell0.setCellValue("宠物猫");
        cell1.setCellValue(6);
        
        //6、向文件中写入数据，以上步骤都是在内存中完成的，想要将文件持久化到磁盘需要文件输出流
        FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C:\\Users\\DeLL\\Desktop\\大三上\\java web\\5班第x组\\EasyMall销售业绩表.xls");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //7、关闭流
        try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}