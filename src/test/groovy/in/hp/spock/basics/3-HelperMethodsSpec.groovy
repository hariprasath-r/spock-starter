package in.hp.spock.basics

import spock.lang.Specification

class HelperMethodsSpec extends Specification {

    def students
    Collage collage

    def "setup"() {
        students = [
                new Student(1, 'Hari', 21, 'Final Year'),
                new Student(2, 'Prasath', 18, 'First Year')
        ]
        collage = new Collage(students)
    }

    def "without helper method example"() {
        when:
        def students = collage.getStudentsFromGrade('First Year')

        then:
        !students.isEmpty()
        students[0].age >= 18
        students[0].grade == 'First Year'
    }

    def "with basic helper method example"() {
        when:
        def students = collage.getStudentsFromGrade('First Year')

        then:
        validateFirstYearStudentByAssert(students)
    }

    def "with assert helper method example"() {
        when:
        def students = collage.getStudentsFromGrade('First Year')

        then:
        validateFirstYearStudentByAssert(students)
    }

    def validateFirstYearStudent(List<Student> students) {
        !students.isEmpty() && students.stream()
                .filter(s -> s.age >= 18 && s.grade == 'First Year')
                .count() > 0
    }

    /**
     * Using assert makes it more readable and will help in identifying error
     */
    void validateFirstYearStudentByAssert(List<Student> students) {
        assert !students.isEmpty()
        assert students.stream()
                .filter(s -> s.age >= 18 && s.grade == 'First Year')
                .count() > 0
    }

    def "with helper method"() {
        when:
        def students = collage.getStudentsFromGrade('First Year')

        then:
        with(students) {
            !students.isEmpty()
            students[0].age >= 18
            students[0].grade == 'First Year'
        }
    }

    def "verify all helper method"() {
        when:
        def student = new Student(1, 'Harry', 25, 'Graduate')

        then:
        // the target is optional
        verifyAll(student) {
            student.id == 1
            student.name == 'Harry'
            student.age == 25
            student.grade == 'Graduate'
        }
    }

}
