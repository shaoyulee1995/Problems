```
select
    max(salary) as 'SecondHighestSalary'
from
    Employee
where
    salary not in (select max(salary) from Employee)
```
```
select
    ifnull(
        (select
            distinct salary 
        from
            Employee
        order by 
            salary desc
        limit 1
        offset 1),
    null) as 'SecondHighestSalary'
```