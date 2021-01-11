import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.LogManager
//import java.io.{File, PrintWriter}


object sparkScala  {
  private val logger = LogManager.getLogger("GetDataLogger")

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("sparkDemo")
    val spark: SparkSession = SparkSession.builder.master("local[*]").config(conf).getOrCreate()
    val df = spark.read.format("csv")
      .option("delimiter", ",")
      .load("/uat/landing/lor/tbl_app_ccps_ncb_result_*.csv")

    logger.info(s"test logs")


    spark.stop()

  }

}
