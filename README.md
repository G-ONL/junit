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
 
 ### Junit 5
 
 #### @BeforeAll
  - Junit 4의 @BeforeClass 처럼 현재 클래스의 모든 테스트 클래스 보다 먼저 실행이 되며 해당 메서드는 static 해야된다.
 
 #### @BeforeEach
  - Junit 4의 @Before에 해당이 된다. 각 테스트 메서드 실행 전에 실행이 된다.
 
 #### @AfterEach
  - Junit 4의 @After에 해당이 된다. 각 테스트 메서드 실행 후에 실행이 된다.
 
 #### @AfterAll
  - Junit 4의 @AfterClass 처럼 현재 클래스의 모든 테스트 클래스가 끝나고 난 뒤에 실행이 되며 @BeforeAll과 동일하게 static이어야 한다.

