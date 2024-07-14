# Employees Earning More Than Their Managers

```sql
select
    employees.name as 'Employee'
from
    Employee employees,
    Employee manager
where
    employees.salary > manager.salary and
    employees.managerId = manager.id
```
