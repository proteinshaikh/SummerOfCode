public class AAA_IMP {
    /*
    *
    * https://onedrive.live.com/edit.aspx?resid=59957F868AD8BA96!675&cid=59957f868ad8ba96
    *
    *
1. Eureka: Probably the first microservice to be UP. Eureka is a service registry, means , it knows which ever microservices
are running and in which port. Eureka is deploying as a sperate application and we can use @EnableEurekaServer 
annotation along with @SpringBootAPplication to make that app a eureka server. So our eureka service registery is UP
and running. From now on all microservices will be registered in this eureka server by using @EnableDiscoveryClient 
annotation along with @SpringBootAPplication in all deployed microservices.

2. Zuul: ZUUL is a load balancer , routing application and reverse proxy server as well.
That is before we were using apache for reverse proxy things , now , for microservices we can use ZUUL.
Advantage is, in ZUUL we can programatically set configurations, like if /customer/* comes go to this microservice like that.
 Also ZUUL can act as a load balancer as well , which will pick the appropriate microservice in a round robin fashion.
 SO how does the ZUUL knows the details of microservices, the answer is eureka. It will work along with eureka to get
 microservice details. And in fact this ZUUL is also a Eureka client where we should mark using @EnableDiscoveryClient,
 thats how these 2 apps(Eureka and zuul) linked.

3. Ribbbon: Ribbon use for load balancing. This is already available inside ZUUL, in which zuul is using Ribbon for load
balancing stuff. Microservices are identified by service-name in properties file. IF we run 2 instances of one microservices
in different port, this will be identified by Eureka and along with Ribbon(Inside zuul), requests will be redirected in
a balanced way.

4. Aws ALB , NGINX , AWS Api gateway etc: There are alternatives for all the above mentioned things. Aws is having own load balancer, service discovery , api gateway etc . Not only AWS all cloud platofrms ,like Azure, have these. Its depends which one to use.
Adding a general question as well , How these microservices communicate each other: Using Resttemplate or Feignclient actual rest API can be called or Message queues like Rabbit MQ etc can be used .
    * */

}
