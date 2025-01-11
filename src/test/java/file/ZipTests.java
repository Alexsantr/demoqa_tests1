package file;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ZipTests {

    public ClassLoader cl = ZipTests.class.getClassLoader();

    @DisplayName("Проверяем PDF файл из архива")
    @Test
    void checkPdfFileFromZipFileTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Zip.zip")) {
            assert is != null;
            try (ZipInputStream zis = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains(".pdf")) {
                        PDF pdf = new PDF(zis);
                        Assertions.assertEquals(1, pdf.numberOfPages);
                    }
                }
            }
        }
    }

    @Test
    void checkXlsxFileFromZipTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Zip.zip")) {
            assert is != null;
            try (ZipInputStream zis = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains(".xls")) {
                        XLS xls = new XLS(zis);
                        String value = xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue();
                       Assertions.assertTrue(value.contains("Technical Architect"));

                    }
                }
            }
        }
    }

    @Test
    void checkCsvFileFromZipTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Zip.zip")) {
            assert is != null;
            try (ZipInputStream zis = new ZipInputStream(is)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains(".csv")) {
                        CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                        List<String[]> data = csvReader.readAll();
                        Assertions.assertEquals(5, data.size());
                        Assertions.assertArrayEquals(
                                new String []{"name","phoneNumber","email","address","userAgent","hexcolor"},
                                data.get(0)
                        );


                    }
                }
            }
        }
    }
}
