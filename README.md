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

                @Configuration
                public class BeanConfiguration{
                    
                    @Bean
                    public Scanner scanner(){
                        return new Scanner(System.in);
                    }

                    @Bean
                    public LocalDate today(){
                        return LocalDate.now();
                    }
                }

            Annotation Based Config

                @Component
                    @Service
                    @Repository
                    ....etc

                @ComponentScan("basePackage")
                @Autowired
                    Field Injection
                    Constructor Injection
                    Setter Injection
                    
                    byType      maps a bean to a field if both are of the smae Type.
                
                @Qualifier
                    byName      enables us to map a bean to a field through bean name.

                @Value          injects a value into a primitive or string field
                @PropertySource

                @Scope("singleton|prototype|reqeust|session|global-session")

                @PostConstruct
                @PreDestroy

    Spring Boot
    ----------------------------------------------------------------------------------------

        is a spring framwork module that offers Auto-Configuration and thus promoting
        Rapid Application Development.

        Spring Core and Context (Ioc)
            1. define a bean cofniguaration class
            2. apply @Configuaration,@ComponentScan,@PropertySource
            3. create a .properties file

        Spring Web (Web MVC)
            1. config all paths to DispatcherServlet
            2. create a bean for InternalResourceViewResolver 
            3. config a UrlHandler ..etc

        Spring Security
            1. config SecurtyAdapter to inform what kind of security we want -- form-authentication/token-authentication...etc
            2. the suer name and role providers are to be configed...
            ....

        Spring Boot will eliminate all of those configs and will provide overridable default configs for
        any known spring module.

        Spring Boot Project also called as Spring Starter Project has an alternate to each spring module
        as spring starter modules, these starter moduel will provide the need defualt config on top
        of the original module.

        @SpringBootApplication = 
            @Configuration + 
            @ComponentScan("packageInWhichWeHaveTheApplicationClass") + 
            @ProeprtySource("classpath:application.properties")

        SpringApplication.run()
            -> create an applicationContext
            -> execute all implementations of Runner interfaces
            -> destroy the applicationContext

        Spring Boot Offers
            CommandLineRunner ...etc.,

        Create a Spring Boot Project
            1. using Spring initilizer tool -> https://start.spring.io
            2. using STS spring starter project wizard
            3. using Spring Boot CLI



        