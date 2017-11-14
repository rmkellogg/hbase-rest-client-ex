package org.apache.hadoop.hbase.client.example;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.rest.client.Client;
import org.apache.hadoop.hbase.rest.client.Cluster;
import org.apache.hadoop.hbase.rest.client.RemoteHTable;
import org.apache.log4j.BasicConfigurator;

/**
 * Trivial example using HBase REST Client API.
 */
public class HBaseRESTClientExample 
{
    public static void main( String[] args )
    throws Exception
    {
    	// Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();

    	Cluster cluster = new Cluster();
    	
    	cluster.add("hostname:8080");
    	//cluster.add(HBASE_REST_HOST_2);
    	
    	Client client = new Client(cluster);
    	
    	Table table = new RemoteHTable(client,"table1");
    	
    	// Just a normal HBase Table from this point forward
    	String lookupKey = "Key1";
    	Get get = new Get(lookupKey.getBytes());
    	Result result = table.get(get);
    	
    	if (!result.isEmpty())
    	{
    		// Display key
    		String foundKey = new String(result.getRow());
    		
	    	System.out.println(foundKey);
	    	
	    	if (!result.getNoVersionMap().isEmpty())
    		{
	    		System.out.println("data found");
	    	}
    	}
    	
    	table.close();
    }
}
