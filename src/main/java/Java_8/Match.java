package Java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String school;
    private int marks;
    private int rank;

    public Course(String name, String school, int marks, int rank) {
        this.name = name;
        this.school = school;
        this.marks = marks;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", marks=" + marks +
                ", rank=" + rank +
                '}';
    }
}

public class Match {
    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Zeeshan", "xaviers", 90, 1),
                new Course("lenin", "stephen", 92, 3),
                new Course("stalin", "loyola", 95, 1),
                new Course("mao", "saboo", 97, 2),
                new Course("che", "xaviers", 99, 5),
                new Course("calrmarx", "xaviers", 90, 5)


        );

        //allMatch
        System.out.println("All Match : " + courses.stream().allMatch(course -> course.getMarks() > 90));

        //allMatch
        System.out.println("None Match : " + courses.stream().noneMatch(course -> course.getMarks() > 90));

        //allMatch
        System.out.println("Any Match : " + courses.stream().anyMatch(course -> course.getMarks() > 90));

        //Natural sort
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getMarks)).collect(Collectors.toList()));

        //Decreasing sort
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getMarks).reversed())
                .collect(Collectors.toList()));

        //compare 2 parameters
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getMarks).reversed()
                        .thenComparing(Course::getRank).reversed()) //2nd parameter
                .collect(Collectors.toList()));

        // Limit
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getMarks).reversed()
                        .thenComparing(Course::getRank).reversed()) //2nd parameter
                .limit(5) //top 5 courses
                .collect(Collectors.toList()));

        // skip -> skip top n
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getMarks).reversed()
                        .thenComparing(Course::getRank).reversed()) //2nd parameter
                .skip(3) //top 5 courses
                .collect(Collectors.toList()));

        // takeWhile print elemnts of list until criteria is  satisfied- java 9
        //dropwhile drop elements until criteria is satisfied- java 9
        Comparator<Course> courseComparator = Comparator.comparingInt(Course::getMarks)
                .thenComparing(Course::getRank)
                .reversed();

        // max prints last element
        System.out.println(courses.stream()
                .max(courseComparator));

        // max prints first element
        System.out.println(courses.stream()
                .min(courseComparator));

        // optional : use orElse to handle default value when no value is found
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() > 100)
                .min(courseComparator)
                .orElse(new Course("calrmarx", "xaviers", 90, 5)));

        // findFirst: finds first element which meets specific criteria
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() > 100)
                .findFirst()
        );

        // findAny: finds one of the  element which meets specific criteria
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() > 100)
                .findAny()
        );

        // sum
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() < 100)
                .mapToInt(Course::getMarks)
                .sum()
        );

        // average
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() < 100)
                .mapToInt(Course::getMarks)
                .average()
        );

        //count

        System.out.println(courses.stream()
                .filter(course -> course.getMarks() < 100)
                .mapToInt(Course::getMarks)
                .count()
        );

        // max
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() < 100)
                .mapToInt(Course::getMarks)
                .max()
        );

        // min
        System.out.println(courses.stream()
                .filter(course -> course.getMarks() < 100)
                .mapToInt(Course::getMarks)
                .min()
        );

        // Grouping
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getSchool))
        );

        // Grouping count
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getSchool, Collectors.counting()))
        );

        // Grouping and get max value
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getSchool,
                        Collectors.maxBy(Comparator.comparing(Course::getMarks))))
        );

        // Grouping mapping
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getSchool,
                        Collectors.mapping(Course::getName, Collectors.toList())))
        );

    }
}
