package co.cask.cdap.data2.util.hbase;

import co.cask.cdap.common.conf.CConfiguration;
import co.cask.cdap.data2.util.TableId;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;

public class HBase20TableUtilChecker {

  public static void main(String[] args) throws Exception {
    CConfiguration cConfiguration = CConfiguration.create();

    HBase20TableUtil tableUtil = new HBase20TableUtil();
    tableUtil.setCConf(cConfiguration);

    Configuration conf = new Configuration();



    conf.addResource("hbase-site.xml");
    System.out.println(conf.get("zookeeper.znode.parent"));
    tableUtil.createHTable(conf,TableId.from("cdaptests", "testtable"));


  }
}
