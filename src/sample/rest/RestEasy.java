package sample.rest;

/**
 * Created by Admin on 24.04.2016.
 */
public class RestEasy {


//    import javax.ws.rs.client.Entity;
//    import javax.ws.rs.core.Response;
//
//    import org.jboss.resteasy.client.jaxrs.ResteasyClient;
//    import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
//    import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
//
//    import com.demo.rest.model.User;
//    import com.demo.rest.model.Users;
//
//    public class Demo_JAXRS_2_Example
//    {
//        public static void main(String[] args)
//        {
//            getExample_one();
//            getExample_two();
//            postExample();
//        }
//
//        private static void getExample_one()
//        {
//            ResteasyClient client = new ResteasyClientBuilder().build();
//            ResteasyWebTarget target = client.target("http://localhost:8080/RESTEasyApplication/user-management/users");
//            Response response = target.request().get();
//            //Read output in string format
//            String value = response.readEntity(String.class);
//            System.out.println(value);
//            response.close();
//        }
//
//        private static void getExample_two()
//        {
//            ResteasyClient client = new ResteasyClientBuilder().build();
//            ResteasyWebTarget target = client.target("http://localhost:8080/RESTEasyApplication/user-management/users");
//            Response response = target.request().get();
//            //Read the entity
//            Users users = response.readEntity(Users.class);
//            for(User user : users.getUsers()){
//                System.out.println(user.getId());
//                System.out.println(user.getLastName());
//            }
//            response.close();
//        }
//
//        private static void postExample()
//        {
//            User user = new User();
//            user.setFirstName("john");
//            user.setLastName("Maclane");
//
//            ResteasyClient client = new ResteasyClientBuilder().build();
//            ResteasyWebTarget target = client.target("http://localhost:8080/RESTEasyApplication/user-management/users");
//            Response response = target.request().post(Entity.entity(user, "application/vnd.com.demo.user-management.user+xml;charset=UTF-8;version=1"));
//            //Read output in string format
//            System.out.println(response.getStatus());
//            response.close();
//        }
//
//    }
//
//
//
//
//    <repositories>
//    <repository>
//    <id>jboss</id>
//    <url>http://repository.jboss.org/maven2</url>
//    </repository>
//    </repositories>
//    <dependencies>
//    <dependency>
//    <groupId>junit</groupId>
//    <artifactId>junit</artifactId>
//    <version>4.11</version>
//    <scope>test</scope>
//    </dependency>
//    <!-- core library -->
//    <dependency>
//    <groupId>org.jboss.resteasy</groupId>
//    <artifactId>resteasy-jaxrs</artifactId>
//    <version>3.0.2.Final</version>
//    </dependency>
//    <!-- JAXB support -->
//    <dependency>
//    <groupId>org.jboss.resteasy</groupId>
//    <artifactId>resteasy-jaxb-provider</artifactId>
//    <version>3.0.2.Final</version>
//    </dependency>
//    <dependency>
//    <groupId>org.jboss.resteasy</groupId>
//    <artifactId>jaxrs-api</artifactId>
//    <version>3.0.2.Final</version>
//    </dependency>
//    <dependency>
//    <groupId>org.jboss.resteasy</groupId>
//    <artifactId>resteasy-client</artifactId>
//    <version>3.0.2.Final</version>
//    </dependency>
//    <dependency>
//    <groupId>net.sf.scannotation</groupId>
//    <artifactId>scannotation</artifactId>
//    <version>1.0.3</version>
//    </dependency>
//    </dependencies>


}
