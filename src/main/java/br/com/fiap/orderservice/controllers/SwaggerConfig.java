@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
 @Bean
public Docket greetingApi() {
 return new Docket(DocumentationType.SWAGGER_2)
 .select()
 .apis(RequestHandlerSelectors.basePackage("br.com.ecommerce"))
 .build()
 .apiInfo(metaData());
 }
private ApiInfo metaData() {
 return new ApiInfoBuilder()
 .title("Order Service REST API")
 .description("\"Order Service REST API for FIAP E-COMMERCE\"")
 .version("1.0.0")
 .license("Apache License Version 2.0")
 .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
 .build();
 }
 @Override
protected void addResourceHandlers(ResourceHandlerRegistry registry) {
 registry.addResourceHandler("swagger-ui.html")
 .addResourceLocations("classpath:/META-INF/resources/");
 registry.addResourceHandler("/webjars/**")
 .addResourceLocations("classpath:/META-INF/resources/webjars/");
 }
}

@RestController
@Api(value = "Order", description = "Order Service REST API")
public class OrderController {
 @Autowired
private OrderService service;
 @ApiOperation(httpMethod = "GET", value = "Método get para buscar pedido filtrando
por id")
 @ApiResponses(value = {
@ApiResponse(code = 200, message = "Retorna um OrderDTO com uma
mensagem de sucesso", response = OrderDTO.class)
})
 @GetMapping(value = "/order/{id}")
public ResponseEntity<OrderDTO> findOrderbyId(@ApiParam( value = "Order Id", required
= true) @PathVariable(value = "id", required = true) String id) {
OrderDTO order = this.service.findOrderbyId(id);
 return new ResponseEntity<>(order, HttpStatus.OK);
 }
