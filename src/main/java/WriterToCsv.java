

import java.io.PrintWriter;

public class WriterToCsv {
    public void writeToCsv(PrintWriter writerCsv, String strElemUrl, String strElemName, String strElemNum) {
        if (strElemUrl.length() > 2) {
            System.out.println(strElemName + "\n" + strElemUrl + "\n" + strElemNum + " reviews.\n\n");
            writerCsv.println(strElemName + "\n" + strElemUrl + "\n" + strElemNum + " reviews.\n\n");

        }
    }

    public void writeOneLine(PrintWriter writerCsv, String linew){
        if (linew.length() > 0) {
            System.out.println(linew);
            writerCsv.println(linew);
        }
    }
}
