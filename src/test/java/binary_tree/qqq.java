package binary_tree;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class qqq {
    
    /** 
     * @Description 以" "拼接源文件各行并输出至目标文件
     * @param srcAddr 源文件地址
     * @param destAddr 目标文件地址
     */
    public void rmvEnter(String srcAddr, String destAddr) {
        File srcFile = new File(srcAddr); 
        File destFile = new File(destAddr);        

        FileReader sr = null;
        FileWriter dw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try {
            if (!srcFile.exists()) {
                srcFile.createNewFile();
            }
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            sr = new FileReader(srcFile);
            dw = new FileWriter(destFile);
            br = new BufferedReader(sr);
            bw = new BufferedWriter(dw);
            
            String str = null;
            /* 读一行，写一行 */
            while((str = br.readLine()) != null) {
                str = " " + str;
                bw.write(str);                
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeWriter(bw);
            closeReader(br);
            closeWriter(dw);
            closeReader(sr);        
        }
        
    }
    
    private void closeReader(Reader rd) {
        if (null != rd) {
            try {
                rd.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void closeWriter(Writer wr) {
        if (null != wr) {
            try {
                wr.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        String test = "乐山市、湘潭市、遵义市、宿迁市、新乡市、信阳市、滁州市、锦州市、潮州市、黄冈市、开封市、德阳市、德州市、梅州市、鄂尔多斯市、邢台市、茂名市、大理白族自治州、韶关市、商丘市、安庆市、黄石市、六安市、玉林市、宜春市、北海市、牡丹江市、张家口市、梧州市、日照市、咸宁市、常德市、佳木斯市、红河哈尼族彝族自治州、黔东南苗族侗族自治州、阳江市、晋中市、渭南市、呼伦贝尔市、恩施土家族苗族自治州、河源市、郴州市、阜阳市、聊城市、大同市、宝鸡市、许昌市、赤峰市、运城市、安阳市、临汾市、宣城市、曲靖市、西双版纳傣族自治州、邵阳市、葫芦岛市、平顶山市、辽阳市、菏泽市、本溪市、驻马店市、汕尾市、焦作市、黄山市、怀化市、四平市、榆林市、十堰市、宜宾市、滨州市、抚州市、淮南市、周口市、黔南布依族苗族自治州、泸州市、玉溪市、眉山市、通化市、宿州市、枣庄市、内江市、遂宁市、吉安市、通辽市、景德镇市、阜新市、雅安市、铁岭市、承德市、娄底市"; 
        
        String newTest = test.replaceAll("、", "\n");
        
        System.out.println(newTest);
        
    }

}