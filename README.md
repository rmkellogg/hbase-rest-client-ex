# hbase-rest-client-ex
Demonstration of using Apache HBase REST Client and Apache Maven Bill-of-Materials (BOM).

Use of the HBase supplied REST Client pulls in excessive transitive dependencies.  The sample 
application shows how to use the Apache Maven Bill-of-Materials (BOM) feature to reduce the 
number of dependencies substantially thereby reducing conflicts.

If you were to use the following directly, you would pull in 146 dependencies.

```
<dependencies>
	<!-- Apache HBase REST Client -->
	<dependency>
		<groupId>org.apache.hbase</groupId>
		<artifactId>hbase-rest</artifactId>
		<version>2.0.0-alpha4</version>
	</dependency>
</dependencies>
```

If you use the Apache Maven Bill-of-Materials, the number is reduced to 21.

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
		<!-- No version specified here -->
	</dependency>
</dependencies>
```

