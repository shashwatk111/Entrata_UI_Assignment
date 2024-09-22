package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

public class ConfigDataReader {

    public static Properties prop = new Properties();

    public static String FirstName="",LastName="",Email="",CompanyName="",PhoneNumber="",UnitCount="",JobTitle="",IAm="";
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public void excelFileReader() {
        String filePath = "src/main/resources/EntrataData.xlsx";
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheet("schedule_demo_user");

        // Get Physical Row Count
        int totalRows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < totalRows; i++) {
            for (int j = 0; j <= 7; j++) {
                switch (j){
                    case 0:
                        FirstName =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 1:
                        LastName =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 2:
                        Email =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 3:
                        CompanyName =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 4:
                        double PhoneNumberNumericValue =  sheet.getRow(i).getCell(j).getNumericCellValue();
                        PhoneNumber = String.format("%.0f",PhoneNumberNumericValue);
                        break;
                    case 5:
                        UnitCount =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 6:
                        JobTitle =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case 7:
                        IAm =  sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    default:
                        System.out.println("Invalid row or column");
                }
            }
        }
    }

    public static void configFileReader() {
        try{
            String filePath = "src/main/resources/config.properties";
            FileInputStream file = new FileInputStream(filePath);
            prop.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getConfigValue(String key){
        return prop.getProperty(key);
    }
}
