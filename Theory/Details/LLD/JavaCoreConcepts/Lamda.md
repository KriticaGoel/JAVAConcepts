### Agenda

- Lambdas
- Functional Interfaces
- Lambdas Expressions
    - Motivation
    - Examples
        - Runnable
        - Addition
        - Passing Lambdas as Arguments
        - Lambdas in Collections
        - Sorting Example

### Lambdas

> A lambda expression is a block of code that gets passed around, like an anonymous method. It is a way to pass behavior
> as an argument to a method invocation and to define a method without a name.


**Functional Interfaces**
A functional interface is an interface that contains one and only one abstract method. It is a way to define a contract
for behavior as an argument to a method invocation

**Lambda expressions**
It has also known as anonymous functions, which provide a way to write a code in more compact form.

The basic syntax of a lambda expression consists of the parameter list, the arrow (->), and the body. The body can be
either an expression or a block of statements.

```
(parameters) -> expression
(parameters) -> { statements }
```

**Parameter List:**  This represents the parameters passed to the lambda expression. It can be empty or contain one or
more parameters enclosed in parentheses. If there's only one parameter and its type is inferred, you can omit the
parentheses.

**Arrow Operator (->):** This separates the parameter list from the body of the lambda expression.

**Lambda Body:** This contains the code that makes up the implementation of the abstract method of the functional
interface. The body can be a single expression or a block of code enclosed in curly braces.

Lambda expressions are most commonly used with functional interfaces, which are interfaces containing only one abstract
method. Java 8 introduced the @FunctionalInterface annotation to mark such interfaces.

```
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}
```

### Examples

Let's start with some simple examples to illustrate the basic syntax:

#### 1. Hello World Runnable

To understand, the motivation behind lambdas, remember how we create a thread in Java. We create a class that implements
the Runnable interface and override the run() method. Then we create a new instance of the class and pass it to the
Thread constructor.

```java
// Traditional approach
Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World!");
            }
        };
```

This is a lot of code to write just to print a simple message. Here, the Runnable interface is a functional interface.
It contains only one abstract method, run(). An interface with a single abstract method (SAM) is called a functional
interface. Such interfaces can be implemented using lambdas.

Using Lambda Expression.

```java
// Lambda expression
Runnable lambdaRunnable = () -> System.out.println("Hello, World!");
```

#### 2. Add Numbers

```java
// Traditional approach
MathOperation traditionalAddition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
```

Using Lambda expression

```java
MathOperation lambdaAddition = (a, b) -> a + b;
```

#### 3. Lambda Expressions with Parameters

Lambda expressions can take parameters, making them versatile for various use cases.

```java
NumberChecker traditionalChecker = new NumberChecker() {
    @Override
    public boolean check(int number) {
        return number % 2 == 0;
    }
};
```

Using Lambda expression

```java
NumberChecker lambdaChecker = number -> number % 2 == 0;
```

### 4. Lambda Expressions in Collections

Lambda expressions are commonly used with collections for concise iteration and processing.

Filtering a List Example (Traditonal Approach)

```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

// Traditional approach
List<String> filteredTraditional = new ArrayList<>();
for(
String fruit :fruits){
        if(fruit.

startsWith("A")){
        filteredTraditional.

add(fruit);
    }
            }
```

Using Lambda expression & Java Stream API

```java
List<String> filteredLambda = fruits.stream()
        .filter(fruit -> fruit.startsWith("A"))
        .collect(Collectors.toList());
```

### 4. Sorting Example

Method references to provide a shorthand notation for lambda expressions, making the code even more concise.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Lambda expression for sorting
Collections.

sort(names, (a, b) ->a.

compareTo(b));

// Method reference for sorting
        Collections.

sort(names, String::compareTo);
```
