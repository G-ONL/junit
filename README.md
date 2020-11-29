# junit
Junit 사용해보기


### Junit 4

#### @BeforeClass
 - 모든 테스트 시작 전에 한 번 실행이 됩니다. 메서드가 static 이어야 한다.

#### @Before
- 각 테스트가 시작하기 전에 @Before 어노테이션이 붙은 메서드를 먼저 실행하고 테스트가 시작된다.

#### @After
-  각 테스트가 시작하고 난 뒤 @After 어노테이션이 붙은 메서드가 실행이 된다.

#### @AfterClass
 - 모든 테스트가 끝난 후 한 번 실행이 됩니다. 메서드가 static 이어야 한다.
 
#### 단언
 - assertTrue, assertThat, 
 
#### 예외를 검증하는 3가지 방법
- @Test(expected= ~~~.class)
- try/catch + fail
- @Rule을 이용한 방식
  
 
 ### Junit 5
 
 #### @BeforeAll
  - Junit 4의 @BeforeClass 처럼 현재 클래스의 모든 테스트 클래스 보다 먼저 실행이 되며 해당 메서드는 static 해야된다.
 
 #### @BeforeEach
  - Junit 4의 @Before에 해당이 된다. 각 테스트 메서드 실행 전에 실행이 된다.
 
 #### @AfterEach
  - Junit 4의 @After에 해당이 된다. 각 테스트 메서드 실행 후에 실행이 된다.
 
 #### @AfterAll
  - Junit 4의 @AfterClass 처럼 현재 클래스의 모든 테스트 클래스가 끝나고 난 뒤에 실행이 되며 @BeforeAll과 동일하게 static이어야 한다.
  
  
    
  
 ### 번외
 
 gradle에서 무심코 dependencies 부분에서 궁금증
 
 - implementation , compileOnly, runtimeOnly, annotationProcessor, testImplementation, testCompileOnly, testRuntimeOnly, testAnnotationProcessor 시점차이
   
    compileClasspath에서는 compileOnly와 implementation으로 접근이 가능 but 프로젝트가 컴파일 된 후에는 compileOnly가 소멸 (런타임시에 필요없는 경우 사용)
    
    프로그램의 메모리 내에 적재되어 있는 메소드는 implementation 과 runtimeOnly의 두 가지 상태값
    
    annotationProcessor의 경우 선언을 하게 되면 이 부분의 작업만 지켜보기 때문에 다른 연관되지 않은 부분에서 속도적 이득을 볼 수 있다고 합니다.
    
    compileOnly의 경우 Gradle 2.12부터 지원을 했다. (Maven의 prvided와 비슷한 기능이라고 한다.) 이번 프로젝트의 gradle 버전은 6.6.1
    annotationProcessor의 경우는 Gradle 4.6 부터
    
     참조)
     https://blog.gradle.org/introducing-compile-only-dependencies,
     https://docs.gradle.org/2.12/userguide/java_plugin.html,
     https://docs.gradle.org/4.6/release-notes.html#convenient-declaration-of-annotation-processor-dependencies
     
    ```
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    ```
    spring-boot-starter-web 패키지에 들어있는 클래스와 메서드들은 런타임시에도 살아있고, lombok은 런타임시에는 소멸이 되어있다.
    이유는 lombok은 동작 기능이라기보다는 편의 기능이기에 축소된 메서드들을 컴파일 시에 풀어서 적용시켜준다.
    
    ```
    @Slf4j
    public class AnnotationTest {
      static Object staticObject;
      Object object1;
    ```
    롬복이 적용된 위의 코드를 컴파일 하고 .class 파일을 IntelliJ에서 살펴보면 아래와 같이 풀어져있는 것을 알 수 있다.
    ```
    public class AnnotationTest {
    private static final Logger log = LoggerFactory.getLogger(AnnotationTest.class);
    static Object staticObject;
    Object object1;

    public AnnotationTest() {
     }
    ```
    
    javap -c AnnotationTest.class ( java 컴파일러에서 -c 옵션을 붙여서 자세하게 )
    ```
     
     Compiled from "AnnotationTest.java"
     public class com.example.junit.five.AnnotationTest {
       static java.lang.Object staticObject;

       java.lang.Object object1;

       public com.example.junit.five.AnnotationTest();
         Code:
            0: aload_0
            1: invokespecial #1                  // Method java/lang/Object."<init>":()V
            4: return


       static {};
         Code:
            0: ldc           #16                 // class com/example/junit/five/AnnotationTest
            2: invokestatic  #17                 // Method org/slf4j/LoggerFactory.getLogger:(Ljava/lang/Class;)Lorg/slf4j/Logger;
            5: putstatic     #2                  // Field log:Lorg/slf4j/Logger;
            8: return
     } 
     ```
    
    
   
     
