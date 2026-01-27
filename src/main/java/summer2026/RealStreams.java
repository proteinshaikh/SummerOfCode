package summer2026;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.*;

public class RealStreams {

  // ===== Records (Java 21 Data Models) =====

  record Customer(Long id, String name, boolean active, boolean premium, List<Order> orders) {}

  record Order(Long id, LocalDate date, List<Product> products) {}

  record Product(String name, String category, double price) {}

  record Transaction(Long customerId, double amount) {}

  record Employee(String name, String department, double salary, boolean permanent) {}

  record Invoice(double amount) {}

  record Log(String message) {
    boolean isError() {
      return message.contains("ERROR");
    }
  }

  // ===== Sample Data =====

  static List<Customer> buildCustomers() {

    Product p1 = new Product("iPhone", "Electronics", 4500);
    Product p2 = new Product("MacBook", "Electronics", 8500);
    Product p3 = new Product("T-Shirt", "Clothing", 150);
    Product p4 = new Product("Shoes", "Clothing", 400);

    Order o1 = new Order(1L, LocalDate.now().minusDays(2), List.of(p1, p3));
    Order o2 = new Order(2L, LocalDate.now().minusDays(1), List.of(p2));
    Order o3 = new Order(3L, LocalDate.now(), List.of(p4, p3));

    return List.of(
        new Customer(1L, "Zeeshan", true, true, List.of(o1, o2)),
        new Customer(2L, "Akhilesh", true, false, List.of(o3)),
        new Customer(3L, "John", false, true, List.of()));
  }

  public static void main(String[] args) throws IOException {

    List<Customer> customers = buildCustomers();

    // ------------------------------------------------------------
    // 1) Filter + Map + Collect
    List<String> activeCustomerNames =
        customers.stream().filter(Customer::active).map(Customer::name).toList();

    System.out.println("1) Active Customers: " + activeCustomerNames);

    // ------------------------------------------------------------
    // 2) flatMap — all orders
    List<Order> allOrders = customers.stream().flatMap(c -> c.orders().stream()).toList();

    System.out.println("2) All Orders Count: " + allOrders.size());

    // ------------------------------------------------------------
    // 3) Grouping + Aggregation
    List<Transaction> transactions =
        customers.stream()
            .flatMap(
                c ->
                    c.orders().stream()
                        .flatMap(o -> o.products().stream())
                        .map(p -> new Transaction(c.id(), p.price())))
            .toList();

    Map<Long, List<Transaction>> byCustomer =
        transactions.stream().collect(Collectors.groupingBy(Transaction::customerId));

    Map<Long, Double> totalPerCustomer =
        transactions.stream()
            .collect(
                Collectors.groupingBy(
                    Transaction::customerId, Collectors.summingDouble(Transaction::amount)));

    System.out.println("3) Total Per Customer: " + totalPerCustomer);

    // ------------------------------------------------------------
    // 4) Find Duplicates
    List<String> names = List.of("apple", "banana", "apple", "orange", "banana");

    Set<String> duplicates =
        names.stream().filter(n -> Collections.frequency(names, n) > 1).collect(Collectors.toSet());

    System.out.println("4) Duplicates: " + duplicates);

    // Better performance duplicate finder
    Set<String> seen = new HashSet<>();
    Set<String> fastDuplicates =
        names.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());

    // ------------------------------------------------------------
    // 5) Sort by multiple fields
    List<Employee> employees =
        List.of(
            new Employee("A", "IT", 9000, true),
            new Employee("B", "IT", 7000, false),
            new Employee("C", "HR", 8000, true));

    List<Employee> sortedEmployees =
        employees.stream()
            .sorted(
                Comparator.comparing(Employee::department)
                    .thenComparing(Employee::salary)
                    .reversed())
            .toList();

    System.out.println("5) Sorted Employees: " + sortedEmployees);

    // ------------------------------------------------------------
    // 6) Partitioning
    Map<Boolean, List<Employee>> partitioned =
        employees.stream().collect(Collectors.partitioningBy(Employee::permanent));

    System.out.println("6) Partitioned: " + partitioned);

    // ------------------------------------------------------------
    // 7) Reduce
    List<Invoice> invoices = List.of(new Invoice(100), new Invoice(250), new Invoice(75));

    double totalInvoiceAmount = invoices.stream().map(Invoice::amount).reduce(0.0, Double::sum);

    System.out.println("7) Total Invoice: " + totalInvoiceAmount);

    // ------------------------------------------------------------
    // 8) Optional + Stream
    Optional<Customer> maybeCustomer =
        customers.stream().filter(c -> c.name().equals("Zeeshan")).findFirst();

    List<Order> optionalOrders = maybeCustomer.stream().flatMap(c -> c.orders().stream()).toList();

    System.out.println("8) Optional Orders: " + optionalOrders.size());

    // ------------------------------------------------------------
    // 9) Parallel Stream
    List<Log> logs =
        List.of(new Log("INFO Startup"), new Log("ERROR Database down"), new Log("ERROR Timeout"));

    long errorCount = logs.parallelStream().filter(Log::isError).count();

    System.out.println("9) Error Count: " + errorCount);

    // ------------------------------------------------------------
    // 10) Stream over file (simulate)
    long lineCount;
    try (Stream<String> lines = Stream.of("INFO Start", "ERROR Fail", "INFO Stop")) {
      lineCount = lines.filter(l -> l.contains("ERROR")).count();
    }
    System.out.println("10) File Error Lines: " + lineCount);

    // ------------------------------------------------------------
    // 11) map + flatMap combined
    Set<Product> uniqueProducts =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .collect(Collectors.toSet());

    System.out.println("11) Unique Products: " + uniqueProducts);

    // ------------------------------------------------------------
    // 12) Custom Collector
    double avgTransaction =
        transactions.stream()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.summingDouble(Transaction::amount),
                    sum -> sum / transactions.size()));

    System.out.println("12) Avg Transaction: " + avgTransaction);

    // ------------------------------------------------------------
    // 13) takeWhile / dropWhile
    List<Integer> taken = Stream.of(2, 4, 6, 7, 8, 10).takeWhile(n -> n % 2 == 0).toList();

    System.out.println("13) TakeWhile: " + taken);

    // ------------------------------------------------------------
    // 14) Immutable Collector
    List<String> immutableNames = names.stream().collect(Collectors.toUnmodifiableList());

    // ------------------------------------------------------------
    // 15) Stream.generate + limit
    List<UUID> ids = Stream.generate(UUID::randomUUID).limit(5).toList();

    System.out.println("15) Random IDs: " + ids);

    // 16) Customers with NO orders
    List<Customer> noOrderCustomers = customers.stream().filter(c -> c.orders().isEmpty()).toList();

    System.out.println("16) Customers with no orders: " + noOrderCustomers);

    // 17) Most expensive product per category

    Map<String, Product> mostExpensivePerCategory =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .collect(
                Collectors.toMap(
                    Product::category,
                    Function.identity(),
                    BinaryOperator.maxBy(Comparator.comparing(Product::price))));

    System.out.println("17) Most expensive per category: " + mostExpensivePerCategory);

    // 18) Top N expensive products

    List<Product> top2Products =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .sorted(Comparator.comparing(Product::price).reversed())
            .limit(2)
            .toList();

    System.out.println("18) Top 2 products: " + top2Products);

    // 19) Second highest salary (classic interview trap)
    Optional<Employee> secondHighest =
        employees.stream()
            .sorted(Comparator.comparing(Employee::salary).reversed())
            .skip(1)
            .findFirst();

    System.out.println("19) Second highest salary: " + secondHighest);

    // 20) Frequency map (word count pattern)
    List<String> words = List.of("java", "spring", "java", "api", "spring", "java");

    Map<String, Long> frequency =
        words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println("20) Frequency: " + frequency);

    // 21) Convert List → Map safely (handle duplicate keys)
    Map<String, Double> productPriceMap =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .collect(
                Collectors.toMap(
                    Product::name,
                    Product::price,
                    (oldVal, newVal) -> oldVal // merge function for duplicates
                    ));

    System.out.println("21) Product Price Map: " + productPriceMap);

    // 22) Distinct by custom key

    Set<String> seenCategories = new HashSet<>();

    List<Product> distinctByCategory =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .filter(p -> seenCategories.add(p.category()))
            .toList();

    System.out.println("22) Distinct by category: " + distinctByCategory);

    // 23) Average spending per customer
    Map<Long, Double> avgPerCustomer =
        transactions.stream()
            .collect(
                Collectors.groupingBy(
                    Transaction::customerId, Collectors.averagingDouble(Transaction::amount)));

    System.out.println("23) Avg spend per customer: " + avgPerCustomer);

    // 24) Join strings (SQL GROUP_CONCAT style)
    Map<Long, String> customerProducts =
        customers.stream()
            .collect(
                Collectors.toMap(
                    Customer::id,
                    c ->
                        c.orders().stream()
                            .flatMap(o -> o.products().stream())
                            .map(Product::name)
                            .collect(Collectors.joining(", "))));

    System.out.println("24) Products per customer: " + customerProducts);

    // 25) Detect if any customer spent above threshold
    boolean bigSpenderExists =
        transactions.stream()
            .collect(
                Collectors.groupingBy(
                    Transaction::customerId, Collectors.summingDouble(Transaction::amount)))
            .values()
            .stream()
            .anyMatch(total -> total > 9000);

    System.out.println("25) Big spender exists: " + bigSpenderExists);

    // 26) Custom Collector – Median calculation

    double medianPrice =
        customers.stream()
            .flatMap(c -> c.orders().stream())
            .flatMap(o -> o.products().stream())
            .map(Product::price)
            .sorted()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                      int size = list.size();
                      return size % 2 == 0
                          ? (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0
                          : list.get(size / 2);
                    }));

    System.out.println("26) Median product price: " + medianPrice);

    // 27) Sliding window (tricky stream pattern)

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    List<List<Integer>> windows =
        IntStream.range(0, numbers.size() - 2).mapToObj(i -> numbers.subList(i, i + 3)).toList();

    System.out.println("27) Sliding windows: " + windows);

    // 28) Lazy evaluation demonstration
    Stream<String> lazy =
        customers.stream()
            .map(
                c -> {
                  System.out.println("Mapping: " + c.name());
                  return c.name();
                });

    // Nothing printed until terminal op:
    lazy.count();

    // 29) Infinite stream with takeWhile
    List<Integer> evens = Stream.iterate(2, n -> n <= 20, n -> n + 2).toList();

    System.out.println("29) Even numbers: " + evens);

    // 30) Parallel stream side-effect bug demo

    // Interview favorite: “Why is this wrong?”

    List<Integer> unsafe = new ArrayList<>();

    IntStream.rangeClosed(1, 1000).parallel().forEach(unsafe::add); // race condition!

    System.out.println("30) Wrong parallel result size: " + unsafe.size());
  }
}
