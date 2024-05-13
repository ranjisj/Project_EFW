package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fileInput = null;
	public FileOutputStream fileOutput = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

// Constructor for the WxcelReader class  	
	public ExcelReader(String path) {
		this.path = path;
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheetAt(0);
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//  RowCount in the Sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

//  Get Data in the cell
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int colnum = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					colnum = i;
			}
			if (colnum == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(colnum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;

			} else if (cell.getCellType() == CellType.BLANK)
				return "";

			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + "does not exist in xlsx";
		}
	}

//	Get Data from cell using Column index
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();

			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				return cellText;

			} else if (cell.getCellType() == CellType.BLANK)
				return "";

			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + "does not exist in xlsx";
		}
	}

//	Write the Data in Excel Sheet It true if data is set successfully else false
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
			fileInput.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				fileInput.close();
			} catch (IOException e2) {

			}
		}
		return true;
	}

//	Write the Data in Excel Sheet It true if data is set successfully else false URL
	@SuppressWarnings("unused")
	public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim()))
					colNum = i;
			}

			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			cell.setCellValue(data);
			XSSFCreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle hlinkStyle = workbook.createCellStyle();
			XSSFFont hlinkFont = workbook.createFont();
			hlinkFont.setUnderline(XSSFFont.U_SINGLE);
			hlinkFont.setColor(IndexedColors.BLUE.getIndex());
			hlinkStyle.setFont(hlinkFont);
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);

			fileOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				fileInput.close();
			} catch (IOException e) {

			}
		}
		return true;
	}

//	Create New Sheet
	public boolean addSheet(String sheetName) {
		FileOutputStream fileOut;
		try {
			if (!isSheetExist(sheetName)) {
				workbook.createSheet(sheetName);
				fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
				fileOut.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

//	Remove Sheet
	public boolean removeSheet(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

//	addColumn
	public boolean addColumn(String sheetName, String colName) {
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return false;
			
			XSSFCellStyle style = workbook.createCellStyle();
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
			cell.setCellValue(colName);
			cell.setCellStyle(style);

			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
			fileOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			CellStyle style = workbook.createCellStyle();

			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
			fileOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public int getColumnCount(String sheetName) {
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;
		return row.getLastCellNum();
	}

	public int getCellRowCount(String SheetName, String colName, String tcname) {
		for (int i = 2; i <= getRowCount(SheetName); i++) {
			if (getCellData(SheetName, colName, i).equalsIgnoreCase(tcname)) {
				return i;
			}
		}
		return -1;
	}

}


