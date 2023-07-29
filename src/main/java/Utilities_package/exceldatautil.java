package Utilities_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldatautil {
	public static FileInputStream fi;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getrowcount(String xfile, String xsheet) throws IOException {
		fi = new FileInputStream(xfile);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(xsheet);
		int rowcount = sheet.getLastRowNum();
		book.close();
		fi.close();
		return rowcount;
	}

	public static int getcellcount(String xfile, String xsheet, int rownum) throws IOException {
		fi = new FileInputStream(xfile);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(xsheet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		book.close();
		fi.close();
		return cellcount;
	}

	public static String getcelldata(String xfile, String xsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xfile);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(xsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter format = new DataFormatter();
			String celldata = format.formatCellValue(cell);
			return celldata;
		} catch (Exception e) {
			data = "";

		}
		book.close();
		fi.close();
		return data;

	}

}
