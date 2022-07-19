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
            CommandLineRunner  public abstract void run(String ...args);
            AppliationRunner   public abstract void run(SpringApplicationArgments args);

        Create a Spring Boot Project
            1. using Spring initilizer tool -> https://start.spring.io
            2. using STS spring starter project wizard
            3. using Spring Boot CLI
    
    Spring Data Jdbc
    ----------------------------------------------------------------------------------------

        is module of spring framework used to connect a database .

        JdbcTemplate
        NamedParameterJdbcTemplate
                update
                query
                queryForObject
    
    Spring Data JPA
    ----------------------------------------------------------------------------------------

        it offers auto implemented repositories.

        CrudRepository
            |- JpaRepository

        @Transactional
            For decalrtive isolation and propagation please refer 
                https://www.baeldung.com/spring-transactional-propagation-isolation

        @Entity
        @Table(name="emps")
        public class Employee {
            @Id
            @GeneratedValue(strategy=IDENTITY)
            private Long empId;
            private String fullName;
            private Double basic;
            private String mailId;

            @ManyToOne
            private Department dept;
            ...........
        }

        public interface EmployeeRepo extends JpaRepository<Employee,Long>{
            boolean existsByMailId(String mailId);
            Optional<Employee> findByMailId(String mailId);
            List<Employee> findAllByFullName(String fullName);
            List<Employee> findAllByDept(Department dept);

            @Query("SELECT e FROM Employee e WHERE e.basic BETWEEN :start AND :end")
            List<Employee> retriveEmployeesWithBasicRange(double start,double end);

            @Query("SELECT e FROM Employee e INNER JOIN Department d ON e.dept WHERE d.dname=:dname")
            List<Employee> retriveEmployeesorGivenDeptName(String dname);
        }

    Spring AOP
    ----------------------------------------------------------------------------------------

      Aspect Oriented Programming

            An aspect is a cross cutting concern, free of any bussiness logic but goes hand-in-hand
            with the bussiness logic.

            Logging
            Authentication and Authorization
            Transaction Management ..etc are a few aspects.

            An aspect is executing an ADVICE at a choosen POINT-CUT out of various JOIN-POINTS
            in an application.

            Join Point - is any place in your application at which an advice must inteveine.

                method calls
                expection handling ...etc are join points

            Point Cut - is an expression (method signature) through which a specific 
                join point is choosen for an advice.

            Advice  - is the piece of implementation that has to execute at the coosen point-cut.

            Aspect Types
                Around              execute an advice before invoking and after executing a join-point choosen by a point-cut
                Before              execute an advice before invoking a  join-point choosen by a point-cut
                After               execute an advice after executing a  join-point choosen by a point-cut
                After Throwing      execute an advice after a  join-point choosen by a point-cut throws a excepton
                After Returning     execute an advice after a  join-point choosen by a point-cut returns a value

        PointCut Expression
        ------------------------
        "execution(returnType packageName.ClassName.methodName(...))"
        
        AspectJ Annotations
        -------------------------
        @EnableAspectJAutoProxy
        @Aspect - Represents an aspect advice class.
        @Before – Run before the method execution
        @After – Run after the method returned a result
        @AfterReturning – Run after the method returned a result, intercept the returned result as well.
        @AfterThrowing – Run after the method throws an exception
        @Around – Run around the method execution, combine all three advices above.
        
        <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<scope>compile</scope>
		</dependency>