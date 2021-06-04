package easymall.POI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateExcel {
	public void print() {
		//1������Workbook
        Workbook workbook = new HSSFWorkbook();
        //2������sheet,Ĭ��������sheet1��sheet2...
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("��Ա�б�");
        //3������row ������0�����1�У�������1����ڶ���...
        Row row0 = sheet.createRow(0);
        Row row2 = sheet.createRow(2);
        Row row3 = sheet.createRow(3);
        Row row4 = sheet.createRow(4);
        Row row5 = sheet.createRow(5);
        Row row6 = sheet.createRow(6);
        Row row7 = sheet.createRow(7);
        //4������cell ��0��
        org.apache.poi.ss.usermodel.Cell cell0 = row0.createCell(0);
        //5����cell���������
        cell0.setCellValue("EasyMall����ҵ����");
        
        cell0 = row2.createCell(0);
        org.apache.poi.ss.usermodel.Cell cell1 = row2.createCell(1);
        cell0.setCellValue("����9s");
        cell1.setCellValue(3);
        
        cell0 = row3.createCell(0);
        cell1 = row3.createCell(1);
        cell0.setCellValue("��ѩ��װ");
        cell1.setCellValue(2);
        
        cell0 = row4.createCell(0);
        cell1 = row4.createCell(1);
        cell0.setCellValue("banana");
        cell1.setCellValue(5);
        
        cell0 = row5.createCell(0);
        cell1 = row5.createCell(1);
        cell0.setCellValue("��ʿ���ڴ���");
        cell1.setCellValue(10);
        
        cell0 = row6.createCell(0);
        cell1 = row6.createCell(1);
        cell0.setCellValue("ɳ��");
        cell1.setCellValue(3);
        
        cell0 = row7.createCell(0);
        cell1 = row7.createCell(1);
        cell0.setCellValue("����è");
        cell1.setCellValue(6);
        
        //6�����ļ���д�����ݣ����ϲ��趼�����ڴ�����ɵģ���Ҫ���ļ��־û���������Ҫ�ļ������
        FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C:\\Users\\DeLL\\Desktop\\������\\java web\\5���x��\\EasyMall����ҵ����.xls");
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
        //7���ر���
        try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}