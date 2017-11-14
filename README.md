# hbase-rest-client-ex
Demonstration of using Apache HBase REST Client and Apache Maven Bill-of-Materials (BOM).

Use of the HBase supplied REST Client pulls in excessive transitive dependencies.  The sample 
application shown how to use the Bill-of-Materials (BOM) feature within Apache Maven to 
reduce the number of dependencies substantially thereby reducing conflicts.

Within your client application, the following needs to be added to your pom.xml:

```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.apache.hbase</groupId>
			<artifactId>hbase-rest-client-bom</artifactId>
			<version>2.0.0-alpha4</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

<dependencies>
	<!-- Apache HBase REST Client -->
	<dependency>
		<groupId>org.apache.hbase</groupId>
		<artifactId>hbase-rest</artifactId>
	</dependency>
</dependencies>
```

