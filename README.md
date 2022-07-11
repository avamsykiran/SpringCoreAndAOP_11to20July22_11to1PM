Spring Framework
======================================================================================

    Pre-Requisites
        Java 8
    
    Lab Setup
        STS IDE / Eclispe for Java EE IDE
        JDK 8
        MySQL

    Introduction
        is a nut shell of various modules that provide with JavaEE capabilities.

        -> Light Weight and Highlt Modular

            Spring Core             IoC via Dependency Injection
            Spring SpEL             Spring Expression Language
            Spring Context          Autowiring
            Spring Boot             AutoConfiguration and Rapid Application Development
            Spring Data JDBC        Jdbc support
            Spring Data JPA         Jpa supported auto implemented repositories
            Spring AOP              Aspect Orient Parogramming
            Spring Web               Web MVC and Rest API
            Spring Test             Testing on Unit and Integration level
            Spring Security         Authorization and Authentication
            Spring Cloud            Microservices
            Spring WebFlux          Responsivee and Asynchronous Web Archetecture
            Spring Batch            Batch Processing..
            ...etc

        -> Interoparability or Puggable


    IoC or DI vis Spring Core and Spring Context
    ----------------------------------------------------------------------------------------

        public interface InventoryDAO {

        }   

        public class InventoryDAOJdbcImpl implements InvnetoryDAO {

        }   

        public class InventoryDAOJpaImpl implements InvnetoryDAO {

        }   

        public interface InventoryService {

        }

        public class InventoryServiceImpl implements InventoryService {
            private InventoryDAO invDao;

            public InventoryServiceImpl(){
                //this.invDao=new InventoryDAOJdbcImpl();
            }
            
            public InventoryServiceImpl(InventoryDAO invDao){
                this.invDao=invDao;
            }

            public void setInvDao(InventoryDAO invDao){
                this.invDao=invDao;
            }

        }

        InventoryService invService1 = new InventoryServiceImpl(new InventoryDAOJdbcImpl()); //construtor injection
        InventoryService invService2 = new InventoryServiceImpl();
        invService2.setInvDao(new InventoryDAOJpaImpl()); //setter injection

        Inversion of Control
            is an idea that allows the object needed for an application be readily managed and supllied
            through a seperated isolated object managing tool.

            Container       is that tool that can create, supply, destroy and m anage the life cycle of
                            objects of classes in a application.

            Component       the classes whose objects are being managed by the contianer are called Components

            Bean            the object of a component.

        Spring Contaienrs

            Spring Core offers BeanFactory
            Spring Context offers ApplicationContext

            ApplicationContext offers Autowiring, which is not possible with BeanFactory.

        Bean Configuration
            is about informing the Contaienr the list of Components and their dependencies.

            XML Based Config
            Java Based Config
            Annotation Based Config
