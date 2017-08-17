package frameword;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import com.ebay.xcelite.writer.SheetWriter;

import java.io.File;
import java.util.Collection;

public class ExcelUtils {
    Xcelite xcelite;
    public ExcelUtils(String pathTofile){
    xcelite= new Xcelite(new File(pathTofile));

    }

    public  <T> Collection<T> getModelFromExcel(Class<T> model){
        XceliteSheet sheet = xcelite.getSheet(0);
        SheetReader<T> sheetReader = sheet.getBeanReader(model);
        Collection<T> collection = sheetReader.read();
        return collection;
    }

    public  <T> void updateDeviceList(Collection<T> model){
        XceliteSheet sheet = xcelite.getSheet(0);
        SheetWriter sheetWriter = sheet.getBeanWriter(model.getClass());
        sheetWriter.generateHeaderRow(true);
        sheetWriter.write(model);
        xcelite.write();
    }
}
