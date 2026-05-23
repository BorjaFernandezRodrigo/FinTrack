# 🏋️ Java Módulo 0 — Ejercicios con Tests JUnit 5

## 🟢 BLOQUE 1 — Records

---

### Ejercicio 1 — Record básico

**Crea un `record` llamado `Point` con dos campos `double x` e `double y`.**
Debe tener un método de instancia `distanceTo(Point other)` que devuelva la distancia euclidiana entre dos puntos.

> 💡 Recuerda: los records generan getters automáticos (`x()`, `y()`), pero puedes añadirles métodos normales.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void recordHasCorrectFields() {
        Point p = new Point(3.0, 4.0);
        assertEquals(3.0, p.x());
        assertEquals(4.0, p.y());
    }

    @Test
    void distanceToOriginIs5() {
        Point origin = new Point(0, 0);
        Point p = new Point(3, 4);
        assertEquals(5.0, p.distanceTo(origin), 0.0001);
    }

    @Test
    void distanceBetweenSamePointIsZero() {
        Point p = new Point(7, 7);
        assertEquals(0.0, p.distanceTo(p), 0.0001);
    }
}
```

---

### Ejercicio 2 — Record con validación

**Crea un `record` llamado `Temperature` con un campo `double celsius`.**
El constructor compacto debe lanzar `IllegalArgumentException` si el valor es menor que `-273.15` (cero absoluto).
Añade un método `toFahrenheit()` que convierta la temperatura.

> 💡 Los records permiten un *compact constructor* para validar: `public Temperature { if (...) throw ... }`

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void validTemperatureCreated() {
        Temperature t = new Temperature(100.0);
        assertEquals(100.0, t.celsius());
    }

    @Test
    void belowAbsoluteZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Temperature(-300.0));
    }

    @Test
    void boilingPointInFahrenheit() {
        Temperature t = new Temperature(100.0);
        assertEquals(212.0, t.toFahrenheit(), 0.0001);
    }

    @Test
    void freezingPointInFahrenheit() {
        Temperature t = new Temperature(0.0);
        assertEquals(32.0, t.toFahrenheit(), 0.0001);
    }
}
```

---

---

## 🟡 BLOQUE 2 — Generics

---

### Ejercicio 3 — Método genérico `swap`

**Crea una clase `ArrayUtils` con un método estático genérico `swap(T[] arr, int i, int j)`**
que intercambie los elementos en las posiciones `i` y `j` del array. Modifica el array in-place (no devuelve nada).

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void swapIntegers() {
        Integer[] arr = {1, 2, 3};
        ArrayUtils.swap(arr, 0, 2);
        assertArrayEquals(new Integer[]{3, 2, 1}, arr);
    }

    @Test
    void swapStrings() {
        String[] arr = {"a", "b", "c"};
        ArrayUtils.swap(arr, 0, 1);
        assertArrayEquals(new String[]{"b", "a", "c"}, arr);
    }

    @Test
    void swapSameIndexDoesNothing() {
        Integer[] arr = {10, 20, 30};
        ArrayUtils.swap(arr, 1, 1);
        assertArrayEquals(new Integer[]{10, 20, 30}, arr);
    }
}
```

---

### Ejercicio 4 — Clase genérica `Pair<A, B>`

**Crea una clase genérica `Pair<A, B>` con dos campos: `first` y `second`.**
Añade un método `swap()` que devuelva un nuevo `Pair<B, A>` con los elementos invertidos.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void pairHoldsValues() {
        Pair<String, Integer> p = new Pair<>("hello", 42);
        assertEquals("hello", p.first());
        assertEquals(42, p.second());
    }

    @Test
    void swapReturnsPairWithInvertedTypes() {
        Pair<String, Integer> p = new Pair<>("world", 7);
        Pair<Integer, String> swapped = p.swap();
        assertEquals(7, swapped.first());
        assertEquals("world", swapped.second());
    }
}
```

---

### Ejercicio 5 — Bounded generics: `max`

**Crea una clase `MathUtils` con un método estático `max(T a, T b)` donde `T extends Comparable<T>`.**
Debe devolver el mayor de los dos valores.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void maxOfIntegers() {
        assertEquals(10, MathUtils.max(3, 10));
    }

    @Test
    void maxOfStrings() {
        assertEquals("zebra", MathUtils.max("apple", "zebra"));
    }

    @Test
    void maxWhenEqualReturnsEither() {
        assertEquals(5, MathUtils.max(5, 5));
    }
}
```

---

---

## 🔵 BLOQUE 3 — Streams

---

### Ejercicio 6 — filter + count

**Crea una clase `StreamExercises` con un método estático
`countLongWords(List<String> words, int minLength)`**
que devuelva cuántas palabras tienen longitud >= `minLength`.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StreamExercisesTest {

    @Test
    void countWordsLongerThan4() {
        List<String> words = List.of("hi", "hello", "world", "java", "streams");
        assertEquals(3, StreamExercises.countLongWords(words, 5));
    }

    @Test
    void countWithEmptyListIsZero() {
        assertEquals(0, StreamExercises.countLongWords(List.of(), 3));
    }

    @Test
    void countAllWhenMinLengthIsOne() {
        List<String> words = List.of("a", "bb", "ccc");
        assertEquals(3, StreamExercises.countLongWords(words, 1));
    }
}
```

---

### Ejercicio 7 — map + collect

**Añade a `StreamExercises` el método `toUpperCase(List<String> words)`**
que devuelva una nueva lista con todos los strings en mayúsculas.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ToUpperCaseTest {

    @Test
    void convertsToUpperCase() {
        List<String> result = StreamExercises.toUpperCase(List.of("java", "streams"));
        assertEquals(List.of("JAVA", "STREAMS"), result);
    }

    @Test
    void emptyListReturnsEmpty() {
        assertEquals(List.of(), StreamExercises.toUpperCase(List.of()));
    }

    @Test
    void alreadyUppercaseUnchanged() {
        assertEquals(List.of("A", "B"), StreamExercises.toUpperCase(List.of("A", "B")));
    }
}
```

---

### Ejercicio 8 — reduce / sum

**Añade `sumOfSquares(List<Integer> numbers)` a `StreamExercises`.**
Debe devolver la suma de los cuadrados de todos los números de la lista.

> Ejemplo: `[1, 2, 3]` → `1 + 4 + 9 = 14`

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SumOfSquaresTest {

    @Test
    void sumOfSquaresBasic() {
        assertEquals(14, StreamExercises.sumOfSquares(List.of(1, 2, 3)));
    }

    @Test
    void sumOfSquaresWithZero() {
        assertEquals(0, StreamExercises.sumOfSquares(List.of(0, 0, 0)));
    }

    @Test
    void sumOfSquaresEmptyList() {
        assertEquals(0, StreamExercises.sumOfSquares(List.of()));
    }
}
```

---

### Ejercicio 9 — flatMap

**Añade `flattenWords(List<List<String>> groups)` a `StreamExercises`.**
Recibe una lista de listas de strings y devuelve una sola lista con todos los strings en orden.

> Equivalente en TS: `groups.flat()`

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlattenWordsTest {

    @Test
    void flattensNestedLists() {
        List<List<String>> groups = List.of(
            List.of("a", "b"),
            List.of("c"),
            List.of("d", "e")
        );
        assertEquals(List.of("a", "b", "c", "d", "e"), StreamExercises.flattenWords(groups));
    }

    @Test
    void emptyGroupsReturnEmpty() {
        assertEquals(List.of(), StreamExercises.flattenWords(List.of()));
    }
}
```

---

### Ejercicio 10 — sorted + distinct

**Añade `uniqueSorted(List<Integer> numbers)` a `StreamExercises`.**
Devuelve una lista con los números únicos ordenados de menor a mayor.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UniqueSortedTest {

    @Test
    void removesduplicatesAndSorts() {
        List<Integer> result = StreamExercises.uniqueSorted(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5));
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 9), result);
    }

    @Test
    void alreadyUniqueAndSorted() {
        assertEquals(List.of(1, 2, 3), StreamExercises.uniqueSorted(List.of(1, 2, 3)));
    }

    @Test
    void emptyListReturnsEmpty() {
        assertEquals(List.of(), StreamExercises.uniqueSorted(List.of()));
    }
}
```

---

---

## 🟠 BLOQUE 4 — Optional

---

### Ejercicio 11 — Optional básico

**Crea `UserService` con un método `findName(int id)`**
que devuelva `Optional<String>`. Sólo existe el usuario con id `1` (nombre `"Ana"`).
Añade `getNameOrDefault(int id)` que devuelva el nombre o `"Desconocido"` si no existe.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void findsExistingUser() {
        Optional<String> name = service.findName(1);
        assertTrue(name.isPresent());
        assertEquals("Ana", name.get());
    }

    @Test
    void returnsEmptyForUnknownId() {
        assertTrue(service.findName(99).isEmpty());
    }

    @Test
    void getNameOrDefaultReturnsName() {
        assertEquals("Ana", service.getNameOrDefault(1));
    }

    @Test
    void getNameOrDefaultReturnsDefault() {
        assertEquals("Desconocido", service.getNameOrDefault(99));
    }
}
```

---

### Ejercicio 12 — Optional con map y filter

**Añade a `UserService` el método `getUpperCaseName(int id)`**
que devuelva `Optional<String>` con el nombre en mayúsculas, o vacío si el usuario no existe.

Y `getNameIfLong(int id, int minLength)` que devuelva el nombre sólo si su longitud es >= `minLength`.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class OptionalMapTest {

    UserService service = new UserService();

    @Test
    void upperCaseNameForExistingUser() {
        assertEquals(Optional.of("ANA"), service.getUpperCaseName(1));
    }

    @Test
    void upperCaseEmptyForMissingUser() {
        assertTrue(service.getUpperCaseName(99).isEmpty());
    }

    @Test
    void longNameReturnsPresent() {
        // "Ana" has length 3, minLength 2 → present
        assertTrue(service.getNameIfLong(1, 2).isPresent());
    }

    @Test
    void shortNameReturnsEmpty() {
        // "Ana" has length 3, minLength 5 → empty
        assertTrue(service.getNameIfLong(1, 5).isEmpty());
    }
}
```

---

---

## 🔴 BLOQUE 5 — Lambdas, Interfaces funcionales y Method References

---

### Ejercicio 13 — Predicate

**Crea `Validator` con un método estático
`filter(List<T> list, Predicate<T> predicate)`**
que devuelva los elementos que cumplen el predicado.

> `Predicate<T>` viene de `java.util.function`. Es equivalente a `(x: T) => boolean` en TS.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void filterEvenNumbers() {
        List<Integer> result = Validator.filter(List.of(1, 2, 3, 4, 5), n -> n % 2 == 0);
        assertEquals(List.of(2, 4), result);
    }

    @Test
    void filterStringsStartingWithA() {
        List<String> result = Validator.filter(
            List.of("Ana", "Bob", "Alice", "Carlos"),
            s -> s.startsWith("A")
        );
        assertEquals(List.of("Ana", "Alice"), result);
    }
}
```

---

### Ejercicio 14 — Function y andThen

**Crea `Transformer` con un método estático
`transform(List<T> list, Function<T, R> fn)`**
que aplique la función a cada elemento y devuelva la lista resultante.

Luego añade `transformTwice(List<T> list, Function<T, T> fn)` que aplique la función DOS veces a cada elemento usando `andThen`.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

class TransformerTest {

    @Test
    void transformIntToString() {
        List<String> result = Transformer.transform(List.of(1, 2, 3), n -> "num" + n);
        assertEquals(List.of("num1", "num2", "num3"), result);
    }

    @Test
    void transformTwiceDoublesEffect() {
        // aplica x -> x + 10 dos veces: 1 -> 11 -> 21
        List<Integer> result = Transformer.transformTwice(List.of(1, 2, 3), n -> n + 10);
        assertEquals(List.of(21, 22, 23), result);
    }
}
```

---

### Ejercicio 15 — Method References

**Crea `Formatter` con métodos estáticos:**
- `formatAll(List<String> words)` → usa method reference a `String::toUpperCase`
- `printAll(List<String> words)` → usa method reference a `System.out::println`
- `parseLongs(List<String> numbers)` → usa method reference a `Long::parseLong` y devuelve `List<Long>`

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    @Test
    void formatAllUpperCase() {
        assertEquals(List.of("JAVA", "ROCKS"), Formatter.formatAll(List.of("java", "rocks")));
    }

    @Test
    void parseLongsFromStrings() {
        List<Long> result = Formatter.parseLongs(List.of("100", "200", "300"));
        assertEquals(List.of(100L, 200L, 300L), result);
    }
}
```

---

---

## 🟣 BLOQUE 6 — Interfaces y Polimorfismo

---

### Ejercicio 16 — Interface con default method

**Crea la interface `Shape` con:**
- método abstracto `double area()`
- método abstracto `double perimeter()`
- método `default` `describe()` que devuelva el String `"Area: X, Perimeter: Y"` (redondeado a 2 decimales)

Implementa `Circle(double radius)` y `Rectangle(double width, double height)`.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void circleArea() {
        Shape c = new Circle(5);
        assertEquals(Math.PI * 25, c.area(), 0.0001);
    }

    @Test
    void rectanglePerimeter() {
        Shape r = new Rectangle(3, 4);
        assertEquals(14.0, r.perimeter(), 0.0001);
    }

    @Test
    void defaultDescribeMethod() {
        Shape r = new Rectangle(3, 4);
        assertTrue(r.describe().startsWith("Area:"));
        assertTrue(r.describe().contains("Perimeter:"));
    }
}
```

---

### Ejercicio 17 — Comparator personalizado

**Crea un record `Student(String name, double gpa)`.**
En `StudentUtils`, crea:
- `sortByGpaDesc(List<Student> students)` → ordena por GPA de mayor a menor
- `sortByName(List<Student> students)` → ordena alfabéticamente por nombre

Usa lambdas o method references para los `Comparator`.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentUtilsTest {

    List<Student> students = List.of(
        new Student("Carlos", 7.5),
        new Student("Ana", 9.2),
        new Student("Bob", 8.0)
    );

    @Test
    void sortByGpaDescending() {
        List<Student> sorted = StudentUtils.sortByGpaDesc(students);
        assertEquals("Ana", sorted.get(0).name());
        assertEquals("Carlos", sorted.get(2).name());
    }

    @Test
    void sortByNameAlphabetically() {
        List<Student> sorted = StudentUtils.sortByName(students);
        assertEquals("Ana", sorted.get(0).name());
        assertEquals("Carlos", sorted.get(1).name());
    }
}
```

---

---

## ⚫ BLOQUE 7 — Streams avanzado + Collectors

---

### Ejercicio 18 — groupingBy

**Crea `GroupingExercises` con el método
`groupByLength(List<String> words)`**
que devuelva un `Map<Integer, List<String>>` donde la clave es la longitud y el valor son las palabras de esa longitud.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class GroupingTest {

    @Test
    void groupsByLength() {
        Map<Integer, List<String>> result = GroupingExercises.groupByLength(
            List.of("hi", "hey", "hello", "bye", "ok")
        );
        assertEquals(List.of("hi", "ok"), result.get(2));
        assertTrue(result.get(3).containsAll(List.of("hey", "bye")));
        assertEquals(List.of("hello"), result.get(5));
    }
}
```

---

### Ejercicio 19 — joining

**Añade a `GroupingExercises` el método `joinWords(List<String> words, String delimiter)`**
que devuelva un único String con todas las palabras unidas por el delimitador.

Y `joinWithBrackets(List<String> words)` que rodee el resultado con `[` y `]`.

> Equivalente en TS: `words.join(delimiter)`

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JoiningTest {

    @Test
    void joinWithComma() {
        assertEquals("a,b,c", GroupingExercises.joinWords(List.of("a", "b", "c"), ","));
    }

    @Test
    void joinWithSpace() {
        assertEquals("hello world", GroupingExercises.joinWords(List.of("hello", "world"), " "));
    }

    @Test
    void joinWithBrackets() {
        assertEquals("[a, b, c]", GroupingExercises.joinWithBrackets(List.of("a", "b", "c")));
    }
}
```

---

### Ejercicio 20 — Pipeline completo (integrador)

**Dado un `record Product(String name, String category, double price)`.**

Crea `ProductCatalog` con el método:
`getTopByCategory(List<Product> products, String category, int n)`

Que devuelva los `n` productos más caros de una categoría dada, ordenados de mayor a menor precio.

```java
// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {

    List<Product> catalog = List.of(
        new Product("Laptop", "tech", 1200.0),
        new Product("Mouse",  "tech", 25.0),
        new Product("Monitor","tech", 650.0),
        new Product("Desk",   "furniture", 300.0),
        new Product("Chair",  "furniture", 450.0),
        new Product("Webcam", "tech", 80.0)
    );

    @Test
    void topTwoTechProducts() {
        List<Product> result = ProductCatalog.getTopByCategory(catalog, "tech", 2);
        assertEquals(2, result.size());
        assertEquals("Laptop",  result.get(0).name());
        assertEquals("Monitor", result.get(1).name());
    }

    @Test
    void topFurnitureProductsAllIfNIsLarger() {
        List<Product> result = ProductCatalog.getTopByCategory(catalog, "furniture", 10);
        assertEquals(2, result.size());
        assertEquals("Chair", result.get(0).name());
    }

    @Test
    void unknownCategoryReturnsEmpty() {
        List<Product> result = ProductCatalog.getTopByCategory(catalog, "food", 5);
        assertTrue(result.isEmpty());
    }
}
```

---

## 🟤 BLOQUE 8 — Enums y Tipos Sellados (Java 21)

---

### Ejercicio 21 — Enum con campos y métodos

**Crea un `enum` llamado `TransactionType` con las constantes `INCOME`, `EXPENSE`, `TRANSFER`.**
Cada constante debe tener un campo `sign` (`+1`, `-1`, `0`) pasado por constructor privado.
Añade un método `apply(BigDecimal amount)` que devuelva `amount.multiply(BigDecimal.valueOf(sign))`.

> 💡 Los enums de Java son clases completas: pueden tener campos, constructores, métodos e incluso implementar interfaces. En TS los enums son solo números o strings.

```java
// Test
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {

    @Test
    void incomeHasPositiveSign() {
        assertEquals(1, TransactionType.INCOME.getSign());
    }

    @Test
    void expenseHasNegativeSign() {
        assertEquals(-1, TransactionType.EXPENSE.getSign());
    }

    @Test
    void applyIncomeMultipliesByOne() {
        BigDecimal result = TransactionType.INCOME.apply(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), result);
    }

    @Test
    void applyExpenseNegatesAmount() {
        BigDecimal result = TransactionType.EXPENSE.apply(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("-100.00"), result);
    }

    @Test
    void applyTransferReturnsZero() {
        BigDecimal result = TransactionType.TRANSFER.apply(new BigDecimal("100.00"));
        assertEquals(BigDecimal.ZERO, result);
    }
}
```

---

### Ejercicio 22 — Sealed class: tipo Resultado

**Crea una jerarquía sellada `Result<T>`** que modele éxito o error, usando `sealed interface` (Java 21):

- `record Success<T>(T value) implements Result<T>`
- `record Failure<T>(String error) implements Result<T>`

Añade un método `T getOrElse(T defaultValue)` a `Result<T>`.

> 💡 Las sealed classes restringen qué subtipos pueden existir. El compilador puede verificar exhaustividad en switches y pattern matching. Equivale a los discriminated unions de TS (`type Result<T> = { kind: 'success', value: T } | { kind: 'failure', error: string }`).

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void successHoldsValue() {
        Result<String> r = new Success<>("hello");
        assertEquals("hello", r.getOrElse("default"));
    }

    @Test
    void failureReturnsDefault() {
        Result<String> r = new Failure<>("something went wrong");
        assertEquals("default", r.getOrElse("default"));
    }

    @Test
    void successDoesNotCallDefault() {
        Result<Integer> r = new Success<>(42);
        assertEquals(42, r.getOrElse(0));
    }

    @Test
    void patternMatchingSwitch() {
        Result<String> r = new Success<>("ok");
        String output = switch (r) {
            case Success<String> s -> "Got: " + s.value();
            case Failure<String> f -> "Error: " + f.error();
        };
        assertEquals("Got: ok", output);
    }
}
```

---

### Ejercicio 23 — Pattern matching con instanceof (Java 21)

**Crea una clase `ResultFormatter` con un método estático `format(Result<?> result)`**
que devuelva un String usando pattern matching en `instanceof` (sin cast explícito).

> Diferencia clave con TS: el compilador de Java hace *flow typing* dentro del bloque `if (x instanceof Type t)` — la variable `t` ya está tipada, sin necesidad de `as Type`.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultFormatterTest {

    @Test
    void formatSuccess() {
        Result<Double> r = new Success<>(3.14);
        String formatted = ResultFormatter.format(r);
        assertTrue(formatted.contains("SUCCESS"));
        assertTrue(formatted.contains("3.14"));
    }

    @Test
    void formatFailure() {
        Result<Double> r = new Failure<>("division by zero");
        String formatted = ResultFormatter.format(r);
        assertTrue(formatted.contains("FAILURE"));
        assertTrue(formatted.contains("division by zero"));
    }
}
```

---

## 🔶 BLOQUE 9 — BigDecimal y Precisión Financiera

---

### Ejercicio 24 — Aritmética con BigDecimal

**Crea una clase `MoneyMath` con métodos estáticos:**

- `safeDivide(BigDecimal a, BigDecimal b)` — divide con `RoundingMode.HALF_EVEN` y escala 4. Si `b` es cero, lanza `ArithmeticException`.
- `percentageOf(BigDecimal amount, BigDecimal percent)` — calcula el porcentaje (ej: 20% de 100 = 20.00) con escala 2.

> ⚠️ **Crítico para FinTrack**: Nunca uses `double` para dinero. `BigDecimal.equals()` compara escala además de valor → `new BigDecimal("2.00").equals(new BigDecimal("2.0"))` es **false**. Usa `compareTo` para igualdad numérica.

```java
// Test
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.junit.jupiter.api.Assertions.*;

class MoneyMathTest {

    @Test
    void safeDivideNormalCase() {
        BigDecimal result = MoneyMath.safeDivide(new BigDecimal("10"), new BigDecimal("3"));
        assertEquals(new BigDecimal("3.3333"), result); // escala 4, HALF_EVEN
    }

    @Test
    void safeDivideByZeroThrows() {
        assertThrows(ArithmeticException.class, () ->
            MoneyMath.safeDivide(BigDecimal.ONE, BigDecimal.ZERO));
    }

    @Test
    void percentageOf() {
        BigDecimal result = MoneyMath.percentageOf(new BigDecimal("200.00"), new BigDecimal("15"));
        assertEquals(new BigDecimal("30.00"), result);
    }

    @Test
    void percentageOfZero() {
        BigDecimal result = MoneyMath.percentageOf(new BigDecimal("100"), BigDecimal.ZERO);
        assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    void compareToVsEquals() {
        BigDecimal a = new BigDecimal("2.00");
        BigDecimal b = new BigDecimal("2.0");
        assertFalse(a.equals(b));           // equals falla por escala diferente
        assertEquals(0, a.compareTo(b));    // compareTo es numérico ✓
    }
}
```

---

### Ejercicio 25 — Value Object `Money` inmutable

**Crea un `record Money(BigDecimal amount, String currency)` con:**

- Constructor compacto que valida: `amount` no puede ser null ni negativo, `currency` debe ser 3 letras mayúsculas (ISO 4217).
- Método `add(Money other)` — lanza `IllegalArgumentException` si las monedas no coinciden.
- Método `subtract(Money other)` — igual validación de moneda, no permite resultado negativo.

> 💡 Los records son perfectos para value objects: inmutables por definición, con equals/hashCode generados. En FinTrack cada saldo de cuenta es un `Money`.

```java
// Test
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void validMoneyCreated() {
        Money m = new Money(new BigDecimal("100.00"), "EUR");
        assertEquals(new BigDecimal("100.00"), m.amount());
        assertEquals("EUR", m.currency());
    }

    @Test
    void negativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Money(new BigDecimal("-10.00"), "EUR"));
    }

    @Test
    void invalidCurrencyThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Money(BigDecimal.TEN, "euros"));
    }

    @Test
    void addSameCurrency() {
        Money m1 = new Money(new BigDecimal("50.00"), "USD");
        Money m2 = new Money(new BigDecimal("25.00"), "USD");
        assertEquals(new Money(new BigDecimal("75.00"), "USD"), m1.add(m2));
    }

    @Test
    void addDifferentCurrencyThrows() {
        Money eur = new Money(BigDecimal.TEN, "EUR");
        Money usd = new Money(BigDecimal.TEN, "USD");
        assertThrows(IllegalArgumentException.class, () -> eur.add(usd));
    }

    @Test
    void subtractResultingNegativeThrows() {
        Money m1 = new Money(new BigDecimal("10.00"), "EUR");
        Money m2 = new Money(new BigDecimal("50.00"), "EUR");
        assertThrows(IllegalArgumentException.class, () -> m1.subtract(m2));
    }
}
```

---

## 🔵 BLOQUE 10 — Excepciones y Control de Errores

---

### Ejercicio 26 — Jerarquía de excepciones propias

**Crea una jerarquía de excepciones para FinTrack:**

- `FinTrackException extends RuntimeException` (base, unchecked)
- `AccountNotFoundException extends FinTrackException` — recibe `Long accountId` en constructor y genera mensaje automático.
- `InsufficientFundsException extends FinTrackException` — recibe `Long accountId, BigDecimal requested, BigDecimal available` y genera mensaje descriptivo.

Demuestra que al ser `RuntimeException` no necesitan `throws` en la firma del método. Añade a `AccountNotFoundException` un método `getAccountId()`.

> 💡 En Java, las excepciones *checked* (heredan de `Exception`) obligan a declarar `throws` o capturarlas. Las *unchecked* (heredan de `RuntimeException`) no. Spring prefiere unchecked — es lo que usa en `@Transactional` para rollback automático.

```java
// Test
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FinTrackExceptionTest {

    @Test
    void accountNotFoundExceptionHasId() {
        AccountNotFoundException ex = new AccountNotFoundException(42L);
        assertEquals(42L, ex.getAccountId());
        assertTrue(ex.getMessage().contains("42"));
    }

    @Test
    void insufficientFundsExceptionHasDetails() {
        InsufficientFundsException ex = new InsufficientFundsException(
            99L,
            new BigDecimal("500.00"),
            new BigDecimal("100.00")
        );
        assertTrue(ex.getMessage().contains("500.00"));
        assertTrue(ex.getMessage().contains("100.00"));
    }

    @Test
    void allAreUnchecked() {
        // Si fueran checked, este código no compilaría sin throws
        assertTrue(RuntimeException.class.isAssignableFrom(FinTrackException.class));
        assertTrue(RuntimeException.class.isAssignableFrom(AccountNotFoundException.class));
        assertTrue(RuntimeException.class.isAssignableFrom(InsufficientFundsException.class));
    }

    @Test
    void methodDoesNotNeedThrowsDeclaration() {
        // Invocamos un método que lanza AccountNotFoundException sin try/catch ni throws
        assertThrows(AccountNotFoundException.class, () -> {
            throw new AccountNotFoundException(1L);
        });
    }
}
```

---

### Ejercicio 27 — Try-with-resources y AutoCloseable

**Crea una clase `DatabaseConnection` que implemente `AutoCloseable`.**
En `open()` simula abrir conexión (lanza `IllegalStateException` si ya está abierta).
En `close()` simula cerrar (sin excepción si ya está cerrada).
Añade un método `query(String sql)` que devuelva un string mock.

Crea una clase `ConnectionPool` con un método `executeQuery(DatabaseConnection conn, String sql)` que use **try-with-resources** para garantizar que la conexión se cierre incluso si la query lanza excepción.

> 💡 Try-with-resources es el equivalente a `using` en C# o al bloque `try { ... } finally { resource.close() }` automático. En Node no hay equivalente directo porque el GC maneja los recursos — en Java, conexiones, streams y archivos DEBEN cerrarse explícitamente.

```java
// Test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void openAndQuery() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        String result = conn.query("SELECT 1");
        assertNotNull(result);
        assertTrue(conn.isOpen());
    }

    @Test
    void doubleOpenThrows() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        assertThrows(IllegalStateException.class, conn::open);
    }

    @Test
    void closeAfterOpen() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        conn.close();
        assertFalse(conn.isOpen());
    }

    @Test
    void doubleCloseDoesNotThrow() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        conn.close();
        assertDoesNotThrow(conn::close); // seguro, no lanza
    }
}

class ConnectionPoolTest {

    @Test
    void tryWithResourcesClosesAfterSuccess() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        ConnectionPool.executeQuery(conn, "SELECT 1");
        assertFalse(conn.isOpen()); // se cerró automáticamente
    }

    @Test
    void tryWithResourcesClosesAfterException() {
        DatabaseConnection conn = new DatabaseConnection();
        conn.open();
        // query("FAIL") lanza RuntimeException
        assertThrows(RuntimeException.class, () ->
            ConnectionPool.executeQuery(conn, "FAIL"));
        assertFalse(conn.isOpen()); // cerrado incluso tras excepción ✓
    }
}
```

---
