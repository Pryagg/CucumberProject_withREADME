//package stepDefinitions.api;
//
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class BasePageSteps {
//	
//	@Test
//	public void getProducts_ShouldBe20() {
//	        
//	    given().
//	    when().
//	        get("http://").
//	    then().
//	        assertThat().
//	        body("g",hasSize());
//	}
//	
//	@Test
//	public void test_productId() {
//	    
//	    String originalText = "test";
//	    String productId = "098f6bcd4621d373cade4e832627b4f6";
//	        
//	    given().
//	        param("text",originalText).
//	    when().
//	        get("http://").
//	    then().
//	        assertThat().
//	        body("products.productID",equalTo(productId));
//	}
//	
//	@Test
//	public void test_NumberOfProductsPerCategory_ShouldBe20() {
//	        
//	    String category = "test";
//	    int numberOfProducts = 20;
//	        
//	    given().
//	        pathParam("testCategory",category).
//	    when().
//	        get("http://").
//	    then().
//	        assertThat().
//	        body("categoryId.Products,hasSize(numberOfProducts));
//	}
//	
//	@DataProvider(name="CategoriesAndNumberOfProducts")
//	public Object[][] createTestDataRecords() {
//	    return new Object[][] {
//	        {"test1",20},
//	        {"test2",21},
//	        {"test3",9}
//	    };
//	}
//	
//	@Test(dataProvider="CategoriesAndNumberOfProducts")
//	public void test_NumberOfProducts_ShouldBe_DataDriven(String product, int CategoryId) {
//	                
//	    given().
//	        pathParam("CategoryId",product).
//	    when().
//	        get("http://inhousePharmacy.vu/api/test/{categoryId}/products.json").
//	    then().
//	        assertThat().
//	        body("CategoryId",hasSize(CategoryId));
//	}
//	
//	@Test
//	public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {
//	        
//	    given().
//	        auth().
//	        preemptive().
//	        basic("username", "password").
//	    when().
//	        get("http:").
//	    then().
//	        assertThat().
//	        statusCode(200);
//	}
//	
//	@Public void getOrders_veriyfStatusCode() {
//		given().
//		when().get("https://inhousepharmacy.vu/").then().assertThat().statusCode(200)
//	}
//
//}
