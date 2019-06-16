package csvdata;
	 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Message;
  
public class expofsmtp  {
	 public void attacher(Exchange exchange){
		
			String csvFile = (String)exchange.getIn().getHeader("CamelFileNameProduced");
                String filePath = csvFile.substring(0, csvFile.lastIndexOf("/"));
                Message in = exchange.getIn();
                String fileId = csvFile.substring(csvFile.lastIndexOf("/"));;
                in.addAttachment(fileId, new DataHandler(new FileDataSource(filePath+"/"+fileId)));
	       
	}
	 
}
