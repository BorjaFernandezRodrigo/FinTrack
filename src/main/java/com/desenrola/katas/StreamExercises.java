package com.desenrola.katas;

import java.util.List;

/**
 * Ejercicios de Streams con explicaciones de Method References.
 *
 * ─── METHOD REFERENCES (::) ───
 * Son azúcar sintáctico que reemplaza una lambda cuando esta simplemente
 * DELEGA en un método que ya existe. El compilador infiere la interfaz funcional.
 *
 * Sintaxis: {@code <Referente>::<NombreDelMetodo>}
 *
 * Hay 4 tipos (domínalos, son ubicuos en Spring):
 *
 *   1. Clase::metodoEstatico       → (a, b) -> Clase.metodoEstatico(a, b)
 *      Ej: Integer::sum, Math::max, String::valueOf
 *
 *   2. objeto::metodoInstancia     → (x) -> objeto.metodoInstancia(x)
 *      Ej: System.out::println, miComparador::compare
 *
 *   3. Clase::metodoInstancia      → (obj, x) -> obj.metodoInstancia(x)
 *      Ej: String::toUpperCase, String::trim, User::getName
 *      (El PRIMER parámetro se convierte en el receptor del método)
 *
 *   4. Clase::new                  → (x) -> new Clase(x)
 *      Ej: ArrayList::new, BigDecimal::new
 *
 * Equivalencia en TypeScript:
 *   No existe sintaxis `::` en TS, pero conceptualmente es como pasar
 *   una función por referencia: [1,2,3].reduce(Math.sum, 0) — si Math.sum existiera.
 */
public class StreamExercises {

    public static int countLongWords(List<String> words, int minLength) {
        return words
            .stream()
            // ❌ No se puede convertir a method reference: la condición incluye minLength
            .filter(word -> word.length() >= minLength)
            .toList()
            .size();
    }

    public static List<String> toUpperCase(List<String> words) {
        return words
            .stream()
            // Equivalente lambda: .map(word -> word.toUpperCase())
            .map(String::toUpperCase) // Tipo 3: referencia a método de instancia de tipo arbitrario
            .toList();
    }

    /**
     * Suma de los cuadrados de una lista de números.
     *
     * Flujo:
     *   [1, 2, 3]
     *     → map(n -> n*n)    → [1, 4, 9]
     *     → reduce(Integer::sum) → 14
     *
     * ═══ Integer::sum en detalle ═══
     *
     * Integer.sum(int a, int b) es un método ESTÁTICO de la clase Integer
     * que devuelve a + b. Su firma es: static int sum(int a, int b).
     *
     * reduce() espera un BinaryOperator<T>, que es una interfaz funcional:
     *   BinaryOperator<Integer> ≡ (Integer, Integer) → Integer
     *
     * Integer::sum encaja perfectamente: (int, int) → int  (el autoboxing lo maneja)
     *
     * ─── Las 3 formas equivalentes (generan el MISMO bytecode) ───
     *
     *   // 1. Lambda explícita (la más verbosa)
     *   .reduce((acumulador, numero) -> acumulador + numero)
     *
     *   // 2. Lambda delegando en método estático (redundante)
     *   .reduce((acumulador, numero) -> Integer.sum(acumulador, numero))
     *
     *   // 3. Method reference (la idiomática) ← Tipo 1: Clase::metodoEstatico
     *   .reduce(Integer::sum)
     *
     * ─── Variantes con otros operadores (mismo patrón) ───
     *
     *   .reduce(Math::max)     // máximo valor
     *   .reduce(0, Integer::sum)   // con valor inicial (evita el Optional)
     */
    public static Integer sumOfSquares(List<Integer> numbers) {
        // ─── Versión anterior (lambda pura) ───
        // return numbers
        //     .stream()
        //     .reduce((accumulator, number) -> accumulator + (number * number))
        //     .orElse(0);

        return numbers
            .stream()
            .map(num -> num * num) // Lambda necesaria: hay transformación (cuadrado)
            .reduce(Integer::sum) // Tipo 1: referencia a método estático de Integer
            .orElse(0); // Si la lista está vacía, devuelve 0
    }

    public static List<String> flattenWords(List<List<String>> groups) {
        return groups
            .stream()
            .flatMap(List::stream) // Tipo 3: referencia a método de instancia de tipo arbitrario
            .sorted()
            .toList();
    }

    public static List<Integer> uniqueSorted(List<Integer> numbers) {
        return numbers.stream().sorted().distinct().toList();
    }
}
