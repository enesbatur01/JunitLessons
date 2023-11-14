package day12_files_seleniumwait;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {

    /*
    Bilgisayarimizdaki herhangi bir dosyanin varligini test etmek icin;
    1-Oncelikle varligini test etmek istedigimiz dosyanin yolunu aliriz
    2-Aldigimiz dosya yolunu Files.exists(Paths.get(dosyayolu))seklinde
    kullanarak bu dosyanin varligini test edebilirz

    Ortak calismalarda bir proje uzerinde bir dosya yolu almak istersek projedeki dosyanin konumu bellidir
    dolayisiyla bu yol herkeste aynidir

    Her kullanicinin user.home dizini farklidir. dolayisiyla biz bu farkiligi System.getProperty("user.home");
    kodu ile dynamic hale getiririz

    herkeste ayni olan yol ile System.getProperty("user.home"); kodunun verdigi yolu concatination yaptigimizda
    herkes icin dynamic bir dosya yolu elde etmis oluruz



     */

    @Test
    public void fileExistsTest() {
        //Bu kod javada programin suanda calistigi directory i string olarak return eder
        // current working directory
        System.out.println(System.getProperty("user.dir"));


        //System.getProperty("user.home"); kullanici ana directory i string olarak return eder
        //Bu yol her kullanici icin farklidir
        //Mesela kullanici adi mehmet olan bir bilgisayar icin bu yol C:\Users\mehmet
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\mua


        //Bilgisayarimizdaki herhangi bir dosyanin varligini test edelim

        //  C:\Users\mua              \Desktop\Batch189.txt

        String ortakYol ="\\Desktop\\Batch189.txt";

        String dynamicPath = userHome+ortakYol;

        // Files.exists(Paths.get(dynamicPath)); methodunu kullanarak parantez icinde belirtilen dosya yolunun
        //dosya sisteminde var olup olmadigini kontrol ederiz, Eger belirtilen yolda bir dosya varsa true
        //yoksa false return eder
        boolean isExist = Files.exists(Paths.get(dynamicPath));

        Assert.assertTrue(isExist);








    }
}
