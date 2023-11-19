# Group by
```
select d.name as 'Department',
        e.name as 'Employee',
        e.salary
from Employee e join Department d
    on e.departmentId = d.id
where (e.departmentId, e.salary) in (
    select e.departmentId, max(e.salary)
    from Employee e
    group by e.departmentId
)
```
# join
```
select d.name as 'Department',
        e.name as 'Employee',
        e.salary as 'Salary'
from Department d join Employee e
    on d.id = e.departmentId join (
        select max(salary) as Salary, DepartmentId
        from Employee
        group by departmentId 
    ) as mx on mx.departmentId = e.departmentId and mx.salary = e.salary
```