package spring.course.mapper;

public interface EntityMapper <T, U>{
    U map(T entity);
    T reverseMap(U entity);
}
