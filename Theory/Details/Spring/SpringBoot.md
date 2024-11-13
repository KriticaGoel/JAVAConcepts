### AGENDA

1. [Spring boot components](#spring-boot-components)
2. [Advantage of spring boot](#advantage-of-spring-boot)
3. [Different tier](#different-tiers)
4. [Annotation](#annotations)
5. [Basic program](#basic-program)
6. ResponseEntity

Spring Boot = spring framework + prebuilt configuration + Embedded server

#### Spring boot components

Spring Boot Starters
Auto Configuration
Spring Boot Actuator-monitor the application
Embedded Server
Spring Boot DevTools

#### Advantage of spring boot

1. Stand alone and Quick Start
2. Starter code
3. Less Configuration
4. Reduce cost and application development time

#### Different Tiers

Presentation Layer—User access. Controller classes exist.
Service Layer—Business logic. communicating b/w user and data.
Data access Layer - Repository classes exit.

![SpringBootArchiteture.jpg](..%2F..%2Fresources%2FSpringBootArchiteture.jpg)

#### Annotations

* @RestController - above the controller class having all get and post request
* @GetMapping("</url>")
* @PostMapping("</url>)
* @PathVariable - read data from url like String name. This is coming in argument
* like helloget(@PathVariable String name)
* @RequestBody - read data of post-body like string name — this is coming in argument
* like helloPost(@RequestBody String message)
* JSON Response—create pojo and in return of controller method called object
* @DeleteMapping("</url>")
* @PutMapping("</url>") - update
* @RequestMapping()
  > //@GetMapping("/api/admin/category")
  @RequestMapping(value="/api/admin/category",method = RequestMethod.GET)
  public ResponseEntity<List<Category>> createCategory() {
  return new ResponseEntity<>(categoryService.getCategories(),HttpStatus.OK);

  }

> @RequestMapping("/api/admin") all maping over class to dd common path

* @Service - on service impl class

#### Basic Program

#### Controller

```java

@RestController()
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    //Create Category
    @PostMapping("/api/admin/createCategory")
    public String createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    //Delete Category
    @DeleteMapping("/api/admin/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
    //Update Category

    //Get All category
    @GetMapping("/api/admin/category")
    public List<Category> createCategory() {
        return categoryService.getCategories();

    }
}
```

Service

```java
public interface CategoryService {


    public List<Category> getCategories();

    public String createCategory(Category category);

    public String deleteCategory(int id);
}

```

ServiceImpl

```java

@Service
public class CategoryServiceImpl implements CategoryService {

    public List<Category> categories = new ArrayList<Category>();
    private int nextId = 1;

    public List<Category> getCategories() {
        return categories;
    }

    public String createCategory(Category category) {
        category.setId(nextId++);
        categories.add(category);
        return "Category created successfully";
    }

    public String deleteCategory(int id) {
        Category category = categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (category == null) {
            return "Category not found";
        } else {
            categories.remove(category);
            return "Category deleted successfully";
        }
    }
}
```

Category

```java
public class Category {
    private int id = 1;
    private String categoryName;

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
```

#### ResponseEntity

ResponseStatusException

````java
public String deleteCategory(int id) {
//        Category category = categories.stream().filter(c->c.getId()==id).findFirst().orElse(null);
//        if(category==null){
//            return "Category not found";
//        }else {
//            categories.remove(category);
//            return "Category deleted successfully";
//        }

    Category category = categories.stream().filter(c -> c.getId() == id).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    categories.remove(category);
    return "Category deleted successfully";
}
````

#### ResponseEntity

```java

@DeleteMapping("/api/admin/deleteCategory/{id}")
public ResponseEntity<String> deleteCategory(@PathVariable int id) {
    try {
        return new ResponseEntity<String>(categoryService.deleteCategory(id), HttpStatus.ACCEPTED);
    } catch (ResponseStatusException e) {
        return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
    }
}
```

```java

@RestController()
public class CategoryController {
    @Autowired
    public CategoryService categoryService;
    //Create Category
    @PostMapping("/api/admin/createCategory")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        return new ResponseEntity<String>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    //Delete Category
    @DeleteMapping("/api/admin/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        try {
            return new ResponseEntity<String>(categoryService.deleteCategory(id), HttpStatus.ACCEPTED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }

    //Update Category
    @PutMapping("/api/admin/updateCategory/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Category category) {
        return new ResponseEntity<String>(categoryService.updateCategory(id, category), HttpStatus.OK);
    }

    ;

    //Get All category
    @GetMapping("/api/admin/category")
    public ResponseEntity<List<Category>> createCategory() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);

    }
}
```