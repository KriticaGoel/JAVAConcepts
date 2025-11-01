# Factory Pattern Diagrams

This directory contains high-level diagrams for the Factory pattern, illustrating the relationship between the Creator and Product hierarchies.

## Files

- **FactoryHighLevelImproved.puml** - PlantUML source file for the improved high-level Factory pattern diagram
- **FactoryHighLevelImproved.svg** - SVG rendering of the diagram
- **FactoryHighLevelImproved.png** - PNG rendering of the diagram

## Diagram Overview

The improved high-level Factory pattern diagram demonstrates:

1. **Interface Separation**: Clear visual distinction between interfaces (shown in light blue) and concrete classes (shown in white)
2. **Orthogonal Layout**: Uses orthogonal arrows to avoid visual overlap and improve readability
3. **Creation Flow**: Labeled relationships show how concrete creators instantiate specific concrete products
4. **Pattern Structure**:
   - `Creator` interface declares the `factoryMethod()` that returns a `Product`
   - Concrete creators (`ConcreteCreatorA`, `ConcreteCreatorB`) implement the factory method to create specific products
   - `Product` interface defines the common interface for all products
   - Concrete products (`ConcreteProductA`, `ConcreteProductB`) implement the product interface

## Key Relationships

- **Inheritance**: Concrete creators implement the Creator interface; concrete products implement the Product interface
- **Dependency**: Creators depend on the Product interface (not concrete products)
- **Creation**: Each concrete creator is responsible for creating its corresponding concrete product

## Design Benefits

- **Encapsulation**: Object creation logic is encapsulated in factory methods
- **Extensibility**: New product types can be added without modifying existing code
- **Loose Coupling**: Client code depends on abstractions (Creator and Product interfaces) rather than concrete implementations

## Rendering the Diagrams

To regenerate the diagrams from the PlantUML source:

### Using PlantUML JAR

```bash
# Generate SVG
java -jar plantuml.jar -tsvg FactoryHighLevelImproved.puml

# Generate PNG
java -jar plantuml.jar -tpng FactoryHighLevelImproved.puml
```

### Using PlantUML CLI (if installed)

```bash
# Generate SVG
plantuml -tsvg FactoryHighLevelImproved.puml

# Generate PNG
plantuml -tpng FactoryHighLevelImproved.puml
```

## Related Files

- **FactoryClassDiagram.puml** - Detailed class diagram showing the complete Factory pattern implementation with Android, iOS, and Flutter UI examples
