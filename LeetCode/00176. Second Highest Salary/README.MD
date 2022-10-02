# SQL
## Max
```
select max(salary) as SecondHighestSalary
from Employee
where salary not in (
    select max(salary)
    from Employee
)
```
# SQL
## Offset, limit
```
select(
    select distinct e.salary
    from Employee e
    order by e.salary desc limit 1 offset 1
) as secondHighestSalary;

```